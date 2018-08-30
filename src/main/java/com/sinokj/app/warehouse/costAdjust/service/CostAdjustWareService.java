 package com.sinokj.app.warehouse.costAdjust.service;
 
 import com.sinokj.app.warehouse.costAdjust.model.CostAdjustWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class CostAdjustWareService extends BaseService<CostAdjustWare>
 {
   public void deleteByIntoId(String intoId)
     throws Exception
   {
     if (StringUtils.isBlank(intoId)) {
       throw new Exception("intoId is null");
     }
     Map param = new HashMap();
     param.put("orderId", intoId);
     this.publicDAO.delete("CostAdjustWare.CostAdjustWare", param);
   }
 }

/* 
 
 
 */