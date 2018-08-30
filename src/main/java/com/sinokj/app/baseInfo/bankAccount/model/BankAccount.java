 package com.sinokj.app.baseInfo.bankAccount.model;
 
 import com.sinokj.code.bean.Base;
 
 public class BankAccount extends Base
 {
   private static final long serialVersionUID = 7802573014841382481L;
   private String account;
   private Double money;
   private String accountHolder;
   private String bank;
   private String remark;
 
   public String getAccount()
   {
     return this.account;
   }
   public Double getMoney() {
     return this.money;
   }
   public String getAccountHolder() {
     return this.accountHolder;
   }
   public String getBank() {
     return this.bank;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setAccount(String account) {
     this.account = account;
   }
   public void setMoney(Double money) {
     this.money = money;
   }
   public void setAccountHolder(String accountHolder) {
     this.accountHolder = accountHolder;
   }
   public void setBank(String bank) {
     this.bank = bank;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
 }