 package com.sinokj.app.store.promote.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.promote.model.Promote;
import com.sinokj.app.store.promote.model.PromoteGood;
import com.sinokj.app.store.promote.service.PromoteGoodService;
import com.sinokj.app.store.promote.service.PromoteService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.io.PrintStream;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class PromoteAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(PromoteAction.class);
   private Promote promote;
   private PromoteService promoteService;
   private PromoteGood promoteGood;
   private PromoteGoodService promoteGoodService;
   private SerialNumberService serialNumberService;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private String[] goodIdArr;
   private String[] goodNameArr;
   private Double[] priceMarketArr;
   private Double[] pricePromoteArr;
 
   public String[] getGoodIdArr()
   {
     return this.goodIdArr;
   }
 
   public void setGoodIdArr(String[] goodIdArr) {
     this.goodIdArr = goodIdArr;
   }
 
   public String[] getGoodNameArr() {
     return this.goodNameArr;
   }
 
   public void setGoodNameArr(String[] goodNameArr) {
     this.goodNameArr = goodNameArr;
   }
   public Double[] getPriceMarketArr() {
     return this.priceMarketArr;
   }
 
   public void setPriceMarketArr(Double[] priceMarketArr) {
     this.priceMarketArr = priceMarketArr;
   }
 
   public Double[] getPricePromoteArr() {
     return this.pricePromoteArr;
   }
 
   public void setPricePromoteArr(Double[] pricePromoteArr) {
     this.pricePromoteArr = pricePromoteArr;
   }
 
   public String listJosn()
   {
     logger.info("start list promote");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.promote == null) {
         this.promote = new Promote();
       }
       resultList = this.promoteService.pageList(pageInfo, this.promote, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list promote", e);
     }
 
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     return "success";
   }
 
   public String list()
   {
     logger.info("start to query promote information");
     return "list_promote";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.promote == null) {
       this.promote = new Promote();
     }
     try
     {
       if (StringUtils.isBlank(this.promote.getId())) {
         this.promote.setState("c");
         initModel(true, this.promote, loginMan);
         try {
           this.promote.setCode(this.serialNumberService.getSerialNumberByDate("PT", "promote"));
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.promote = ((Promote)this.promoteService.getModel(this.promote.getId()));
         initModel(false, this.promote, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list promote", e);
       responseFlag(false);
     }
     return "edit_promote";
   }
 
   public void save()
   {
     HttpServletRequest request = getRequest();
     String picId = request.getParameter("picId");
     this.promote.setPicId(picId);
     System.out.println("picId:" + picId);
     logger.info("start to update promote information");
     try {
       if (this.promote == null) {
         this.promote = new Promote();
       }
       if (StringUtils.isBlank(this.promote.getId())) {
         this.promote.setId(this.promoteService.makeId());
         this.promote.setState("c");
         this.promote.setModifyTime(new Date());
         this.promoteService.insertPromote(this.promote);
       } else {
         this.promoteService.update(this.promote);
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.cleanAppId(this.promote.getId());
           this.fileUploadService.updateAppId(picId, this.promote.getId());
         }
       }
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.promote.getId());
         }
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.promote.getPicId());
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save promote information");
       e.printStackTrace();
       responseFlag(false);
     }
     try {
       this.promoteGoodService.deleteByPromoteId(this.promote.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete promoteGood", e);
     }
 
     String promoteId = this.promote.getId();
     if ((this.goodIdArr != null) && (this.goodIdArr.length != 0))
       for (int i = 0; i < this.goodIdArr.length; i++) {
         PromoteGood promoteGood = new PromoteGood();
         promoteGood.setPromoteId(promoteId);
         promoteGood.setGoodId(this.goodIdArr[i]);
         promoteGood.setGoodName(this.goodNameArr[i]);
         promoteGood.setPriceMarket(this.priceMarketArr[i]);
         promoteGood.setPricePromote(this.pricePromoteArr[i]);
         promoteGood.setSort(Integer.valueOf(i));
         try {
           this.promoteGoodService.insert(promoteGood);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert  promoteGood", e);
         }
       }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.promote == null) {
         this.promote = new Promote();
       }
       this.promoteGoodService.deleteByPromoteId(this.promote.getId());
       this.promoteService.delete(this.promote.getId());
       logger.info(loginMan.getCode() + " delete promote,id:" + this.promote.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a promote!", e);
     }
   }
 
   public Promote getPromote() {
     return this.promote;
   }
 
   public void setPromote(Promote promote) {
     this.promote = promote;
   }
 
   public PromoteService getPromoteService() {
     return this.promoteService;
   }
 
   public void setPromoteService(PromoteService promoteService) {
     this.promoteService = promoteService;
   }
 
   public PromoteGood getPromoteGood() {
     return this.promoteGood;
   }
 
   public void setPromoteGood(PromoteGood promoteGood) {
     this.promoteGood = promoteGood;
   }
 
   public PromoteGoodService getPromoteGoodService() {
     return this.promoteGoodService;
   }
 
   public void setPromoteGoodService(PromoteGoodService promoteGoodService) {
     this.promoteGoodService = promoteGoodService;
   }
 
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public String getImgIdStr() {
     return this.imgIdStr;
   }
 
   public void setImgIdStr(String imgIdStr) {
     this.imgIdStr = imgIdStr;
   }
 
   public FileUploadService getFileUploadService() {
     return this.fileUploadService;
   }
 
   public void setFileUploadService(FileUploadService fileUploadService) {
     this.fileUploadService = fileUploadService;
   }
 }

/* 
 
 
 */