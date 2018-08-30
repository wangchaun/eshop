 package com.sinokj.app.order.cashBasis.pay.model;
 
 import com.sinokj.code.bean.Base;
 
 public class CashItem extends Base
 {
   private static final long serialVersionUID = 1L;
   private Double money;
   private String orderId;
   private String remark;
   private String bankAccountCode;
   private String bankAccountId;
   private String account;
   private String bankAccountName;
   private String accountHolder;
   private String bank;
 
   public Double getMoney()
   {
     return this.money;
   }
   public void setMoney(Double money) {
     this.money = money;
   }
   public String getOrderId() {
     return this.orderId;
   }
   public void setOrderId(String orderId) {
     this.orderId = orderId;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public String getBankAccountCode() {
     return this.bankAccountCode;
   }
   public void setBankAccountCode(String bankAccountCode) {
     this.bankAccountCode = bankAccountCode;
   }
   public String getBankAccountId() {
     return this.bankAccountId;
   }
   public void setBankAccountId(String bankAccountId) {
     this.bankAccountId = bankAccountId;
   }
   public String getAccount() {
     return this.account;
   }
   public void setAccount(String account) {
     this.account = account;
   }
   public String getBankAccountName() {
     return this.bankAccountName;
   }
   public void setBankAccountName(String bankAccountName) {
     this.bankAccountName = bankAccountName;
   }
   public String getAccountHolder() {
     return this.accountHolder;
   }
   public void setAccountHolder(String accountHolder) {
     this.accountHolder = accountHolder;
   }
   public String getBank() {
     return this.bank;
   }
   public void setBank(String bank) {
     this.bank = bank;
   }
 }

/* 
 
 
 */