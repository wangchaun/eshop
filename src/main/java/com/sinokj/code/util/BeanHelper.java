 package com.sinokj.code.util;
 
 import java.io.UnsupportedEncodingException;
 import java.lang.reflect.Field;
 import java.lang.reflect.Modifier;
 import java.net.URLDecoder;
 import java.sql.Timestamp;
 import java.util.HashMap;
 import java.util.Map;
 
 public class BeanHelper
 {
   public static final String RANGE = "Range";
 
   public static HashMap toHashMap(Object objBean)
   {
     return toHashMap(objBean, objBean.getClass());
   }
 
   public static HashMap toHashMap(Object objBean, Class fieldClass)
   {
     HashMap mapBean = new HashMap();
     if (objBean == null) {
       return null;
     }
     Field[] fields = fieldClass.getDeclaredFields();
     for (Field field : fields) {
       if (!Modifier.isPublic(field.getModifiers()))
         field.setAccessible(true);
       try {
         mapBean.put(field.getName(), field.get(objBean));
       } catch (IllegalAccessException ex) {
         ex.printStackTrace();
       }
     }
     return mapBean;
   }
 
   public static void decodeStringFields(Object objBean, String code)
   {
     if (objBean == null)
       return;
     Field[] fields = objBean.getClass().getDeclaredFields();
     String value = null;
     Object objValue = null;
     for (Field field : fields)
       if (field.getType() == String.class)
       {
         try
         {
           if (!Modifier.isPublic(field.getModifiers())) {
             field.setAccessible(true);
           }
           objValue = field.get(objBean);
           if (objValue != null)
           {
             value = objValue.toString();
 
             field.set(objBean, URLDecoder.decode(value, code));
           }
         } catch (IllegalAccessException ex) { ex.printStackTrace();
         } catch (UnsupportedEncodingException ex) {
           ex.printStackTrace();
         }
       }
   }
 
   public static void decodeStringFieldsByUtf8(Object objBean)
   {
     decodeStringFields(objBean, "utf-8");
   }
 
   public static void fromMap(Object objBean, Map mapBean)
   {
     if (mapBean == null)
       return;
     Field[] fields = objBean.getClass().getDeclaredFields();
     String keyName = "";
     Object objResult = null;
     String result = "";
     Class fieldType = null;
     for (Field field : fields) {
       keyName = field.getName();
       fieldType = field.getType();
       if (!mapBean.containsKey(keyName))
         keyName = field.getName().toUpperCase();
       if (mapBean.containsKey(keyName)) {
         objResult = mapBean.get(keyName);
         if (objResult != null)
         {
           if (((objResult instanceof String[])) && 
             (((String[])objResult).length > 0))
             result = ((String[])objResult)[0];
           else {
             result = objResult.toString();
           }
           if (result != null)
           {
             if (!Modifier.isPublic(field.getModifiers()))
               field.setAccessible(true);
             try
             {
               if (fieldType == String.class) {
                 field.set(objBean, result);
               }
               if (!result.equals(""))
               {
                 if ((fieldType == Long.TYPE) || (fieldType == Long.class))
                   field.set(objBean, Long.valueOf(Long.parseLong(result)));
                 else if ((fieldType == Double.TYPE) || 
                   (fieldType == Double.class))
                   field.set(objBean, Double.valueOf(Double.parseDouble(result)));
                 else if (fieldType == Timestamp.class)
                   field.set(objBean, Timestamp.valueOf(result));
               }
             } catch (IllegalAccessException ex) {
               ex.printStackTrace();
             }
           }
         }
       }
     }
   }
 
   public static void addParamRangeQuery(Object objParamBean)
   {
     if (objParamBean == null)
       return;
     Field[] fields = objParamBean.getClass().getDeclaredFields();
     Object objResult = null;
     for (Field field : fields)
       if (field.getName().endsWith("Range"))
       {
         if (field.getType() == String.class)
         {
           if (!Modifier.isPublic(field.getModifiers()))
             field.setAccessible(true);
           try {
             objResult = field.get(objParamBean);
             if ((objResult != null) && (!objResult.toString().equals("")))
             {
               field.set(objParamBean, "%" + objResult.toString() + "%");
             }
           } catch (IllegalAccessException ex) { ex.printStackTrace(); }
 
         }
       }
   }
 }

/* 
 
 
 */