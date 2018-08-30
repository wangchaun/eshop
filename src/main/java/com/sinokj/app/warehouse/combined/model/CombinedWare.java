 package com.sinokj.app.warehouse.combined.model;
 
 import com.sinokj.code.bean.Base;
 
 public class CombinedWare extends Base
 {
   private static final long serialVersionUID = 1L;
   private String orderId;
   private String wareId;
   private String wareName;
   private int wareCount;
 
   public String getOrderId()
   {
     return this.orderId;
   }
   public String getWareId() {
     return this.wareId;
   }
   public String getWareName() {
     return this.wareName;
   }
   public int getWareCount() {
     return this.wareCount;
   }
   public void setOrderId(String orderId) {
     this.orderId = orderId;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
   public void setWareName(String wareName) {
     this.wareName = wareName;
   }
   public void setWareCount(int wareCount) {
     this.wareCount = wareCount;
   }
 }

/* 
 
 
 */