 package com.sinokj.app.good.goodAttr.model;
 
 import com.sinokj.code.bean.Base;
 
 public class GoodAttrValue extends Base
 {
   private static final long serialVersionUID = 1868284268981800706L;
   private String goodId;
   private String goodAttrId;
   private String attrValue;
 
   public String getGoodId()
   {
     return this.goodId;
   }
   public String getGoodAttrId() {
     return this.goodAttrId;
   }
   public String getAttrValue() {
     return this.attrValue;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
   public void setGoodAttrId(String goodAttrId) {
     this.goodAttrId = goodAttrId;
   }
   public void setAttrValue(String attrValue) {
     this.attrValue = attrValue;
   }
 }

/* 
 
 
 */