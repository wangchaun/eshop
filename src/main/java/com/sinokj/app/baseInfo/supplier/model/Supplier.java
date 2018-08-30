 package com.sinokj.app.baseInfo.supplier.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Supplier extends Base
 {
   private String address;
   private String areaIds;
   private String areaNames;
   private String cooperationState;
   private String email;
   private String linkman;
   private String mobile;
   private Double payables;
   private Double receivables;
   private String street;
   private String telphone;
   private Double totalPayables;
   private Double totalReceivables;
   private String warehouseRemark;
   private String zipCode;
 
   public String getAddress()
   {
     return this.address;
   }
 
   public String getAreaIds() {
     return this.areaIds;
   }
 
   public String getAreaNames() {
     return this.areaNames;
   }
 
   public String getCooperationState() {
     return this.cooperationState;
   }
 
   public String getEmail() {
     return this.email;
   }
 
   public String getLinkman() {
     return this.linkman;
   }
 
   public String getMobile() {
     return this.mobile;
   }
 
   public Double getPayables() {
     return this.payables;
   }
 
   public Double getReceivables() {
     return this.receivables;
   }
 
   public String getStreet() {
     return this.street;
   }
 
   public String getTelphone() {
     return this.telphone;
   }
 
   public Double getTotalPayables() {
     return this.totalPayables;
   }
 
   public Double getTotalReceivables() {
     return this.totalReceivables;
   }
 
   public String getWarehouseRemark() {
     return this.warehouseRemark;
   }
 
   public String getZipCode() {
     return this.zipCode;
   }
 
   public void setAddress(String address) {
     this.address = address;
   }
 
   public void setAreaIds(String areaIds) {
     this.areaIds = areaIds;
   }
 
   public void setAreaNames(String areaNames) {
     this.areaNames = areaNames;
   }
 
   public void setCooperationState(String cooperationState) {
     this.cooperationState = cooperationState;
   }
 
   public void setEmail(String email) {
     this.email = email;
   }
 
   public void setLinkman(String linkman) {
     this.linkman = linkman;
   }
 
   public void setMobile(String mobile) {
     this.mobile = mobile;
   }
 
   public void setPayables(Double payables) {
     this.payables = payables;
   }
 
   public void setReceivables(Double receivables) {
     this.receivables = receivables;
   }
 
   public void setStreet(String street) {
     this.street = street;
   }
 
   public void setTelphone(String telphone) {
     this.telphone = telphone;
   }
 
   public void setTotalPayables(Double totalPayables) {
     this.totalPayables = totalPayables;
   }
 
   public void setTotalReceivables(Double totalReceivables) {
     this.totalReceivables = totalReceivables;
   }
 
   public void setWarehouseRemark(String warehouseRemark) {
     this.warehouseRemark = warehouseRemark;
   }
 
   public void setZipCode(String zipCode) {
     this.zipCode = zipCode;
   }
 }