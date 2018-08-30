 package com.sinokj.code.util;
 
 import java.math.BigDecimal;
 import java.util.Map;
 import org.apache.struts2.util.StrutsTypeConverter;
 
 public class DoubleConverter extends StrutsTypeConverter
 {
   public Object convertFromString(Map context, String[] values, Class toClass)
   {
     Double doubleObj = Double.valueOf(0.0D);
     if (Double.class == toClass) {
       String doubleStr = values[0];
       if (!doubleStr.equals("")) {
         doubleObj = Double.valueOf(Double.parseDouble(doubleStr));
       }
     }
     return doubleObj;
   }
 
   public String convertToString(Map context, Object o)
   {
     if ((o instanceof Double)) {
       Double d = (Double)o;
       BigDecimal b = new BigDecimal(d.doubleValue()).setScale(2, 
         5);
       return b.toString();
     }
     return o.toString();
   }
 }

/* 
 
 
 */