 package com.sinokj.app.baseInfo.payment.service;
 
 import com.sinokj.app.baseInfo.payment.model.Payment;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
import java.util.Map;
 
 public class PaymentService extends BaseService<Payment>
 {
   public Payment getPayment(Payment payment)
     throws Exception
   {
     if (payment == null) {
       throw new Exception("payment is null,can not query");
     }
     Payment way = null;
     Map map = new HashMap();
     map.put("code", payment.getCode());
     Object obj = this.publicDAO.selectOne("Payment.Payment", map);
     if (obj != null) {
       way = (Payment)obj;
     }
     return way;
   }
 }