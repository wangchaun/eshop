 package com.sinokj.code.util;
 
 import java.io.PrintStream;
 import java.security.MessageDigest;
 import java.security.NoSuchAlgorithmException;
 import org.apache.log4j.Logger;
 
 public class MD5
 {
   private static Logger logger = Logger.getLogger(MD5.class);
 
   public static String compute(String source) {
     if (source == null) {
       return null;
     }
     MessageDigest md5 = null;
     try {
       md5 = MessageDigest.getInstance("MD5");
     } catch (NoSuchAlgorithmException e) {
       logger.error("error occur when generating MD5 string!", e);
       return null;
     }
     char[] charArray = source.toCharArray();
 
     byte[] byteArray = new byte[charArray.length];
 
     for (int i = 0; i < charArray.length; i++) {
       byteArray[i] = ((byte)charArray[i]);
     }
     byte[] md5Bytes = md5.digest(byteArray);
 
     StringBuffer hexValue = new StringBuffer();
 
     for (int i = 0; i < md5Bytes.length; i++) {
       int val = md5Bytes[i] & 0xFF;
       if (val < 16)
         hexValue.append("0");
       hexValue.append(Integer.toHexString(val));
     }
 
     return hexValue.toString();
   }
 
   
 }

/* 
 
 
 */