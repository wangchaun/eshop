 package com.sinokj.app.vip.prepaid.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Prepaid extends Base
 {
   private static final long serialVersionUID = 1L;
   private String customerId;
   private String customerName;
   private Double prepaidMoney;
   private String deptId;
   private String deptName;
   private String handlerId;
   private String handlerName;
   private String remark;
 
   public String getCustomerId()
   {
     return this.customerId;
   }
   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }
   public String getCustomerName() {
     return this.customerName;
   }
   public void setCustomerName(String customerName) {
     this.customerName = customerName;
   }
   public Double getPrepaidMoney() {
     return this.prepaidMoney;
   }
   public void setPrepaidMoney(Double prepaidMoney) {
     this.prepaidMoney = prepaidMoney;
   }
   public String getDeptId() {
     return this.deptId;
   }
   public void setDeptId(String deptId) {
     this.deptId = deptId;
   }
   public String getDeptName() {
     return this.deptName;
   }
   public void setDeptName(String deptName) {
     this.deptName = deptName;
   }
   public String getHandlerId() {
     return this.handlerId;
   }
   public void setHandlerId(String handlerId) {
     this.handlerId = handlerId;
   }
   public String getHandlerName() {
     return this.handlerName;
   }
   public void setHandlerName(String handlerName) {
     this.handlerName = handlerName;
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