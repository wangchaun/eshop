 package com.sinokj.app.order.cashBasis.pay.action;
 
 import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.baseInfo.supplier.model.Supplier;
import com.sinokj.app.baseInfo.supplier.service.SupplierService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.order.cashBasis.pay.model.CashItem;
import com.sinokj.app.order.cashBasis.pay.model.Pay;
import com.sinokj.app.order.cashBasis.pay.service.CashItemService;
import com.sinokj.app.order.cashBasis.pay.service.PayService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class PayAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(PayAction.class);
   private Pay pay;
   private PayService payService;
   private CashItem cashItem;
   private CashItemService cashItemService;
   private SerialNumberService serialNumberService;
   private BankAccountService bankAccountService;
   private Customer customer;
   private Supplier supplier;
   private SupplierService supplierService;
   private double[] moneyArr;
   private String[] bankAccountCodeArr;
   private String[] bankAccountIdArr;
   private String[] accountArr;
   private String[] bankAccountNameArr;
   private String[] accountHolderArr;
   private String[] bankArr;
   private String[] remarkArr;
 
   public String list()
   {
     return "list_pay";
   }
 
   public String listJosn()
   {
     logger.info("start list pay");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.pay == null) {
         this.pay = new Pay();
       }
       resultList = this.payService.pageList(pageInfo, this.pay, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list pay", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.pay == null) {
       this.pay = new Pay();
     }
     try
     {
       if (StringUtils.isBlank(this.pay.getId())) {
         this.pay.setState("c");
         initModel(true, this.pay, loginMan);
         this.pay.setHandlerId(loginMan.getId());
         this.pay.setHandlerName(loginMan.getName());
         this.pay.setDeptId(loginMan.getDeptId());
         this.pay.setDeptName(loginMan.getDeptName());
         try {
           this.pay.setCode(this.serialNumberService.getSerialNumberByDate("FKD", "pay"));
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.pay = ((Pay)this.payService.getModel(this.pay.getId()));
         initModel(false, this.pay, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list pay", e);
       responseFlag(false);
     }
     return "edit_pay";
   }
 
   public void save()
   {
     logger.info("start to update pay information");
     if (this.pay == null)
       this.pay = new Pay();
     try
     {
       if (StringUtils.isBlank(this.pay.getId())) {
         this.pay.setId(this.payService.makeId());
         this.payService.insert(this.pay);
       } else {
         this.payService.update(this.pay);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save pay information");
       e.printStackTrace();
       responseFlag(false);
     }
     try {
       this.cashItemService.deleteByIntoId(this.pay.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete pay", e);
     }
 
     String orderId = this.pay.getId();
     if ((this.bankAccountIdArr != null) && (this.bankAccountIdArr.length != 0)) {
       for (int i = 0; i < this.bankAccountIdArr.length; i++) {
         CashItem cashItem = new CashItem();
         cashItem.setOrderId(orderId);
         cashItem.setMoney(Double.valueOf(this.moneyArr[i]));
         cashItem.setRemark(this.remarkArr[i]);
         cashItem.setAccount(this.accountArr[i]);
         cashItem.setAccountHolder(this.accountHolderArr[i]);
         cashItem.setBank(this.bankArr[i]);
         cashItem.setBankAccountId(this.bankAccountIdArr[i]);
         cashItem.setBankAccountCode(this.bankAccountCodeArr[i]);
         cashItem.setBankAccountName(this.bankAccountNameArr[i]);
         cashItem.setSort(Integer.valueOf(i));
         try {
           this.cashItemService.insert(cashItem);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert a cashItem", e);
         }
         if ("s".equals(this.pay.getState())) {
           try {
             this.bankAccountService.updateMoney(this.bankAccountIdArr[i], Double.valueOf(0.0D - this.moneyArr[i]));
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when insert a cashItem", e);
           }
         }
       }
     }
     if ("s".equals(this.pay.getState()))
     {
       String customerId = this.pay.getCustomerId();
       Supplier supplier = (Supplier)this.supplierService.getModel(customerId);
       if (supplier != null)
         try {
           this.supplierService.updateReceivables(customerId, Double.valueOf(0.0D + this.pay.getMoneyPayment().doubleValue()));
         } catch (Exception e) {
           logger.error("error occur when update supplier money", e);
           responseFlag(false);
         }
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.pay == null) {
         this.pay = new Pay();
       }
       this.cashItemService.deleteByIntoId(this.pay.getId());
       this.payService.delete(this.pay.getId());
       logger.info(loginMan.getCode() + " delete pay,id:" + this.pay.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a  pay", e);
     }
   }
 
   public Pay getPay() {
     return this.pay;
   }
   public void setPay(Pay pay) {
     this.pay = pay;
   }
   public PayService getPayService() {
     return this.payService;
   }
   public void setPayService(PayService payService) {
     this.payService = payService;
   }
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
   public double[] getMoneyArr() {
     return this.moneyArr;
   }
   public void setMoneyArr(double[] moneyArr) {
     this.moneyArr = moneyArr;
   }
   public String[] getRemarkArr() {
     return this.remarkArr;
   }
   public void setRemarkArr(String[] remarkArr) {
     this.remarkArr = remarkArr;
   }
 
   public CashItem getCashItem() {
     return this.cashItem;
   }
 
   public void setCashItem(CashItem cashItem) {
     this.cashItem = cashItem;
   }
 
   public void setCashItemService(CashItemService cashItemService) {
     this.cashItemService = cashItemService;
   }
 
   public String[] getBankAccountCodeArr() {
     return this.bankAccountCodeArr;
   }
 
   public void setBankAccountCodeArr(String[] bankAccountCodeArr) {
     this.bankAccountCodeArr = bankAccountCodeArr;
   }
 
   public String[] getBankAccountIdArr() {
     return this.bankAccountIdArr;
   }
 
   public void setBankAccountIdArr(String[] bankAccountIdArr) {
     this.bankAccountIdArr = bankAccountIdArr;
   }
 
   public String[] getAccountArr() {
     return this.accountArr;
   }
 
   public void setAccountArr(String[] accountArr) {
     this.accountArr = accountArr;
   }
 
   public String[] getBankAccountNameArr() {
     return this.bankAccountNameArr;
   }
 
   public void setBankAccountNameArr(String[] bankAccountNameArr) {
     this.bankAccountNameArr = bankAccountNameArr;
   }
 
   public String[] getAccountHolderArr() {
     return this.accountHolderArr;
   }
 
   public void setAccountHolderArr(String[] accountHolderArr) {
     this.accountHolderArr = accountHolderArr;
   }
 
   public String[] getBankArr() {
     return this.bankArr;
   }
 
   public void setBankArr(String[] bankArr) {
     this.bankArr = bankArr;
   }
 
   public void setBankAccountService(BankAccountService bankAccountService) {
     this.bankAccountService = bankAccountService;
   }
 
   public void setSupplierService(SupplierService supplierService) {
     this.supplierService = supplierService;
   }
 
   public Customer getCustomer() {
     return this.customer;
   }
 
   public void setCustomer(Customer customer) {
     this.customer = customer;
   }
 
   public Supplier getSupplier() {
     return this.supplier;
   }
 
   public void setSupplier(Supplier supplier) {
     this.supplier = supplier;
   }
 }

/* 
 
 
 */