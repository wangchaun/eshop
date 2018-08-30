 package com.sinokj.app.vip.applyCash.action;
 
 import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.vip.applyCash.model.ApplyToCash;
import com.sinokj.app.vip.applyCash.service.ApplyToCashService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class ApplyToCashAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(ApplyToCashAction.class);
   private ApplyToCash applyToCash;
   private ApplyToCashService applyToCashService;
   private CustomerService customerService;
   private Customer customer;
 
   public String list()
   {
     return "list_applyToCash";
   }
 
   public String listJosn()
   {
     logger.info("start list applyToCash");
 
     List resultList = null;
 
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.applyToCash == null) {
         this.applyToCash = new ApplyToCash();
       }
 
       resultList = this.applyToCashService.pageList(pageInfo, this.applyToCash, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list prepaid", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all prepaid");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.applyToCash == null) {
       this.applyToCash = new ApplyToCash();
     }
     try
     {
       if (StringUtils.isBlank(this.applyToCash.getId())) {
         this.applyToCash.setState("c");
         initModel(true, this.applyToCash, loginMan);
         this.applyToCash.setHandlerId(loginMan.getId());
         this.applyToCash.setHandlerName(loginMan.getName());
         this.applyToCash.setDeptId(loginMan.getDeptId());
         this.applyToCash.setDeptName(loginMan.getDeptName());
       } else {
         this.applyToCash = ((ApplyToCash)this.applyToCashService.getModel(this.applyToCash.getId()));
         if (StringUtils.isBlank(this.applyToCash.getHandlerId())) {
           this.applyToCash.setHandlerId(loginMan.getId());
           this.applyToCash.setHandlerName(loginMan.getName());
         }
         initModel(false, this.applyToCash, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list applyToCash", e);
     }
     return "edit_applyToCash";
   }
 
   public void save()
   {
     logger.info("start to update applyToCash information");
     try {
       if (this.applyToCash == null) {
         this.applyToCash = new ApplyToCash();
       }
       if (StringUtils.isBlank(this.applyToCash.getId()))
       {
         this.applyToCash.setId(this.applyToCashService.makeId());
         this.applyToCashService.insert(this.applyToCash);
       }
       else {
         this.applyToCashService.update(this.applyToCash);
       }
 
       if ("s".equals(this.applyToCash.getState())) {
         try
         {
           this.customerService.updatePayables(this.applyToCash.getCustomerId(), Double.valueOf(0.0D - this.applyToCash.getToCashAmount().doubleValue()));
         } catch (Exception e) {
           logger.error("error occur when update customer money", e);
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save applyToCash information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.applyToCash == null) {
         this.applyToCash = new ApplyToCash();
       }
       this.applyToCashService.delete(this.applyToCash.getId());
       logger.info(loginMan.getCode() + " delete applyToCash,id:" + this.applyToCash.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale applyToCash", e);
     }
   }
 
   public ApplyToCash getApplyToCash() {
     return this.applyToCash;
   }
   public void setApplyToCash(ApplyToCash applyToCash) {
     this.applyToCash = applyToCash;
   }
   public Customer getCustomer() {
     return this.customer;
   }
   public void setCustomer(Customer customer) {
     this.customer = customer;
   }
   public void setApplyToCashService(ApplyToCashService applyToCashService) {
     this.applyToCashService = applyToCashService;
   }
   public void setCustomerService(CustomerService customerService) {
     this.customerService = customerService;
   }
 }

/* 
 
 
 */