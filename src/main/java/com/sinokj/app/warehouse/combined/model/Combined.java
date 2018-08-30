 package com.sinokj.app.warehouse.combined.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Combined extends Base
 {
   private static final long serialVersionUID = 1L;
   private String type;
   private String warehouseId;
   private String warehouseName;
   private String wareId;
   private String wareName;
   private int wareCount;
   private String remark;
 
   public String getType()
   {
     return this.type;
   }
   public String getWarehouseId() {
     return this.warehouseId;
   }
   public String getWarehouseName() {
     return this.warehouseName;
   }
   public String getWareId() {
     return this.wareId;
   }
   public String getWareName() {
     return this.wareName;
   }
   public String getRemark() {
     return this.remark;
   }
   public void setType(String type) {
     this.type = type;
   }
   public void setWarehouseId(String warehouseId) {
     this.warehouseId = warehouseId;
   }
   public void setWarehouseName(String warehouseName) {
     this.warehouseName = warehouseName;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
   public void setWareName(String wareName) {
     this.wareName = wareName;
   }
   public void setRemark(String remark) {
     this.remark = remark;
   }
   public int getWareCount() {
     return this.wareCount;
   }
   public void setWareCount(int wareCount) {
     this.wareCount = wareCount;
   }
 }

/* 
 
 
 */