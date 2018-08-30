 package com.sinokj.app.filter;
 
 import java.io.IOException;
 import java.io.PrintWriter;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.apache.log4j.Logger;
 
 public class SystemFilterService
 {
   private static final Logger logger = Logger.getLogger(SystemFilterService.class);
   private static final String LOGIN_URL = "frontLogin.do";
 
   public void dofilter(HttpServletRequest request, HttpServletResponse response)
     throws IOException, ServletException
   {
     String uri = request.getRequestURI();
 
     boolean isNotNeedFilter = SystemFilter.isNotNeedFilter(uri);
     if (-1 != uri.indexOf("!")) {
       if (!isNotNeedFilter) {
         Object systemUser = request.getSession().getAttribute("loginUser");
         boolean isLogin = false;
         if (systemUser != null) {
           isLogin = true;
         }
         if (!isLogin) {
           String loginUrl = request.getContextPath() + SystemFilter.adminLoginUrl;
           String remoteAddr = request.getRemoteAddr();
           logger.warn("illegal access! url:" + uri + " ;visitor ip:" + remoteAddr);
 
           printErrorInfo(response, loginUrl, "请先登录!");
         }
       }
 
     }
     else if (!isNotNeedFilter) {
       Object loginCustomer = request.getSession().getAttribute("loginCustomer");
       boolean isLogin = false;
       if (loginCustomer != null) {
         isLogin = true;
       }
       if (!isLogin) {
         String loginUrl = request.getContextPath() + SystemFilter.frontLoginUrl;
         String remoteAddr = request.getRemoteAddr();
         logger.warn("illegal access! url:" + uri + " ;visitor ip:" + remoteAddr);
 
         printErrorInfo(response, loginUrl, "请先登录!");
         return;
       }
     }
   }
 
   public void printErrorInfo(HttpServletResponse response, String loginUrl, String errorInfo)
   {
     loginUrl = loginUrl + "frontLogin.do";
     response.setContentType("text/html; charset=UTF-8");
     PrintWriter writer = null;
     try {
       writer = response.getWriter();
     } catch (IOException e) {
       e.printStackTrace();
     }
     writer.write("<script language='javascript'>");
     writer.write("alert('" + errorInfo + "');");
     writer.write("window.location.href='" + loginUrl + "';");
     writer.write("</script>");
     writer.close();
   }
 }