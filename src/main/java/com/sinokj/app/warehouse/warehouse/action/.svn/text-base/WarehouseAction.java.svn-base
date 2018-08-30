 package com.sinokj.app.warehouse.warehouse.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.warehouse.model.Warehouse;
import com.sinokj.app.warehouse.warehouse.service.WarehouseService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class WarehouseAction extends BaseAction
 {
   private static final long serialVersionUID = -5328157621841061704L;
   private static final Logger logger = Logger.getLogger(WarehouseAction.class);
   private Warehouse warehouse;
   private WarehouseService warehouseService;
   private SerialNumberService serialNumberService;
 
   public void setWarehouseService(WarehouseService warehouseService)
   {
     this.warehouseService = warehouseService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService)
   {
     this.serialNumberService = serialNumberService;
   }
 
   public String list()
   {
     return "list_warehouse";
   }
 
   public String listJson()
   {
     logger.info("start list warehouse!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehouse == null) {
         this.warehouse = new Warehouse();
       }
       resultList = this.warehouseService.pageList(pageInfo, this.warehouse, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list goods", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all data!");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.warehouse == null) {
       this.warehouse = new Warehouse();
     }
     if (StringUtils.isBlank(this.warehouse.getId())) {
       initModel(true, this.warehouse, loginMan);
     } else {
       this.warehouse = ((Warehouse)this.warehouseService.getModel(this.warehouse.getId()));
       initModel(false, this.warehouse, loginMan);
     }
     return "edit_warehouse";
   }
 
   public void save()
   {
     try
     {
       if (StringUtils.isBlank(this.warehouse.getId())) {
         String code = this.serialNumberService.getSerialNumberNoDate("", "Warehouse", 3);
         this.warehouse.setCode(code);
         this.warehouseService.insert(this.warehouse);
       } else {
         this.warehouseService.update(this.warehouse);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save warehouse", e);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
 
     String id = this.warehouse.getId();
     logger.info("delete Warehouse,id:" + id);
     try
     {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.warehouseService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete Warehouse,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + 
         " delete Warehouse,id:" + id, e);
     }
   }
 
   public Warehouse getWarehouse() {
     return this.warehouse;
   }
 
   public void setWarehouse(Warehouse warehouse) {
     this.warehouse = warehouse;
   }
 }

/* 
 
 
 */