 package com.sinokj.app.warehouse.warehousePosition.service;
 
 import com.sinokj.app.warehouse.warehousePosition.model.WarehousePosition;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WarehousePositionService extends BaseService<WarehousePosition>
 {
   public List<WarehousePosition> getWarehousePositionValByWarehouseId(String warehouseId)
   {
     if (StringUtils.isBlank(warehouseId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("warehouseId", warehouseId);
 
     List list = this.publicDAO.select("WarehousePosition.WarehousePosition", param);
     return list;
   }
 
   public List<WarehousePosition> getByWareId(String warehouseId, String wareId)
     throws Exception
   {
     if (StringUtils.isBlank(warehouseId)) {
       throw new Exception("warehouseId is null");
     }
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     Map param = new HashMap();
     param.put("warehouseId", warehouseId);
     param.put("wareId", wareId);
 
     List list = this.publicDAO.select("WarehousePosition.WarehousePosition_wareId", param);
     return list;
   }
 }

/* 
 
 
 */