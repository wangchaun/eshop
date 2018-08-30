 package com.sinokj.app.order.sale.saleCollection.service;
 
 import com.sinokj.app.order.sale.saleCollection.model.SaleCollection;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class SaleCollectionService extends BaseService<SaleCollection>
 {
   public SaleCollection getSaleCollectionByOrderId(String orderId)
     throws Exception
   {
     if (StringUtils.isBlank(orderId)) {
       throw new Exception("orderId is null");
     }
     Map param = new HashMap();
     param.put("orderId", orderId);
     SaleCollection saleCollection = (SaleCollection)this.publicDAO.selectOne("SaleCollection.SaleCollection", param);
     return saleCollection;
   }
 }

/* 
 
 
 */