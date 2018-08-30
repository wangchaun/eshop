 package com.sinokj.app.warehouse.costAdjust.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.costAdjust.model.CostAdjust;
import com.sinokj.app.warehouse.costAdjust.model.CostAdjustWare;
import com.sinokj.app.warehouse.costAdjust.service.CostAdjustService;
import com.sinokj.app.warehouse.costAdjust.service.CostAdjustWareService;
import com.sinokj.app.warehouse.warehouse.service.WarehouseWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class CostAdjustAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(CostAdjustAction.class);
   private CostAdjust costAdjust;
   private CostAdjustService costAdjustService;
   private CostAdjustWareService costAdjustWareService;
   private WarehouseWareService warehouseWareService;
   private SerialNumberService serialNumberService;
   private String[] wareIdArr;
   private String[] wareCodeArr;
   private String[] wareNameArr;
   private Double[] costCurrentArr;
   private Double[] costAdjustArr;
   private int[] stockArr;
   private String[] remarkArr;
 
   public void setCostAdjustService(CostAdjustService costAdjustService)
   {
     this.costAdjustService = costAdjustService;
   }
 
   public void setCostAdjustWareService(CostAdjustWareService costAdjustWareService) {
     this.costAdjustWareService = costAdjustWareService;
   }
 
   public void setWarehouseWareService(WarehouseWareService warehouseWareService) {
     this.warehouseWareService = warehouseWareService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public String list()
   {
     return "list_costAdjust";
   }
 
   public String listJson()
   {
     logger.info("start list costAdjust");
     List resultList = null;
     int totalRows = 0;
     try {
       if (this.costAdjust == null) {
         this.costAdjust = new CostAdjust();
       }
       PageInfo pageInfo = createPageInfo();
       resultList = this.costAdjustService.pageList(pageInfo, this.costAdjust, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list costAdjust", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all costAdjust");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.costAdjust == null) {
       this.costAdjust = new CostAdjust();
     }
     if (StringUtils.isBlank(this.costAdjust.getId())) {
       this.costAdjust.setState("c");
       initModel(true, this.costAdjust, loginMan);
       try {
         String code = this.serialNumberService.getSerialNumberByDate("CTZ", "CostAdjust");
         this.costAdjust.setCode(code);
       } catch (Exception e) {
         logger.error("error occur when get code", e);
       }
     } else {
       this.costAdjust = ((CostAdjust)this.costAdjustService.getModel(this.costAdjust.getId()));
       initModel(false, this.costAdjust, loginMan);
     }
     return "edit_costAdjust";
   }
 
   public void save()
   {
     logger.info("start save costAdjust");
     if (StringUtils.isBlank(this.costAdjust.getId())) {
       String id = this.costAdjustService.makeId();
       this.costAdjust.setId(id);
       try {
         this.costAdjustService.insert(this.costAdjust);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when insert costAdjust", e);
       }
     } else {
       try {
         this.costAdjustService.update(this.costAdjust);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when update costAdjust", e);
       }
     }
     try
     {
       this.costAdjustWareService.deleteByIntoId(this.costAdjust.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete  documentItem", e);
     }
 
     if ((this.wareIdArr != null) && (this.wareIdArr.length > 0)) {
       for (int i = 0; i < this.wareIdArr.length; i++) {
         if (StringUtils.isNotBlank(this.wareIdArr[i])) {
           CostAdjustWare costAdjustWare = new CostAdjustWare();
           costAdjustWare.setOrderId(this.costAdjust.getId());
           costAdjustWare.setWareId(this.wareIdArr[i]);
           costAdjustWare.setWareCode(this.wareCodeArr[i]);
           costAdjustWare.setWareName(this.wareNameArr[i]);
           costAdjustWare.setCostCurrent(this.costCurrentArr[i]);
           costAdjustWare.setCostAdjust(this.costAdjustArr[i]);
           costAdjustWare.setStock(this.stockArr[i]);
           costAdjustWare.setRemark(this.remarkArr[i]);
           costAdjustWare.setSort(Integer.valueOf(i));
           try {
             this.costAdjustWareService.insert(costAdjustWare);
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when insert costAdjustWare", e);
           }
           if ("s".equals(this.costAdjust.getState())) {
             try {
               this.warehouseWareService.updateCost(this.costAdjust.getWarehouseId(), this.wareIdArr[i], this.costAdjustArr[i]);
             } catch (Exception e) {
               responseFlag(false);
               logger.error("error occur when update warehouse ware cost", e);
             }
           }
         }
       }
     }
     responseFlag(true);
   }
 
   public void delete()
   {
     if (this.costAdjust == null)
       this.costAdjust = new CostAdjust();
     try
     {
       this.costAdjustWareService.deleteByIntoId(this.costAdjust.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete costAdjust ware", e);
     }
     try {
       this.costAdjustService.delete(this.costAdjust.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete costAdjust", e);
     }
     responseFlag(true);
   }
 
   public CostAdjust getCostAdjust() {
     return this.costAdjust;
   }
   public void setCostAdjust(CostAdjust costAdjust) {
     this.costAdjust = costAdjust;
   }
 
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
 
   public String[] getWareNameArr() {
     return this.wareNameArr;
   }
 
   public Double[] getCostCurrentArr() {
     return this.costCurrentArr;
   }
 
   public Double[] getCostAdjustArr() {
     return this.costAdjustArr;
   }
 
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
 
   public void setWareNameArr(String[] wareNameArr) {
     this.wareNameArr = wareNameArr;
   }
 
   public void setCostCurrentArr(Double[] costCurrentArr) {
     this.costCurrentArr = costCurrentArr;
   }
 
   public void setCostAdjustArr(Double[] costAdjustArr) {
     this.costAdjustArr = costAdjustArr;
   }
 
   public int[] getStockArr() {
     return this.stockArr;
   }
 
   public void setStockArr(int[] stockArr) {
     this.stockArr = stockArr;
   }
 
   public String[] getRemarkArr() {
     return this.remarkArr;
   }
   public void setRemarkArr(String[] remarkArr) {
     this.remarkArr = remarkArr;
   }
 
   public String[] getWareCodeArr() {
     return this.wareCodeArr;
   }
 
   public void setWareCodeArr(String[] wareCodeArr) {
     this.wareCodeArr = wareCodeArr;
   }
 }

/* 
 
 
 */