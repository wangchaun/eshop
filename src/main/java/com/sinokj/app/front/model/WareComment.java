 package com.sinokj.app.front.model;
 
 import com.sinokj.code.bean.Base;

import java.util.Date;
 
 public class WareComment extends Base
 {
   private static final long serialVersionUID = -3717075047362160191L;
   private String wareId;
   private String commentId;
   private String content;
   private String type;
   private int level;
   private String goodCode;
   private String goodName;
   private int wareCommentNum;
   private String pic;
   private Date buyTime;
   private String goodId;
 
   public String getGoodId()
   {
     return this.goodId;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
   public String getCommentId() {
     return this.commentId;
   }
   public String getContent() {
     return this.content;
   }
   public String getGoodCode() {
     return this.goodCode;
   }
   public String getGoodName() {
     return this.goodName;
   }
   public String getType() {
     return this.type;
   }
   public int getWareCommentNum() {
     return this.wareCommentNum;
   }
   public String getWareId() {
     return this.wareId;
   }
   public void setCommentId(String commentId) {
     this.commentId = commentId;
   }
   public void setContent(String content) {
     this.content = content;
   }
   public void setGoodCode(String goodCode) {
     this.goodCode = goodCode;
   }
   public void setGoodName(String goodName) {
     this.goodName = goodName;
   }
   public void setType(String type) {
     this.type = type;
   }
   public void setWareCommentNum(int wareCommentNum) {
     this.wareCommentNum = wareCommentNum;
   }
   public void setWareId(String wareId) {
     this.wareId = wareId;
   }
   public int getLevel() {
     return this.level;
   }
   public void setLevel(int level) {
     this.level = level;
   }
   public String getPic() {
     return this.pic;
   }
   public void setPic(String pic) {
     this.pic = pic;
   }
   public Date getBuyTime() {
     return this.buyTime;
   }
   public void setBuyTime(Date buyTime) {
     this.buyTime = buyTime;
   }
 }