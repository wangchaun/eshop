 package com.sinokj.app.store.promotionActivity.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.promotionActivity.model.PromotionActivity;
import com.sinokj.app.store.promotionActivity.model.PromotionActivityGood;
import com.sinokj.app.store.promotionActivity.service.PromotionActivityGoodService;
import com.sinokj.app.store.promotionActivity.service.PromotionActivityService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.vip.level.model.VipLevel;
import com.sinokj.app.vip.level.service.VipLevelService;
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
 
 public class PromotionActivityAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(PromotionActivityAction.class);
   private PromotionActivity promotionActivity;
   private PromotionActivityService promotionActivityService;
   private PromotionActivityGood promotionActivityGood;
   private PromotionActivityGoodService promotionActivityGoodService;
   private SerialNumberService serialNumberService;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private String[] goodIdArr;
   private String[] goodNameArr;
   private Double[] priceMarketArr;
   private Double[] pricePromoteArr;
   private String[] vipLevelIdArr;
   private List<VipLevel> vipLevelList;
   private VipLevelService vipLevelService;
 
   public String listJosn()
   {
     logger.info("start list promotionActivity");
     List resultList = null;
     int totalRows = 0;
     try
     {
       PageInfo pageInfo = createPageInfo();
       if (this.promotionActivity == null) {
         this.promotionActivity = new PromotionActivity();
       }
       resultList = this.promotionActivityService.pageList(pageInfo, this.promotionActivity, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list promotionActivity", e);
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
     logger.info("start to query promotionActivity information");
     return "list_promotionActivity";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.promotionActivity == null) {
       this.promotionActivity = new PromotionActivity();
     }
     this.vipLevelList = this.vipLevelService.select(new VipLevel());
     try
     {
       if (StringUtils.isBlank(this.promotionActivity.getId())) {
         this.promotionActivity.setState("c");
         initModel(true, this.promotionActivity, loginMan);
         try {
           this.promotionActivity.setCode(this.serialNumberService.getSerialNumberByDate("PA", "promotionActivity"));
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.promotionActivity = ((PromotionActivity)this.promotionActivityService.getModel(this.promotionActivity.getId()));
         initModel(false, this.promotionActivity, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list promotionActivity", e);
       responseFlag(false);
     }
     return "edit_promotionActivity";
   }
 
   public void save()
   {
     HttpServletRequest request = getRequest();
     String picId = request.getParameter("picId");
     this.promotionActivity.setPicId(picId);
     System.out.println("picId:" + picId);
     logger.info("start to update promotionActivity information");
     try {
       String vipLevelId = "";
       String vipLevelName = "";
       if (this.vipLevelIdArr != null) {
         for (int i = 0; i < this.vipLevelIdArr.length; i++) {
           VipLevel vipLevel = (VipLevel)this.vipLevelService.getModel(this.vipLevelIdArr[i]);
           if (vipLevel != null) {
             vipLevelId = vipLevelId + vipLevel.getId();
             vipLevelName = vipLevelName + vipLevel.getName();
           }
           if (i != this.vipLevelIdArr.length - 1) {
             vipLevelId = vipLevelId + ",";
             vipLevelName = vipLevelName + ",";
           }
         }
         this.promotionActivity.setVipLevelId(vipLevelId);
         this.promotionActivity.setVipLevelName(vipLevelName);
       }
       if (this.promotionActivity == null) {
         this.promotionActivity = new PromotionActivity();
       }
 
       if (StringUtils.isBlank(this.promotionActivity.getId())) {
         this.promotionActivity.setId(this.promotionActivityService.makeId());
         this.promotionActivity.setState("c");
         this.promotionActivityService.insertPromotionActivity(this.promotionActivity);
       } else {
         this.promotionActivityService.update(this.promotionActivity);
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.cleanAppId(this.promotionActivity.getId());
           this.fileUploadService.updateAppId(picId, this.promotionActivity.getId());
         }
       }
 
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.promotionActivity.getId());
         }
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.promotionActivity.getPicId());
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save promotionActivity information");
       e.printStackTrace();
       responseFlag(false);
     }
     try {
       this.promotionActivityGoodService.deleteByPromoteId(this.promotionActivity.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete promotionActivityGood", e);
     }
 
     String promoteId = this.promotionActivity.getId();
     if ((this.goodIdArr != null) && (this.goodIdArr.length != 0))
       for (int i = 0; i < this.goodIdArr.length; i++) {
         PromotionActivityGood promotionActivityGood = new PromotionActivityGood();
         promotionActivityGood.setPromoteId(promoteId);
         promotionActivityGood.setGoodId(this.goodIdArr[i]);
         promotionActivityGood.setGoodName(this.goodNameArr[i]);
         promotionActivityGood.setPriceMarket(this.priceMarketArr[i]);
         promotionActivityGood.setPricePromote(this.pricePromoteArr[i]);
         promotionActivityGood.setSort(Integer.valueOf(i));
         try {
           this.promotionActivityGoodService.insert(promotionActivityGood);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert  promotionActivityGood", e);
         }
       }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
     try {
       if (this.promotionActivity == null) {
         this.promotionActivity = new PromotionActivity();
       }
       this.promotionActivityGoodService.deleteByPromoteId(this.promotionActivity.getId());
       this.promotionActivityService.delete(this.promotionActivity.getId());
       logger.info(loginMan.getCode() + " delete promotionActivity,id:" + this.promotionActivity.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a promotionActivity!", e);
     }
   }
 
   public PromotionActivity getPromotionActivity()
   {
     return this.promotionActivity;
   }
 
   public void setPromotionActivity(PromotionActivity promotionActivity) {
     this.promotionActivity = promotionActivity;
   }
 
   public PromotionActivityService getPromotionActivityService() {
     return this.promotionActivityService;
   }
 
   public void setPromotionActivityService(PromotionActivityService promotionActivityService)
   {
     this.promotionActivityService = promotionActivityService;
   }
 
   public PromotionActivityGood getPromotionActivityGood() {
     return this.promotionActivityGood;
   }
 
   public void setPromotionActivityGood(PromotionActivityGood promotionActivityGood) {
     this.promotionActivityGood = promotionActivityGood;
   }
 
   public PromotionActivityGoodService getPromotionActivityGoodService() {
     return this.promotionActivityGoodService;
   }
 
   public void setPromotionActivityGoodService(PromotionActivityGoodService promotionActivityGoodService)
   {
     this.promotionActivityGoodService = promotionActivityGoodService;
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
 
   public String[] getVipLevelIdArr() {
     return this.vipLevelIdArr;
   }
 
   public void setVipLevelIdArr(String[] vipLevelIdArr) {
     this.vipLevelIdArr = vipLevelIdArr;
   }
 
   public List<VipLevel> getVipLevelList() {
     return this.vipLevelList;
   }
 
   public void setVipLevelList(List<VipLevel> vipLevelList) {
     this.vipLevelList = vipLevelList;
   }
 
   public VipLevelService getVipLevelService() {
     return this.vipLevelService;
   }
 
   public void setVipLevelService(VipLevelService vipLevelService) {
     this.vipLevelService = vipLevelService;
   }
 
   public String[] getGoodIdArr() {
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
 }

/* 
 
 
 */