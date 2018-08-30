 package com.sinokj.app.component.file.action;
 
 import com.sinokj.app.common.Static;
import com.sinokj.app.component.file.model.FileUpload;
import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.DateUtil;

 import java.io.File;
 import java.util.Date;
 import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
 
 public class FrontFileUploadAction extends BaseAction
 {
   private static final long serialVersionUID = 8576935397110491269L;
   private static final Logger logger = Logger.getLogger(FileUploadAction.class);
   private FileUploadService fileUploadService;
   private File[] fileupload;
   private String[] fileuploadFileName;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
 
   public String frontedit()
   {
     return "edit_FrontFileUpload";
   }
 
   public void frontsave()
   {
     String folderPath = Static.APACHE_CONTEXT_PATH + Static.PIC_PATH;
     Date now = new Date();
     String nowStr = DateUtil.date2Str(now, "yyyyMMdd");
     now = DateUtil.str2Date(nowStr, "yyyyMMdd");
 
     folderPath = folderPath + "/" + this.appType + "/" + nowStr;
 
     logger.info("relativePath:" + folderPath);
     String idStr = "";
     String imgPath = "";
     String fileName = "";
 
     boolean isOk = true;
     if ((this.fileupload != null) && (this.fileupload.length > 0)) {
       logger.info("fileupload.length:" + this.fileupload.length);
 
       File savedir = new File(folderPath);
       if (!savedir.exists()) {
         savedir.mkdirs();
       }
 
       for (int i = 0; i < this.fileupload.length; i++) {
         fileName = this.fileuploadFileName[i];
         String postfix = fileName.substring(fileName.lastIndexOf(".") + 1);
         logger.info("uploadFileName[" + i + "]=" + fileName);
 
         String id = this.fileUploadService.makeId();
         idStr = idStr + (i == 0 ? id : new StringBuilder(",").append(id).toString());
 
         String fileNewName = id + "." + postfix;
         File savefile = new File(savedir, fileNewName);
         logger.info("save file:" + fileNewName + " to folder:" + savedir.getPath());
         try {
           FileUtils.copyFile(this.fileupload[i], savefile);
 
           FileUpload fileUpload = new FileUpload();
           fileUpload.setId(id);
           fileUpload.setAppType(this.appType);
           fileUpload.setCreateTime(now);
           fileUpload.setPostfix(postfix);
           fileUpload.setOriginalName(fileName);
 
           StringBuffer relativePath = new StringBuffer();
           relativePath.append(Static.PIC_PATH)
             .append("/").append(this.appType)
             .append("/").append(nowStr)
             .append("/").append(id).append(".").append(postfix);
           fileUpload.setRelativePath(relativePath.toString());
           imgPath = relativePath.toString();
           this.fileUploadService.insert(fileUpload);
         } catch (Exception e) {
           if (isOk) {
             isOk = false;
           }
           logger.error("error when copyFile,savefile:" + savefile, e);
         }
       }
     } else {
       logger.warn("fileupload is null or fileupload.length <=0");
       isOk = false;
     }
 
     if (!isOk) {
       responseFlag(isOk);
     }
     else if (this.appType.equals("News"))
       responseFlag(imgPath);
     else if (this.appType.equals("magazine"))
       responseFlag(idStr + ',' + fileName);
     else
       responseFlag(idStr + ',' + imgPath);
   }
 
   public File[] getFileupload()
   {
     return this.fileupload;
   }
 
   public void setFileupload(File[] fileupload) {
     this.fileupload = fileupload;
   }
 
   public String[] getFileuploadFileName() {
     return this.fileuploadFileName;
   }
 
   public void setFileuploadFileName(String[] fileuploadFileName) {
     this.fileuploadFileName = fileuploadFileName;
   }
 }