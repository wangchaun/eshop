 package com.sinokj.app.store.advertise.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Advertise extends Base
 {
   private static final long serialVersionUID = 3060608438603311114L;
   private String subject;
   private String content;
   private String picId;
   private String pic;
   private String type;
   private String placeId;
   private String place;
   private Integer level;
   private String url;
   private String isGoodTypeId;
   private String areaId;
   private String areaName;
 
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
   public String getIsGoodTypeId() {
     return this.isGoodTypeId;
   }
   public void setIsGoodTypeId(String isGoodTypeId) {
     this.isGoodTypeId = isGoodTypeId;
   }
   public String getUrl() {
     return this.url;
   }
   public void setUrl(String url) {
     this.url = url;
   }
   public Integer getLevel() {
     return this.level;
   }
   public void setLevel(Integer level) {
     this.level = level;
   }
 
   public String getType() {
     return this.type;
   }
   public void setType(String type) {
     this.type = type;
   }
   public String getPicId() {
     return this.picId;
   }
   public void setPicId(String picId) {
     this.picId = picId;
   }
   public String getPic() {
     return this.pic;
   }
   public void setPic(String pic) {
     this.pic = pic;
   }
   public String getSubject() {
     return this.subject;
   }
   public void setSubject(String subject) {
     this.subject = subject;
   }
   public String getContent() {
     return this.content;
   }
   public void setContent(String content) {
     this.content = content;
   }
   public String getPlaceId() {
     return this.placeId;
   }
   public void setPlaceId(String placeId) {
     this.placeId = placeId;
   }
   public String getPlace() {
     return this.place;
   }
   public void setPlace(String place) {
     this.place = place;
   }
 }

/* 
 
 
 */