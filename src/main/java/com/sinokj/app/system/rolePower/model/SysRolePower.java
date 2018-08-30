 package com.sinokj.app.system.rolePower.model;
 
 import com.sinokj.code.bean.Base;
 
 public class SysRolePower extends Base
 {
   private static final long serialVersionUID = -6405399691384793474L;
   private String roleId;
   private String powerId;
   private String powerName;
   private String inserts;
   private String deletes;
   private String selects;
   private String updates;
 
   public String getPowerId()
   {
     return this.powerId;
   }
   public void setPowerId(String powerId) {
     this.powerId = powerId;
   }
   public String getPowerName() {
     return this.powerName;
   }
   public void setPowerName(String powerName) {
     this.powerName = powerName;
   }
   public String getRoleId() {
     return this.roleId;
   }
   public void setRoleId(String roleId) {
     this.roleId = roleId;
   }
   public String getInserts() {
     return this.inserts;
   }
   public void setInserts(String inserts) {
     this.inserts = inserts;
   }
   public String getDeletes() {
     return this.deletes;
   }
   public void setDeletes(String deletes) {
     this.deletes = deletes;
   }
   public String getSelects() {
     return this.selects;
   }
   public void setSelects(String selects) {
     this.selects = selects;
   }
   public String getUpdates() {
     return this.updates;
   }
   public void setUpdates(String updates) {
     this.updates = updates;
   }
 }

/* 
 
 
 */