 package com.sinokj.app.good.goodBrand.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.goodBrand.model.GoodBrand;
import com.sinokj.app.good.goodBrand.service.GoodBrandService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.io.UnsupportedEncodingException;
 import java.net.URLDecoder;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodBrandAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(GoodBrandAction.class);
   private GoodBrand goodBrand;
   private GoodBrandService goodBrandService;
   private List<GoodBrand> resultList;
   private SerialNumberService serialNumberService;
 
   public void setGoodBrandService(GoodBrandService goodBrandService)
   {
     this.goodBrandService = goodBrandService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public String list()
   {
     return "list_goodBrand";
   }
 
   public String listJson()
   {
     if (this.goodBrand == null) {
       this.goodBrand = new GoodBrand();
     }
     String parentId = this.goodBrand.getParentId();
     if (StringUtils.isNotBlank(parentId)) {
       GoodBrand brand = (GoodBrand)this.goodBrandService.getModel(parentId);
       Integer parentLevel = brand.getLevel();
       this.goodBrand.setLevel(Integer.valueOf(parentLevel.intValue() + 1));
       this.goodBrand.setIdStr(brand.getId());
     }
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.goodBrand.getParentId() == null)
         resultList = this.goodBrandService.getGoodBrandList(Integer.valueOf(1));
       else
         resultList = this.goodBrandService.getGoodBrandList1(this.goodBrand);
       if (resultList == null) {
         resultList = new ArrayList();
       }
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when listing goodBrand information", e);
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
 
     logger.info("finish list all goodBrand data!");
     return "success";
   }
 
   public String findBrand()
     throws UnsupportedEncodingException
   {
     HttpServletRequest request = getRequest();
     if (this.goodBrand == null) {
       this.goodBrand = new GoodBrand();
     }
     String brandName = this.goodBrand.getName();
     if (brandName != null)
     {
       brandName = URLDecoder.decode(brandName, "UTF-8");
       this.goodBrand.setName(brandName);
     }
     String parentId = this.goodBrand.getParentId();
     if (StringUtils.isNotBlank(parentId)) {
       GoodBrand brand = (GoodBrand)this.goodBrandService.getModel(parentId);
       Integer parentLevel = brand.getLevel();
       this.goodBrand.setLevel(Integer.valueOf(parentLevel.intValue() + 1));
     }
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       this.resultList = this.goodBrandService.pageList(pageInfo, this.goodBrand, true);
       if (this.resultList == null) {
         this.resultList = new ArrayList();
       }
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when listing goodBrand information", e);
     }
     request.setAttribute("totalRows", Integer.valueOf(totalRows));
     return "find_goodBrand";
   }
 
   public String edit(){
     HttpServletRequest request = getRequest();
     try {
       SysUser loginMain = getSessionUserInfo();
       if (this.goodBrand == null) {
         this.goodBrand = new GoodBrand();
       }
       if (StringUtils.isNotBlank(this.goodBrand.getId())) {
         this.goodBrand = ((GoodBrand)this.goodBrandService.getModel(this.goodBrand.getId()));
 
         initModel(false, this.goodBrand, loginMain);
       }
       else {
         initModel(true, this.goodBrand, loginMain);
 
         String parentId = this.goodBrand.getParentId();
         if ((StringUtils.isNotBlank(parentId)) && (parentId != null))
         {
           GoodBrand brand = (GoodBrand)this.goodBrandService.getModel(parentId);
           String parentName = brand.getName();
           this.goodBrand.setLevel(Integer.valueOf(brand.getLevel().intValue() + 1));
           request.setAttribute("parentName", parentName);
         }
       }
     } catch (Exception e) {
       logger.error("error occur when select goodBrand information", e);
     }
     return "edit_goodBrand";
   }
 
   public void save()
   {
     logger.info("start to save goodType information");
     String prefix = "";
     String appType = "GoodBrand";
     try
     {
       if (this.goodBrand == null) {
         this.goodBrand = new GoodBrand();
       }
       if (this.goodBrand.getLevel() == null) {
         this.goodBrand.setLevel(Integer.valueOf(1));
       }
 
       int brandNumber = this.goodBrandService.count().intValue();
       this.goodBrand.setSort(Integer.valueOf(brandNumber));
 
       if (StringUtils.isBlank(this.goodBrand.getCode())) {
         String parentId = this.goodBrand.getParentId();
         if ((StringUtils.isNotBlank(parentId)) && (parentId != null))
         {
           GoodBrand brand = (GoodBrand)this.goodBrandService.getModel(parentId);
 
           prefix = brand.getCode();
           appType = appType + brand.getName();
         }
         String code = this.serialNumberService.getSerialNumberNoDate(prefix, appType, 3);
         this.goodBrand.setCode(code);
       }
       if (StringUtils.isBlank(this.goodBrand.getId()))
       {
         this.goodBrandService.insert(this.goodBrand);
       }
       else {
         this.goodBrandService.update(this.goodBrand);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("eror occur when inserting goodType information", e);
     }
   }
 
   public void delete()
   {
     logger.info("start to delete goodType information");
     try {
       if (this.goodBrand == null) {
         this.goodBrand = new GoodBrand();
       }
 
       this.goodBrandService.delete(this.goodBrand.getId());
       responseFlag(true);
     } catch (Exception e) {
       logger.error("eror occur when deleting goodType information", e);
       responseFlag(false);
     }
   }
 
   public void checkCode()
   {
     if (this.goodBrand == null) {
       this.goodBrand = new GoodBrand();
     }
     if (StringUtils.isNotBlank(this.goodBrand.getCode())) {
       try {
         this.goodBrand = this.goodBrandService.getByCode(this.goodBrand.getCode());
       } catch (Exception e) {
         logger.error("error occur when get goodBrand by code", e);
       }
       if (this.goodBrand == null)
         responseFlag(true);
       else
         responseFlag(false);
     }
     else {
       responseFlag(false);
     }
   }
 
   public GoodBrand getGoodBrand() { return this.goodBrand; }
 
   public void setGoodBrand(GoodBrand goodBrand) {
     this.goodBrand = goodBrand;
   }
   public List<GoodBrand> getResultList() {
     return this.resultList;
   }
   public void setResultList(List<GoodBrand> resultList) {
     this.resultList = resultList;
   }
 }

/* 
 
 
 */