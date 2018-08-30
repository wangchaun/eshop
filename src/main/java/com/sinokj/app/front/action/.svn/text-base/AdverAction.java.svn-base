 package com.sinokj.app.front.action;
 
 import com.sinokj.app.component.file.model.FileUpload;
import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.goodBrand.model.GoodBrand;
import com.sinokj.app.good.goodBrand.service.GoodBrandService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.app.store.promote.model.Promote;
import com.sinokj.app.store.promote.model.PromoteGood;
import com.sinokj.app.store.promote.service.PromoteGoodService;
import com.sinokj.app.store.promote.service.PromoteService;
import com.sinokj.app.store.promotionActivity.model.PromotionActivity;
import com.sinokj.app.store.promotionActivity.model.PromotionActivityGood;
import com.sinokj.app.store.promotionActivity.service.PromotionActivityGoodService;
import com.sinokj.app.store.promotionActivity.service.PromotionActivityService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.net.URLDecoder;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
 
 public class AdverAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(AdverAction.class);
   private Advertise advertise;
   private AdvertiseService advertiseService;
   private List<Advertise> advertiseList;
   private PromotionActivity promotionActivity;
   private PromotionActivityService promotionActivityService;
   private List<PromotionActivity> promotionActivityList;
   private Promote promote;
   private PromoteService promoteService;
   private List<Promote> promoteList;
   private List<Information> informationList;
   private InformationService informationService;
   private FileUploadService fileUploadService;
   private List<FileUpload> promotePicList;
   private List<FileUpload> promotionActivityPicList;
   private List<PromoteGood> promoteGoodList;
   private PromoteGoodService promoteGoodService;
   private List<Good> goodList;
   private List<Good> goodSaleList;
   private List<Good> goodtotalSaleList;
   private List<Good> goodTimeList;
   private List<Good> goodTypeList;
   private List<Good> goodTagList;
   private List<Good> goodArrList;
   private GoodType goodType;
   private List<GoodType> typeList;
   private Good good;
   private List<GoodBrand> goodbrandlist;
   private GoodService goodService;
   private GoodTypeService goodTypeService;
   private GoodBrandService goodBrandService;
   private List<PromotionActivityGood> promotionActivityGoodList;
   private List<PromotionActivityGood> promotionActivityGoodTypeList;
   private PromotionActivityGoodService promotionActivityGoodService;
   private PromotionActivityGood promotionActivityGood;
 
   public String listPromotionActivity()
   {
     if (this.promotionActivity == null) {
       this.promotionActivity = new PromotionActivity();
     }
     this.informationList = this.informationService.select(new Information());
     this.promotionActivityList = this.promotionActivityService.select(new PromotionActivity());
     try {
       this.promotionActivityGoodList = this.promotionActivityGoodService.getPromotionActivityGoodByPromoteId(this.promotionActivity.getId());
       if (this.promotionActivityGoodList.size() > 0) {
         Good good = new Good();
         for (int i = 0; i < this.promotionActivityGoodList.size(); i++) {
           good = (Good)this.goodService.getModel(((PromotionActivityGood)this.promotionActivityGoodList.get(i)).getGoodId());
           ((PromotionActivityGood)this.promotionActivityGoodList.get(i)).setPic(good.getPic());
           ((PromotionActivityGood)this.promotionActivityGoodList.get(i)).setPicId(good.getPicId());
         }
       }
       this.promotionActivityPicList = this.fileUploadService.getFileUploadByPromoteId(this.promotionActivity.getId());
       getRequest().setAttribute("picSize", Integer.valueOf(this.promotionActivityPicList.size()));
     } catch (Exception e) {
       logger.error("获取图片出错", e);
     }
     return "listPromotionActivity";
   }
 
   public String listAdvertise()
   {
     if (this.advertise == null) {
       this.advertise = new Advertise();
     }
     this.goodList = this.goodService.select(new Good());
     this.informationList = this.informationService.select(new Information());
     this.advertiseList = this.advertiseService.select(new Advertise());
     return "listAdvertise";
   }
 
   public String listPromote()
   {
     if (this.promote == null) {
       this.promote = new Promote();
     }
     this.informationList = this.informationService.select(new Information());
     this.promotionActivityList = this.promotionActivityService.select(new PromotionActivity());
     try {
       this.promoteGoodList = this.promoteGoodService.getPromoteGoodByPromoteId(this.promote.getId());
       if (this.promoteGoodList.size() > 0) {
         Good good = new Good();
         for (int i = 0; i < this.promoteGoodList.size(); i++) {
           good = (Good)this.goodService.getModel(((PromoteGood)this.promoteGoodList.get(i)).getGoodId());
           ((PromoteGood)this.promoteGoodList.get(i)).setPic(good.getPic());
           ((PromoteGood)this.promoteGoodList.get(i)).setPicId(good.getPicId());
         }
       }
       this.promotePicList = this.fileUploadService.getFileUploadById(this.promote.getId());
       getRequest().setAttribute("picSize", Integer.valueOf(this.promotePicList.size()));
     } catch (Exception e) {
       logger.error("获取图片出错", e);
     }
     return "listPromote";
   }
 
   public String listChannel()
   {
     this.informationList = this.informationService.select(new Information());
     try {
       this.advertiseList = this.advertiseService.getAdvertiseById(this.goodType.getId());
 
       this.goodSaleList = this.goodService.getGoodsBydailyNetSales(this.good.getGoodTypeId());
 
       this.goodTimeList = this.goodService.getGoodsBySaleTime(this.good.getGoodTypeId());
 
       this.goodTypeList = this.goodService.getGoodsByGoodType(this.good.getGoodTypeId());
 
       this.typeList = this.goodTypeService.getAllGoodType(this.goodType.getId());
 
       this.goodbrandlist = this.goodBrandService.getGoodBrandList(Integer.valueOf(2));
       this.goodTagList = this.goodService.getGoodsByTag(this.good.getGoodTypeId());
 
       List goodSaleSortList = this.goodService.getGoodsByType(this.good.getGoodTypeId());
       getRequest().setAttribute("goodSaleSortList", goodSaleSortList);
     } catch (Exception e) {
       logger.error("获取出错", e);
     }
     return "listChannel";
   }
 
   public String listPreferential()
   {
     HttpServletRequest request = getRequest();
     String pageIndex = request.getParameter("page");
     int pageSize = 16;
     PageInfo pageInfo = createPageInfo();
     pageInfo.setPageSize(pageSize);
     if (pageIndex == null)
       pageInfo.setPageIndex(1);
     else {
       pageInfo.setPageIndex(Integer.parseInt(pageIndex));
     }
 
     this.informationList = this.informationService.select(new Information());
     try {
       if (this.promotionActivityGood == null) {
         this.promotionActivityGood = new PromotionActivityGood();
       }
       this.promotionActivityGoodTypeList = this.promotionActivityGoodService.pageList(pageInfo, this.promotionActivityGood, true);
       request.setAttribute("typeId", this.promotionActivityGood.getTypeId());
       if (this.promotionActivityGoodTypeList.size() > 0) {
         Good good = new Good();
         for (int i = 0; i < this.promotionActivityGoodTypeList.size(); i++) {
           good = (Good)this.goodService.getModel(((PromotionActivityGood)this.promotionActivityGoodTypeList.get(i)).getGoodId());
           ((PromotionActivityGood)this.promotionActivityGoodTypeList.get(i)).setPic(good.getPic());
           ((PromotionActivityGood)this.promotionActivityGoodTypeList.get(i)).setPicId(good.getPicId());
         }
       }
     } catch (Exception e) {
       logger.error("获取特惠抢购商品出错", e);
     }
 
     if ((pageInfo.getCount() > 0) && (pageInfo.getCount() % pageSize != 0))
       pageInfo.setPageCount(pageInfo.getCount() / pageSize + 1);
     else {
       pageInfo.setPageCount(pageInfo.getCount() / pageSize);
     }
     request.setAttribute("pageInfo", pageInfo);
     return "listPreferential";
   }
 
   public String listNew()
   {
     HttpServletRequest request = getRequest();
     String pageIndex = request.getParameter("page");
     int pageSize = 16;
     PageInfo pageInfo = createPageInfo();
     pageInfo.setPageSize(pageSize);
     if (pageIndex == null)
       pageInfo.setPageIndex(1);
     else {
       pageInfo.setPageIndex(Integer.parseInt(pageIndex));
     }
     this.informationList = this.informationService.select(new Information());
     String index = this.goodType.getIndex();
     String typeId = this.goodType.getParentId();
     try {
       if (this.good == null) {
         this.good = new Good();
       }
       if (index.equals("1")) {
         this.good.setRegisterDate("1");
         this.good.setIndexs("1");
         this.good.setTypeId(typeId);
         this.goodArrList = this.goodService.pageList(pageInfo, this.good, true);
       } else if (index.equals("2")) {
         this.good.setSalesVolume("2");
         this.good.setIndexs("1");
         this.good.setTypeId(typeId);
         this.goodArrList = this.goodService.pageList(pageInfo, this.good, true);
       } else if (index.equals("3")) {
         this.good.setTag("精品推荐");
         this.good.setRecommend("3");
         this.good.setIndexs("1");
         this.good.setTypeId(typeId);
         this.goodArrList = this.goodService.pageList(pageInfo, this.good, true);
       }
       request.setAttribute("index", this.goodType.getIndex());
       request.setAttribute("parentId", this.goodType.getParentId());
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     if ((pageInfo.getCount() > 0) && (pageInfo.getCount() % pageSize != 0))
       pageInfo.setPageCount(pageInfo.getCount() / pageSize + 1);
     else {
       pageInfo.setPageCount(pageInfo.getCount() / pageSize);
     }
     request.setAttribute("pageInfo", pageInfo);
     return "listNew";
   }
 
   public String listChannelThree()
   {
     HttpServletRequest request = getRequest();
     String pageIndex = request.getParameter("pageIndex");
     int pageSize = 16;
     PageInfo pageInfo = createPageInfo();
     pageInfo.setPageSize(pageSize);
     if (pageIndex == null)
       pageInfo.setPageIndex(1);
     else {
       pageInfo.setPageIndex(Integer.parseInt(pageIndex));
     }
     try
     {
       if (this.good == null) {
         this.good = new Good();
       }
       String brandId = this.good.getBrandId();
       String brandname = this.good.getBrandName();
       if (brandname != null) {
         brandname = URLDecoder.decode(brandname, "UTF-8");
       }
       this.informationList = this.informationService.select(new Information());
 
       this.goodList = this.goodService.pageList(pageInfo, this.good, true);
       this.goodbrandlist = this.goodBrandService.getGoodBrandList(Integer.valueOf(2));
       this.goodtotalSaleList = this.goodService.getGoodsByTotalsales();
 
       if ((pageInfo.getCount() > 0) && (pageInfo.getCount() % pageSize != 0))
         pageInfo.setPageCount(pageInfo.getCount() / pageSize + 1);
       else {
         pageInfo.setPageCount(pageInfo.getCount() / pageSize);
       }
       request.setAttribute("pageInfo", pageInfo);
       request.setAttribute("brandId", brandId);
       request.setAttribute("brandname", brandname);
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     return "listChannelThree";
   }
 
   public Advertise getAdvertise()
   {
     return this.advertise;
   }
 
   public void setAdvertise(Advertise advertise) {
     this.advertise = advertise;
   }
   public AdvertiseService getAdvertiseService() {
     return this.advertiseService;
   }
 
   public void setAdvertiseService(AdvertiseService advertiseService) {
     this.advertiseService = advertiseService;
   }
 
   public List<Advertise> getAdvertiseList() {
     return this.advertiseList;
   }
 
   public void setAdvertiseList(List<Advertise> advertiseList) {
     this.advertiseList = advertiseList;
   }
   public PromotionActivity getPromotionActivity() {
     return this.promotionActivity;
   }
   public void setPromotionActivity(PromotionActivity promotionActivity) {
     this.promotionActivity = promotionActivity;
   }
   public PromotionActivityService getPromotionActivityService() {
     return this.promotionActivityService;
   }
 
   public void setPromotionActivityService(PromotionActivityService promotionActivityService) {
     this.promotionActivityService = promotionActivityService;
   }
   public List<PromotionActivity> getPromotionActivityList() {
     return this.promotionActivityList;
   }
 
   public void setPromotionActivityList(List<PromotionActivity> promotionActivityList) {
     this.promotionActivityList = promotionActivityList;
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
   public List<Promote> getPromoteList() {
     return this.promoteList;
   }
   public void setPromoteList(List<Promote> promoteList) {
     this.promoteList = promoteList;
   }
   public List<Information> getInformationList() {
     return this.informationList;
   }
   public void setInformationList(List<Information> informationList) {
     this.informationList = informationList;
   }
   public InformationService getInformationService() {
     return this.informationService;
   }
   public void setInformationService(InformationService informationService) {
     this.informationService = informationService;
   }
   public FileUploadService getFileUploadService() {
     return this.fileUploadService;
   }
   public void setFileUploadService(FileUploadService fileUploadService) {
     this.fileUploadService = fileUploadService;
   }
   public List<FileUpload> getPromotePicList() {
     return this.promotePicList;
   }
   public void setPromotePicList(List<FileUpload> promotePicList) {
     this.promotePicList = promotePicList;
   }
   public List<PromoteGood> getPromoteGoodList() {
     return this.promoteGoodList;
   }
   public void setPromoteGoodList(List<PromoteGood> promoteGoodList) {
     this.promoteGoodList = promoteGoodList;
   }
   public PromoteGoodService getPromoteGoodService() {
     return this.promoteGoodService;
   }
   public void setPromoteGoodService(PromoteGoodService promoteGoodService) {
     this.promoteGoodService = promoteGoodService;
   }
   public List<Good> getGoodList() {
     return this.goodList;
   }
   public void setGoodList(List<Good> goodList) {
     this.goodList = goodList;
   }
   public GoodService getGoodService() {
     return this.goodService;
   }
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
   public PromotionActivityGoodService getPromotionActivityGoodService() {
     return this.promotionActivityGoodService;
   }
 
   public void setPromotionActivityGoodService(PromotionActivityGoodService promotionActivityGoodService) {
     this.promotionActivityGoodService = promotionActivityGoodService;
   }
   public List<PromotionActivityGood> getPromotionActivityGoodList() {
     return this.promotionActivityGoodList;
   }
 
   public void setPromotionActivityGoodList(List<PromotionActivityGood> promotionActivityGoodList) {
     this.promotionActivityGoodList = promotionActivityGoodList;
   }
   public List<FileUpload> getPromotionActivityPicList() {
     return this.promotionActivityPicList;
   }
 
   public void setPromotionActivityPicList(List<FileUpload> promotionActivityPicList) {
     this.promotionActivityPicList = promotionActivityPicList;
   }
   public List<Good> getGoodSaleList() {
     return this.goodSaleList;
   }
   public void setGoodSaleList(List<Good> goodSaleList) {
     this.goodSaleList = goodSaleList;
   }
   public GoodType getGoodType() {
     return this.goodType;
   }
   public void setGoodType(GoodType goodType) {
     this.goodType = goodType;
   }
   public Good getGood() {
     return this.good;
   }
   public void setGood(Good good) {
     this.good = good;
   }
   public List<Good> getGoodTimeList() {
     return this.goodTimeList;
   }
   public void setGoodTimeList(List<Good> goodTimeList) {
     this.goodTimeList = goodTimeList;
   }
 
   public List<Good> getGoodTypeList() {
     return this.goodTypeList;
   }
   public void setGoodTypeList(List<Good> goodTypeList) {
     this.goodTypeList = goodTypeList;
   }
   public List<GoodType> getTypeList() {
     return this.typeList;
   }
   public void setTypeList(List<GoodType> typeList) {
     this.typeList = typeList;
   }
   public GoodTypeService getGoodTypeService() {
     return this.goodTypeService;
   }
   public void setGoodTypeService(GoodTypeService goodTypeService) {
     this.goodTypeService = goodTypeService;
   }
 
   public List<GoodBrand> getGoodbrandlist() {
     return this.goodbrandlist;
   }
   public void setGoodbrandlist(List<GoodBrand> goodbrandlist) {
     this.goodbrandlist = goodbrandlist;
   }
   public GoodBrandService getGoodBrandService() {
     return this.goodBrandService;
   }
   public void setGoodBrandService(GoodBrandService goodBrandService) {
     this.goodBrandService = goodBrandService;
   }
   public List<Good> getGoodtotalSaleList() {
     return this.goodtotalSaleList;
   }
   public void setGoodtotalSaleList(List<Good> goodtotalSaleList) {
     this.goodtotalSaleList = goodtotalSaleList;
   }
   public List<Good> getGoodArrList() {
     return this.goodArrList;
   }
   public void setGoodArrList(List<Good> goodArrList) {
     this.goodArrList = goodArrList;
   }
   public List<Good> getGoodTagList() {
     return this.goodTagList;
   }
   public void setGoodTagList(List<Good> goodTagList) {
     this.goodTagList = goodTagList;
   }
   public List<PromotionActivityGood> getPromotionActivityGoodTypeList() {
     return this.promotionActivityGoodTypeList;
   }
 
   public void setPromotionActivityGoodTypeList(List<PromotionActivityGood> promotionActivityGoodTypeList) {
     this.promotionActivityGoodTypeList = promotionActivityGoodTypeList;
   }
   public PromotionActivityGood getPromotionActivityGood() {
     return this.promotionActivityGood;
   }
   public void setPromotionActivityGood(PromotionActivityGood promotionActivityGood) {
     this.promotionActivityGood = promotionActivityGood;
   }
 }