 package com.sinokj.app.store.promote.model;
 
 import com.sinokj.code.bean.Base;
 
 public class PromoteGood extends Base
 {
   private static final long serialVersionUID = 1L;
   private String promoteId;
   private String goodId;
   private String goodName;
   private Double priceMarket;
   private Double pricePromote;
   private String pic;
   private String picId;
   private String introBrief;
   private Integer minprice;
   private Integer maxprice;
 
   public String getIntroBrief()
   {
     return this.introBrief;
   }
   public void setIntroBrief(String introBrief) {
     this.introBrief = introBrief;
   }
   public String getPromoteId() {
     return this.promoteId;
   }
   public void setPromoteId(String promoteId) {
     this.promoteId = promoteId;
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
   public Double getPriceMarket() {
     return this.priceMarket;
   }
   public void setPriceMarket(Double priceMarket) {
     this.priceMarket = priceMarket;
   }
   public Double getPricePromote() {
     return this.pricePromote;
   }
   public void setPricePromote(Double pricePromote) {
     this.pricePromote = pricePromote;
   }
   public String getPic() {
     return this.pic;
   }
   public void setPic(String pic) {
     this.pic = pic;
   }
   public String getPicId() {
     return this.picId;
   }
   public void setPicId(String picId) {
     this.picId = picId;
   }
   public Integer getMinprice() {
     return this.minprice;
   }
   public void setMinprice(Integer minprice) {
     this.minprice = minprice;
   }
   public Integer getMaxprice() {
     return this.maxprice;
   }
   public void setMaxprice(Integer maxprice) {
     this.maxprice = maxprice;
   }
 }

/* 
 
 
 */