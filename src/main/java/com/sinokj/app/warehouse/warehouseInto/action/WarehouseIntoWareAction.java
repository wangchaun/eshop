 package com.sinokj.app.warehouse.warehouseInto.action;
 
 import com.sinokj.app.warehouse.warehouseInto.model.WarehouseIntoWare;
import com.sinokj.app.warehouse.warehouseInto.service.WarehouseIntoWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class WarehouseIntoWareAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(WarehouseIntoWareAction.class);
   private WarehouseIntoWare warehouseIntoWare;
   private WarehouseIntoWareService warehouseIntoWareService;
 
   public void setWarehouseIntoWareService(WarehouseIntoWareService warehouseIntoWareService)
   {
     this.warehouseIntoWareService = warehouseIntoWareService;
   }
 
   public String listJson()
   {
     logger.info("start list warehouseIntoWare");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehouseIntoWare == null) {
         this.warehouseIntoWare = new WarehouseIntoWare();
       }
       resultList = this.warehouseIntoWareService.pageList(pageInfo, this.warehouseIntoWare, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list warehouseIntoWare", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list warehouseIntoWare");
     return "success";
   }
 
   public WarehouseIntoWare getWarehouseIntoWare() {
     return this.warehouseIntoWare;
   }
   public void setWarehouseIntoWare(WarehouseIntoWare warehouseIntoWare) {
     this.warehouseIntoWare = warehouseIntoWare;
   }
 }

/* 
 
 
 */