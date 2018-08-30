 package com.sinokj.app.good.ware.action;
 
 import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.model.WareSpecificationVal;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class WareAction extends BaseAction
 {
   private static final long serialVersionUID = 5262527672659603176L;
   private static final Logger logger = Logger.getLogger(WareAction.class);
   private Ware ware;
   private WareService wareService;
   private GoodService goodService;
   private WareSpecificationValService wareSpecificationValService;
 
   public void setWareService(WareService wareService)
   {
     this.wareService = wareService;
   }
 
   public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService) {
     this.wareSpecificationValService = wareSpecificationValService;
   }
 
   public String list()
   {
     return "list_ware";
   }
 
   public String listJson()
   {
     logger.info("start list ware!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.ware == null) {
         this.ware = new Ware();
       }
       resultList = this.wareService.pageList(pageInfo, this.ware, true);
 
       for (int i = 0; i < resultList.size(); i++) {
         this.ware = ((Ware)resultList.get(i));
         List wareSpecificationValList = this.wareSpecificationValService.getByWareId(((Ware)resultList.get(i)).getId());
         String specificationVal = "";
         for (int j = 0; j < wareSpecificationValList.size(); j++) {
           specificationVal = specificationVal + ((WareSpecificationVal)wareSpecificationValList.get(j)).getSpecificationValName();
           if (j + 1 != wareSpecificationValList.size()) {
             specificationVal = specificationVal + ",";
           }
         }
 
         Good good = new Good();
 
         good.setId(this.ware.getGoodId());
         good = (Good)this.goodService.selectOne(good);
         Integer sum = Integer.valueOf(0);
         if (good != null)
         {
           if (good.getPurchaseNum() == null)
           {
             good.setPurchaseNum(Integer.valueOf(0));
           }
           if (good.getInitialNum() == null)
           {
             good.setInitialNum(Double.valueOf(0.0D));
           }
           if (good.getInitialNum() != null)
           {
             String str = good.getInitialNum().toString();
             Integer InitialNum = Integer.valueOf(Integer.parseInt(str.substring(0, str.indexOf("."))));
             sum = Integer.valueOf(InitialNum.intValue() + good.getPurchaseNum().intValue());
           }
         }
         this.ware.setStock(sum);
         ((Ware)resultList.get(i)).setWareSpecificationVal(specificationVal);
 
         ((Ware)resultList.get(i)).setPrice(Double.valueOf(((Ware)resultList.get(i)).getPrice().doubleValue() + ((Ware)resultList.get(i)).getPriceDiscount().doubleValue()));
       }
 
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list ware", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all ware!");
     return "success";
   }
   public Ware getWare() {
     return this.ware;
   }
   public void setWare(Ware ware) {
     this.ware = ware;
   }
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 }

/* 
 
 
 */