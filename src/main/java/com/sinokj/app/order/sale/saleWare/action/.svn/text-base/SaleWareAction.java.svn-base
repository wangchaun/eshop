 package com.sinokj.app.order.sale.saleWare.action;
 
 import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.model.WareSpecificationVal;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class SaleWareAction extends BaseAction
 {
   private static final long serialVersionUID = 1897117049912187706L;
   private static final Logger logger = Logger.getLogger(SaleWareAction.class);
   private SaleWare saleWare;
   private SaleWareService saleWareService;
   private GoodService goodService;
   private WareService wareService;
   private WareSpecificationValService wareSpecificationValService;
 
   public void setSaleWareService(SaleWareService saleWareService)
   {
     this.saleWareService = saleWareService;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
 
   public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService) {
     this.wareSpecificationValService = wareSpecificationValService;
   }
 
   public String listJson()
   {
     logger.info("start list saleware!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.saleWare == null) {
         resultList = new ArrayList();
       } else {
         resultList = this.saleWareService.pageList(pageInfo, this.saleWare, true);
         totalRows = pageInfo.getCount();
 
         for (int i = 0; i < resultList.size(); i++) {
           Ware ware = new Ware();
           ware = (Ware)this.wareService.getModel(((SaleWare)resultList.get(i)).getWareId());
           if (ware != null) {
             ((SaleWare)resultList.get(i)).setCode(ware.getCode());
             List wareSpecificationValList = this.wareSpecificationValService.getByWareId(ware.getId());
             String specificationVal = "";
             for (int j = 0; j < wareSpecificationValList.size(); j++) {
               specificationVal = specificationVal + ((WareSpecificationVal)wareSpecificationValList.get(j)).getSpecificationValName();
               if (j + 1 != wareSpecificationValList.size()) {
                 specificationVal = specificationVal + ",";
               }
             }
             ((SaleWare)resultList.get(i)).setWareSpecificationVal(specificationVal);
 
             Good good = (Good)this.goodService.getModel(ware.getGoodId());
             if (good != null) {
               ((SaleWare)resultList.get(i)).setCode(good.getCode());
               ((SaleWare)resultList.get(i)).setName(good.getName());
               ((SaleWare)resultList.get(i)).setGoodTypeName(good.getGoodTypeName());
               ((SaleWare)resultList.get(i)).setTaxRate(good.getTaxRate());
               ((SaleWare)resultList.get(i)).setTaxPrice(good.getTaxPrice());
               if (good.getInitialNum() == null)
               {
                 good.setInitialNum(Double.valueOf(0.0D));
               }
               if (good.getPurchaseNum() == null)
               {
                 good.setPurchaseNum(Integer.valueOf(0));
               }
               ((SaleWare)resultList.get(i)).setGoodStcok(Double.valueOf(good.getPurchaseNum().intValue() + good.getInitialNum().doubleValue()));
               if ((good.getTaxPrice() != null) && (((SaleWare)resultList.get(i)).getOrderNumber() != null))
               {
                 ((SaleWare)resultList.get(i)).setTaxMoney(Double.valueOf(((SaleWare)resultList.get(i)).getOrderNumber().doubleValue() * good.getTaxPrice().doubleValue()));
               }
             }
           }
         }
       }
     } catch (Exception e) {
       logger.error("error occur when list saleware", e);
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all saleware!");
     return "success";
   }
 
   public SaleWare getSaleWare() {
     return this.saleWare;
   }
   public void setSaleWare(SaleWare saleWare) {
     this.saleWare = saleWare;
   }
 }

/* 
 
 
 */