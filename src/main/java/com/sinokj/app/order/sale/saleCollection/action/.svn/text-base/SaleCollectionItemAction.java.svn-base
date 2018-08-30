 package com.sinokj.app.order.sale.saleCollection.action;
 
 import com.sinokj.app.order.sale.saleCollection.model.SaleCollectionItem;
import com.sinokj.app.order.sale.saleCollection.service.SaleCollectionItemService;
import com.sinokj.app.order.sale.saleDelivery.model.SaleDelivery;
import com.sinokj.app.order.sale.saleDelivery.service.SaleDeliveryService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class SaleCollectionItemAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(SaleCollectionItemAction.class);
   private SaleCollectionItem saleCollectionItem;
   private SaleCollectionItemService saleCollectionItemService;
   private SaleDelivery saleDelivery;
   private SaleDeliveryService saleDeliveryService;
 
   public void setSaleCollectionItemService(SaleCollectionItemService saleCollectionItemService)
   {
     this.saleCollectionItemService = saleCollectionItemService;
   }
 
   public void setSaleDeliveryService(SaleDeliveryService saleDeliveryService)
   {
     this.saleDeliveryService = saleDeliveryService;
   }
 
   public String listJson()
   {
     logger.info("start list saleCollectionItem");
     List<SaleCollectionItem> resultList = null;
     int totalRows = 0;
     try {
       if (this.saleCollectionItem == null) {
         this.saleCollectionItem = new SaleCollectionItem();
       }
 
       if ((this.saleDelivery != null) && (StringUtils.isNotBlank(this.saleDelivery.getId())) && (StringUtils.isBlank(this.saleCollectionItem.getCollectionId()))) {
         this.saleDelivery = ((SaleDelivery)this.saleDeliveryService.getModel(this.saleDelivery.getId()));
         this.saleCollectionItem.setOrderId(this.saleDelivery.getId());
         this.saleCollectionItem.setCode(this.saleDelivery.getCode());
         this.saleCollectionItem.setMoneyAccount(this.saleDelivery.getMoneyAccount());
         if (this.saleDelivery.getMoneyReceived() == null) {
           this.saleDelivery.setMoneyReceived(Double.valueOf(0.0D));
         }
         this.saleCollectionItem.setMoneyAlreadyReceived(this.saleDelivery.getMoneyReceived());
         resultList = new ArrayList();
         resultList.add(this.saleCollectionItem);
         totalRows = 1;
       } else {
         PageInfo pageInfo = createPageInfo();
         resultList = this.saleCollectionItemService.pageList(pageInfo, this.saleCollectionItem, true);
         for (SaleCollectionItem saleCollectionItem : resultList) {
           this.saleDelivery = ((SaleDelivery)this.saleDeliveryService.getModel(saleCollectionItem.getOrderId()));
           saleCollectionItem.setCode(this.saleDelivery.getCode());
         }
         totalRows = pageInfo.getCount();
       }
     } catch (Exception e) {
       logger.error("error occur when list saleCollectionItem", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all saleCollectionItem!");
     return "success";
   }
 
   public SaleCollectionItem getSaleCollectionItem() {
     return this.saleCollectionItem;
   }
   public void setSaleCollectionItem(SaleCollectionItem saleCollectionItem) {
     this.saleCollectionItem = saleCollectionItem;
   }
   public SaleDelivery getSaleDelivery() {
     return this.saleDelivery;
   }
   public void setSaleDelivery(SaleDelivery saleDelivery) {
     this.saleDelivery = saleDelivery;
   }
 }

/* 
 
 
 */