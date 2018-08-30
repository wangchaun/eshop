 package com.sinokj.app.store.gift.model;
 
 import com.sinokj.code.bean.Base;
 
 public class GiftGood extends Base
 {
   private static final long serialVersionUID = 1L;
   private String promoteId;
   private String goodId;
   private String goodName;
   private Double priceMarket;
   private Double pricePromote;
 
   public String getPromoteId()
   {
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
 }

/* 
 
 
 */