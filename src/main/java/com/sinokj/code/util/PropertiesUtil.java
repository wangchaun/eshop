 package com.sinokj.code.util;
 
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Properties;
 
 public class PropertiesUtil
 {
   public static Properties loadFile(String classPath)
   {
     InputStream inStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(classPath);
     Properties properties = new Properties();
     try {
       properties.load(inStream);
     } catch (IOException e) {
       e.printStackTrace();
     }
     return properties;
   }
 }

/* 
 
 
 */