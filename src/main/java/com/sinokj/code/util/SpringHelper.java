 package com.sinokj.code.util;
 
 import javax.servlet.ServletContext;
 import org.springframework.web.context.WebApplicationContext;
 
 public class SpringHelper
 {
   private static ServletContext servletContextStatic = null;
 
   public static void bindSessionContext(ServletContext servletContext)
   {
     if (servletContextStatic == null)
    	 servletContextStatic = servletContext;
   }
 
   public static Object getBean(String beanId)
   {
     WebApplicationContext context = (WebApplicationContext)servletContextStatic.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
     return context.getBean(beanId);
   }
 
   public static ServletContext getServletContext()
   {
     return servletContextStatic;
   }
 }

/* 
 
 
 */