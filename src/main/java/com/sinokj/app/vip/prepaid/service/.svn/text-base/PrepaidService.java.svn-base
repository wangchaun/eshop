 package com.sinokj.app.vip.prepaid.service;
 
 import com.sinokj.app.vip.prepaid.model.Prepaid;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
import java.util.Map;
 
 public class PrepaidService extends BaseService<Prepaid>
 {
   public List<Prepaid> getTotalMoney(String code, String customerName)
     throws Exception
   {
     if (code == null) {
       throw new Exception("code is null");
     }
     Map map = new HashMap();
     map.put("code", code);
     map.put("customerName", customerName);
     List list = this.publicDAO.select("Prepaid.Prepaid_sum_query", map);
     return list;
   }
 }

/* 
 
 
 */