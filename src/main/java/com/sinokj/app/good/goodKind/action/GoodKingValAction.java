 package com.sinokj.app.good.goodKind.action;
 
 import com.sinokj.app.good.goodKind.model.GoodKingVal;
import com.sinokj.app.good.goodKind.service.GoodKingValService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodKingValAction extends BaseAction
 {
   private static final long serialVersionUID = -1459567392036376844L;
   private static final Logger logger = Logger.getLogger(GoodKingValAction.class);
   private GoodKingVal goodKingVal;
   private String goodKingId;
   private GoodKingValService goodKingValService;
 
   public void setGoodKingValService(GoodKingValService goodKingValService)
   {
     this.goodKingValService = goodKingValService;
   }
 
   public String list()
   {
     this.goodKingId = this.goodKingVal.getGoodKingId();
     return "list_goodKingVal";
   }
 
   public String listJson()
   {
     logger.info("start list goodKing!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.goodKingVal == null) {
         this.goodKingVal = new GoodKingVal();
       }
       resultList = this.goodKingValService.pageList(pageInfo, this.goodKingVal, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list goodKingVal", e);
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
     if (this.goodKingVal == null) {
       this.goodKingVal = new GoodKingVal();
     }
     if (StringUtils.isNotBlank(this.goodKingVal.getId()))
       this.goodKingVal = ((GoodKingVal)this.goodKingValService.getModel(this.goodKingVal.getId()));
     else {
       this.goodKingVal.setGoodKingId(this.goodKingId);
     }
     return "edit_goodKingVal";
   }
 
   public void save()
   {
     try
     {
       if (StringUtils.isBlank(this.goodKingVal.getId()))
         this.goodKingValService.insert(this.goodKingVal);
       else {
         this.goodKingValService.update(this.goodKingVal);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save goodKingVal", e);
     }
   }
 
   public void delete()
   {
     try
     {
       if (StringUtils.isBlank(this.goodKingVal.getId())) {
         responseFlag(false);
       } else {
         this.goodKingValService.delete(this.goodKingVal.getId());
         responseFlag(true);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete a goodKingVal", e);
     }
   }
 
   public void getKingVal()
   {
     if (this.goodKingVal == null)
       this.goodKingVal = new GoodKingVal();
     try
     {
       List list = this.goodKingValService.getKingValByKingId(this.goodKingVal.getGoodKingId());
       String html = "";
       if (list != null) {
         for (int i = 0; i < list.size(); i++) {
           html = html + "&nbsp;&nbsp;<span class='KingVal' style='border:1px solid #8DB2E3;font-size: 18px;'>&nbsp;" + ((GoodKingVal)list.get(i)).getValue() + "&nbsp;" + 
             "<input type='hidden' class='KingValId' value='" + ((GoodKingVal)list.get(i)).getId() + "'/></span>";
         }
       }
       responseFlag(html);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when get goodKingVal", e);
     }
   }
 
   public GoodKingVal getGoodKingVal() {
     return this.goodKingVal;
   }
 
   public void setGoodKingVal(GoodKingVal goodKingVal) {
     this.goodKingVal = goodKingVal;
   }
   public String getGoodKingId() {
     return this.goodKingId;
   }
   public void setGoodKingId(String goodKingId) {
     this.goodKingId = goodKingId;
   }
 }

/* 
 
 
 */