 package com.sinokj.app.formcenter.orderform.saledetail;
 
 import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.app.order.sale.saleWare.service.SaleWareService;
import com.sinokj.code.struct.BaseAction;

 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class SaledetailAction extends BaseAction
 {
   private static final Logger logger = Logger.getLogger(SaledetailAction.class);
   private SaleWare saleWare;
   private SaleWareService saleWareService;
 
   public void setSaleWareService(SaleWareService saleWareService)
   {
     this.saleWareService = saleWareService;
   }
 
   public String list()
   {
     return "list_saledetail";
   }
 
   public String listJson()
   {
     logger.info("start list saleware!");
     List resultList = null;
     Double sumOrdernum = Double.valueOf(0.0D);
     Double sumMoney = Double.valueOf(0.0D);
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
       resultList = this.saleWareService.getSaleDetailList(this.saleWare);
       for (int i = 0; i < resultList.size(); i++)
       {
         this.saleWare = ((SaleWare)resultList.get(i));
         if (this.saleWare.getOrderNumber() != null)
         {
           sumOrdernum = Double.valueOf(sumOrdernum.doubleValue() + this.saleWare.getOrderNumber().doubleValue());
         }
         if (this.saleWare.getMoney() != null)
         {
           sumMoney = Double.valueOf(sumMoney.doubleValue() + this.saleWare.getMoney().doubleValue());
         }
       }
 
       for (int j = 0; j < resultList.size(); j++)
       {
         this.saleWare = ((SaleWare)resultList.get(j));
         this.saleWare.setTotalOrderNum(sumOrdernum);
         this.saleWare.setTotalSalesmoney(sumMoney);
       }
     } catch (Exception e) {
       logger.error("error occur when list saleware", e);
     }
     this.jsonMap = new HashMap();
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