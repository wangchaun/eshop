 package com.sinokj.app.warehouse.warehousePosition.service;
 
 import com.sinokj.app.warehouse.warehousePosition.model.WarehousePositionWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WarehousePositionWareService extends BaseService<WarehousePositionWare>
 {
   public List<WarehousePositionWare> getWareByPositionId(String positionId)
     throws Exception
   {
     if (StringUtils.isBlank(positionId)) {
       throw new Exception("intoId is null");
     }
     Map param = new HashMap();
     param.put("warehousePositionId", positionId);
     List resultList = this.publicDAO.select("WarehousePositionWare.WarehousePositionWare", param);
     return resultList;
   }
 
   public void updateWareNum(Map<String, String> param, int changeNum)
     throws Exception
   {
     String wareId = (String)param.get("wareId");
     String warehousePositionId = (String)param.get("warehousePositionId");
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null ");
     }
     if (StringUtils.isBlank(warehousePositionId)) {
       throw new Exception("warehousePositionId is null ");
     }
     Map map = new HashMap();
     map.put("wareId", wareId);
     map.put("warehousePositionId", warehousePositionId);
     WarehousePositionWare warehousePositionWare = (WarehousePositionWare)this.publicDAO.selectOne("WarehousePositionWare.WarehousePositionWare", map);
     if (warehousePositionWare == null) {
       warehousePositionWare = new WarehousePositionWare();
       warehousePositionWare.setWareId(wareId);
       warehousePositionWare.setWareName((String)param.get("wareName"));
       warehousePositionWare.setWarehouseId((String)param.get("warehouseId"));
       warehousePositionWare.setWarehouseName((String)param.get("warehouseName"));
       warehousePositionWare.setWarehousePositionId(warehousePositionId);
       warehousePositionWare.setWarehousePositionName((String)param.get("warehousePositionName"));
       int count = getWarehousePositionWareCount(warehousePositionId).intValue();
       warehousePositionWare.setSort(Integer.valueOf(count + 1));
       warehousePositionWare.setWareCount(changeNum);
       if (warehousePositionWare.getWareCount() >= 0)
         insert(warehousePositionWare);
     }
     else {
       int wareCount = warehousePositionWare.getWareCount();
       wareCount += changeNum;
       warehousePositionWare.setWareCount(wareCount);
       update(warehousePositionWare);
     }
   }
 
   public Integer getWarehousePositionWareCount(String warehousePositionId)
     throws Exception
   {
     if (StringUtils.isBlank(warehousePositionId)) {
       throw new Exception("warehousePositionId is null ");
     }
     Map param = new HashMap();
     param.put("warehousePositionId", warehousePositionId);
     Integer count = Integer.valueOf(this.publicDAO.select("WarehousePositionWare.WarehousePositionWare", param).size());
     return count;
   }
 }

/* 
 
 
 */