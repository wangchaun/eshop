 package com.sinokj.app.store.storeSet.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.storeSet.model.StoreSet;
import com.sinokj.app.store.storeSet.service.StoreSetService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class StoreSetAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(StoreSetAction.class);
   private StoreSetService storeSetService;
   private StoreSet storeSet;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private SerialNumberService serialNumberService;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
 
   public String listJson()
   {
     logger.info("start list storeSet!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.storeSet == null) {
         this.storeSet = new StoreSet();
       }
       resultList = this.storeSetService.pageList(pageInfo, this.storeSet, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list storeSet!", e);
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
     logger.info("start to query storeSet information");
     return "list_storeSet";
   }
 
   public String edit()
   {
     logger.info("start to query storeSet information");
     SysUser loginMan = getSessionUserInfo();
     if (this.storeSet == null) {
       this.storeSet = new StoreSet();
     }
     if (StringUtils.isBlank(this.storeSet.getId())) {
       this.storeSet.setState("c");
       initModel(true, this.storeSet, loginMan);
     } else {
       this.storeSet = ((StoreSet)this.storeSetService.getModel(this.storeSet.getId()));
       initModel(false, this.storeSet, loginMan);
     }
     return "edit_storeSet";
   }
 
   public void save()
   {
     logger.info("start to update storeSet information");
     try
     {
       if (this.storeSet == null) {
         this.storeSet = new StoreSet();
       }
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.storeSet.getId());
         }
       }
 
       if (StringUtils.isBlank(this.storeSet.getId()))
       {
         this.storeSet.setId(this.storeSetService.makeId());
         this.storeSet.setCode(this.serialNumberService.getSerialNumberByDate("SS", "storeSet"));
         this.storeSetService.insert(this.storeSet);
       } else {
         this.storeSetService.update(this.storeSet);
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save storeSet information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save storeSet information");
   }
 
   public void delete()
   {
     logger.info("start delete a good:" + this.storeSet.getId());
     try
     {
       this.fileUploadService.cleanAppId(this.storeSet.getId());
       this.storeSetService.delete(this.storeSet.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a storeSet!", e);
     }
   }
 
   public static long getSerialVersionUID()
   {
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
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public StoreSetService getStoreSetService() {
     return this.storeSetService;
   }
 
   public StoreSet getStoreSet() {
     return this.storeSet;
   }
 
   public void setStoreSet(StoreSet storeSet) {
     this.storeSet = storeSet;
   }
 
   public FileUploadService getFileUploadService() {
     return this.fileUploadService;
   }
 
   public void setStoreSetService(StoreSetService storeSetService) {
     this.storeSetService = storeSetService;
   }
 }

/* 
 
 
 */