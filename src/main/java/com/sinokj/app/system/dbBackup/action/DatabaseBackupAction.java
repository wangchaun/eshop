 package com.sinokj.app.system.dbBackup.action;
 
 import com.sinokj.app.system.dbBackup.service.DatabaseBackupService;
import com.sinokj.code.struct.BaseAction;

import org.apache.log4j.Logger;
 
 public class DatabaseBackupAction extends BaseAction
 {
   private static final long serialVersionUID = 775910044329989542L;
   private static final Logger logger = Logger.getLogger(DatabaseBackupAction.class);
   private DatabaseBackupService databaseBackupService;
 
   public void setDatabaseBackupService(DatabaseBackupService databaseBackupService)
   {
     this.databaseBackupService = databaseBackupService;
   }
 
   public void backUp()
   {
     logger.info("start backup database");
     String message = this.databaseBackupService.backup();
     responseFlag(message);
   }
 }

/* 
 
 
 */