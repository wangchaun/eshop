 package com.sinokj.app.good.goodKind.model;
 
 import com.sinokj.code.bean.Base;
 
 public class GoodKind extends Base
 {
   private static final long serialVersionUID = 581864322996065545L;
   private String remark;
   private String goodtypeId;
   private String goodtypeName;
 
   public String getGoodtypeId()
   {
     return this.goodtypeId;
   }
   public void setGoodtypeId(String goodtypeId) {
     this.goodtypeId = goodtypeId;
   }
   public String getGoodtypeName() {
     return this.goodtypeName;
   }
   public void setGoodtypeName(String goodtypeName) {
     this.goodtypeName = goodtypeName;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
 }

/* 
 
 
 */