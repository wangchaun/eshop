 package com.sinokj.app.order.buy.rebate.model;
 
 import com.sinokj.code.bean.Base;
 
 public class RebateItem extends Base
 {
   private static final long serialVersionUID = 1L;
   private String supplierId;
   private String supplierName;
   private String rebateId;
   private Double rebateAmount;
   private String remark;
   private Double saleMoney;
   private Double rebateRate;
   private Float actualRebate;
 
   public String getSupplierId()
   {
     return this.supplierId;
   }
   public void setSupplierId(String supplierId) {
     this.supplierId = supplierId;
   }
   public String getSupplierName() {
     return this.supplierName;
   }
   public void setSupplierName(String supplierName) {
     this.supplierName = supplierName;
   }
   public Double getRebateAmount() {
     return this.rebateAmount;
   }
   public void setRebateAmount(Double rebateAmount) {
     this.rebateAmount = rebateAmount;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public String getRebateId() {
     return this.rebateId;
   }
   public void setRebateId(String rebateId) {
     this.rebateId = rebateId;
   }
   public Double getSaleMoney() {
     return this.saleMoney;
   }
   public void setSaleMoney(Double saleMoney) {
     this.saleMoney = saleMoney;
   }
   public Double getRebateRate() {
     return this.rebateRate;
   }
   public void setRebateRate(Double rebateRate) {
     this.rebateRate = rebateRate;
   }
   public Float getActualRebate() {
     return this.actualRebate;
   }
   public void setActualRebate(Float actualRebate) {
     this.actualRebate = actualRebate;
   }
 }

/* 
 
 
 */