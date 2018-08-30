 package com.sinokj.app.good.ware.model;
 
 import com.sinokj.code.bean.Base;
 
 public class WareSpecificationVal extends Base
 {
   private static final long serialVersionUID = 8038208173373814744L;
   private String wareId;
   private String goodSpecificationValId;
   private String specificationValName;
 
   public String getWareId()
   {
     return this.wareId;
   }
   public String getGoodSpecificationValId() {
     return this.goodSpecificationValId;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
   public void setGoodSpecificationValId(String goodSpecificationValId) {
     this.goodSpecificationValId = goodSpecificationValId;
   }
   public String getSpecificationValName() {
     return this.specificationValName;
   }
   public void setSpecificationValName(String specificationValName) {
     this.specificationValName = specificationValName;
   }
 }

/* 
 
 
 */