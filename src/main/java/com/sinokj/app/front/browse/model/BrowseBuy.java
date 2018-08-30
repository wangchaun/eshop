 package com.sinokj.app.front.browse.model;
 
 import com.sinokj.code.bean.Base;
 
 public class BrowseBuy extends Base
 {
   private static final long serialVersionUID = -2446719740797638726L;
   private String goodId;
   private String goodName;
   private String goodPic;
   private Double goodPrice;
   private Double clickNumber;
   private String goodTypeId;
   private String goodTypeName;
   private String customerId;
   private Double buyNumber;
   private String parentId;
   private Double buyValue;
   private String introBrief;
   private String customerIdStr;
 
   public String getCustomerIdStr()
   {
     return this.customerIdStr;
   }
   public void setCustomerIdStr(String customerIdStr) {
     this.customerIdStr = customerIdStr;
   }
   public String getIntroBrief() {
     return this.introBrief;
   }
   public void setIntroBrief(String introBrief) {
     this.introBrief = introBrief;
   }
   public String getParentId() {
     return this.parentId;
   }
   public void setParentId(String parentId) {
     this.parentId = parentId;
   }
   public Double getClickNumber() {
     return this.clickNumber;
   }
   public void setClickNumber(Double clickNumber) {
     this.clickNumber = clickNumber;
   }
 
   public String getGoodTypeId() {
     return this.goodTypeId;
   }
   public void setGoodTypeId(String goodTypeId) {
     this.goodTypeId = goodTypeId;
   }
   public String getGoodTypeName() {
     return this.goodTypeName;
   }
   public void setGoodTypeName(String goodTypeName) {
     this.goodTypeName = goodTypeName;
   }
   public String getGoodName() {
     return this.goodName;
   }
   public void setGoodName(String goodName) {
     this.goodName = goodName;
   }
   public String getGoodPic() {
     return this.goodPic;
   }
   public void setGoodPic(String goodPic) {
     this.goodPic = goodPic;
   }
 
   public Double getGoodPrice() {
     return this.goodPrice;
   }
   public void setGoodPrice(Double goodPrice) {
     this.goodPrice = goodPrice;
   }
   public String getGoodId() {
     return this.goodId;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
   public Double getBuyValue() {
     return this.buyValue;
   }
   public void setBuyValue(Double buyValue) {
     this.buyValue = buyValue;
   }
   public String getCustomerId() {
     return this.customerId;
   }
   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }
   public Double getBuyNumber() {
     return this.buyNumber;
   }
   public void setBuyNumber(Double buyNumber) {
     this.buyNumber = buyNumber;
   }
 }