 package com.sinokj.app.order.cashBasis.collection.action;
 
 import com.sinokj.app.baseInfo.bankAccount.service.BankAccountService;
import com.sinokj.app.baseInfo.supplier.model.Supplier;
import com.sinokj.app.baseInfo.supplier.service.SupplierService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.order.cashBasis.collection.model.Collection;
import com.sinokj.app.order.cashBasis.collection.service.CollectionService;
import com.sinokj.app.order.cashBasis.pay.model.CashItem;
import com.sinokj.app.order.cashBasis.pay.service.CashItemService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class CollectionAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(CollectionAction.class);
   private Collection collection;
   private CollectionService collectionService;
   private CashItem cashItem;
   private CashItemService cashItemService;
   private SerialNumberService serialNumberService;
   private BankAccountService bankAccountService;
   private Customer customer;
   private Supplier supplier;
   private CustomerService customerService;
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
     return "list_collection";
   }
 
   public String listJosn()
   {
     logger.info("start list Collection");
 
     List resultList = null;
 
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.collection == null) {
         this.collection = new Collection();
       }
 
       resultList = this.collectionService.pageList(pageInfo, this.collection, true);
       for (int i = 0; i < resultList.size(); i++)
       {
         this.collection = ((Collection)resultList.get(i));
         if ((this.collection.getMoneyAccount() != null) || (this.collection.getMoneyCollect() != null))
         {
           this.collection.setMoneyUncollect(Double.valueOf(this.collection.getMoneyAccount().doubleValue() - this.collection.getMoneyCollect().doubleValue()));
         }
       }
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list Collection", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all Collection");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.collection == null) {
       this.collection = new Collection();
     }
     try
     {
       if (StringUtils.isBlank(this.collection.getId())) {
         this.collection.setState("c");
         initModel(true, this.collection, loginMan);
         this.collection.setHandlerId(loginMan.getId());
         this.collection.setHandlerName(loginMan.getName());
         this.collection.setDeptId(loginMan.getDeptId());
         this.collection.setDeptName(loginMan.getDeptName());
         try {
           this.collection.setCode(this.serialNumberService.getSerialNumberByDate("SKD", "collection"));
         } catch (Exception e) {
           logger.error("error occur when list Collection", e);
         }
       } else {
         this.collection = ((Collection)this.collectionService.getModel(this.collection.getId()));
         initModel(false, this.collection, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list Collection", e);
     }
     return "edit_collection";
   }
 
   public void save()
   {
     logger.info("start to update Collection information");
     if (this.collection == null)
       this.collection = new Collection();
     try
     {
       if (StringUtils.isBlank(this.collection.getId()))
       {
         this.collection.setId(this.collectionService.makeId());
         this.collectionService.insert(this.collection);
       } else {
         this.collectionService.update(this.collection);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save collection information");
       e.printStackTrace();
       responseFlag(false);
     }
     try
     {
       this.cashItemService.deleteByIntoId(this.collection.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete cashItem", e);
     }
 
     String orderId = this.collection.getId();
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
         if ("s".equals(this.collection.getState())) {
           try {
             this.bankAccountService.updateMoney(this.bankAccountIdArr[i], Double.valueOf(0.0D + this.moneyArr[i]));
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when insert a bankAccount", e);
           }
         }
       }
     }
     if ("s".equals(this.collection.getState()))
     {
       String customerId = this.collection.getCustomerId();
       Supplier supplier = (Supplier)this.supplierService.getModel(customerId);
       if (supplier != null)
       {
         try {
           this.supplierService.updatePayables(customerId, Double.valueOf(0.0D - this.collection.getMoneyCollect().doubleValue()));
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when update supplier money", e);
         }
       } else {
         Customer customer = (Customer)this.customerService.getModel(customerId);
         if (customer != null)
           try
           {
             this.customerService.updatePayables(customerId, Double.valueOf(0.0D - this.collection.getMoneyCollect().doubleValue()));
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when update customer money", e);
           }
       }
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.collection == null) {
         this.collection = new Collection();
       }
       this.collectionService.delete(this.collection.getId());
       this.cashItemService.deleteByIntoId(this.collection.getId());
       logger.info(loginMan.getCode() + " delete Collection,id:" + this.collection.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale Collection", e);
     }
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
 
   public Collection getCollection() {
     return this.collection;
   }
 
   public void setCollection(Collection collection) {
     this.collection = collection;
   }
 
   public CollectionService getCollectionService() {
     return this.collectionService;
   }
 
   public void setCollectionService(CollectionService collectionService) {
     this.collectionService = collectionService;
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
 
   public CashItemService getCashItemService() {
     return this.cashItemService;
   }
 
   public void setBankAccountService(BankAccountService bankAccountService) {
     this.bankAccountService = bankAccountService;
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
 
   public void setCustomerService(CustomerService customerService) {
     this.customerService = customerService;
   }
 
   public void setSupplierService(SupplierService supplierService) {
     this.supplierService = supplierService;
   }
 }

/* 
 
 
 */