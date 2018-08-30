 package com.sinokj.code.util;
 
 import java.util.HashMap;
 import java.util.Map;
 
 public class PageHelp
 {
   private static ThreadLocal<Map<String, Integer>> pageLocal = new ThreadLocal();
 
   public static Integer getPageSize()
   {
     if ((pageLocal == null) || (pageLocal.get() == null))
       return Integer.valueOf(0);
     Integer pageSize = (Integer)((Map)pageLocal.get()).get("pageSize");
     if (pageSize == null)
       return Integer.valueOf(0);
     return pageSize;
   }
 
   public static Integer getTotalElements()
   {
     if ((pageLocal == null) || (pageLocal.get() == null))
       return Integer.valueOf(0);
     Integer totalElements = (Integer)((Map)pageLocal.get()).get("totalElements");
     if (totalElements == null)
       return Integer.valueOf(0);
     return totalElements;
   }
 
   public static void setPageSize(Integer pageSize)
   {
     Map map = (Map)pageLocal.get();
     if (map == null) {
       map = new HashMap();
       pageLocal.set(map);
     }
     map.put("pageSize", pageSize);
   }
 
   public static void setTotalElements(Integer totalElements)
   {
     Map map = (Map)pageLocal.get();
     if (map == null) {
       map = new HashMap();
       pageLocal.set(map);
     }
     map.put("totalElements", totalElements);
   }
 
   public static void clean()
   {
     pageLocal.remove();
   }
 }

/* 
 
 
 */