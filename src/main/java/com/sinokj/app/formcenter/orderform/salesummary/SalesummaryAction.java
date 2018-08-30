 package com.sinokj.app.formcenter.orderform.salesummary;
 
 import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.code.struct.BaseAction;

 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class SalesummaryAction extends BaseAction
 {
   private static final Logger logger = Logger.getLogger(SalesummaryAction.class);
   private SaleWare saleWare;
   private SaleWareService saleWareService;
 
   public String list()
   {
     return "list_salesummary";
   }
 
   public String listJson() {
     logger.info("start list saleWare!");
     List resultList = null;
     Double sumSale = Double.valueOf(0.0D);
     Double sumCost = Double.valueOf(0.0D);
     Double sumMargin = Double.valueOf(0.0D);
     Double sumNum = Double.valueOf(0.0D);
     try {
       if (this.saleWare == null) {
         this.saleWare = new SaleWare();
       }
 
       if (this.saleWare.getBegin() == null)
       {
         Calendar cal = Calendar.getInstance();
         cal.set(5, 1);
         Date firstMonday = cal.getTime();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String dtStr = sdf.format(firstMonday);
         Date createTime = sdf.parse(dtStr);
         this.saleWare.setBegin(createTime);
       }
       resultList = this.saleWareService.getSummaryList(this.saleWare);
       for (int j = 0; j < resultList.size(); j++)
       {
         this.saleWare = ((SaleWare)resultList.get(j));
         if ((this.saleWare.getSalesmoney() != null) && (this.saleWare.getGrossSales() != null))
         {
           this.saleWare.setGrossMargin(Double.valueOf(this.saleWare.getGrossSales().doubleValue() / this.saleWare.getSalesmoney().doubleValue() * 100.0D));
         }
         if ((this.saleWare.getTaxRate() != null) && (this.saleWare.getGoodPrice() != null) && (this.saleWare.getOrderNumber() != null))
         {
           this.saleWare.setTaxDueSum(Double.valueOf(this.saleWare.getTaxRate().doubleValue() * this.saleWare.getGoodPrice().doubleValue() * this.saleWare.getOrderNumber().doubleValue()));
         }
 
         if (this.saleWare.getSalesmoney() != null)
         {
           sumSale = Double.valueOf(sumSale.doubleValue() + this.saleWare.getSalesmoney().doubleValue());
         }
 
         if (this.saleWare.getCostmoney() != null)
         {
           sumCost = Double.valueOf(sumCost.doubleValue() + this.saleWare.getCostmoney().doubleValue());
         }
         if (this.saleWare.getGrossSales() != null)
         {
           sumMargin = Double.valueOf(sumMargin.doubleValue() + this.saleWare.getGrossSales().doubleValue());
         }
         if (this.saleWare.getOrderNumber() != null)
         {
           sumNum = Double.valueOf(sumNum.doubleValue() + this.saleWare.getOrderNumber().doubleValue());
         }
 
         if (this.saleWare.getOrderNumber() == null)
         {
           this.saleWare.setOrderNumber(Double.valueOf(0.0D));
         }
         if (this.saleWare.getSalesmoney() == null)
         {
           this.saleWare.setSalesmoney(Double.valueOf(0.0D));
         }
         if (this.saleWare.getCostmoney() == null)
         {
           this.saleWare.setCostmoney(Double.valueOf(0.0D));
         }
       }
 
       for (int i = 0; i < resultList.size(); i++) {
         this.saleWare = ((SaleWare)resultList.get(i));
         this.saleWare.setTotalSalesmoney(sumSale);
         this.saleWare.setTotalCostmoney(sumCost);
         this.saleWare.setTotalGrossSales(sumMargin);
         this.saleWare.setTotalOrderNum(sumNum);
       }
     } catch (Exception e) {
       logger.error("error occur when list saleWare", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all saleWare!");
     return "success";
   }
   public SaleWare getSaleWare() {
     return this.saleWare;
   }
   public void setSaleWare(SaleWare saleWare) {
     this.saleWare = saleWare;
   }
   public void setSaleWareService(SaleWareService saleWareService) {
     this.saleWareService = saleWareService;
   }
 }