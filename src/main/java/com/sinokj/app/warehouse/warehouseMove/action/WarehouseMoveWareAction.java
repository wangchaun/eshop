 package com.sinokj.app.warehouse.warehouseMove.action;
 
 import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.warehouse.warehouseMove.model.WarehouseMoveWare;
import com.sinokj.app.warehouse.warehouseMove.service.WarehouseMoveWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class WarehouseMoveWareAction extends BaseAction
 {
   private static final long serialVersionUID = -5328157621841061704L;
   private static final Logger logger = Logger.getLogger(WarehouseMoveWareAction.class);
   private WarehouseMoveWare warehouseMoveWare;
   private WarehouseMoveWareService warehouseMoveWareService;
   private WareService wareService;
 
   public void setWarehouseMoveWareService(WarehouseMoveWareService warehouseMoveWareService)
   {
     this.warehouseMoveWareService = warehouseMoveWareService;
   }
 
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
 
   public String listJson()
   {
     logger.info("start list warehouseMoveWare!");
     List<WarehouseMoveWare> resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehouseMoveWare == null) {
         this.warehouseMoveWare = new WarehouseMoveWare();
       }
       resultList = this.warehouseMoveWareService.pageList(pageInfo, this.warehouseMoveWare, true);
       if (resultList != null) {
         for (WarehouseMoveWare warehouseMoveWare : resultList) {
           Ware ware = (Ware)this.wareService.getModel(warehouseMoveWare.getWareId());
           warehouseMoveWare.setCode(ware.getCode());
         }
       }
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list warehouseMoveWare", e);
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
   public WarehouseMoveWare getWarehouseMoveWare() {
     return this.warehouseMoveWare;
   }
 
   public void setWarehouseMoveWare(WarehouseMoveWare warehouseMoveWare) {
     this.warehouseMoveWare = warehouseMoveWare;
   }
 }

/* 
 
 
 */