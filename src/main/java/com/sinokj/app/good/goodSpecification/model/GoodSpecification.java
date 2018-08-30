 package com.sinokj.app.good.goodSpecification.model;
 
 import com.sinokj.code.bean.Base;
 
 public class GoodSpecification extends Base
 {
   private static final long serialVersionUID = 5054104975426159299L;
   private String showType;
   private String showWay;
   private String remark;
   private String[] idArr;
   private String value;
   private String goodId;
 
   public String getShowType()
   {
     return this.showType;
   }
   public String getShowWay() {
     return this.showWay;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setShowType(String showType) {
     this.showType = showType;
   }
   public void setShowWay(String showWay) {
     this.showWay = showWay;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public String[] getIdArr() {
     return this.idArr;
   }
   public void setIdArr(String[] idArr) {
     this.idArr = idArr;
   }
   public String getValue() {
     return this.value;
   }
   public void setValue(String value) {
     this.value = value;
   }
   public String getGoodId() {
     return this.goodId;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
 }

/* 
 
 
 */