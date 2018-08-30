 package com.sinokj.app.vip.applyCash.model;
 
 import com.sinokj.code.bean.Base;
 
 public class ApplyToCash extends Base
 {
   private static final long serialVersionUID = 1L;
   private String customerId;
   private String customerName;
   private Double toCashAmount;
   private String bankName;
   private String accountHolder;
   private String bankAccount;
   private String remark;
   private String handlerId;
   private String handlerName;
   private String deptId;
   private String deptName;
 
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
   public Double getToCashAmount() {
     return this.toCashAmount;
   }
   public void setToCashAmount(Double toCashAmount) {
     this.toCashAmount = toCashAmount;
   }
   public String getBankName() {
     return this.bankName;
   }
   public void setBankName(String bankName) {
     this.bankName = bankName;
   }
   public String getAccountHolder() {
     return this.accountHolder;
   }
   public void setAccountHolder(String accountHolder) {
     this.accountHolder = accountHolder;
   }
   public String getBankAccount() {
     return this.bankAccount;
   }
   public void setBankAccount(String bankAccount) {
     this.bankAccount = bankAccount;
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
 }

/* 
 
 
 */