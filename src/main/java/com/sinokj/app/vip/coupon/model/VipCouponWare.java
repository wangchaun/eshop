 package com.sinokj.app.vip.coupon.model;
 
 import com.sinokj.code.bean.Base;
 
 public class VipCouponWare extends Base
 {
   private static final long serialVersionUID = 1L;
   private String vipCouponId;
   private String vipCouponName;
   private String wareId;
   private String wareName;
 
   public String getVipCouponId()
   {
     return this.vipCouponId;
   }
   public void setVipCouponId(String vipCouponId) {
     this.vipCouponId = vipCouponId;
   }
   public String getVipCouponName() { return this.vipCouponName; }
 
   public void setVipCouponName(String vipCouponName) {
     this.vipCouponName = vipCouponName;
   }
   public String getWareId() {
     return this.wareId;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
   public String getWareName() {
     return this.wareName;
   }
   public void setWareName(String wareName) {
     this.wareName = wareName;
   }
 }

/* 
 
 
 */