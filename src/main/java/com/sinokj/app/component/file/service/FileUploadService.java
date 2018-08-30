 package com.sinokj.app.component.file.service;
 
 import com.sinokj.app.common.Static;
import com.sinokj.app.component.file.model.FileUpload;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.io.File;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class FileUploadService extends BaseService<FileUpload>
 {
   private static final Logger logger = Logger.getLogger(FileUpload.class);
 
   public void deleteInvalidFile()
   {
     List<FileUpload> list = this.publicDAO.select("FileUpload.FileUpload_invalid", null);
     if ((list != null) && (!list.isEmpty()))
       for (FileUpload o : list)
         deleteFile(o);
   }
 
   public boolean deleteFile(FileUpload o)
   {
     boolean isDeleted = false;
 
     String id = o.getId();
     try {
       logger.info("delete FileUpload,id:" + id);
       super.delete(id);
     } catch (Exception e) {
       logger.error("error when delete FileUpload,id:" + id, e);
     }
     String relativePath = o.getRelativePath();
     if (StringUtils.isNotBlank(relativePath))
     {
       File file = new File(Static.APACHE_CONTEXT_PATH, relativePath);
       if ((file != null) && (file.exists())) {
         isDeleted = file.delete();
         logger.info((isDeleted ? "successed" : "failed") + " delete file,path:" + file.getPath());
       }
     }
 
     return isDeleted;
   }
 
   public void updateAppId(String id, String appId)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("the primary key is null, can not update FileUpload");
     }
     Map map = new HashMap();
     map.put("id", id);
     map.put("appId", appId);
     this.publicDAO.update("FileUpload.FileUpload", map);
   }
 
   public void removeAppId(String picPathArr, String appId)
     throws Exception
   {
     if (StringUtils.isBlank(picPathArr)) {
       throw new Exception("the primary key is null, can not update FileUpload");
     }
     Map map = new HashMap();
     map.put("relativePath", picPathArr);
     map.put("appId", appId);
     this.publicDAO.deletePic("FileUpload.FileUpload", map);
   }
 
   public void cleanAppId(String appId)
     throws Exception
   {
     if (StringUtils.isBlank(appId)) {
       throw new Exception("the foreign key appId is empty");
     }
 
     Map map = new HashMap();
     map.put("appId", appId);
 
     this.publicDAO.update("FileUpload.FileUpload_clean_appId", map);
   }
 
   public List<FileUpload> getFileUploadByGoodId(String goodId)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("the  key goodId is empty");
     }
     Map map = new HashMap();
     map.put("appId", goodId);
     map.put("appType", "GoodAlbum");
     List list = this.publicDAO.select("FileUpload.FileUpload", map);
     return list;
   }
 
   public List<FileUpload> getFileUploadById(String id)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("the  key goodId is empty");
     }
     Map map = new HashMap();
     map.put("appId", id);
     List list = this.publicDAO.select("FileUpload.FileUpload", map);
     return list;
   }
   public List<FileUpload> getFileUploadByPromoteId(String id) throws Exception {
     if (StringUtils.isBlank(id)) {
       throw new Exception("the  key goodId is empty");
     }
     Map map = new HashMap();
     map.put("appId", id);
     map.put("appType", "promotionActivityPic");
     List list = this.publicDAO.select("FileUpload.FileUpload", map);
     return list;
   }
 }