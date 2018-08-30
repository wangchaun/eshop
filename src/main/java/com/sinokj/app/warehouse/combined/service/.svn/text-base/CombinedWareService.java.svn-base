 package com.sinokj.app.warehouse.combined.service;
 
 import com.sinokj.app.warehouse.combined.model.CombinedWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class CombinedWareService extends BaseService<CombinedWare>
 {
   public void deleteByOrderId(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("orderId", orderId);
     this.publicDAO.delete("CombinedWare.CombinedWare", param);
   }
 }

/* 
 
 
 */