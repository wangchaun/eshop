 package com.sinokj.app.order.cashBasis.pay.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Pay extends Base
 {
   private static final long serialVersionUID = 1L;
   private Double moneyAccount;
   private Double moneyPayment;
   private String remark;
   private String handlerId;
   private String handlerName;
   private String deptId;
   private String deptName;
   private String customerId;
   private String customerName;
 
   public Double getMoneyAccount()
   {
     return this.moneyAccount;
   }
   public void setMoneyAccount(Double moneyAccount) {
     this.moneyAccount = moneyAccount;
   }
   public Double getMoneyPayment() {
     return this.moneyPayment;
   }
   public void setMoneyPayment(Double moneyPayment) {
     this.moneyPayment = moneyPayment;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setRemark(String remark) {
     this.remark = remark;
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
   public String getCustomerId() {
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
 }

/* 
 
 
 */