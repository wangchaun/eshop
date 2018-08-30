 package com.sinokj.app.store.greetingCard.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.greetingCard.model.GreetingCard;
import com.sinokj.app.store.greetingCard.service.GreetingCardService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GreetingCardAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(GreetingCardAction.class);
   private GreetingCardService greetingCardService;
   private GreetingCard greetingCard;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private SerialNumberService serialNumberService;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
 
   public String listJson()
   {
     logger.info("start list greetingCard!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.greetingCard == null) {
         this.greetingCard = new GreetingCard();
       }
       resultList = this.greetingCardService.pageList(pageInfo, this.greetingCard, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list greetingCard!", e);
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
     logger.info("start to query GreetingCard information");
     return "list_greetingCard";
   }
 
   public String edit()
   {
     logger.info("start to query greetingCard information");
     SysUser loginMan = getSessionUserInfo();
     if (this.greetingCard == null) {
       this.greetingCard = new GreetingCard();
     }
     if (StringUtils.isBlank(this.greetingCard.getId())) {
       this.greetingCard.setState("c");
       initModel(true, this.greetingCard, loginMan);
     } else {
       this.greetingCard = ((GreetingCard)this.greetingCardService.getModel(this.greetingCard.getId()));
       initModel(false, this.greetingCard, loginMan);
     }
     return "edit_greetingCard";
   }
 
   public void save()
   {
     logger.info("start to update GreetingCard information");
     try {
       if (this.greetingCard == null) {
         this.greetingCard = new GreetingCard();
       }
 
       if (StringUtils.isBlank(this.greetingCard.getId()))
       {
         this.greetingCard.setId(this.greetingCardService.makeId());
         this.greetingCard.setCode(this.serialNumberService.getSerialNumberByDate("GC", "greetingCard"));
         this.greetingCardService.insert(this.greetingCard);
       } else {
         this.greetingCardService.update(this.greetingCard);
       }
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.greetingCard.getId());
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save greetingCard information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save greetingCard information");
   }
 
   public void delete()
   {
     logger.info("start delete a good:" + this.greetingCard.getId());
     try
     {
       this.fileUploadService.cleanAppId(this.greetingCard.getId());
       this.greetingCardService.delete(this.greetingCard.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a greetingCard!", e);
     }
   }
 
   public GreetingCardService getGreetingCardservice()
   {
     return this.greetingCardService;
   }
   public void setGreetingCardservice(GreetingCardService greetingCardservice) {
     this.greetingCardService = greetingCardservice;
   }
   public GreetingCard getGreetingCard() {
     return this.greetingCard;
   }
   public void setGreetingCard(GreetingCard greetingCard) {
     this.greetingCard = greetingCard;
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
 
   public void setGreetingCardService(GreetingCardService greetingCardService) {
     this.greetingCardService = greetingCardService;
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