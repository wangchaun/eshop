 package com.sinokj.code.listener;

 import com.sinokj.app.common.Static;
import com.sinokj.code.util.SpringHelper;

 import javax.servlet.ServletContext;
 import javax.servlet.ServletContextEvent;
 import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
 
 public class ServletContextLoaderListener
   implements ServletContextListener
 {
   private Logger logger = Logger.getLogger(ServletContextLoaderListener.class);
 
   public void contextInitialized(ServletContextEvent servletContextEvent) {
     ServletContext servletContext = servletContextEvent.getServletContext();
     Static.SERVLET_CONTEXT_PATH = servletContext.getRealPath("");
     this.logger.info("init SERVLET_CONTEXT_PATH:" + Static.SERVLET_CONTEXT_PATH);
     Static.APACHE_CONTEXT_PATH = Static.SERVLET_CONTEXT_PATH;
     this.logger.info("init APACHE_CONTEXT_PATH:" + Static.APACHE_CONTEXT_PATH);
     SpringHelper.bindSessionContext(servletContext);
     this.logger.info("bindSessionContext");

    /*// 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials("AKIDvgDXdV5bppa7RXN0NVN0NWP3ScWE8y0o", "iDUXNzMVQ6YmlV2LQHuJTQ9evynPmvpV");
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
    ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
    // 3 生成cos客户端
    COSClient cosclient = new COSClient(cred, clientConfig);
    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    String bucketName = "maiya-1253429902";*/
   }
 
   public void contextDestroyed(ServletContextEvent servletContextEvent) {
     this.logger.info("contextDestroyed");
   }
 }

/* 
 
 
 */