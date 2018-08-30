 package com.sinokj.app.store.information.action;
 
 import com.sinokj.app.baseInfo.area.model.Area;
import com.sinokj.app.baseInfo.area.service.AreaService;
import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.store.advertise.model.Advertise;
import com.sinokj.app.store.advertise.service.AdvertiseService;
import com.sinokj.app.store.information.model.Information;
import com.sinokj.app.store.information.service.InformationService;
import com.sinokj.app.system.user.model.SysUser;
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
 
 public class InformationAction extends BaseAction
 {
   private static final long serialVersionUID = -1299499640055184711L;
   private static final Logger logger = Logger.getLogger(InformationAction.class);
   private InformationService informationService;
   private Information information;
   private String imgIdStr;
   private FileUploadService fileUploadService;
   private SerialNumberService serialNumberService;
   private List<Information> informationList;
   private List<Advertise> advertiseList;
   private List<Area> areaList;
   private AreaService areaService;
   private AdvertiseService advertiseService;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
 
   public String listJson()
   {
     logger.info("start list Information!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.information == null) {
         this.information = new Information();
       }
       resultList = this.informationService.pageList(pageInfo, this.information, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list information!", e);
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
     logger.info("start to query Information information");
     String type = this.information.getType();
     getRequest().setAttribute("type", type);
 
     return "list_information";
   }
 
   public String edit()
   {
     logger.info("start to query Information information");
     SysUser loginMan = getSessionUserInfo();
     if (this.information == null) {
       this.information = new Information();
     }
     String type = this.information.getType();
     this.information.setType(this.information.getType());
     if (StringUtils.isBlank(this.information.getId())) {
       this.information.setState("c");
       try {
         String prefix = "AM";
         if ("1".equals(type))
           prefix = "NW";
         else if ("2".equals(type))
           prefix = "IF";
         else if ("3".equals(type))
           prefix = "NR";
         else if ("4".equals(type))
           prefix = "TP";
         else if ("5".equals(type))
           prefix = "MS";
         else if ("6".equals(type))
           prefix = "HC";
         else if ("7".equals(type))
           prefix = "CP";
         else if ("8".equals(type))
           prefix = "LN";
         else if (type.equals("9")) {
           prefix = "GZ";
         }
         String appType = "Information" + prefix;
         if (StringUtils.isNotBlank(type)) {
           appType = appType + type;
         }
         String code = this.serialNumberService.getSerialNumberNoDate(prefix, appType, 3);
         this.information.setCode(code);
       }
       catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when get code", e);
       }
       initModel(true, this.information, loginMan);
     } else {
       this.information = ((Information)this.informationService.getModel(this.information.getId()));
       initModel(false, this.information, loginMan);
     }
     System.out.println("type:" + type);
     return "edit_information";
   }
 
   public void save()
   {
     logger.info("start to update information information");
     try
     {
       if (this.information == null) {
         this.information = new Information();
       }
 
       if (StringUtils.isBlank(this.information.getId()))
       {
         this.information.setId(this.informationService.makeId());
         this.informationService.insert(this.information);
       } else {
         this.informationService.update(this.information);
       }
       if (StringUtils.isNotBlank(this.imgIdStr)) {
         String[] imgIdArr = this.imgIdStr.split(",");
         for (int i = 0; i < imgIdArr.length; i++) {
           this.fileUploadService.updateAppId(imgIdArr[i], this.information.getId());
         }
       }
       responseFlag(true);
     } catch (Exception e) {
       logger.info("error occur when save information information");
       e.printStackTrace();
       responseFlag(false);
     }
     logger.info("finish to save information information");
   }
 
   public void delete()
   {
     logger.info("start delete a good:" + this.information.getId());
     try
     {
       this.fileUploadService.cleanAppId(this.information.getId());
       this.informationService.delete(this.information.getId());
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a information!", e);
     }
   }
 
   public String listInfor()
   {
     if (this.information == null) {
       this.information = new Information();
     }
     String type = this.information.getType();
 
     this.advertiseList = this.advertiseService.getAdvertiseList();
 
     if (this.information.getId() != null) {
       this.information = ((Information)this.informationService.getModel(this.information.getId()));
     } else if ((this.information.getId() == null) && (type != null)) {
       Information infor = new Information();
       infor.setType(type);
       this.information = ((Information)this.informationService.selectOne(infor));
     }
 
     this.informationList = this.informationService.select(new Information());
     return "listInfor";
   }
 
   public InformationService getInformationservice()
   {
     return this.informationService;
   }
   public void setInformationservice(InformationService informationservice) {
     this.informationService = informationservice;
   }
   public Information getInformation() {
     return this.information;
   }
   public void setInformation(Information information) {
     this.information = information;
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
 
   public void setInformationService(InformationService informationService) {
     this.informationService = informationService;
   }
 
   public SerialNumberService getSerialNumberService() {
     return this.serialNumberService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
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
 
   public List<Advertise> getAdvertiseList() {
     return this.advertiseList;
   }
 
   public void setAdvertiseList(List<Advertise> advertiseList) {
     this.advertiseList = advertiseList;
   }
 
   public List<Area> getAreaList() {
     return this.areaList;
   }
 
   public void setAreaList(List<Area> areaList) {
     this.areaList = areaList;
   }
 
   public void setAreaService(AreaService areaService) {
     this.areaService = areaService;
   }
 
   public void setAdvertiseService(AdvertiseService advertiseService) {
     this.advertiseService = advertiseService;
   }
 }

/* 
 
 
 */