 package com.sinokj.app.good.goodKind.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.goodAttr.service.GoodAttrService;
import com.sinokj.app.good.goodKind.model.GoodKind;
import com.sinokj.app.good.goodKind.service.GoodKindService;
import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodKindAction extends BaseAction
 {
   private static final long serialVersionUID = -5269625408439629251L;
   private static final Logger logger = Logger.getLogger(GoodKindAction.class);
   private GoodKind goodKind;
   private GoodKindService goodKindService;
   private GoodAttrService goodAttrService;
   private SerialNumberService serialNumberService;
   private GoodType goodType;
   private List<GoodType> goodTypeList;
   private GoodTypeService goodTypeService;
 
   public String list()
   {
     return "list_goodKind";
   }
 
   public String listJson()
   {
     logger.info("start list all kind!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.goodKind == null) {
         this.goodKind = new GoodKind();
       }
       resultList = this.goodKindService.pageList(pageInfo, this.goodKind, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list goods", e);
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
 
   public String edit()
   {
     logger.info("start get a kind");
     if (this.goodKind == null) {
       this.goodKind = new GoodKind();
     }
     if (this.goodType == null) {
       this.goodType = new GoodType();
     }
 
     try
     {
       this.goodType.setLevel(Integer.valueOf(1));
       this.goodTypeList = this.goodTypeService.select(this.goodType);
       if (StringUtils.isNotBlank(this.goodKind.getId())) {
         this.goodKind = ((GoodKind)this.goodKindService.getModel(this.goodKind.getId()));
         initModel(false, this.goodKind, getSessionUserInfo());
       } else {
         initModel(true, this.goodKind, getSessionUserInfo());
       }
     } catch (Exception e) {
       logger.error("error occur when get a kind", e);
     }
     return "edit_goodKind";
   }
 
   public void save()
   {
     logger.info("start saving a kind");
     try {
       if (this.goodKind.getGoodtypeId() != null) {
         this.goodType = ((GoodType)this.goodTypeService.getModel(this.goodKind.getGoodtypeId()));
         this.goodKind.setGoodtypeName(this.goodType.getName());
       }
       if (StringUtils.isNotBlank(this.goodKind.getId())) {
         this.goodKindService.update(this.goodKind);
       } else {
         String prefix = "";
         String apptype = "goodKind";
         String code = this.serialNumberService.getSerialNumberNoDate(prefix, apptype, 3);
         this.goodKind.setCode(code);
         this.goodKindService.insert(this.goodKind);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when saving a kind", e);
     }
   }
 
   public void delete()
   {
     logger.info("start deleting a kind");
     try {
       if (StringUtils.isNotBlank(this.goodKind.getId()))
       {
         this.goodAttrService.deleteByKindId(this.goodKind.getId());
         this.goodKindService.delete(this.goodKind.getId());
         responseFlag(true);
       } else {
         responseFlag(false);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a kind", e);
     }
   }
 
   public GoodKind getGoodKind() {
     return this.goodKind;
   }
   public void setGoodKind(GoodKind goodKind) {
     this.goodKind = goodKind;
   }
   public void setGoodKindService(GoodKindService goodKindService) {
     this.goodKindService = goodKindService;
   }
   public void setGoodAttrService(GoodAttrService goodAttrService) {
     this.goodAttrService = goodAttrService;
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
   public GoodKindService getGoodKindService() {
     return this.goodKindService;
   }
   public GoodAttrService getGoodAttrService() {
     return this.goodAttrService;
   }
   public GoodType getGoodType() {
     return this.goodType;
   }
   public void setGoodType(GoodType goodType) {
     this.goodType = goodType;
   }
 }

/* 
 
 
 */