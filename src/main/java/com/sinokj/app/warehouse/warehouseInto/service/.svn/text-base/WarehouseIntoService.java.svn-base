 package com.sinokj.app.warehouse.warehouseInto.service;
 
 import com.sinokj.app.warehouse.warehouseInto.model.WarehouseInto;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WarehouseIntoService extends BaseService<WarehouseInto>
 {
   public WarehouseInto getWarehouseIntoByOrderId(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("orderId", orderId);
     param.put("type", "0");
     WarehouseInto warehouseInto = (WarehouseInto)this.publicDAO.selectOne("WarehouseInto.WarehouseInto", param);
     return warehouseInto;
   }
 }

/* 
 
 
 */