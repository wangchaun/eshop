 package com.sinokj.app.customer.action;
 
 import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.vip.level.model.VipLevel;
import com.sinokj.app.vip.level.service.VipLevelService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class CustomerAction extends BaseAction
 {
   private static final long serialVersionUID = 6742401615779505558L;
   private static final Logger logger = Logger.getLogger(CustomerAction.class);
   private CustomerService customerService;
   private Customer customer;
   private String type;
   private String loginManRole;
   private VipLevelService vipLevelService;
   private List<VipLevel> vipLevelList;
 
   public String list()
   {
     SysUser loginMan = getSessionUserInfo();
     this.loginManRole = loginMan.getRoleCode();
     if ((this.customer != null) && (StringUtils.isNotBlank(this.customer.getType()))) {
       this.type = this.customer.getType();
     }
     return "list_customer";
   }
 
   public String edit()
   {
     logger.info("start to query Customer information");
     try {
       SysUser loginMan = getSessionUserInfo();
 
       if (this.customer == null) {
         this.customer = new Customer();
       }
 
       if (StringUtils.isNotBlank(this.customer.getId())) {
         this.customer = ((Customer)this.customerService.getModel(this.customer.getId()));
 
         initModel(false, this.customer, loginMan);
       }
       else {
         initModel(true, this.customer, loginMan);
         this.customer.setType("c");
       }
       if (this.customer == null) {
         this.customer = new Customer();
       }
 
       this.vipLevelList = this.vipLevelService.select(new VipLevel());
     }
     catch (Exception e) {
       logger.info("error occur when query Customer information");
       e.printStackTrace();
     }
     return "edit_customer";
   }
   public String listJson(){
	 logger.info("start to list Customer information");   
     if (this.customer == null) {
       this.customer = new Customer();
     }  
     SysUser loginMan = getSessionUserInfo();
     String warehouseId = loginMan.getWarehouseId();
     if (warehouseId != null) {
       this.customer.setWarehouseId(warehouseId);
     }
     
     List<Customer> list = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       list = this.customerService.pageList(pageInfo, this.customer, true);
       if (list == null) {
         list = new ArrayList<Customer>();
       }
       totalRows = pageInfo.getCount();
     }
     catch (Exception e) {
       logger.info("eror occur when listing Customer information");
       e.printStackTrace();
     }
     this.jsonMap = new HashMap<String,Object>();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", list);
     logger.info("finish list all Customer data!");
 
     return "success";
   }
 
   public void save()
   {
     logger.info("start to update Customer information");
     try {
       if (this.customer == null) {
         this.customer = new Customer();
       }
 
       VipLevel vipLevel = (VipLevel)this.vipLevelService.getModel(this.customer.getVipLevelId());
       if (vipLevel != null) {
         this.customer.setVipLevelId(vipLevel.getId());
         this.customer.setVipLevelName(vipLevel.getName());
       }
       if (StringUtils.isBlank(this.customer.getId()))
       {
         this.customerService.insert(this.customer);
       }
       else {
         this.customerService.update(this.customer);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save Customer information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save Customer information");
   }
 
   public void editState()
   {
     logger.info("start to update customer State");
     try {
       if (this.customer == null) {
         this.customer = new Customer();
       }
       if (StringUtils.isNotBlank(this.customer.getId())) {
         this.customerService.updateState(this.customer.getId(), this.customer.getState());
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.info("error occur when updating customer State");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("end of updating customer State");
   }
 
   public void delete()
   {
     try
     {
       logger.info("start to delete area information");
       if (this.customer == null) {
         this.customer = new Customer();
       }
       String id = this.customer.getId();
 
       if (StringUtils.isNotBlank(id)) {
         String[] idArr = id.split(",");
         for (String idStr : idArr) {
           this.customerService.delete(idStr);
         }
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       logger.info("error occur when deleting area information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void checkCodeIsExists()
   {
     Boolean isExists = Boolean.valueOf(true);
     if (this.customer == null)
       this.customer = new Customer();
     try
     {
       this.customer = this.customerService.getCustomerByCode(this.customer.getCode());
       if (this.customer == null) {
         isExists = Boolean.valueOf(false);
       }
       responseFlag(isExists.booleanValue());
     } catch (Exception e) {
       e.printStackTrace();
     }
   }
 
   public void checkMobileIsExists()
   {
     Boolean isExists = Boolean.valueOf(true);
     if (this.customer == null)
       this.customer = new Customer();
     try
     {
       this.customer = this.customerService.getCustomerByMobile(this.customer.getMobile());
       if (this.customer == null) {
         isExists = Boolean.valueOf(false);
       }
       responseFlag(isExists.booleanValue());
     } catch (Exception e) {
       e.printStackTrace();
     }
   }
 
   public Customer getCustomer() { return this.customer; }
 
   public void setCustomer(Customer customer)
   {
     this.customer = customer;
   }
 
   public void setCustomerService(CustomerService customerService) {
     this.customerService = customerService;
   }
 
   public String getLoginManRole() {
     return this.loginManRole;
   }
 
   public void setLoginManRole(String loginManRole) {
     this.loginManRole = loginManRole;
   }
 
   public String getType() {
     return this.type;
   }
 
   public void setType(String type) {
     this.type = type;
   }
 
   public List<VipLevel> getVipLevelList() {
     return this.vipLevelList;
   }
 
   public void setVipLevelList(List<VipLevel> vipLevelList) {
     this.vipLevelList = vipLevelList;
   }
 
   public void setVipLevelService(VipLevelService vipLevelService) {
     this.vipLevelService = vipLevelService;
   }

public CustomerService getCustomerService() {
	return customerService;
}

public VipLevelService getVipLevelService() {
	return vipLevelService;
}
 }