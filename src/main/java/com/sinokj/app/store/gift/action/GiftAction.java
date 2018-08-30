 package com.sinokj.app.store.gift.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.gift.model.Gift;
import com.sinokj.app.store.gift.model.GiftGood;
import com.sinokj.app.store.gift.service.GiftGoodService;
import com.sinokj.app.store.gift.service.GiftService;
import com.sinokj.app.store.promotionActivity.model.PromotionActivityGood;
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
 
 public class GiftAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(GiftAction.class);
   private SerialNumberService serialNumberService;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private Gift gift;
   private GiftService giftService;
   private GiftGood giftGood;
   private GiftGoodService giftGoodService;
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
       if (this.gift == null) {
         this.gift = new Gift();
       }
       resultList = this.giftService.pageList(pageInfo, this.gift, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list gift", e);
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
     logger.info("start to query gift information");
     return "list_gift";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.gift == null) {
       this.gift = new Gift();
     }
     this.vipLevelList = this.vipLevelService.select(new VipLevel());
     try
     {
       if (StringUtils.isBlank(this.gift.getId())) {
         this.gift.setState("c");
         initModel(true, this.gift, loginMan);
         try {
           this.gift.setCode(this.serialNumberService.getSerialNumberByDate("GF", "gift"));
         } catch (Exception e) {
           logger.error("error occur when get code", e);
         }
       } else {
         this.gift = ((Gift)this.giftService.getModel(this.gift.getId()));
         initModel(false, this.gift, loginMan);
       }
     } catch (Exception e) {
       logger.error("error occur when list gift", e);
       responseFlag(false);
     }
     return "edit_gift";
   }
 
   public void save()
   {
     HttpServletRequest request = getRequest();
     String picId = request.getParameter("picId");
     this.gift.setPicId(picId);
     System.out.println("picId:" + picId);
     logger.info("start to update gift information");
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
         this.gift.setVipLevelId(vipLevelId);
         this.gift.setVipLevelName(vipLevelName);
       }
       if (this.gift == null) {
         this.gift = new Gift();
       }
 
       if (StringUtils.isBlank(this.gift.getId())) {
         this.gift.setId(this.giftService.makeId());
         this.gift.setState("c");
         this.giftService.insertGift(this.gift);
       } else {
         this.giftService.update(this.gift);
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.gift.getId());
         }
       }
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.gift.getId());
         }
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.gift.getPicId());
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save gift information");
       e.printStackTrace();
       responseFlag(false);
     }
     try {
       this.giftGoodService.deleteByPromoteId(this.gift.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete giftGood", e);
     }
 
     String promoteId = this.gift.getId();
     if ((this.goodIdArr != null) && (this.goodIdArr.length != 0))
       for (int i = 0; i < this.goodIdArr.length; i++) {
         PromotionActivityGood giftGood = new PromotionActivityGood();
         giftGood.setPromoteId(promoteId);
         giftGood.setGoodId(this.goodIdArr[i]);
         giftGood.setGoodName(this.goodNameArr[i]);
         giftGood.setPriceMarket(this.priceMarketArr[i]);
         giftGood.setPricePromote(this.pricePromoteArr[i]);
         giftGood.setSort(Integer.valueOf(i));
         try {
           this.giftGoodService.insert(giftGood);
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
       if (this.gift == null) {
         this.gift = new Gift();
       }
       this.giftService.delete(this.gift.getId());
       logger.info(loginMan.getCode() + " delete gift,id:" + this.gift.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a gift!", e);
     }
   }
 
   public SerialNumberService getSerialNumberService()
   {
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
   public Gift getGift() {
     return this.gift;
   }
   public void setGift(Gift gift) {
     this.gift = gift;
   }
   public GiftService getGiftService() {
     return this.giftService;
   }
   public void setGiftService(GiftService giftService) {
     this.giftService = giftService;
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
   public void setGiftGoodService(GiftGoodService giftGoodService) {
     this.giftGoodService = giftGoodService;
   }
   public GiftGood getGiftGood() {
     return this.giftGood;
   }
   public void setGiftGood(GiftGood giftGood) {
     this.giftGood = giftGood;
   }
   public GiftGoodService getGiftGoodService() {
     return this.giftGoodService;
   }
 }

/* 
 
 
 */