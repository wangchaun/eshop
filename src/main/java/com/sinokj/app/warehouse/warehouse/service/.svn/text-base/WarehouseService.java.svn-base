 package com.sinokj.app.warehouse.warehouse.service;
 
 import com.sinokj.app.warehouse.warehouse.model.Warehouse;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.List;
import org.apache.commons.lang3.StringUtils;
 
 public class WarehouseService extends BaseService<Warehouse>
 {
   public void updateCostInventory(String warehouseId, Double changeCost)
     throws Exception
   {
     if (StringUtils.isBlank(warehouseId)) {
       throw new Exception("warehouseId is null");
     }
     Warehouse warehouse = (Warehouse)getModel(warehouseId);
     Double cost = Double.valueOf(0.0D);
     if (warehouse.getTotalCostInventory() != null) {
       cost = warehouse.getTotalCostInventory();
     }
     cost = Double.valueOf(cost.doubleValue() + changeCost.doubleValue());
     warehouse.setTotalCostInventory(cost);
     update(warehouse);
   }
 
   public List<Warehouse> getWarehouseList()
   {
     return this.publicDAO.select("Warehouse.front_Warehouse", null);
   }
 }

/* 
 
 
 */