 package com.sinokj.app.warehouse.warehouseInto.service;
 
 import com.sinokj.app.warehouse.warehouseInto.model.WarehouseIntoWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WarehouseIntoWareService extends BaseService<WarehouseIntoWare>
 {
   public void deleteByIntoId(String intoId)
     throws Exception
   {
     if (StringUtils.isBlank(intoId)) {
       throw new Exception("intoId is null");
     }
     Map param = new HashMap();
     param.put("warehouseIntoId", intoId);
     this.publicDAO.delete("WarehouseIntoWare.WarehouseIntoWare", param);
   }
 
   public List<WarehouseIntoWare> pageListDaily(WarehouseIntoWare warehouseIntoWare)
   {
     List result = this.publicDAO.select("WarehouseIntoWare.WarehouseIntoWareList_daily", warehouseIntoWare);
     return result;
   }
 
   public List<WarehouseIntoWare> pageListColdstorage(WarehouseIntoWare warehouseIntoWare)
   {
     List result = this.publicDAO.select("WarehouseIntoWare.WarehouseIntoWareList_coldstorage", warehouseIntoWare);
     return result;
   }
 
   public List<WarehouseIntoWare> pageListDiscrepancy(WarehouseIntoWare warehouseIntoWare)
   {
     List result = this.publicDAO.select("WarehouseIntoWare.WarehouseIntoWareList_discrepancy", warehouseIntoWare);
     return result;
   }
 
   public List<WarehouseIntoWare> pageListInventory(WarehouseIntoWare warehouseIntoWare)
   {
     List result = this.publicDAO.select("WarehouseIntoWare.WarehouseIntoWareList_inventory", warehouseIntoWare);
     return result;
   }
 
   public List<WarehouseIntoWare> pageListKucuncount(WarehouseIntoWare warehouseIntoWare)
   {
     List result = this.publicDAO.select("WarehouseIntoWare.WarehouseIntoWareList_kucuncount", warehouseIntoWare);
     return result;
   }
 }

/* 
 
 
 */