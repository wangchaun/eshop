 package com.sinokj.code.util;
 
 import java.util.Properties;
 
 public class ConfigUtil
 {
   private static Properties properties = PropertiesUtil.loadFile("config.properties");
 
   private static String get(String key)
   {
     return properties.getProperty(key);
   }
 
   public static String getFilePath()
   {
     return get("FILE_PATH");
   }
 
   public static String getPicPath()
   {
     return get("PIC_PATH");
   }
 
   public static String getApachePath()
   {
     return get("APACHE_PATH");
   }
 
   public static String getSysName()
   {
     return get("SYS_NAME");
   }
 
   public static String getWebappPath() {
     return get("WEBAPP_PATH");
   }
 
   public static String getBbsUrl()
   {
     return get("BBS_URL");
   }
 
   public static String getHost()
   {
     return get("MYSQL_HOST");
   }
 
   public static String getMysqlBackupFolder()
   {
     return get("MYSQL_BACKUP_FOLDER");
   }
 
   public static String getDatabaseName()
   {
     return get("MYSQL_DBNAME");
   }
 
   public static String getDatabaseUsername()
   {
     return get("MYSQL_USERNAME");
   }
 
   public static String getDatabasePassword()
   {
     return get("MYSQL_PASSWORD");
   }
 
   public static String getMailHost()
   {
     return get("MAIL_HOST");
   }
 
   public static String getPdfPath()
   {
     return get("PDF_PATH");
   }
 
   public static String[] getAdminMails()
   {
     String mailStr = get("ADMIN_MAIL");
     String[] mailArr = (String[])null;
     if ((mailStr != null) && (mailStr != "")) {
       mailArr = mailStr.split(",");
     }
     return mailArr;
   }
 
   public static String getKey()
   {
     return get("KEY");
   }
 
   public static String getLicense()
   {
     return get("LICENSE");
   }
 
   public static String getGoodTypeLevel()
   {
     return get("GOOD_TYPE_LEVEL");
   }
 
   public static String getAreaLevel()
   {
     return get("AREA_LEVEL");
   }
 
   public static String getPowerLevel()
   {
     return get("Power_LEVEL");
   }
 
   public static String getGoodPicNum()
   {
     return get("GOOD_PIC_NUM");
   }
 
   public static String getAlipayNotifyUrl()
   {
     return get("ALIPAY_NOTIFY_URL");
   }
 
   public static String getAlipayReturnUrl()
   {
     return get("ALIPAY_RETURN_URL");
   }
 
   public static String getBankReturnUrl()
   {
     return get("BANK_RECEIVE_URL");
   }
 }

/* 
 
 
 */