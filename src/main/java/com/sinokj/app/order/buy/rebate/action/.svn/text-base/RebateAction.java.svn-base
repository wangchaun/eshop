 package com.sinokj.app.order.buy.rebate.action;
 
 import com.sinokj.app.baseInfo.supplier.model.Supplier;
import com.sinokj.app.baseInfo.supplier.service.SupplierService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.order.buy.rebate.model.Rebate;
import com.sinokj.app.order.buy.rebate.model.RebateItem;
import com.sinokj.app.order.buy.rebate.service.RebateItemService;
import com.sinokj.app.order.buy.rebate.service.RebateService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class RebateAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(RebateAction.class);
   private Rebate rebate;
   private RebateService rebateService;
   private RebateItem rebateItem;
   private List<RebateItem> rebateItemList;
   private List<RebateItem> rebateItemListByState;
   private List<Supplier> supplierList;
   private SupplierService supplierService;
   private RebateItemService rebateItemService;
   private SerialNumberService serialNumberService;
 
   public String list()
   {
     return "list_rebate";
   }
 
   public String listJosn()
   {
     logger.info("start list rebate");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.rebate == null) {
         this.rebate = new Rebate();
       }
 
       resultList = this.rebateService.pageList(pageInfo, this.rebate, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("erro occur when list rebate", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all rebate");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.rebate == null) {
       this.rebate = new Rebate();
     }
     try
     {
       if (StringUtils.isBlank(this.rebate.getId())) {
         this.rebate.setState("c");
         initModel(true, this.rebate, loginMan);
         this.rebate.setHandlerId(loginMan.getId());
         this.rebate.setHandlerName(loginMan.getName());
         this.rebate.setDeptId(loginMan.getDeptId());
         this.rebate.setDeptName(loginMan.getDeptName());
         try {
           String code = this.serialNumberService.getSerialNumberByDate("FL", "rebate");
           this.rebate.setCode(code);
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.rebate = ((Rebate)this.rebateService.getModel(this.rebate.getId()));
         initModel(false, this.rebate, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list rebate", e);
     }
     return "edit_rebate";
   }
 
   public String itemEdit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.rebate == null)
       this.rebate = new Rebate();
     try
     {
       this.rebate = ((Rebate)this.rebateService.getModel(this.rebate.getId()));
       initModel(false, this.rebate, loginMan);
 
       this.rebateItemList = this.rebateItemService.getRebateItem(this.rebate.getId());
 
       if (this.rebateItemList.size() < 1)
       {
         this.supplierList = this.supplierService.getSupplierList();
 
         if (this.supplierList.size() > 0)
           for (int i = 0; i < this.supplierList.size(); i++) {
             List resultList = null;
             Double saleMoney = Double.valueOf(0.0D);
             String supplierId = ((Supplier)this.supplierList.get(i)).getId();
 
             if (StringUtils.isNotBlank(supplierId)) {
               resultList = this.rebateItemService.getTotalMoney(supplierId, this.rebate.getStartTime(), this.rebate.getEndTime());
               if (resultList.get(0) != null) {
                 saleMoney = (Double)resultList.get(0);
               }
               if (this.rebateItem == null) {
                 this.rebateItem = new RebateItem();
               }
               this.rebateItem.setState("c");
               initModel(true, this.rebateItem, loginMan);
               this.rebateItem.setSupplierId(supplierId);
               this.rebateItem.setSupplierName(((Supplier)this.supplierList.get(i)).getName());
               this.rebateItem.setSaleMoney(saleMoney);
               this.rebateItem.setId(this.rebateItemService.makeId());
               this.rebateItem.setRebateId(this.rebate.getId());
               this.rebateItem.setSort(Integer.valueOf(i + 1));
               this.rebateItemService.insert(this.rebateItem);
             }
           }
       }
     }
     catch (Exception e) {
       logger.error("error occur when list rebate", e);
     }
     return "itemEdit_rebate";
   }
 
   public String itemShow()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.rebate == null)
       this.rebate = new Rebate();
     try
     {
       this.rebate = ((Rebate)this.rebateService.getModel(this.rebate.getId()));
       initModel(false, this.rebate, loginMan);
     } catch (Exception e) {
       logger.error("error occur when list rebate", e);
     }
     return "show_rebate";
   }
 
   public void save()
   {
     logger.info("start to update rebate information");
     try {
       if (this.rebate == null)
         this.rebate = new Rebate();
       if (StringUtils.isBlank(this.rebate.getId())) {
         this.rebate.setId(this.rebateService.makeId());
         this.rebateService.insert(this.rebate);
         responseFlag(true);
       } else {
         this.rebateItemList = this.rebateItemService.getRebateItem(this.rebate.getId());
         this.rebateItemListByState = this.rebateItemService.getRebateItemByState(this.rebate.getId());
         if (this.rebateItemList.size() < 1) {
           responseFlag("id");
         } else if (this.rebateItemListByState.size() > 0) {
           responseFlag("state");
         } else {
           this.rebateService.update(this.rebate);
           responseFlag(true);
         }
       }
     } catch (Exception e) {
       logger.info("error occur when save rebate information", e);
       e.printStackTrace();
       responseFlag(false);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.rebate == null) {
         this.rebate = new Rebate();
       }
 
       this.rebateItemService.deleteByIntoId(this.rebate.getId());
       this.rebateService.delete(this.rebate.getId());
       logger.info(loginMan.getCode() + "delete rebate,id:" + this.rebate.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when delete a supplier", e);
     }
   }
 
   public Rebate getRebate() {
     return this.rebate;
   }
 
   public void setRebate(Rebate rebate) {
     this.rebate = rebate;
   }
 
   public RebateItem getRebateItem() {
     return this.rebateItem;
   }
 
   public void setRebateItem(RebateItem rebateItem) {
     this.rebateItem = rebateItem;
   }
 
   public List<RebateItem> getRebateItemList() {
     return this.rebateItemList;
   }
 
   public void setRebateItemList(List<RebateItem> rebateItemList) {
     this.rebateItemList = rebateItemList;
   }
 
   public List<RebateItem> getRebateItemListByState() {
     return this.rebateItemListByState;
   }
 
   public void setRebateItemListByState(List<RebateItem> rebateItemListByState) {
     this.rebateItemListByState = rebateItemListByState;
   }
 
   public List<Supplier> getSupplierList() {
     return this.supplierList;
   }
 
   public void setSupplierList(List<Supplier> supplierList) {
     this.supplierList = supplierList;
   }
 
   public void setRebateService(RebateService rebateService) {
     this.rebateService = rebateService;
   }
 
   public void setSupplierService(SupplierService supplierService) {
     this.supplierService = supplierService;
   }
 
   public void setRebateItemService(RebateItemService rebateItemService) {
     this.rebateItemService = rebateItemService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 }

/* 
 
 
 */