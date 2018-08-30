 package com.sinokj.app.baseInfo.dictionary.model;
 
 import com.sinokj.code.bean.Base;
 
 public class Dictionary extends Base
 {
   private static final long serialVersionUID = 7711015487241219519L;
   private String code;
   private String name;
 
   public String getCode()
   {
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