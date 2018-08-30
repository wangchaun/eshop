 package com.sinokj.app.warehouse.warehouse.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Warehouse extends Base
 {
   private static final long serialVersionUID = 1L;
   private String areaId;
   private String areaName;
   private Double totalCostInventory;
   private String remark;
 
   public String getAreaId()
   {
     return this.areaId;
   }
   public void setAreaId(String areaId) {
     this.areaId = areaId;
   }
   public String getAreaName() {
     return this.areaName;
   }
   public void setAreaName(String areaName) {
     this.areaName = areaName;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public Double getTotalCostInventory() {
     return this.totalCostInventory;
   }
   public void setTotalCostInventory(Double totalCostInventory) {
     this.totalCostInventory = totalCostInventory;
   }
 }

/* 
 
 
 */