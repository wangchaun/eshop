 package com.sinokj.app.good.goodRelate.model;
 
 import com.sinokj.code.bean.Base;
 
 public class GoodRelate extends Base
 {
   private static final long serialVersionUID = -6695606258651883449L;
   private String goodId;
   private String relateGoodId;
   private String goodTypeName;
   private String brandName;
   private Double price;
   private String goodName;
   private String pic;
 
   public String getGoodId()
   {
     return this.goodId;
   }
   public String getRelateGoodId() {
     return this.relateGoodId;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
   public void setRelateGoodId(String relateGoodId) {
     this.relateGoodId = relateGoodId;
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
 }

/* 
 
 
 */