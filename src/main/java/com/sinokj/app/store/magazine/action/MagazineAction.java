 package com.sinokj.app.store.magazine.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.magazine.model.Magazine;
import com.sinokj.app.store.magazine.service.MagazineService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class MagazineAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(MagazineAction.class);
   private MagazineService magazineService;
   private Magazine magazine;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private SerialNumberService serialNumberService;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
 
   public String listJson()
   {
     logger.info("start list magazine!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.magazine == null) {
         this.magazine = new Magazine();
       }
       resultList = this.magazineService.pageList(pageInfo, this.magazine, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list Magazine!", e);
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
     logger.info("start to query Magazine information");
     return "list_magazine";
   }
 
   public String edit()
   {
     logger.info("start to query Magazine information");
     SysUser loginMan = getSessionUserInfo();
     if (this.magazine == null) {
       this.magazine = new Magazine();
     }
     if (StringUtils.isBlank(this.magazine.getId())) {
       this.magazine.setState("c");
       initModel(true, this.magazine, loginMan);
     } else {
       this.magazine = ((Magazine)this.magazineService.getModel(this.magazine.getId()));
       initModel(false, this.magazine, loginMan);
     }
     return "edit_magazine";
   }
 
   public void save()
   {
     HttpServletRequest request = getRequest();
     String documentId = request.getParameter("fileUploadId");
     this.magazine.setDocumentId(documentId);
     logger.info("start to update Magazine information");
     try {
       if (this.magazine == null) {
         this.magazine = new Magazine();
       }
 
       if (StringUtils.isBlank(this.magazine.getId()))
       {
         if (StringUtils.isNotBlank(documentId)) {
           this.fileUploadService.updateAppId(documentId, this.magazine.getDocumentId());
         }
 
         this.magazine.setId(this.magazineService.makeId());
         this.magazine.setCode(this.serialNumberService.getSerialNumberByDate("MZ", "magazine"));
         this.magazineService.insert(this.magazine);
       } else {
         this.magazineService.update(this.magazine);
       }
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.magazine.getId());
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save Magazine information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save Magazine information");
   }
 
   public void delete()
   {
     logger.info("start delete a good:" + this.magazine.getId());
     try
     {
       this.fileUploadService.cleanAppId(this.magazine.getId());
       this.magazineService.delete(this.magazine.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a Magazine!", e);
     }
   }
 
   public MagazineService getMagazineservice()
   {
     return this.magazineService;
   }
   public void setMagazineservice(MagazineService magazineservice) {
     this.magazineService = magazineservice;
   }
   public Magazine getMagazine() {
     return this.magazine;
   }
   public void setMagazine(Magazine magazine) {
     this.magazine = magazine;
   }
   public static long getSerialVersionUID() {
     return -1299499640055184711L;
   }
   public static Logger getLogger() {
     return logger;
   }
 
   public String getImgIdStr() {
     return this.imgIdStr;
   }
 
   public void setImgIdStr(String imgIdStr) {
     this.imgIdStr = imgIdStr;
   }
 
   public void setMagazineService(MagazineService magazineService) {
     this.magazineService = magazineService;
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