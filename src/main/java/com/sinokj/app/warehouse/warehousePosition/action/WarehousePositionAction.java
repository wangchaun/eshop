 package com.sinokj.app.warehouse.warehousePosition.action;
 
 import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.warehouse.model.Warehouse;
import com.sinokj.app.warehouse.warehouse.service.WarehouseService;
import com.sinokj.app.warehouse.warehousePosition.model.WarehousePosition;
import com.sinokj.app.warehouse.warehousePosition.service.WarehousePositionService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class WarehousePositionAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(WarehousePosition.class);
   private WarehousePosition warehousePosition;
   private String warehouseId;
   private String wareId;
   private WarehousePositionService warehousePositionService;
   private WarehouseService warehouseService;
 
   public void setWarehousePositionService(WarehousePositionService warehousePositionService)
   {
     this.warehousePositionService = warehousePositionService;
   }
 
   public void setWarehouseService(WarehouseService warehouseService) {
     this.warehouseService = warehouseService;
   }
 
   public String list()
   {
     this.warehouseId = this.warehousePosition.getWarehouseId();
     return "list_warehousePosition";
   }
 
   public String listJson()
   {
     logger.info("start list warehousePosition!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehousePosition == null) {
         this.warehousePosition = new WarehousePosition();
       }
       resultList = this.warehousePositionService.pageList(pageInfo, this.warehousePosition, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list warehousePosition", e);
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
 
   public String show()
   {
     if (this.warehousePosition == null) {
       this.warehousePosition = new WarehousePosition();
     }
     return "show_warehousePosition";
   }
 
   public String showJson()
   {
     logger.info("start list warehousePosition!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       resultList = this.warehousePositionService.getByWareId(this.warehouseId, this.wareId);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list warehousePosition", e);
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
     if (this.warehousePosition == null) {
       this.warehousePosition = new WarehousePosition();
     }
     Warehouse warehouse = (Warehouse)this.warehouseService.getModel(this.warehouseId);
     if (warehouse != null) {
       this.warehousePosition.setWarehouseId(warehouse.getId());
       this.warehousePosition.setWarehouseName(warehouse.getName());
     }
     if (StringUtils.isNotBlank(this.warehousePosition.getId())) {
       this.warehousePosition = ((WarehousePosition)this.warehousePositionService.getModel(this.warehousePosition.getId()));
       initModel(false, this.warehousePosition, loginMan);
     } else {
       initModel(true, this.warehousePosition, loginMan);
     }
     return "edit_warehousePosition";
   }
 
   public void save()
   {
     try
     {
       if (StringUtils.isBlank(this.warehousePosition.getId()))
         this.warehousePositionService.insert(this.warehousePosition);
       else {
         this.warehousePositionService.update(this.warehousePosition);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save warehousePosition", e);
     }
   }
 
   public void delete()
   {
     try
     {
       if (StringUtils.isBlank(this.warehousePosition.getId())) {
         responseFlag(false);
       } else {
         this.warehousePositionService.delete(this.warehousePosition.getId());
         responseFlag(true);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a warehousePosition", e);
     }
   }
 
   public WarehousePosition getWarehousePosition() {
     return this.warehousePosition;
   }
 
   public void setWarehousePosition(WarehousePosition warehousePosition) {
     this.warehousePosition = warehousePosition;
   }
 
   public String getWarehouseId() {
     return this.warehouseId;
   }
 
   public void setWarehouseId(String warehouseId) {
     this.warehouseId = warehouseId;
   }
 
   public String getWareId() {
     return this.wareId;
   }
 
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
 }

/* 
 
 
 */