 package com.sinokj.app.warehouse.warehousePosition.model;
 
 import com.sinokj.code.bean.Base;
 
 public class WarehousePositionWare extends Base
 {
   private static final long serialVersionUID = 1L;
   private String warehousePositionId;
   private String warehousePositionName;
   private String wareId;
   private String wareName;
   private int wareCount;
   private String warehouseId;
   private String warehouseName;
   private String wareSpecificationVal;
   private String wareCode;
 
   public String getWareId()
   {
     return this.wareId;
   }
   public String getWareName() {
     return this.wareName;
   }
   public int getWareCount() {
     return this.wareCount;
   }
   public String getWarehouseId() {
     return this.warehouseId;
   }
   public String getWarehouseName() {
     return this.warehouseName;
   }
   public String getWarehousePositionId() {
     return this.warehousePositionId;
   }
   public String getWarehousePositionName() {
     return this.warehousePositionName;
   }
   public void setWarehousePositionId(String warehousePositionId) {
     this.warehousePositionId = warehousePositionId;
   }
   public void setWarehousePositionName(String warehousePositionName) {
     this.warehousePositionName = warehousePositionName;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
   public void setWareName(String wareName) {
     this.wareName = wareName;
   }
   public void setWareCount(int wareCount) {
     this.wareCount = wareCount;
   }
   public void setWarehouseId(String warehouseId) {
     this.warehouseId = warehouseId;
   }
   public void setWarehouseName(String warehouseName) {
     this.warehouseName = warehouseName;
   }
   public String getWareCode() {
     return this.wareCode;
   }
   public void setWareCode(String wareCode) {
     this.wareCode = wareCode;
   }
   public String getWareSpecificationVal() {
     return this.wareSpecificationVal;
   }
   public void setWareSpecificationVal(String wareSpecificationVal) {
     this.wareSpecificationVal = wareSpecificationVal;
   }
 }

/* 
 
 
 */