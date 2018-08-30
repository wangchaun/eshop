 package com.sinokj.app.warehouse.warehouseInto.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.good.service.GoodService;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.warehouse.service.WarehouseService;
import com.sinokj.app.warehouse.warehouse.service.WarehouseWareService;
import com.sinokj.app.warehouse.warehouseInto.model.WarehouseInto;
import com.sinokj.app.warehouse.warehouseInto.model.WarehouseIntoWare;
import com.sinokj.app.warehouse.warehouseInto.service.WarehouseIntoService;
import com.sinokj.app.warehouse.warehouseInto.service.WarehouseIntoWareService;
import com.sinokj.app.warehouse.warehousePosition.service.WarehousePositionWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
 import org.apache.log4j.Logger;
 public class WarehouseIntoAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(WarehouseIntoAction.class);
   private WarehouseInto warehouseInto;
   private WarehouseIntoService warehouseIntoService;
   private WarehouseIntoWareService warehouseIntoWareService;
   private SerialNumberService serialNumberService;
   private WarehouseService warehouseService;
   private WarehouseWareService warehouseWareService;
   private WarehousePositionWareService warehousePositionWareService;
   private GoodService goodService;
   private WareService wareService;
   private String[] wareIdArr;
   private String[] wareNameArr;
   private String[] warehousePositionIdArr;
   private String[] warehousePositionNameArr;
   private Integer[] intoNumArr;
   private Double[] priceInArr;
   private Double[] moneyInArr;
 
   public void setWarehouseIntoService(WarehouseIntoService warehouseIntoService)
   {
     this.warehouseIntoService = warehouseIntoService;
   }
 
   public void setWarehouseIntoWareService(WarehouseIntoWareService warehouseIntoWareService) {
     this.warehouseIntoWareService = warehouseIntoWareService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService) {
     this.serialNumberService = serialNumberService;
   }
 
   public void setWarehouseService(WarehouseService warehouseService) {
     this.warehouseService = warehouseService;
   }
 
   public void setWarehouseWareService(WarehouseWareService warehouseWareService) {
     this.warehouseWareService = warehouseWareService;
   }
 
   public void setWarehousePositionWareService(WarehousePositionWareService warehousePositionWareService)
   {
     this.warehousePositionWareService = warehousePositionWareService;
   }
 
   public void setGoodService(GoodService goodService) {
     this.goodService = goodService;
   }
 
   public void setWareService(WareService wareService) {
     this.wareService = wareService;
   }
 
   public String list()
   {
     return "list_warehouseInto";
   }
 
   public String listJson()
   {
     logger.info("start list warehouseInto");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehouseInto == null) {
         this.warehouseInto = new WarehouseInto();
       }
       resultList = this.warehouseIntoService.pageList(pageInfo, this.warehouseInto, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list warehouseInto", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all warehouseInto");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.warehouseInto == null) {
       this.warehouseInto = new WarehouseInto();
     }
     String type = this.warehouseInto.getType();
     if (StringUtils.isBlank(this.warehouseInto.getId())) {
       if (StringUtils.isBlank(this.warehouseInto.getId())) {
         this.warehouseInto.setState("c");
         initModel(true, this.warehouseInto, loginMan);
         this.warehouseInto.setHandlerId(loginMan.getId());
         this.warehouseInto.setHandlerName(loginMan.getName());
         this.warehouseInto.setDeptId(loginMan.getDeptId());
         this.warehouseInto.setDeptName(loginMan.getDeptName());
         try {
           String prefix = "WRK";
           if ("1".equals(type))
             prefix = "ZRK";
           else if ("2".equals(type)) {
             prefix = "QRK";
           }
           String appType = "WarehouseInto";
           if (StringUtils.isNotBlank(type)) {
             appType = appType + type;
           }
           String code = this.serialNumberService.getSerialNumberByDate(prefix, appType);
           this.warehouseInto.setCode(code);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when get code", e);
         }
       }
       if (StringUtils.isNotBlank(type))
         this.warehouseInto.setType(type);
     }
     else {
       this.warehouseInto = ((WarehouseInto)this.warehouseIntoService.getModel(this.warehouseInto.getId()));
       initModel(false, this.warehouseInto, loginMan);
     }
     return "edit_warehouseInto";
   }
 
   public void save(){
     if (StringUtils.isBlank(this.warehouseInto.getId())) {
       String id = this.warehouseIntoService.makeId();
       this.warehouseInto.setId(id);
       try {
         this.warehouseIntoService.insert(this.warehouseInto);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occcur when insert warehouseInto", e);
       }
     } else {
       try {
         this.warehouseIntoService.update(this.warehouseInto);
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when update warehouseInto", e);
       }
       try {
         this.warehouseIntoWareService.deleteByIntoId(this.warehouseInto.getId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when delete warehoudeIntoWare", e);
       }
     }
 
     if ((this.wareIdArr != null) && (this.wareIdArr.length > 0)) {
       Double changeMoney = Double.valueOf(0.0D);
       for (int i = 0; i < this.wareIdArr.length; i++) {
         if (StringUtils.isNotBlank(this.wareIdArr[i])) {
           WarehouseIntoWare warehouseIntoWare = new WarehouseIntoWare();
           warehouseIntoWare.setWareId(this.wareIdArr[i]);
           warehouseIntoWare.setWareName(this.wareNameArr[i]);
           warehouseIntoWare.setWarehousePositionId(this.warehousePositionIdArr[i]);
           warehouseIntoWare.setWarehousePositionName(this.warehousePositionNameArr[i]);
           warehouseIntoWare.setIntoNum(this.intoNumArr[i].intValue());
           warehouseIntoWare.setPriceIn(this.priceInArr[i]);
           warehouseIntoWare.setMoneyIn(this.moneyInArr[i]);
           warehouseIntoWare.setSort(Integer.valueOf(i));
           warehouseIntoWare.setWarehouseIntoId(this.warehouseInto.getId());
           changeMoney = Double.valueOf(changeMoney.doubleValue() + this.moneyInArr[i].doubleValue());
           try {
             this.warehouseIntoWareService.insert(warehouseIntoWare);
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when insert warehoudeIntoWare", e);
           }
 
           if ("s".equals(this.warehouseInto.getState())) {
             Map param = new HashMap();
             param.put("wareId", this.wareIdArr[i]);
             param.put("wareName", this.wareNameArr[i]);
             param.put("warehouseId", this.warehouseInto.getWarehouseId());
             param.put("warehouseName", this.warehouseInto.getWarehouseName());
             param.put("warehousePositionId", this.warehousePositionIdArr[i]);
             param.put("warehousePositionName", this.warehousePositionNameArr[i]);
 
             if (!"0".equals(this.warehouseInto.getType())){
               try {
                 this.warehouseWareService.updateInventory(param, this.intoNumArr[i].intValue(), this.priceInArr[i]);
               } catch (Exception e) {
                 logger.error("error occur when updateInventory", e);
               }
               /*
               try{
            	 
                 this.warehouseService.updateCostInventory(this.warehouseInto.getWarehouseId(), this.moneyInArr[i]);
               } catch (Exception e) {
                 logger.error("error occur when update warehouse CostInventory", e);
               }*/
               Good good = new Good();
               try {
                 good = this.goodService.getGoodByWareId(this.wareIdArr[i]);
               } catch (Exception e) {
                 responseFlag(false);
                 logger.error("error occur when get good by wareId", e);
               }
 
               int purchaseNum = 0;
               if (good.getPurchaseNum() != null) {
                 purchaseNum = good.getPurchaseNum().intValue();
               }
 
               Double totalCostInventory = Double.valueOf(0.0D);
               if (good.getTotalCostInventory() != null) {
                 totalCostInventory = good.getTotalCostInventory();
               }
               purchaseNum += this.intoNumArr[i].intValue();
               totalCostInventory = Double.valueOf(totalCostInventory.doubleValue() + this.moneyInArr[i].doubleValue());
               try {
                 this.goodService.updateGoodInventoryInfo(good.getId(), totalCostInventory, Integer.valueOf(purchaseNum));
               } catch (Exception e) {
                 logger.error("error occur when update good inventory infomation", e);
               }
               try{
                 this.wareService.updateWareStock(this.wareIdArr[i], this.intoNumArr[i].intValue());
               } catch (Exception e) {
                 logger.error("error occur when update ware stock", e);
               }
             }
             try
             {
               this.warehousePositionWareService.updateWareNum(param, this.intoNumArr[i].intValue());
             } catch (Exception e) {
               responseFlag(false);
               logger.error("error occur when updateWareNum", e);
             }
           }
         }
       }
 
       if ((!"0".equals(this.warehouseInto.getType())) && ("s".equals(this.warehouseInto.getState()))) {
         try {
           this.warehouseService.updateCostInventory(this.warehouseInto.getWarehouseId(), changeMoney);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when update warehouse costInventory", e);
         }
       }
     }
     responseFlag(true);
   }
 
   public void delete()
   {
     if ((this.warehouseInto != null) && (StringUtils.isNotBlank(this.warehouseInto.getId()))) {
       try {
         this.warehouseIntoWareService.deleteByIntoId(this.warehouseInto.getId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when delete warenhouseInto ware", e);
       }
       try {
         this.warehouseIntoService.delete(this.warehouseInto.getId());
       } catch (Exception e) {
         responseFlag(false);
         logger.error("error occur when delete warenhouseInto", e);
       }
     }
     responseFlag(true);
   }
 
   public WarehouseInto getWarehouseInto()
   {
     return this.warehouseInto;
   }
 
   public void setWarehouseInto(WarehouseInto warehouseInto) {
     this.warehouseInto = warehouseInto;
   }
 
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
 
   public String[] getWareNameArr() {
     return this.wareNameArr;
   }
 
   public Integer[] getIntoNumArr() {
     return this.intoNumArr;
   }
 
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
 
   public void setWareNameArr(String[] wareNameArr) {
     this.wareNameArr = wareNameArr;
   }
 
   public void setIntoNumArr(Integer[] intoNumArr) {
     this.intoNumArr = intoNumArr;
   }
 
   public String[] getWarehousePositionIdArr() {
     return this.warehousePositionIdArr;
   }
 
   public void setWarehousePositionIdArr(String[] warehousePositionIdArr) {
     this.warehousePositionIdArr = warehousePositionIdArr;
   }
 
   public String[] getWarehousePositionNameArr() {
     return this.warehousePositionNameArr;
   }
 
   public void setWarehousePositionNameArr(String[] warehousePositionNameArr) {
     this.warehousePositionNameArr = warehousePositionNameArr;
   }
 
   public Double[] getPriceInArr() {
     return this.priceInArr;
   }
 
   public Double[] getMoneyInArr() {
     return this.moneyInArr;
   }
 
   public void setPriceInArr(Double[] priceInArr) {
     this.priceInArr = priceInArr;
   }
 
   public void setMoneyInArr(Double[] moneyInArr) {
     this.moneyInArr = moneyInArr;
   }
 }

/* 
 
 
 */