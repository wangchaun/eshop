 package com.sinokj.app.warehouse.warehousePosition.action;
 
 import com.sinokj.app.good.ware.model.WareSpecificationVal;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.app.warehouse.warehousePosition.model.WarehousePositionWare;
import com.sinokj.app.warehouse.warehousePosition.service.WarehousePositionWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class WarehousePositionWareAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(WarehousePositionWareAction.class);
   private WarehousePositionWare warehousePositionWare;
   private WarehousePositionWareService warehousePositionWareService;
   private WareSpecificationValService wareSpecificationValService;
 
   public void setWarehousePositionWareService(WarehousePositionWareService warehousePositionWareService)
   {
     this.warehousePositionWareService = warehousePositionWareService;
   }
 
   public String list()
   {
     return "list_warehousePositionWare";
   }
 
   public String listJson()
   {
     logger.info("start list warehousePositionWare");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehousePositionWare == null) {
         this.warehousePositionWare = new WarehousePositionWare();
       }
       resultList = this.warehousePositionWareService.pageList(pageInfo, this.warehousePositionWare, true);
       totalRows = pageInfo.getCount();
 
       for (int i = 0; i < resultList.size(); i++) {
         List wareSpecificationValList = this.wareSpecificationValService.getByWareId(((WarehousePositionWare)resultList.get(i)).getWareId());
         String specificationVal = "";
         for (int j = 0; j < wareSpecificationValList.size(); j++) {
           specificationVal = specificationVal + ((WareSpecificationVal)wareSpecificationValList.get(j)).getSpecificationValName();
           if (j + 1 != wareSpecificationValList.size()) {
             specificationVal = specificationVal + ",";
           }
         }
         ((WarehousePositionWare)resultList.get(i)).setWareSpecificationVal(specificationVal);
       }
     }
     catch (Exception e) {
       logger.error("error occur when list warehousePositionWare", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list warehousePositionWare");
     return "success";
   }
 
   public WarehousePositionWare getWarehousePositionWare() {
     return this.warehousePositionWare;
   }
   public void setWarehousePositionWare(WarehousePositionWare warehousePositionWare) {
     this.warehousePositionWare = warehousePositionWare;
   }
 
   public WareSpecificationValService getWareSpecificationValService() {
     return this.wareSpecificationValService;
   }
 
   public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService)
   {
     this.wareSpecificationValService = wareSpecificationValService;
   }
 }

/* 
 
 
 */