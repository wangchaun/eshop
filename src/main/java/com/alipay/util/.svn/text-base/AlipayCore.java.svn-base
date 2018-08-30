 package com.alipay.util;
 
 import com.alipay.config.AlipayConfig;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 
 public class AlipayCore
 {
   public static String buildMysign(Map<String, String> sArray)
   {
     String prestr = createLinkString(sArray);
     prestr = prestr + AlipayConfig.key;
     String mysign = AlipayMd5Encrypt.md5(prestr);
     return mysign;
   }
 
   public static Map<String, String> paraFilter(Map<String, String> sArray)
   {
     Map result = new HashMap();
 
     if ((sArray == null) || (sArray.size() <= 0)) {
       return result;
     }
 
     for (String key : sArray.keySet()) {
       String value = (String)sArray.get(key);
       if ((value != null) && (!value.equals("")) && (!key.equalsIgnoreCase("sign")) && 
         (!key.equalsIgnoreCase("sign_type")))
       {
         result.put(key, value);
       }
     }
     return result;
   }
 
   public static String createLinkString(Map<String, String> params)
   {
     List keys = new ArrayList((Collection)params.keySet());
     Collections.sort(keys);
 
     String prestr = "";
 
     for (int i = 0; i < keys.size(); i++) {
       String key = (String)keys.get(i);
       String value = (String)params.get(key);
 
       if (i == keys.size() - 1)
         prestr = prestr + key + "=" + value;
       else {
         prestr = prestr + key + "=" + value + "&";
       }
     }
 
     return prestr;
   }
 
   public static void logResult(String sWord)
   {
     FileWriter writer = null;
     try {
       writer = new FileWriter(AlipayConfig.log_path);
       writer.write(sWord);
     } catch (Exception e) {
       e.printStackTrace();
 
       if (writer != null)
         try {
           writer.close();
         } catch (IOException ex) {
           ex.printStackTrace();
         }
     }
     finally
     {
       if (writer != null)
         try {
           writer.close();
         } catch (IOException e) {
           e.printStackTrace();
         }
     }
   }
 }