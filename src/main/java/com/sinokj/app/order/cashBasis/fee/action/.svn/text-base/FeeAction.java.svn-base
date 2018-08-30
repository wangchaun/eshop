 package com.sinokj.app.order.cashBasis.fee.action;
 
 import com.sinokj.app.baseInfo.bankAccount.model.BankAccount;
import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.order.cashBasis.fee.model.Fee;
import com.sinokj.app.order.cashBasis.fee.model.FeeItem;
import com.sinokj.app.order.cashBasis.fee.service.FeeItemService;
import com.sinokj.app.order.cashBasis.fee.service.FeeService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class FeeAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(FeeAction.class);
   private Fee fee;
   private FeeService feeService;
   private FeeItem feeItem;
   private FeeItemService feeItemService;
   private SerialNumberService serialNumberService;
   private BankAccountService bankAccountService;
   private List<BankAccount> bankAccountList;
   private double[] moneyArr;
   private String[] nameArr;
   private String[] codeArr;
   private String[] remarkArr;
 
   public String list()
   {
     return "list_fee";
   }
 
   public String listJosn()
   {
     logger.info("start list fee");
 
     List resultList = null;
 
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.fee == null) {
         this.fee = new Fee();
       }
 
       resultList = this.feeService.pageList(pageInfo, this.fee, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list fee", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all fee");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.fee == null) {
       this.fee = new Fee();
     }
     try
     {
       if (StringUtils.isBlank(this.fee.getId())) {
         this.fee.setState("c");
         initModel(true, this.fee, loginMan);
         this.fee.setHandlerId(loginMan.getId());
         this.fee.setHandlerName(loginMan.getName());
         this.fee.setDeptId(loginMan.getDeptId());
         this.fee.setDeptName(loginMan.getDeptName());
         try
         {
           String code = this.serialNumberService.getSerialNumberByDate("FYD", "fee");
           this.fee.setCode(code);
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.fee = ((Fee)this.feeService.getModel(this.fee.getId()));
         initModel(false, this.fee, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list warehouseInto", e);
     }
     this.bankAccountList = this.bankAccountService.select(new BankAccount());
     return "edit_fee";
   }
 
   public void save()
   {
     logger.info("start to update fee information");
     try {
       if (this.fee == null) {
         this.fee = new Fee();
       }
 
       BankAccount bankAccount = (BankAccount)this.bankAccountService.getModel(this.fee.getBankAccountId());
       if (bankAccount != null) {
         this.fee.setBankAccountId(bankAccount.getId());
         this.fee.setBankAccountName(bankAccount.getName());
       }
       if (StringUtils.isBlank(this.fee.getId()))
       {
         String id = this.feeService.makeId();
         this.fee.setId(id);
         this.feeService.insert(this.fee);
       } else {
         this.feeService.update(this.fee);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save fee information");
       e.printStackTrace();
       responseFlag(false);
     }
     try
     {
       this.feeItemService.deleteByIntoId(this.fee.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete  documentItem", e);
     }
 
     if ("s".equals(this.fee.getState())) {
       try
       {
         this.bankAccountService.updateMoney(this.fee.getBankAccountId(), Double.valueOf(0.0D - this.fee.getMoneyAccount().doubleValue()));
       } catch (Exception e) {
         logger.error("error occur when update bankAccount money", e);
       }
     }
 
     String orderId = this.fee.getId();
     if ((this.codeArr != null) && (this.codeArr.length != 0))
       for (int i = 0; i < this.codeArr.length; i++) {
         FeeItem feeItem = new FeeItem();
         feeItem.setOrderId(orderId);
         feeItem.setMoney(Double.valueOf(this.moneyArr[i]));
         feeItem.setName(this.nameArr[i]);
         feeItem.setCode(this.codeArr[i]);
         feeItem.setRemark(this.remarkArr[i]);
         feeItem.setSort(Integer.valueOf(i));
         try {
           this.feeItemService.insert(feeItem);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert a warehouseMoveWare", e);
         }
       }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.fee == null) {
         this.fee = new Fee();
       }
       this.feeItemService.deleteByIntoId(this.fee.getId());
       this.feeService.delete(this.fee.getId());
       logger.info(loginMan.getCode() + " delete fee,id:" + this.fee.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale order", e);
     }
   }
 
   public Fee getFee() { return this.fee; }
 
   public void setFee(Fee fee)
   {
     this.fee = fee;
   }
 
   public void setFeeService(FeeService feeService)
   {
     this.feeService = feeService;
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
 
   public String[] getNameArr() {
     return this.nameArr;
   }
 
   public void setNameArr(String[] nameArr) {
     this.nameArr = nameArr;
   }
 
   public void setBankAccountService(BankAccountService bankAccountService) {
     this.bankAccountService = bankAccountService;
   }
 
   public List<BankAccount> getBankAccountList() {
     return this.bankAccountList;
   }
 
   public void setBankAccountList(List<BankAccount> bankAccountList) {
     this.bankAccountList = bankAccountList;
   }
 
   public String[] getCodeArr() {
     return this.codeArr;
   }
 
   public void setCodeArr(String[] codeArr) {
     this.codeArr = codeArr;
   }
 
   public String[] getRemarkArr() {
     return this.remarkArr;
   }
 
   public void setRemarkArr(String[] remarkArr) {
     this.remarkArr = remarkArr;
   }
 
   public FeeItem getFeeItem() {
     return this.feeItem;
   }
 
   public void setFeeItem(FeeItem feeItem) {
     this.feeItem = feeItem;
   }
 
   public void setFeeItemService(FeeItemService feeItemService) {
     this.feeItemService = feeItemService;
   }
 }

/* 
 
 
 */