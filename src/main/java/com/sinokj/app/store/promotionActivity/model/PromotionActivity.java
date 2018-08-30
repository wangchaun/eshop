 package com.sinokj.app.store.promotionActivity.model;
 
 import com.sinokj.code.bean.Base;

import java.util.Date;
 
 public class PromotionActivity extends Base
 {
   private static final long serialVersionUID = 1L;
   private String name;
   private String intro;
   private String picId;
   private String pic;
   private String type;
   private Date startTime;
   private Date endTime;
   private String vipLevelId;
   private String vipLevelName;
 
   public String getVipLevelId()
   {
     return this.vipLevelId;
   }
   public void setVipLevelId(String vipLevelId) {
     this.vipLevelId = vipLevelId;
   }
   public String getVipLevelName() {
     return this.vipLevelName;
   }
   public void setVipLevelName(String vipLevelName) {
     this.vipLevelName = vipLevelName;
   }
   public String getName() {
     return this.name;
   }
   public void setName(String name) {
     this.name = name;
   }
   public String getIntro() {
     return this.intro;
   }
   public void setIntro(String intro) {
     this.intro = intro;
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
   public String getType() {
     return this.type;
   }
   public void setType(String type) {
     this.type = type;
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