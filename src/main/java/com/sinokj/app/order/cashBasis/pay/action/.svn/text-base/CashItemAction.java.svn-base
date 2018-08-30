 package com.sinokj.app.order.cashBasis.pay.action;
 
 import com.sinokj.app.order.cashBasis.pay.model.CashItem;
import com.sinokj.app.order.cashBasis.pay.service.CashItemService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class CashItemAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(CashItemAction.class);
   private CashItem cashItem;
   private CashItemService cashItemService;
 
   public CashItem getCashItem()
   {
     return this.cashItem;
   }
 
   public void setCashItem(CashItem cashItem) {
     this.cashItem = cashItem;
   }
 
   public void setCashItemService(CashItemService cashItemService) {
     this.cashItemService = cashItemService;
   }
 
   public String listJson()
   {
     logger.info("start list CashItem");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.cashItem == null) {
         this.cashItem = new CashItem();
       }
       resultList = this.cashItemService.pageList(pageInfo, this.cashItem, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list CashItem", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list CashItem");
     return "success";
   }
 }

/* 
 
 
 */