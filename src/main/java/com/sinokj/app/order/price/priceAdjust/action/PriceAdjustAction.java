 package com.sinokj.app.order.price.priceAdjust.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.order.price.priceAdjust.model.PriceAdjust;
import com.sinokj.app.order.price.priceAdjust.model.PriceAdjustWare;
import com.sinokj.app.order.price.priceAdjust.service.PriceAdjustService;
import com.sinokj.app.order.price.priceAdjust.service.PriceAdjustWareService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class PriceAdjustAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(PriceAdjustAction.class);
   private PriceAdjust priceAdjust;
   private PriceAdjustService priceAdjustService;
   private SerialNumberService serialNumberService;
   private PriceAdjustWareService priceAdjustWareService;
   private GoodService goodService;
   private WareService wareService;
   private String[] wareIdArr;
   private String[] wareNameArr;
   private Double[] priceCurrentArr;
   private Double[] priceAdjustArr;
 
   public void setPriceAdjustService(PriceAdjustService priceAdjustService)
   {
     this.priceAdjustService = priceAdjustService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public void setPriceAdjustWareService(PriceAdjustWareService priceAdjustWareService)
   {
     this.priceAdjustWareService = priceAdjustWareService;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
 
   public String list()
   {
     return "list_priceAdjust";
   }
 
   public String listJson()
   {
     logger.info("start list priceAdjust");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.priceAdjust == null) {
         this.priceAdjust = new PriceAdjust();
       }
       resultList = this.priceAdjustService.pageList(pageInfo, this.priceAdjust, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list priceAdjust", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all priceAdjust");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.priceAdjust == null) {
       this.priceAdjust = new PriceAdjust();
     }
     if (StringUtils.isBlank(this.priceAdjust.getId())) {
       String prefix = "";
       String appType = "";
       if ("0".equals(this.priceAdjust.getType())) {
         prefix = "STJ";
         appType = "priceAdjust0";
       } else if ("1".equals(this.priceAdjust.getType())) {
         prefix = "CTJ";
         appType = "priceAdjust1";
       } else if ("2".equals(this.priceAdjust.getType())) {
         prefix = "BTJ";
         appType = "priceAdjust2";
       }
       try {
         String code = this.serialNumberService.getSerialNumberByDate(prefix, appType);
         this.priceAdjust.setCode(code);
       } catch (Exception e) {
         logger.error("error occur when get code", e);
       }
       initModel(true, this.priceAdjust, loginMan);
       this.priceAdjust.setAdjustState("0");
       this.priceAdjust.setHandlerId(loginMan.getId());
       this.priceAdjust.setHandlerName(loginMan.getName());
       this.priceAdjust.setDeptId(loginMan.getDeptId());
       this.priceAdjust.setDeptName(loginMan.getDeptName());
     } else {
       this.priceAdjust = ((PriceAdjust)this.priceAdjustService.getModel(this.priceAdjust.getId()));
       initModel(false, this.priceAdjust, loginMan);
     }
     return "edit_priceAdjust";
   }
 
   public void save()
   {
     logger.info("start save saleAdjustment");
     if (StringUtils.isBlank(this.priceAdjust.getId())) {
       String id = this.priceAdjustService.makeId();
       this.priceAdjust.setId(id);
       try {
         this.priceAdjustService.insert(this.priceAdjust);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when insert priceAdjust", e);
       }
     } else {
       try {
         this.priceAdjustService.update(this.priceAdjust);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when update priceAdjust", e);
       }
       try {
         this.priceAdjustWareService.deleteByOrderId(this.priceAdjust.getId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when delete priceAdjust ware", e);
       }
     }
 
     if ((this.wareIdArr != null) && (this.wareIdArr.length > 0)) {
       for (int i = 0; i < this.wareIdArr.length; i++) {
         PriceAdjustWare priceAdjustWare = new PriceAdjustWare();
         priceAdjustWare.setWareId(this.wareIdArr[i]);
         priceAdjustWare.setWareName(this.wareNameArr[i]);
         priceAdjustWare.setPriceCurrent(this.priceCurrentArr[i]);
         priceAdjustWare.setPriceAdjust(this.priceAdjustArr[i]);
         priceAdjustWare.setOrderId(this.priceAdjust.getId());
         priceAdjustWare.setSort(Integer.valueOf(i));
         try {
           this.priceAdjustWareService.insert(priceAdjustWare);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert priceAdjustWare", e);
         }
 
         if ("1".equals(this.priceAdjust.getAdjustState())) {
           try {
             if ("2".equals(this.priceAdjust.getType()))
             {
               Good good = this.goodService.getGoodByWareId(this.wareIdArr[i]);
               this.goodService.updatePurchasePrice(good.getId(), this.priceAdjustArr[i]);
             }
             else
             {
               Double priceChange = Double.valueOf(this.priceAdjustArr[i].doubleValue() - this.priceCurrentArr[i].doubleValue());
 
               Ware ware = (Ware)this.wareService.getModel(this.wareIdArr[i]);
               List wareList = this.wareService.getWareByGoodId(ware.getGoodId());
               int size = 0;
               if (wareList != null) {
                 size = wareList.size();
               }
               if (size > 1)
               {
                 Double priceDiscount = ware.getPriceDiscount();
                 priceDiscount = Double.valueOf(priceDiscount.doubleValue() + priceChange.doubleValue());
                 ware.setPriceDiscount(priceDiscount);
                 this.wareService.update(ware);
               } else if (size == 1)
               {
                 Good good = this.goodService.getGoodByWareId(this.wareIdArr[i]);
                 Double price = good.getPrice();
                 price = Double.valueOf(price.doubleValue() + priceChange.doubleValue());
                 this.goodService.updatePrice(good.getId(), price);
               }
             }
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when update good price info", e);
           }
         }
       }
     }
     responseFlag(true);
   }
 
   public void delete()
   {
     if (this.priceAdjust == null) {
       this.priceAdjust = new PriceAdjust();
     }
     if (StringUtils.isNotBlank(this.priceAdjust.getId())) {
       try {
         this.priceAdjustWareService.deleteByOrderId(this.priceAdjust.getId());
       } catch (Exception e) {
         logger.error("error occur when delete priceAdjust ware", e);
       }
       try {
         this.priceAdjustService.delete(this.priceAdjust.getId());
       } catch (Exception e) {
         logger.error("error occur when delete priceAdjust", e);
       }
       responseFlag(true);
     }
   }
 
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
   public String[] getWareNameArr() {
     return this.wareNameArr;
   }
   public Double[] getPriceCurrentArr() {
     return this.priceCurrentArr;
   }
   public Double[] getPriceAdjustArr() {
     return this.priceAdjustArr;
   }
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
   public void setWareNameArr(String[] wareNameArr) {
     this.wareNameArr = wareNameArr;
   }
   public void setPriceCurrentArr(Double[] priceCurrentArr) {
     this.priceCurrentArr = priceCurrentArr;
   }
   public void setPriceAdjustArr(Double[] priceAdjustArr) {
     this.priceAdjustArr = priceAdjustArr;
   }
 
   public PriceAdjust getPriceAdjust() {
     return this.priceAdjust;
   }
 
   public void setPriceAdjust(PriceAdjust priceAdjust) {
     this.priceAdjust = priceAdjust;
   }
 }

/* 
 
 
 */