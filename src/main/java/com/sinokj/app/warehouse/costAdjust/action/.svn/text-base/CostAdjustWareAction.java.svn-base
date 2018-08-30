 package com.sinokj.app.warehouse.costAdjust.action;
 
 import com.sinokj.app.warehouse.costAdjust.model.CostAdjustWare;
import com.sinokj.app.warehouse.costAdjust.service.CostAdjustWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class CostAdjustWareAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(CostAdjustWareAction.class);
   private CostAdjustWareService costAdjustWareService;
   private CostAdjustWare costAdjustWare;
 
   public String listJson()
   {
     logger.info("start list costAdjustWare");
     List resultList = null;
     int totalRows = 0;
     try {
       if (this.costAdjustWare == null) {
         this.costAdjustWare = new CostAdjustWare();
       }
       PageInfo pageInfo = createPageInfo();
       resultList = this.costAdjustWareService.pageList(pageInfo, this.costAdjustWare, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list costAdjustWare", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all costAdjust");
     return "success";
   }
 
   public void setCostAdjustWareService(CostAdjustWareService costAdjustWareService) {
     this.costAdjustWareService = costAdjustWareService;
   }
 }

/* 
 
 
 */