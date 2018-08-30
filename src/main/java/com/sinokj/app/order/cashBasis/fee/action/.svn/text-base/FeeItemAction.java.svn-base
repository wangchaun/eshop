 package com.sinokj.app.order.cashBasis.fee.action;
 
 import com.sinokj.app.order.cashBasis.fee.model.FeeItem;
import com.sinokj.app.order.cashBasis.fee.service.FeeItemService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class FeeItemAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(FeeItemAction.class);
   private FeeItem feeItem;
   private FeeItemService feeItemService;
 
   public void setFeeItemService(FeeItemService feeItemService)
   {
     this.feeItemService = feeItemService;
   }
 
   public String listJson()
   {
     logger.info("start list documentItem");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.feeItem == null) {
         this.feeItem = new FeeItem();
       }
       resultList = this.feeItemService.pageList(pageInfo, this.feeItem, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list warehouseIntoWare", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list documentItem");
     return "success";
   }
 
   public FeeItem getFeeItem() {
     return this.feeItem;
   }
 
   public void setFeeItem(FeeItem feeItem) {
     this.feeItem = feeItem;
   }
 }

/* 
 
 
 */