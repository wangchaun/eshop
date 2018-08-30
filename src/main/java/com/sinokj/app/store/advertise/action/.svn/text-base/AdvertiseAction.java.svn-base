 package com.sinokj.app.store.advertise.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class AdvertiseAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(AdvertiseAction.class);
   private AdvertiseService advertiseService;
   private Advertise advertise;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private SerialNumberService serialNumberService;
   private List<GoodType> goodTypeList;
   private GoodTypeService goodTypeService;
   private GoodType goodType;
   private List<GoodType> goodTypeList1;
 
   public String listJson()
   {
     logger.info("start list advertise!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.advertise == null) {
         this.advertise = new Advertise();
       }
       resultList = this.advertiseService.pageList(pageInfo, this.advertise, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list advertise!", e);
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
     logger.info("start to query Advertise information");
     return "list_advertise";
   }
 
   public String edit()
     throws Exception
   {
     logger.info("start to query Advertise information");
     if (this.goodType == null) {
       this.goodType = new GoodType();
     }
 
     GoodType goodtype = new GoodType();
     goodtype.setLevel(Integer.valueOf(1));
     this.goodTypeList = this.goodTypeService.queryTypeTree(goodtype);
 
     SysUser loginMan = getSessionUserInfo();
     if (this.advertise == null) {
       this.advertise = new Advertise();
     }
     if (StringUtils.isBlank(this.advertise.getId())) {
       this.advertise.setState("c");
       initModel(true, this.advertise, loginMan);
     } else {
       this.advertise = ((Advertise)this.advertiseService.getModel(this.advertise.getId()));
       initModel(false, this.advertise, loginMan);
     }
     return "edit_advertise";
   }
 
   public void save()
   {
     logger.info("start to update advertise information");
     HttpServletRequest request = getRequest();
     String picId = request.getParameter("picId");
     try
     {
       if (this.advertise == null) {
         this.advertise = new Advertise();
         this.advertise.setPicId(picId);
       } else {
         this.advertise.setPicId(picId);
       }
 
       if (StringUtils.isBlank(this.advertise.getId()))
       {
         this.advertise.setId(this.advertiseService.makeId());
         this.advertise.setCode(this.serialNumberService.getSerialNumberByDate("AD", "advertise"));
         this.advertise.setCreateTime(new Date());
         this.advertise.setModifyTime(new Date());
         this.advertiseService.insertAdvertise(this.advertise);
       } else {
         this.advertise.setModifyTime(new Date());
         this.advertiseService.update(this.advertise);
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.advertise.getId());
         }
       }
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.advertise.getId());
         }
         if (StringUtils.isNotBlank(picId)) {
           this.fileUploadService.updateAppId(picId, this.advertise.getPicId());
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save advertise information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save advertise information");
   }
 
   public void delete()
   {
     logger.info("start delete a good:" + this.advertise.getId());
     try
     {
       this.fileUploadService.cleanAppId(this.advertise.getId());
       this.advertiseService.delete(this.advertise.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a advertise!", e);
     }
   }
 
   public AdvertiseService getAdvertiseservice()
   {
     return this.advertiseService;
   }
   public void setAdvertiseservice(AdvertiseService advertiseservice) {
     this.advertiseService = advertiseservice;
   }
   public Advertise getAdvertise() {
     return this.advertise;
   }
   public void setAdvertise(Advertise advertise) {
     this.advertise = advertise;
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
 
   public void setAdvertiseService(AdvertiseService advertiseService) {
     this.advertiseService = advertiseService;
   }
 
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public List<GoodType> getGoodTypeList() {
     return this.goodTypeList;
   }
 
   public void setGoodTypeList(List<GoodType> goodTypeList) {
     this.goodTypeList = goodTypeList;
   }
 
   public GoodTypeService getGoodTypeService() {
     return this.goodTypeService;
   }
 
   public void setGoodTypeService(GoodTypeService goodTypeService) {
     this.goodTypeService = goodTypeService;
   }
   public GoodType getGoodType() {
     return this.goodType;
   }
 
   public void setGoodType(GoodType goodType) {
     this.goodType = goodType;
   }
 
   public List<GoodType> getGoodTypeList1() {
     return this.goodTypeList1;
   }
 
   public void setGoodTypeList1(List<GoodType> goodTypeList1) {
     this.goodTypeList1 = goodTypeList1;
   }
 
   public AdvertiseService getAdvertiseService() {
     return this.advertiseService;
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