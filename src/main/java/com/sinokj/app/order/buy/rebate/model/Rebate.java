 package com.sinokj.app.order.buy.rebate.model;
 
 import com.sinokj.code.bean.Base;

import java.util.Date;
 
 public class Rebate extends Base
 {
   private static final long serialVersionUID = 1L;
   private String remark;
   private String handlerId;
   private String handlerName;
   private String deptId;
   private String deptName;
   private Date startTime;
   private Date endTime;
 
   public String getRemark()
   {
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
   public Date getStartTime() {
     return this.startTime;
   }
   public void setStartTime(Date startTime) {
     this.startTime = startTime;
   }
   public Date getEndTime() {
     return this.endTime;
   }
   public void setEndTime(Date endTime) {
     this.endTime = endTime;
   }
 }

/* 
 
 
 */