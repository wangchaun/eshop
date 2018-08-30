 package com.sinokj.app.warehouse.warehouse.action;
 
 import com.sinokj.code.struct.BaseAction;

import org.apache.log4j.Logger;
 
 public class SmartReplenishAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(SmartReplenishAction.class);
 
   public String list() {
     return "list_smartReplenish";
   }
 }

/* 
 
 
 */