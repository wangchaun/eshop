 package com.sinokj.app.order.price.priceAdjust.service;
 
 import com.sinokj.app.order.price.priceAdjust.model.PriceAdjustWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class PriceAdjustWareService extends BaseService<PriceAdjustWare>
 {
   public void deleteByOrderId(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("orderId", orderId);
     this.publicDAO.delete("PriceAdjustWare.PriceAdjustWare", param);
   }
 }

/* 
 
 
 */