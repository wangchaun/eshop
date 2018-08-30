 package com.sinokj.app.vip.coupon.action;
 
 import com.sinokj.app.vip.coupon.model.VipCouponWare;
import com.sinokj.app.vip.coupon.service.VipCouponWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class VipCouponWareAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(VipCouponWareAction.class);
   private VipCouponWare vipCouponWare;
   private VipCouponWareService vipCouponWareService;
 
   public VipCouponWare getVipCouponWare()
   {
     return this.vipCouponWare;
   }
   public void setVipCouponWare(VipCouponWare vipCouponWare) {
     this.vipCouponWare = vipCouponWare;
   }
   public void setVipCouponWareService(VipCouponWareService vipCouponWareService) {
     this.vipCouponWareService = vipCouponWareService;
   }
 
   public String listJson()
   {
     logger.info("start list CashItem");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.vipCouponWare == null) {
         this.vipCouponWare = new VipCouponWare();
       }
       resultList = this.vipCouponWareService.pageList(pageInfo, this.vipCouponWare, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list vipCouponWare", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list vipCouponWare");
     return "success";
   }
 }

/* 
 
 
 */