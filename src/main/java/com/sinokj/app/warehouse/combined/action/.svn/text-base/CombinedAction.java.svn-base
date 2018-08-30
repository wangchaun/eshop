 package com.sinokj.app.warehouse.combined.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.combined.model.Combined;
import com.sinokj.app.warehouse.combined.model.CombinedWare;
import com.sinokj.app.warehouse.combined.service.CombinedService;
import com.sinokj.app.warehouse.combined.service.CombinedWareService;
import com.sinokj.app.warehouse.warehouse.model.WarehouseWare;
import com.sinokj.app.warehouse.warehouse.service.WarehouseWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class CombinedAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(CombinedAction.class);
   private Combined combined;
   private CombinedService combinedService;
   private CombinedWareService combinedWareService;
   private SerialNumberService serialNumberService;
   private WarehouseWareService warehouseWareService;
   private GoodService goodService;
   private String[] wareIdArr;
   private String[] wareNameArr;
   private Integer[] wareCountArr;
 
   public void setCombinedService(CombinedService combinedService)
   {
     this.combinedService = combinedService;
   }
 
   public void setCombinedWareService(CombinedWareService combinedWareService) {
     this.combinedWareService = combinedWareService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public void setWarehouseWareService(WarehouseWareService warehouseWareService) {
     this.warehouseWareService = warehouseWareService;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public String list()
   {
     return "list_combined";
   }
 
   public String listJson()
   {
     logger.info("start list combined");
     List resultList = null;
     int totalRows = 0;
     try {
       if (this.combined == null) {
         this.combined = new Combined();
       }
       PageInfo pageInfo = createPageInfo();
       resultList = this.combinedService.pageList(pageInfo, this.combined, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list combined", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all combined!");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.combined == null) {
       this.combined = new Combined();
     }
     if (StringUtils.isBlank(this.combined.getId())) {
       this.combined.setState("c");
       initModel(true, this.combined, loginMan);
       String prefix = "";
       String appType = "";
 
       if ("0".equals(this.combined.getType()))
       {
         prefix = "ZH";
         appType = "Combined";
       } else if ("1".equals(this.combined.getType()))
       {
         prefix = "CF";
         appType = "Split";
       }
       try {
         String code = this.serialNumberService.getSerialNumberByDate(prefix, appType);
         this.combined.setCode(code);
       } catch (Exception e) {
         logger.error("error occur when get code", e);
       }
     } else {
       this.combined = ((Combined)this.combinedService.getModel(this.combined.getId()));
       initModel(false, this.combined, loginMan);
     }
     return "edit_combined";
   }
 
   public void save()
   {
     if (StringUtils.isBlank(this.combined.getId())) {
       String id = this.combinedService.makeId();
       this.combined.setId(id);
       try {
         this.combinedService.insert(this.combined);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when insert combined", e);
       }
     } else {
       try {
         this.combinedService.update(this.combined);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when update combined", e);
       }
       try
       {
         this.combinedWareService.deleteByOrderId(this.combined.getId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when delete combinedWare", e);
       }
     }
 
     int wareCount = this.combined.getWareCount();
     Map param = new HashMap();
     param.put("warehouseId", this.combined.getWarehouseId());
     param.put("warehouseName", this.combined.getWarehouseName());
     Good good = new Good();
     WarehouseWare warehouseWare = new WarehouseWare();
 
     if ((this.wareIdArr != null) && (this.wareIdArr.length > 0)) {
       for (int i = 0; i < this.wareIdArr.length; i++) {
         CombinedWare combinedWare = new CombinedWare();
         combinedWare.setWareId(this.wareIdArr[i]);
         combinedWare.setWareName(this.wareNameArr[i]);
         combinedWare.setWareCount(this.wareCountArr[i].intValue());
         combinedWare.setOrderId(this.combined.getId());
         combinedWare.setSort(Integer.valueOf(i));
         try {
           this.combinedWareService.insert(combinedWare);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert combinedWare", e);
         }
 
         if ("s".equals(this.combined.getState())) {
           param.put("wareId", this.wareIdArr[i]);
           param.put("wareName", this.wareNameArr[i]);
           try
           {
             warehouseWare = this.warehouseWareService.getWarehouseWareByWareId(this.wareIdArr[i], this.combined.getWarehouseId());
             good = this.goodService.getGoodByWareId(this.wareIdArr[i]);
 
             int purchaseNum = 0;
             if (good.getPurchaseNum() != null) {
               purchaseNum = good.getPurchaseNum().intValue();
             }
 
             double totalCostInventory = 0.0D;
             if (good.getTotalCostInventory() != null) {
               totalCostInventory = good.getTotalCostInventory().doubleValue();
             }
             double averageCostInventory = 0.0D;
 
             if (warehouseWare.getAverageCostInventory() != null) {
               averageCostInventory = warehouseWare.getAverageCostInventory().doubleValue();
             }
             if ("0".equals(this.combined.getType()))
             {
               this.warehouseWareService.updateInventory(param, 0 - wareCount * this.wareCountArr[i].intValue(), Double.valueOf(-1.0D));
 
               purchaseNum -= wareCount * this.wareCountArr[i].intValue();
 
               totalCostInventory -= averageCostInventory * wareCount * this.wareCountArr[i].intValue();
             } else if ("1".equals(this.combined.getType()))
             {
               this.warehouseWareService.updateInventory(param, wareCount * this.wareCountArr[i].intValue(), Double.valueOf(-1.0D));
 
               purchaseNum += wareCount * this.wareCountArr[i].intValue();
 
               totalCostInventory += averageCostInventory * wareCount * this.wareCountArr[i].intValue();
             }
             this.goodService.updateGoodInventoryInfo(good.getId(), Double.valueOf(totalCostInventory), Integer.valueOf(purchaseNum));
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when update inventory", e);
           }
         }
       }
     }
 
     if ("s".equals(this.combined.getState())) {
       param.put("warehouseId", this.combined.getWarehouseId());
       param.put("warehouseName", this.combined.getWarehouseName());
       param.put("wareId", this.combined.getWareId());
       param.put("wareName", this.combined.getWareName());
       try
       {
         good = this.goodService.getGoodByWareId(this.combined.getWareId());
         warehouseWare = this.warehouseWareService.getWarehouseWareByWareId(this.combined.getWareId(), this.combined.getWarehouseId());
 
         int purchaseNum = 0;
         if (good.getPurchaseNum() != null) {
           purchaseNum = good.getPurchaseNum().intValue();
         }
 
         double totalCostInventory = 0.0D;
         if (good.getTotalCostInventory() != null) {
           totalCostInventory = good.getTotalCostInventory().doubleValue();
         }
         double averageCostInventory = 0.0D;
 
         if (warehouseWare.getAverageCostInventory() != null) {
           averageCostInventory = warehouseWare.getAverageCostInventory().doubleValue();
         }
         if ("0".equals(this.combined.getType()))
         {
           this.warehouseWareService.updateInventory(param, wareCount, Double.valueOf(-1.0D));
 
           purchaseNum += wareCount;
           totalCostInventory += averageCostInventory * wareCount;
         } else if ("1".equals(this.combined.getType()))
         {
           this.warehouseWareService.updateInventory(param, 0 - wareCount, Double.valueOf(-1.0D));
 
           purchaseNum -= wareCount;
           totalCostInventory -= averageCostInventory * wareCount;
         }
         this.goodService.updateGoodInventoryInfo(good.getId(), Double.valueOf(totalCostInventory), Integer.valueOf(purchaseNum));
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when update inventory", e);
       }
     }
     responseFlag(true);
   }
 
   public Combined getCombined() {
     return this.combined;
   }
   public void setCombined(Combined combined) {
     this.combined = combined;
   }
 
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
 
   public String[] getWareNameArr() {
     return this.wareNameArr;
   }
 
   public Integer[] getWareCountArr() {
     return this.wareCountArr;
   }
 
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
 
   public void setWareNameArr(String[] wareNameArr) {
     this.wareNameArr = wareNameArr;
   }
 
   public void setWareCountArr(Integer[] wareCountArr) {
     this.wareCountArr = wareCountArr;
   }
 }

/* 
 
 
 */