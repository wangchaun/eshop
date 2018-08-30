 package com.sinokj.app.store.packaging.service;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.store.packaging.model.Packaging;
import com.sinokj.code.service.BaseService;

import org.apache.commons.lang3.StringUtils;
 
 public class PackagingService extends BaseService<Packaging>
 {
   private FileUploadService fileUploadService;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
   public void insertPackaging(Packaging model) throws Exception {
     if (model == null) {
       throw new Exception("Object Packaging is null,can not insert Packaging Information!");
     }
     super.insert(model);
 
     if (StringUtils.isNotBlank(model.getPicId()))
       this.fileUploadService.updateAppId(model.getPicId(), model.getId());
   }
 }

/* 
 
 
 */