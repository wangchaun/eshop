 package com.sinokj.app.order.cashBasis.pay.service;
 
 import com.sinokj.app.order.cashBasis.pay.model.CashItem;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class CashItemService extends BaseService<CashItem>
 {
   public void deleteByIntoId(String intoId)
     throws Exception
   {
     if (StringUtils.isBlank(intoId)) {
       throw new Exception("intoId is null");
     }
     Map param = new HashMap();
     param.put("orderId", intoId);
     this.publicDAO.delete("CashItem.CashItem", param);
   }
 }

/* 
 
 
 */