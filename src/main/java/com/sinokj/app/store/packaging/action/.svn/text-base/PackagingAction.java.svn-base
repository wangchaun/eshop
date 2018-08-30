 package com.sinokj.app.store.packaging.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.packaging.model.Packaging;
import com.sinokj.app.store.packaging.service.PackagingService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.io.PrintStream;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class PackagingAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(PackagingAction.class);
   private PackagingService packagingService;
   private Packaging packaging;
   private FileUploadService fileUploadService;
   private SerialNumberService serialNumberService;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
 
   public String showPic()
   {
     logger.info("start to get picId");
     SysUser loginMan = getSessionUserInfo();
 
     if (StringUtils.isBlank(this.packaging.getPicId())) {
       this.packaging = ((Packaging)this.packagingService.getModel(this.packaging.getId()));
       initModel(false, this.packaging, loginMan);
     }
     return "list_pic";
   }
 
   public String listJson()
   {
     logger.info("start list packaging!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.packaging == null) {
         this.packaging = new Packaging();
       }
       resultList = this.packagingService.pageList(pageInfo, this.packaging, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list packaging!", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all data!");
     return "success";
   }
 
   public String list()
   {
     logger.info("start to query Packaging information");
     return "list_packaging";
   }
 
   public String edit()
   {
     logger.info("start to query packaging information");
     SysUser loginMan = getSessionUserInfo();
     if (this.packaging == null) {
       this.packaging = new Packaging();
     }
     if (StringUtils.isBlank(this.packaging.getId())) {
       this.packaging.setState("c");
       initModel(true, this.packaging, loginMan);
     } else {
       this.packaging = ((Packaging)this.packagingService.getModel(this.packaging.getId()));
       initModel(false, this.packaging, loginMan);
     }
     return "edit_packaging";
   }
 
   public void save()
   {
     logger.info("start to update packaging information");
     HttpServletRequest request = getRequest();
     String picId = request.getParameter("picId");
     this.packaging.setPicId(picId);
     System.out.println("picId:" + picId);
     try
     {
       if (this.packaging == null) {
         this.packaging = new Packaging();
       }
 
       if (StringUtils.isBlank(this.packaging.getId()))
       {
         this.packaging.setId(this.packagingService.makeId());
         this.packaging.setCode(this.serialNumberService.getSerialNumberByDate("PK", "packaging"));
         this.packagingService.insertPackaging(this.packaging);
       } else {
         this.packagingService.update(this.packaging);
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.packaging.getId());
         }
       }
       if (StringUtils.isNotBlank(picId)) {
         this.fileUploadService.updateAppId(picId, this.packaging.getPicId());
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save packaging information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save packaging information");
   }
 
   public void delete()
   {
     logger.info("start delete a good:" + this.packaging.getId());
     try
     {
       this.fileUploadService.cleanAppId(this.packaging.getId());
       this.packagingService.delete(this.packaging.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a packaging!", e);
     }
   }
 
   public PackagingService getPackagingservice()
   {
     return this.packagingService;
   }
   public void setPackagingservice(PackagingService packagingservice) {
     this.packagingService = packagingservice;
   }
   public Packaging getPackaging() {
     return this.packaging;
   }
   public void setPackaging(Packaging packaging) {
     this.packaging = packaging;
   }
   public static long getSerialVersionUID() {
     return -1299499640055184711L;
   }
   public static Logger getLogger() {
     return logger;
   }
   public void setPackagingService(PackagingService packagingService) {
     this.packagingService = packagingService;
   }
 
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 }

/* 
 
 
 */