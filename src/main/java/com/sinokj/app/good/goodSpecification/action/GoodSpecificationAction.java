 package com.sinokj.app.good.goodSpecification.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.goodSpecification.model.GoodSpecification;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationService;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationValService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodSpecificationAction extends BaseAction
 {
   private static final long serialVersionUID = -5328157621477061704L;
   private static final Logger logger = Logger.getLogger(GoodSpecificationAction.class);
   private GoodSpecification goodSpecification;
   private GoodSpecificationService goodSpecificationService;
   private GoodSpecificationValService goodSpecificationValService;
   private SerialNumberService serialNumberService;
 
   public void setGoodSpecificationService(GoodSpecificationService goodSpecificationService)
   {
     this.goodSpecificationService = goodSpecificationService;
   }
 
   public void setGoodSpecificationValService(GoodSpecificationValService goodSpecificationValService)
   {
     this.goodSpecificationValService = goodSpecificationValService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public String list()
   {
     return "list_goodSpecification";
   }
 
   public String listJson()
   {
     logger.info("start list goodSpecification!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.goodSpecification == null) {
         this.goodSpecification = new GoodSpecification();
       }
       resultList = this.goodSpecificationService.pageList(pageInfo, this.goodSpecification, true);
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
     SysUser loginMan = getSessionUserInfo();
     if (this.goodSpecification == null) {
       this.goodSpecification = new GoodSpecification();
     }
     if (StringUtils.isBlank(this.goodSpecification.getId())) {
       initModel(true, this.goodSpecification, loginMan);
     } else {
       this.goodSpecification = ((GoodSpecification)this.goodSpecificationService.getModel(this.goodSpecification.getId()));
       initModel(false, this.goodSpecification, loginMan);
     }
     return "edit_goodSpecification";
   }
 
   public void save()
   {
     try
     {
       if (StringUtils.isBlank(this.goodSpecification.getId())) {
         String code = this.serialNumberService.getSerialNumberNoDate("", "Specification", 3);
         this.goodSpecification.setCode(code);
         this.goodSpecification.setShowWay("1");
         this.goodSpecificationService.insert(this.goodSpecification);
       } else {
         this.goodSpecificationService.update(this.goodSpecification);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save goodSpecification", e);
     }
   }
 
   public void delete()
   {
     try
     {
       if (StringUtils.isNotBlank(this.goodSpecification.getId())) {
         this.goodSpecificationValService.deleteBySpecicationId(this.goodSpecification.getId());
         this.goodSpecificationService.delete(this.goodSpecification.getId());
         responseFlag(true);
       }
     } catch (Exception e) {
       responseFlag(false);
       e.printStackTrace();
     }
   }
 
   public GoodSpecification getGoodSpecification() {
     return this.goodSpecification;
   }
   public void setGoodSpecification(GoodSpecification goodSpecification) {
     this.goodSpecification = goodSpecification;
   }
 }

/* 
 
 
 */