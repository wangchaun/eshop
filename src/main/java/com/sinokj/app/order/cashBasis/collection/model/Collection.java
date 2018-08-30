 package com.sinokj.app.order.cashBasis.collection.model;
 
 import com.sinokj.code.bean.Base;

import java.util.Date;
 
 public class Collection extends Base
 {
   private static final long serialVersionUID = 1L;
   private Double moneyAccount;
   private Double moneyCollect;
   private Double moneyUncollect;
   private String remark;
   private String handlerId;
   private String handlerName;
   private String deptId;
   private String deptName;
   private String customerId;
   private String customerName;
   private Date begin;
   private Date end;
 
   public Double getMoneyAccount()
   {
     return this.moneyAccount;
   }
 
   public void setMoneyAccount(Double moneyAccount) {
     this.moneyAccount = moneyAccount;
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
 
   public static long getSerialVersionUID() {
     return 1L;
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
 
   public Double getMoneyCollect()
   {
     return this.moneyCollect;
   }
 
   public void setMoneyCollect(Double moneyCollect) {
     this.moneyCollect = moneyCollect;
   }
 
   public Date getBegin() {
     return this.begin;
   }
 
   public void setBegin(Date begin) {
     this.begin = begin;
   }
 
   public Date getEnd() {
     return this.end;
   }
 
   public void setEnd(Date end) {
     this.end = end;
   }
 
   public Double getMoneyUncollect() {
     return this.moneyUncollect;
   }
 
   public void setMoneyUncollect(Double moneyUncollect) {
     this.moneyUncollect = moneyUncollect;
   }
 }

/* 
 
 
 */