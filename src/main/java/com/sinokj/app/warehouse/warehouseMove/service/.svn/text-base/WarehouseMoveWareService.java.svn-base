 package com.sinokj.app.warehouse.warehouseMove.service;
 
 import com.sinokj.app.warehouse.warehouseMove.model.WarehouseMoveWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WarehouseMoveWareService extends BaseService<WarehouseMoveWare>
 {
   public void deleteByWarehouseMoveId(String warehouseMoveId)
     throws Exception
   {
     if (StringUtils.isBlank(warehouseMoveId)) {
       throw new Exception("warehouseMoveId is null");
     }
     Map param = new HashMap();
     param.put("warehouseMoveId", warehouseMoveId);
     this.publicDAO.delete("WarehouseMoveWare.WarehouseMoveWare", param);
   }
 
   public List pageListTransfer(WarehouseMoveWare ware) {
     List result = this.publicDAO.select("WarehouseMoveWare.WarehouseMoveWare_Transfer", ware);
     return result;
   }
 
   public List pageListSummary(WarehouseMoveWare ware)
   {
     List result = this.publicDAO.select("WarehouseMoveWare.WarehouseMoveWare_Summary", ware);
     return result;
   }
 }

/* 
 
 
 */