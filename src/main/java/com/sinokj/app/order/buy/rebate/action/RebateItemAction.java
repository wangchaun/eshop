 package com.sinokj.app.order.buy.rebate.action;
 
 import com.sinokj.app.baseInfo.supplier.model.Supplier;
import com.sinokj.app.order.buy.rebate.model.Rebate;
import com.sinokj.app.order.buy.rebate.model.RebateItem;
import com.sinokj.app.order.buy.rebate.service.RebateItemService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class RebateItemAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(RebateItemAction.class);
   private Rebate rebate;
   private RebateItem rebateItem;
   private RebateItemService rebateItemService;
   private Supplier supplier;
 
   public String list()
   {
     return "list_rebateItem";
   }
 
   public String listJosn()
   {
     logger.info("start list rebateItem");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.rebateItem == null) {
         this.rebateItem = new RebateItem();
       }
       resultList = this.rebateItemService.pageList(pageInfo, this.rebateItem, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("erro occur when list rebateItem", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all supplier");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.rebateItem == null)
       this.rebateItem = new RebateItem();
     try
     {
       Date startTime = this.rebate.getStartTime();
       Date endTime = this.rebate.getEndTime();
       if ((startTime != null) && (endTime != null)) {
         getRequest().setAttribute("startTime", startTime);
         getRequest().setAttribute("endTime", endTime);
       }
       if (StringUtils.isBlank(this.rebateItem.getId())) {
         String rebateId = this.rebateItem.getRebateId();
         this.rebateItem.setState("c");
         this.rebateItem.setRebateId(rebateId);
         initModel(true, this.rebateItem, loginMan);
       } else {
         this.rebateItem = ((RebateItem)this.rebateItemService.getModel(this.rebateItem.getId()));
         initModel(false, this.rebateItem, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list rebateItem", e);
     }
     return "edit_rebateItem";
   }
 
   public String show()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.rebateItem == null)
       this.rebateItem = new RebateItem();
     try
     {
       this.rebateItem = ((RebateItem)this.rebateItemService.getModel(this.rebateItem.getId()));
       initModel(false, this.rebateItem, loginMan);
     } catch (Exception e) {
       logger.error("error occur when list rebateItem", e);
     }
     return "show_rebateItem";
   }
 
   public void save()
   {
     logger.info("start to update rebateItem information");
     try {
       if (this.rebateItem == null)
         this.rebateItem = new RebateItem();
       if (StringUtils.isBlank(this.rebateItem.getId())) {
         String id = this.rebateItemService.makeId();
         this.rebateItem.setId(id);
         this.rebateItemService.insert(this.rebateItem);
       } else {
         this.rebateItemService.update(this.rebateItem);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save rebateItem information", e);
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.rebateItem == null) {
         this.rebateItem = new RebateItem();
       }
       this.rebateItemService.delete(this.rebateItem.getId());
       logger.info(loginMan.getCode() + "delete rebateItem,id:" + this.rebateItem.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when delete a supplier", e);
     }
   }
 
   public Rebate getRebate()
   {
     return this.rebate;
   }
 
   public void setRebate(Rebate rebate) {
     this.rebate = rebate;
   }
 
   public Supplier getSupplier() {
     return this.supplier;
   }
 
   public void setSupplier(Supplier supplier) {
     this.supplier = supplier;
   }
   public RebateItem getRebateItem() {
     return this.rebateItem;
   }
 
   public void setRebateItem(RebateItem rebateItem) {
     this.rebateItem = rebateItem;
   }
 
   public RebateItemService getRebateItemService() {
     return this.rebateItemService;
   }
 
   public void setRebateItemService(RebateItemService rebateItemService) {
     this.rebateItemService = rebateItemService;
   }
 }

/* 
 
 
 */