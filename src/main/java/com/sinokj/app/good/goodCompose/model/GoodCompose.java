 package com.sinokj.app.good.goodCompose.model;
 
 import com.sinokj.code.bean.Base;
 
 public class GoodCompose extends Base
 {
   private static final long serialVersionUID = -595109428374011341L;
   private String goodId;
   private String composeGoodId;
   private Double priceDiscount;
   private String goodTypeName;
   private String brandName;
   private Double price;
   private String goodName;
   private String pic;
   private String introBrief;
   private String wareId;
 
   public String getGoodId()
   {
     return this.goodId;
   }
 
   public Double getPriceDiscount() {
     return this.priceDiscount;
   }
 
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
 
   public void setPriceDiscount(Double priceDiscount) {
     this.priceDiscount = priceDiscount;
   }
 
   public String getComposeGoodId() {
     return this.composeGoodId;
   }
 
   public void setComposeGoodId(String composeGoodId) {
     this.composeGoodId = composeGoodId;
   }
 
   public String getGoodTypeName() {
     return this.goodTypeName;
   }
 
   public String getBrandName() {
     return this.brandName;
   }
 
   public Double getPrice() {
     return this.price;
   }
 
   public void setGoodTypeName(String goodTypeName) {
     this.goodTypeName = goodTypeName;
   }
 
   public void setBrandName(String brandName) {
     this.brandName = brandName;
   }
 
   public void setPrice(Double price) {
     this.price = price;
   }
   public String getGoodName() {
     return this.goodName;
   }
   public void setGoodName(String goodName) {
     this.goodName = goodName;
   }
   public String getPic() {
     return this.pic;
   }
   public void setPic(String pic) {
     this.pic = pic;
   }
 
   public String getIntroBrief() {
     return this.introBrief;
   }
 
   public void setIntroBrief(String introBrief) {
     this.introBrief = introBrief;
   }
 
   public String getWareId() {
     return this.wareId;
   }
 
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
 }

/* 
 
 
 */