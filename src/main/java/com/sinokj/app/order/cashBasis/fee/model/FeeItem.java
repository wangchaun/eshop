 package com.sinokj.app.order.cashBasis.fee.model;
 
 import com.sinokj.code.bean.Base;

import java.util.Date;
 
 public class FeeItem extends Base
 {
   private static final long serialVersionUID = 1L;
   private String name;
   private Double money;
   private String orderId;
   private String remark;
   private Double amount;
   private Double totlemoney;
   private Date beginTime;
   private Date endTime;
   private String customerName;
 
   public String getName()
   {
     return this.name;
   }
   public void setName(String name) {
     this.name = name;
   }
   public Double getMoney() {
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
   public Double getAmount() {
     return this.amount;
   }
   public void setAmount(Double amount) {
     this.amount = amount;
   }
   public Double getTotlemoney() {
     return this.totlemoney;
   }
   public void setTotlemoney(Double totlemoney) {
     this.totlemoney = totlemoney;
   }
   public Date getBeginTime() {
     return this.beginTime;
   }
   public void setBeginTime(Date beginTime) {
     this.beginTime = beginTime;
   }
   public Date getEndTime() {
     return this.endTime;
   }
   public void setEndTime(Date endTime) {
     this.endTime = endTime;
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