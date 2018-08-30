 package com.sinokj.app.baseInfo.dictionary.model;
 
 import com.sinokj.code.bean.Base;
 
 public class DictionaryItem extends Base
 {
   private static final long serialVersionUID = -3308546669050871255L;
   private String dictionaryId;
   private String code;
   private String name;
 
   public String getDictionaryId()
   {
     return this.dictionaryId;
   }
   public void setDictionaryId(String dictionaryId) {
     this.dictionaryId = dictionaryId;
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