 package com.sinokj.app.system.user.model;
 
 import com.sinokj.code.bean.Base;

import java.util.Date;
 
 public class SysUser extends Base
 {
   private static final long serialVersionUID = 3060608438603311114L;
   private String roleId;
   private String roleCode;
   private String roleName;
   private String pwd;
   private String mobile;
   private String telphone;
   private String email;
   private String deptId;
   private String deptName;
   private String company;
   private String address;
   private String warehouseId;
   private String warehouseName;
   private Date begin;
   private Date end;
   private String newPwd;
 
   public String getRoleId()
   {
     return this.roleId;
   }
   public void setRoleId(String roleId) {
     this.roleId = roleId;
   }
   public String getRoleName() {
     return this.roleName;
   }
   public void setRoleName(String roleName) {
     this.roleName = roleName;
   }
   public String getPwd() {
     return this.pwd;
   }
   public void setPwd(String pwd) {
     this.pwd = pwd;
   }
   public String getRoleCode() {
     return this.roleCode;
   }
   public void setRoleCode(String roleCode) {
     this.roleCode = roleCode;
   }
   public String getTelphone() {
     return this.telphone;
   }
   public void setTelphone(String telphone) {
     this.telphone = telphone;
   }
   public String getEmail() {
     return this.email;
   }
   public void setEmail(String email) {
     this.email = email;
   }
   public String getMobile() {
     return this.mobile;
   }
   public void setMobile(String mobile) {
     this.mobile = mobile;
   }
   public String getNewPwd() {
     return this.newPwd;
   }
   public void setNewPwd(String newPwd) {
     this.newPwd = newPwd;
   }
   public String getCompany() {
     return this.company;
   }
   public void setCompany(String company) {
     this.company = company;
   }
   public String getAddress() {
     return this.address;
   }
   public void setAddress(String address) {
     this.address = address;
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
   public String getWarehouseId() {
     return this.warehouseId;
   }
   public void setWarehouseId(String warehouseId) {
     this.warehouseId = warehouseId;
   }
   public String getWarehouseName() {
     return this.warehouseName;
   }
   public void setWarehouseName(String warehouseName) {
     this.warehouseName = warehouseName;
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
 }

/* 
 
 
 */