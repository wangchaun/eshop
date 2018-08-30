 package com.sinokj.app.good.goodAttr.model;
 
 import com.sinokj.app.good.goodKind.model.GoodKingVal;
import com.sinokj.code.bean.Base;

import java.util.List;
 
 public class GoodAttr extends Base
 {
   private static final long serialVersionUID = 4602552882352444259L;
   private String goodKindId;
   private String inputType;
   private String remark;
   private String value;
   private String attrValueId;
   private String attrValue;
   private List<GoodKingVal> goodKingValList;
 
   public String getGoodKindId()
   {
     return this.goodKindId;
   }
   public String getInputType() {
     return this.inputType;
   }
   public String getRemark() {
     return this.remark;
   }
   public String getValue() {
     return this.value;
   }
   public String getAttrValueId() {
     return this.attrValueId;
   }
   public String getAttrValue() {
     return this.attrValue;
   }
   public void setGoodKindId(String goodKindId) {
     this.goodKindId = goodKindId;
   }
   public void setInputType(String inputType) {
     this.inputType = inputType;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public void setValue(String value) {
     this.value = value;
   }
   public void setAttrValueId(String attrValueId) {
     this.attrValueId = attrValueId;
   }
   public void setAttrValue(String attrValue) {
     this.attrValue = attrValue;
   }
   public List<GoodKingVal> getGoodKingValList() {
     return this.goodKingValList;
   }
   public void setGoodKingValList(List<GoodKingVal> goodKingValList) {
     this.goodKingValList = goodKingValList;
   }
 }

/* 
 
 
 */