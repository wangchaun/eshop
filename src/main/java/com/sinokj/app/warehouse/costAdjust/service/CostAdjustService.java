 package com.sinokj.app.warehouse.costAdjust.service;
 
 import com.sinokj.app.warehouse.costAdjust.model.CostAdjust;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class CostAdjustService extends BaseService<CostAdjust>
 {
   public void deleteByOrderId(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("orderId", orderId);
     this.publicDAO.delete("CostAdjustWare.CostAdjustWare", param);
   }
 }

/* 
 
 
 */