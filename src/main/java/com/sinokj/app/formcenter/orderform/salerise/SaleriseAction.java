 package com.sinokj.app.formcenter.orderform.salerise;
 
 import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.code.struct.BaseAction;

 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class SaleriseAction extends BaseAction
 {
   private static final Logger logger = Logger.getLogger(SaleriseAction.class);
   private Good good;
   private GoodService goodService;
 
   public String list()
   {
     return "list_salerise";
   }
 
   public String listJson()
   {
     logger.info("start list good!");
     List resultList = null;
     Double sumpurchaseNum = Double.valueOf(0.0D);
     Double sumtotalSales = Double.valueOf(0.0D);
     try {
       if (this.good == null)
       {
         this.good = new Good();
       }
 
       if (this.good.getBegin() == null)
       {
         Calendar cal = Calendar.getInstance();
         cal.set(5, 1);
         Date firstMonday = cal.getTime();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String dtStr = sdf.format(firstMonday);
         Date createTime = sdf.parse(dtStr);
         this.good.setBegin(createTime);
       }
       resultList = this.goodService.getSaleriseList(this.good);
       for (int i = 0; i < resultList.size(); i++)
       {
         this.good = ((Good)resultList.get(i));
         if (this.good.getPurchaseNum() != null)
         {
           sumpurchaseNum = Double.valueOf(sumpurchaseNum.doubleValue() + this.good.getPurchaseNum().intValue());
         }
         if (this.good.getTotalSales() != null)
         {
           sumtotalSales = Double.valueOf(sumtotalSales.doubleValue() + this.good.getTotalSales().intValue());
         }
       }
       for (int j = 0; j < resultList.size(); j++)
       {
         this.good.setSumpurchaseNum(sumpurchaseNum);
         this.good.setSumtotalSales(sumtotalSales);
       }
     } catch (Exception e) {
       logger.error("error occur when list good", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all good!");
     return "success";
   }
 
   public Good getGood() {
     return this.good;
   }
 
   public void setGood(Good good) {
     this.good = good;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 }