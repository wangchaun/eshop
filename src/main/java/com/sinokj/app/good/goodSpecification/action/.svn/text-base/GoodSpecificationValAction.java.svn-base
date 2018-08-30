 package com.sinokj.app.good.goodSpecification.action;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.good.goodSpecification.model.GoodSpecification;
import com.sinokj.app.good.goodSpecification.model.GoodSpecificationVal;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationService;
import com.sinokj.app.good.goodSpecification.service.GoodSpecificationValService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodSpecificationValAction extends BaseAction
 {
   private static final long serialVersionUID = -1459567392036376844L;
   private static final Logger logger = Logger.getLogger(GoodSpecificationValAction.class);
   private GoodSpecificationVal goodSpecificationVal;
   private String goodSpecificationId;
   private GoodSpecification goodSpecification;
   private GoodSpecificationService goodSpecificationService;
   private FileUploadService fileUploadService;
   private GoodSpecificationValService goodSpecificationValService;
 
   public void setFileUploadService(FileUploadService fileUploadService)
   {
     this.fileUploadService = fileUploadService;
   }
 
   public void setGoodSpecificationValService(GoodSpecificationValService goodSpecificationValService)
   {
     this.goodSpecificationValService = goodSpecificationValService;
   }
 
   public String list()
   {
     this.goodSpecificationId = this.goodSpecificationVal.getGoodSpecificationId();
     return "list_goodSpecificationVal";
   }
 
   public String listJson()
   {
     logger.info("start list goodSpecification!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.goodSpecificationVal == null) {
         this.goodSpecificationVal = new GoodSpecificationVal();
       }
       resultList = this.goodSpecificationValService.pageList(pageInfo, this.goodSpecificationVal, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list goodSpecificationVal", e);
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
     if (this.goodSpecificationVal == null) {
       this.goodSpecificationVal = new GoodSpecificationVal();
     }
     if (StringUtils.isNotBlank(this.goodSpecificationVal.getId())) {
       this.goodSpecificationVal = ((GoodSpecificationVal)this.goodSpecificationValService.getModel(this.goodSpecificationVal.getId()));
       this.goodSpecification = ((GoodSpecification)this.goodSpecificationService.getModel(this.goodSpecificationVal.getGoodSpecificationId()));
       if (this.goodSpecification != null)
         this.goodSpecificationVal.setShowType(this.goodSpecification.getShowType());
     }
     else {
       this.goodSpecification = ((GoodSpecification)this.goodSpecificationService.getModel(this.goodSpecificationId));
       this.goodSpecificationVal.setGoodSpecificationId(this.goodSpecificationId);
       if (this.goodSpecification != null) {
         this.goodSpecificationVal.setShowType(this.goodSpecification.getShowType());
       }
     }
     return "edit_goodSpecificationVal";
   }
 
   public void save()
   {
     try
     {
       HttpServletRequest request = getRequest();
 
       if (StringUtils.isBlank(this.goodSpecificationVal.getId()))
         this.goodSpecificationValService.insert(this.goodSpecificationVal);
       else {
         this.goodSpecificationValService.update(this.goodSpecificationVal);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save goodSpecificationVal", e);
     }
   }
 
   public void delete()
   {
     try
     {
       if (StringUtils.isBlank(this.goodSpecificationVal.getId())) {
         responseFlag(false);
       } else {
         this.goodSpecificationValService.delete(this.goodSpecificationVal.getId());
         responseFlag(true);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a goodSpecificationVal", e);
     }
   }
 
   public void getSpecificationVal()
   {
     if (this.goodSpecificationVal == null)
       this.goodSpecificationVal = new GoodSpecificationVal();
     try
     {
       List list = this.goodSpecificationValService.getSpecificationValBySpecificationId(this.goodSpecificationVal.getGoodSpecificationId());
       String html = "";
       if (list != null) {
         for (int i = 0; i < list.size(); i++) {
           html = html + "&nbsp;&nbsp;<span class='specificationVal' style='border:1px solid #8DB2E3;font-size: 18px;'>&nbsp;" + ((GoodSpecificationVal)list.get(i)).getValue() + "&nbsp;" + 
             "<input type='hidden' class='specificationValId' value='" + ((GoodSpecificationVal)list.get(i)).getId() + "'/></span>";
         }
       }
       responseFlag(html);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when get goodSpecificationVal", e);
     }
   }
 
   public GoodSpecificationVal getGoodSpecificationVal() {
     return this.goodSpecificationVal;
   }
 
   public void setGoodSpecificationVal(GoodSpecificationVal goodSpecificationVal) {
     this.goodSpecificationVal = goodSpecificationVal;
   }
   public String getGoodSpecificationId() {
     return this.goodSpecificationId;
   }
   public void setGoodSpecificationId(String goodSpecificationId) {
     this.goodSpecificationId = goodSpecificationId;
   }
   public GoodSpecification getGoodSpecification() {
     return this.goodSpecification;
   }
   public void setGoodSpecification(GoodSpecification goodSpecification) {
     this.goodSpecification = goodSpecification;
   }
   public GoodSpecificationValService getGoodSpecificationValService() {
     return this.goodSpecificationValService;
   }
   public GoodSpecificationService getGoodSpecificationService() {
     return this.goodSpecificationService;
   }
 
   public void setGoodSpecificationService(GoodSpecificationService goodSpecificationService) {
     this.goodSpecificationService = goodSpecificationService;
   }
 }

/* 
 
 
 */