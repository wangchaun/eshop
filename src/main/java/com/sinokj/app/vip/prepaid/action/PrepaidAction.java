 package com.sinokj.app.vip.prepaid.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.customer.model.Customer;
import com.sinokj.app.customer.service.CustomerService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.vip.prepaid.model.Prepaid;
import com.sinokj.app.vip.prepaid.service.PrepaidService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class PrepaidAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(PrepaidAction.class);
   private Prepaid prepaid;
   private PrepaidService prepaidService;
   private CustomerService customerService;
   private Customer customer;
   private SerialNumberService serialNumberService;
 
   public String list()
   {
     return "list_prepaid";
   }
 
   public String listJosn()
   {
     logger.info("start list prepaid");
     List resultList = null;
     int totalRows = 0;
     if (this.prepaid == null) {
       this.prepaid = new Prepaid();
     }
     try
     {
       PageInfo pageInfo = createPageInfo();
 
       resultList = this.prepaidService.pageList(pageInfo, this.prepaid, true);
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
 
   public void getTotalMoney()
   {
     List resultList = null;
     Double totalMoney = Double.valueOf(0.0D);
     if (this.prepaid == null)
       this.prepaid = new Prepaid();
     try
     {
       String code = this.prepaid.getCode();
       String customerName = this.prepaid.getCustomerName();
 
       if ((StringUtils.isNotBlank(customerName)) || (StringUtils.isNotBlank(code))) {
         resultList = this.prepaidService.getTotalMoney(code, customerName);
         totalMoney = (Double)resultList.get(0);
       }
       responseFlag(totalMoney.toString());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when list prepaid", e);
     }
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.prepaid == null) {
       this.prepaid = new Prepaid();
     }
     try
     {
       if (StringUtils.isBlank(this.prepaid.getId())) {
         this.prepaid.setState("c");
         initModel(true, this.prepaid, loginMan);
         this.prepaid.setHandlerId(loginMan.getId());
         this.prepaid.setHandlerName(loginMan.getName());
         this.prepaid.setDeptId(loginMan.getDeptId());
         this.prepaid.setDeptName(loginMan.getDeptName());
         try {
           this.prepaid.setCode(this.serialNumberService.getSerialNumberByDate("CZ", "prepaid"));
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.prepaid = ((Prepaid)this.prepaidService.getModel(this.prepaid.getId()));
         initModel(false, this.prepaid, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list prepaid", e);
     }
     return "edit_prepaid";
   }
 
   public void save()
   {
     logger.info("start to update prepaid information");
     if (this.prepaid == null)
       this.prepaid = new Prepaid();
     try
     {
       if (StringUtils.isBlank(this.prepaid.getId()))
       {
         this.prepaid.setId(this.prepaidService.makeId());
         this.prepaidService.insert(this.prepaid);
       }
       else {
         this.prepaidService.update(this.prepaid);
       }
 
       if ("s".equals(this.prepaid.getState())) {
         try
         {
           this.customerService.updatePayables(this.prepaid.getCustomerId(), Double.valueOf(0.0D + this.prepaid.getPrepaidMoney().doubleValue()));
         } catch (Exception e) {
           logger.error("error occur when update customer money", e);
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save prepaid information");
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.prepaid == null)
       this.prepaid = new Prepaid();
     try
     {
       this.prepaidService.delete(this.prepaid.getId());
       logger.info(loginMan.getCode() + " delete prepaid,id:" + this.prepaid.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a sale prepaid", e);
     }
   }
 
   public Prepaid getPrepaid() {
     return this.prepaid;
   }
 
   public void setPrepaid(Prepaid prepaid) {
     this.prepaid = prepaid;
   }
 
   public void setPrepaidService(PrepaidService prepaidService) {
     this.prepaidService = prepaidService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public Customer getCustomer() {
     return this.customer;
   }
 
   public void setCustomer(Customer customer) {
     this.customer = customer;
   }
 
   public void setCustomerService(CustomerService customerService) {
     this.customerService = customerService;
   }
 }

/* 
 
 
 */