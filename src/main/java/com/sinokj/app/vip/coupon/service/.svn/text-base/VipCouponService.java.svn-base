 package com.sinokj.app.vip.coupon.service;
 
 import com.sinokj.app.vip.coupon.model.VipCoupon;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
import java.util.Map;
 
 public class VipCouponService extends BaseService<VipCoupon>
 {
   public List<VipCoupon> getListCode(String code)
     throws Exception
   {
     if (code == null) {
       throw new Exception("code is null");
     }
     Map map = new HashMap();
     map.put("code", code);
     List list = this.publicDAO.select("VipCoupon.VipCoupon_by_code", map);
     return list;
   }
 
   public void updateState(String id)
   {
     Map param = new HashMap();
     param.put("id", id);
     VipCoupon vipCoupon = (VipCoupon)this.publicDAO.selectOne("VipCoupon.VipCoupon", param);
     if (vipCoupon != null) {
       vipCoupon.setState("d");
       this.publicDAO.update("VipCoupon.VipCoupon", vipCoupon);
     }
   }
 
   public List<VipCoupon> getAddList(Object obj)
     throws Exception
   {
     if (obj == null) {
       throw new Exception("object is null");
     }
 
     List list = this.publicDAO.select("VipCoupon.VipCoupon_query", obj);
     return list;
   }
 
   public Double getMoneyByCustomerId(String customerId)
     throws Exception
   {
     if (customerId == null) {
       throw new Exception("code is null");
     }
     Map param = new HashMap();
     param.put("customerId", customerId);
     Double money = (Double)this.publicDAO.selectOne("VipCoupon.VipCoupon_by_customerId", param);
     return money;
   }
 }

/* 
 
 
 */