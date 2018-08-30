 package com.sinokj.app.store.information.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Information extends Base
 {
   private static final long serialVersionUID = 3060608438603311114L;
   private String title;
   private String content;
   private String type;
   private String areaId;
   private String areaName;
   private String ecommunity;
   private String regulationType;
 
   public String getType()
   {
     return this.type;
   }
   public void setType(String type) {
     this.type = type;
   }
   public String getTitle() {
     return this.title;
   }
   public void setTitle(String title) {
     this.title = title;
   }
   public String getContent() {
     return this.content;
   }
   public void setContent(String content) {
     this.content = content;
   }
   public String getEcommunity() {
     return this.ecommunity;
   }
   public void setEcommunity(String ecommunity) {
     this.ecommunity = ecommunity;
   }
   public String getAreaId() {
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
   public String getRegulationType() {
     return this.regulationType;
   }
   public void setRegulationType(String regulationType) {
     this.regulationType = regulationType;
   }
 }

/* 
 
 
 */