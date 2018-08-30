 package com.sinokj.app.front.browse.model;
 
 import com.sinokj.code.bean.Base;
 
 public class BrowseOthers extends Base
 {
   private static final long serialVersionUID = -2446719740797638726L;
   private String goodId;
   private String goodName;
   private String goodPic;
   private Double goodPrice;
   private Double clickNumber;
   private String goodTypeId;
   private String goodTypeName;
   private Double clickValue;
   private String introBrief;
 
   public String getIntroBrief()
   {
     return this.introBrief;
   }
   public void setIntroBrief(String introBrief) {
     this.introBrief = introBrief;
   }
   public Double getClickValue() {
     return this.clickValue;
   }
   public void setClickValue(Double clickValue) {
     this.clickValue = clickValue;
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
 }