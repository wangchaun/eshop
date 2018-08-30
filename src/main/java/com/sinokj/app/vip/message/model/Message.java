 package com.sinokj.app.vip.message.model;
 
 import com.sinokj.code.bean.Base;

import java.util.List;
 
 public class Message extends Base
 {
   private static final long serialVersionUID = 1L;
   private String messageId;
   private String content;
   private String replyState;
   private String goodId;
   private String type;
   private String goodName;
   private String goodCode;
   private int messageNum;
   private List<Message> list;
   private String pic;
   private String replyContent;
 
   public String getReplyContent()
   {
     return this.replyContent;
   }
   public void setReplyContent(String replyContent) {
     this.replyContent = replyContent;
   }
   public String getPic() {
     return this.pic;
   }
   public void setPic(String pic) {
     this.pic = pic;
   }
   public String getMessageId() {
     return this.messageId;
   }
   public void setMessageId(String messageId) {
     this.messageId = messageId;
   }
   public String getContent() {
     return this.content;
   }
   public void setContent(String content) {
     this.content = content;
   }
   public String getReplyState() {
     return this.replyState;
   }
   public void setReplyState(String replyState) {
     this.replyState = replyState;
   }
   public String getGoodId() {
     return this.goodId;
   }
   public void setGoodId(String goodId) {
     this.goodId = goodId;
   }
   public String getGoodName() {
     return this.goodName;
   }
   public void setGoodName(String goodName) {
     this.goodName = goodName;
   }
   public String getGoodCode() {
     return this.goodCode;
   }
   public void setGoodCode(String goodCode) {
     this.goodCode = goodCode;
   }
   public int getMessageNum() {
     return this.messageNum;
   }
   public void setMessageNum(int messageNum) {
     this.messageNum = messageNum;
   }
   public String getType() {
     return this.type;
   }
   public void setType(String type) {
     this.type = type;
   }
   public List<Message> getList() {
     return this.list;
   }
   public void setList(List<Message> list) {
     this.list = list;
   }
 }

/* 
 
 
 */