 package com.sinokj.app.store.greetingCard.model;
 
 import com.sinokj.code.bean.Base;
 
 public class GreetingCard extends Base
 {
   private static final long serialVersionUID = 1L;
   private String name;
   private String content;
   private String customerId;
   private String customerName;
 
   public String getName()
   {
     return this.name;
   }
   public void setName(String name) {
     this.name = name;
   }
   public String getContent() {
     return this.content;
   }
   public void setContent(String content) {
     this.content = content;
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