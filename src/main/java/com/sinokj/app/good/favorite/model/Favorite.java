 package com.sinokj.app.good.favorite.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Favorite extends Base
 {
   private static final long serialVersionUID = 6309271268688143742L;
   private String goodId;
   private String goodName;
   private String picId;
   private String pic;
   private Double price;
   private String unit;
   private String goodCode;
   private String introBrief;
   private Double priceMarket;
   private Integer warehousecount;
   private String wareId;
 
   public Integer getWarehousecount()
   {
     return this.warehousecount;
   }
   public void setWarehousecount(Integer warehousecount) {
     this.warehousecount = warehousecount;
   }
   public Double getPriceMarket() {
     return this.priceMarket;
   }
   public void setPriceMarket(Double priceMarket) {
     this.priceMarket = priceMarket;
   }
   public String getIntroBrief() {
     return this.introBrief;
   }
   public void setIntroBrief(String introBrief) {
     this.introBrief = introBrief;
   }
   public String getGoodId() {
     return this.goodId;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
   public String getGoodName() {
     return this.goodName;
   }
   public void setGoodName(String goodName) {
     this.goodName = goodName;
   }
   public String getPicId() {
     return this.picId;
   }
   public void setPicId(String picId) {
     this.picId = picId;
   }
   public String getPic() {
     return this.pic;
   }
   public void setPic(String pic) {
     this.pic = pic;
   }
   public Double getPrice() {
     return this.price;
   }
   public void setPrice(Double price) {
     this.price = price;
   }
   public String getUnit() {
     return this.unit;
   }
   public void setUnit(String unit) {
     this.unit = unit;
   }
   public String getGoodCode() {
     return this.goodCode;
   }
   public void setGoodCode(String goodCode) {
     this.goodCode = goodCode;
   }
   public String getWareId() {
     return this.wareId;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
 }