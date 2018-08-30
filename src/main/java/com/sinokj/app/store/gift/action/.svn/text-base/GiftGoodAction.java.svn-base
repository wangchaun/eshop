 package com.sinokj.app.store.gift.action;
 
 import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.app.order.price.priceAdjust.action.PriceAdjustWareAction;
import com.sinokj.app.store.gift.model.GiftGood;
import com.sinokj.app.store.gift.service.GiftGoodService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class GiftGoodAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(PriceAdjustWareAction.class);
   private GiftGood giftGood;
   private GiftGoodService giftGoodService;
   private GoodService goodService;
   private WareService wareService;
   private WareSpecificationValService wareSpecificationValService;
 
   public void setGoodService(GoodService goodService)
   {
     this.goodService = goodService;
   }
 
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
 
   public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService)
   {
     this.wareSpecificationValService = wareSpecificationValService;
   }
 
   public String listJson()
   {
     logger.info("start list GiftGood");
     List resultList = null;
 
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.giftGood == null) {
         this.giftGood = new GiftGood();
       }
       resultList = this.giftGoodService.pageList(pageInfo, this.giftGood, true);
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
     logger.info("finish list giftGood");
     return "success";
   }
 
   public GiftGood getGiftGood()
   {
     return this.giftGood;
   }
   public void setGiftGood(GiftGood giftGood) {
     this.giftGood = giftGood;
   }
   public GiftGoodService getGiftGoodService() {
     return this.giftGoodService;
   }
   public void setGiftGoodService(GiftGoodService giftGoodService) {
     this.giftGoodService = giftGoodService;
   }
   public GoodService getGoodService() {
     return this.goodService;
   }
 }

/* 
 
 
 */