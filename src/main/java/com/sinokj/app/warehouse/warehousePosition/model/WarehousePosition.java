 package com.sinokj.app.warehouse.warehousePosition.model;
 
 import com.sinokj.code.bean.Base;
 
 public class WarehousePosition extends Base
 {
   private static final long serialVersionUID = 1L;
   private String warehouseId;
   private String warehouseName;
   private String code;
   private String name;
   private String wareId;
 
   public String getWareId()
   {
     return this.wareId;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
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
   public String getCode() {
     return this.code;
   }
   public void setCode(String code) {
     this.code = code;
   }
   public String getName() {
     return this.name;
   }
   public void setName(String name) {
     this.name = name;
   }
 }

/* 
 
 
 */