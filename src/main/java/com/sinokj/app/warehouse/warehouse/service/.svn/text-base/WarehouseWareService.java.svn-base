 package com.sinokj.app.warehouse.warehouse.service;
 
 import com.sinokj.app.warehouse.warehouse.model.WarehouseWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WarehouseWareService extends BaseService<WarehouseWare>
 {
   public WarehouseWare getWarehouseWareByWareId(String wareId, String warehouseId)
     throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     if (StringUtils.isBlank(warehouseId)) {
       throw new Exception("warehouseId is null");
     }
     Map param = new HashMap();
     param.put("wareId", wareId);
     param.put("warehouseId", warehouseId);
     WarehouseWare warehouseWare = (WarehouseWare)this.publicDAO.selectOne("WarehouseWare.WarehouseWare", param);
     return warehouseWare;
   }
 
   public void updateInventory(Map<String, String> param, int changeNum, Double warePrice)
     throws Exception
   {
     String wareId = (String)param.get("wareId");
     String warehouseId = (String)param.get("warehouseId");
     WarehouseWare warehouseWare = getWarehouseWareByWareId(wareId, warehouseId);
     if (warehouseWare == null) {
       warehouseWare = new WarehouseWare();
       warehouseWare.setWareId(wareId);
       warehouseWare.setWareName((String)param.get("wareName"));
       warehouseWare.setWarehouseId(warehouseId);
       warehouseWare.setWarehouseName((String)param.get("warehouseName"));
       warehouseWare.setWareCount(changeNum);
       warehouseWare.setAverageCostInventory(warePrice);
       warehouseWare.setTotalCostInventory(Double.valueOf(warePrice.doubleValue() * changeNum));
       int sort = getWareCount(warehouseId).intValue();
       warehouseWare.setSort(Integer.valueOf(sort + 1));
       insert(warehouseWare);
     }
     else {
       int wareCount = warehouseWare.getWareCount();
       wareCount += changeNum;
       warehouseWare.setWareCount(wareCount);
       Double totalCostInventory = Double.valueOf(0.0D);
       if (warehouseWare.getTotalCostInventory() != null) {
         totalCostInventory = warehouseWare.getTotalCostInventory();
       }
 
       if (warePrice.equals(Double.valueOf(-1.0D))) {
         warePrice = warehouseWare.getAverageCostInventory();
       }
       totalCostInventory = Double.valueOf(totalCostInventory.doubleValue() + warePrice.doubleValue() * changeNum);
       Double averageCostInventory = Double.valueOf(totalCostInventory.doubleValue() / wareCount);
       warehouseWare.setAverageCostInventory(averageCostInventory);
       warehouseWare.setTotalCostInventory(totalCostInventory);
       update(warehouseWare);
     }
   }
 
   public void updateCost(String warehouseId, String wareId, Double changeCost)
     throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     if (StringUtils.isBlank(warehouseId)) {
       throw new Exception("warehouseId is null");
     }
     WarehouseWare warehouseWare = getWarehouseWareByWareId(wareId, warehouseId);
     if (warehouseWare != null) {
       int wareCount = warehouseWare.getWareCount();
       Double totalCostInventory = Double.valueOf(wareCount * changeCost.doubleValue());
       warehouseWare.setAverageCostInventory(changeCost);
       warehouseWare.setTotalCostInventory(totalCostInventory);
       update(warehouseWare);
     }
   }
 
   public Integer getWareCount(String warehouseId)
     throws Exception
   {
     if (StringUtils.isBlank(warehouseId)) {
       throw new Exception("warehouseId is null");
     }
     Map param = new HashMap();
     param.put("warehouseId", warehouseId);
     Integer count = Integer.valueOf(this.publicDAO.select("WarehouseWare.WarehouseWare", param).size());
     return count;
   }
 }

/* 
 
 
 */