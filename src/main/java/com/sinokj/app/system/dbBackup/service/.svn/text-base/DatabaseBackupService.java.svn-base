 package com.sinokj.app.system.dbBackup.service;
 
 import com.sinokj.app.common.Static;
import com.sinokj.code.util.ConfigUtil;
import com.sinokj.code.util.DateUtil;

 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.OutputStream;
 import java.io.OutputStreamWriter;
 import java.io.PrintStream;
 import java.io.PrintWriter;
 import java.io.UnsupportedEncodingException;
import java.util.Date;
 
 public class DatabaseBackupService
 {
   private String mysqlHost = ConfigUtil.getHost();
   private String mysqlBackupFolder = ConfigUtil.getMysqlBackupFolder();
   private static final String dbName = ConfigUtil.getDatabaseName();
   private static final String dbUserName = ConfigUtil.getDatabaseUsername();
   private static final String dbPassword = ConfigUtil.getDatabasePassword();
 
   public String backup()
   {
     try
     {
       Date now = new Date();
       String nowStr = DateUtil.date2Str(now, "yyyyMMdd");
 
       File backupFloder = new File(this.mysqlBackupFolder);
       if (!backupFloder.exists()) {
         backupFloder.mkdirs();
       }
       String path = this.mysqlBackupFolder + Static.SYS_NAME + "_db_Backup_" + nowStr + ".sql";
       OutputStream out = new FileOutputStream(path);
       deleteBackupFile();
       backup(out);
       return "true," + path;
     } catch (FileNotFoundException e) {
       e.printStackTrace();
     }return "false,";
   }
 
   public void backup(OutputStream output)
   {
     String command = "cmd /c mysqldump -h" + this.mysqlHost + " -u" + dbUserName + 
       " -p" + dbPassword + " " + dbName;
     System.out.println(command);
     PrintWriter p = null;
     BufferedReader reader = null;
     try {
       p = new PrintWriter(new OutputStreamWriter(output, "utf8"));
       Process process = Runtime.getRuntime().exec(command);
       InputStreamReader inputStreamReader = new InputStreamReader(
         process.getInputStream(), "utf8");
       reader = new BufferedReader(inputStreamReader);
       String line = null;
       while ((line = reader.readLine()) != null) {
         p.println(line);
       }
       p.flush();
     } catch (UnsupportedEncodingException e) {
       e.printStackTrace();
       try
       {
         if (reader != null) {
           reader.close();
         }
         if (p != null)
           p.close();
       }
       catch (IOException ex) {
         ex.printStackTrace();
       }
     }
     catch (IOException e)
     {
       e.printStackTrace();
       try
       {
         if (reader != null) {
           reader.close();
         }
         if (p != null)
           p.close();
       }
       catch (IOException ex) {
         ex.printStackTrace();
       }
     }
     finally
     {
       try
       {
         if (reader != null) {
           reader.close();
         }
         if (p != null)
           p.close();
       }
       catch (IOException e) {
         e.printStackTrace();
       }
     }
   }
 
   public void deleteBackupFile()
   {
     String fileName = "";
 
     File file = new File(this.mysqlBackupFolder);
     String[] list = file.list();
     if (list.length >= 20) {
       fileName = list[0];
     }
     String path = this.mysqlBackupFolder + fileName;
     File sqlFile = new File(path);
     if ((sqlFile.isFile()) && (sqlFile.exists()))
       sqlFile.delete();
   }
 
   public String getMysqlBackupFolder() {
     return this.mysqlBackupFolder;
   }
   public void setMysqlBackupFolder(String mysqlBackupFolder) {
     this.mysqlBackupFolder = mysqlBackupFolder;
   }
 }

/* 
 
 
 */