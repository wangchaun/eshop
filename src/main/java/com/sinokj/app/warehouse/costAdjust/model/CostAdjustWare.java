 package com.sinokj.app.warehouse.costAdjust.model;
 
 import com.sinokj.code.bean.Base;
 
 public class CostAdjustWare extends Base
 {
   private static final long serialVersionUID = 1L;
   private String orderId;
   private String wareId;
   private String wareName;
   private String wareCode;
   private int stock;
   private Double costCurrent;
   private Double costAdjust;
   private String remark;
   private String goodTypeName;
   private String wareSpecificationVal;
 
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
   public Double getCostCurrent() {
     return this.costCurrent;
   }
   public Double getCostAdjust() {
     return this.costAdjust;
   }
   public String getGoodTypeName() {
     return this.goodTypeName;
   }
   public String getWareSpecificationVal() {
     return this.wareSpecificationVal;
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
   public void setCostCurrent(Double costCurrent) {
     this.costCurrent = costCurrent;
   }
   public void setCostAdjust(Double costAdjust) {
     this.costAdjust = costAdjust;
   }
   public void setGoodTypeName(String goodTypeName) {
     this.goodTypeName = goodTypeName;
   }
   public void setWareSpecificationVal(String wareSpecificationVal) {
     this.wareSpecificationVal = wareSpecificationVal;
   }
 
   public int getStock() {
     return this.stock;
   }
   public void setStock(int stock) {
     this.stock = stock;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public String getWareCode() {
     return this.wareCode;
   }
   public void setWareCode(String wareCode) {
     this.wareCode = wareCode;
   }
 }

/* 
 
 
 */