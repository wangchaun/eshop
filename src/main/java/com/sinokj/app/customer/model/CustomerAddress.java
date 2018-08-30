 package com.sinokj.app.customer.model;
 
 import com.sinokj.code.bean.Base;
 
 public class CustomerAddress extends Base
 {
   private static final long serialVersionUID = -3717075047362160191L;
   private String customerId;
   private String mobile;
   private String zipCode;
   private String remark;
   private String isDefault;
   private String address;
   private String street;
   private String whetherordrer;
   private String customerAdds;
   private String phone;
   private String province;
   private String city;
   private String region;
 
   public String getStreet()
   {
     return this.street;
   }
   public void setStreet(String street) {
     this.street = street;
   }
   public String getCustomerId() {
     return this.customerId;
   }
   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }
   public String getMobile() {
     return this.mobile;
   }
   public void setMobile(String mobile) {
     this.mobile = mobile;
   }
   public String getZipCode() {
     return this.zipCode;
   }
   public void setZipCode(String zipCode) {
     this.zipCode = zipCode;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public String getIsDefault() {
     return this.isDefault;
   }
   public void setIsDefault(String isDefault) {
     this.isDefault = isDefault;
   }
   public String getAddress() {
     return this.address;
   }
   public void setAddress(String address) {
     this.address = address;
   }
   public String getWhetherordrer() {
     return this.whetherordrer;
   }
   public void setWhetherordrer(String whetherordrer) {
     this.whetherordrer = whetherordrer;
   }
   public String getCustomerAdds() {
     return this.customerAdds;
   }
   public void setCustomerAdds(String customerAdds) {
     this.customerAdds = customerAdds;
   }
   public String getProvince() {
     return this.province;
   }
   public void setProvince(String province) {
     this.province = province;
   }
   public String getCity() {
     return this.city;
   }
   public void setCity(String city) {
     this.city = city;
   }
   public String getRegion() {
     return this.region;
   }
   public void setRegion(String region) {
     this.region = region;
   }
   public String getPhone() {
     return this.phone;
   }
   public void setPhone(String phone) {
     this.phone = phone;
   }
 }