 package com.sinokj.app.warehouse.warehouseMove.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.system.user.model.SysUser;
import com.sinokj.app.warehouse.warehouse.service.WarehouseService;
import com.sinokj.app.warehouse.warehouse.service.WarehouseWareService;
import com.sinokj.app.warehouse.warehouseMove.model.WarehouseMove;
import com.sinokj.app.warehouse.warehouseMove.model.WarehouseMoveWare;
import com.sinokj.app.warehouse.warehouseMove.service.WarehouseMoveService;
import com.sinokj.app.warehouse.warehouseMove.service.WarehouseMoveWareService;
import com.sinokj.app.warehouse.warehousePosition.service.WarehousePositionWareService;
import com.sinokj.code.struct.BaseAction;
import com.sinokj.code.util.PageInfo;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class WarehouseMoveAction extends BaseAction
 {
   private static final long serialVersionUID = -5328157621841061704L;
   private static final Logger logger = Logger.getLogger(WarehouseMoveAction.class);
   private WarehouseMove warehouseMove;
   private WarehouseMoveService warehouseMoveService;
   private WarehouseMoveWareService warehouseMoveWareService;
   private SerialNumberService serialNumberService;
   private WarehouseWareService warehouseWareService;
   private WarehousePositionWareService warehousePositionWareService;
   private WarehouseService warehouseService;
   private int[] moveNumArr;
   private String[] fwarehousePositionIdArr;
   private String[] fwarehousePositionNameArr;
   private String[] swarehousePositionIdArr;
   private String[] swarehousePositionNameArr;
   private String[] wareIdArr;
   private String[] wareNameArr;
   private Double[] priceOutArr;
   private Double[] moneyOutArr;
   private Double[] priceInArr;
   private Double[] moneyInArr;
   private Double[] priceSaleArr;
   private Double[] moneySaleArr;
 
   public void setWarehouseMoveService(WarehouseMoveService warehouseMoveService)
   {
     this.warehouseMoveService = warehouseMoveService;
   }
 
   public void setWarehouseMoveWareService(WarehouseMoveWareService warehouseMoveWareService) {
     this.warehouseMoveWareService = warehouseMoveWareService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService)
   {
     this.serialNumberService = serialNumberService;
   }
 
   public void setWarehouseWareService(WarehouseWareService warehouseWareService) {
     this.warehouseWareService = warehouseWareService;
   }
 
   public void setWarehousePositionWareService(WarehousePositionWareService warehousePositionWareService) {
     this.warehousePositionWareService = warehousePositionWareService;
   }
 
   public void setWarehouseService(WarehouseService warehouseService) {
     this.warehouseService = warehouseService;
   }
 
   public String list()
   {
     return "list_warehouseMove";
   }
 
   public String listJson()
   {
     logger.info("start list warehouseMove!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehouseMove == null) {
         this.warehouseMove = new WarehouseMove();
       }
       resultList = this.warehouseMoveService.pageList(pageInfo, this.warehouseMove, true);
       totalRows = pageInfo.getCount();
     } catch (Exception e) {
       logger.error("error occur when list warehouseMove", e);
     }
     if (resultList == null) {
       resultList = new ArrayList();
     }
     this.jsonMap = new HashMap();
     this.jsonMap.put("total", Integer.valueOf(totalRows));
     this.jsonMap.put("rows", resultList);
     logger.info("finish list all data!");
     return "success";
   }
 
   public String edit()
   {
     SysUser loginMan = getSessionUserInfo();
     if (this.warehouseMove == null) {
       this.warehouseMove = new WarehouseMove();
     }
     if (StringUtils.isBlank(this.warehouseMove.getId())) {
       this.warehouseMove.setState("c");
       initModel(true, this.warehouseMove, loginMan);
       this.warehouseMove.setHandlerId(loginMan.getId());
       this.warehouseMove.setHandlerName(loginMan.getName());
       this.warehouseMove.setDeptId(loginMan.getDeptId());
       this.warehouseMove.setDeptName(loginMan.getDeptName());
       try
       {
         String code = this.serialNumberService.getSerialNumberByDate("SDH", "warehouseMove");
         this.warehouseMove.setCode(code);
       } catch (Exception e) {
         logger.error("error occur when get code", e);
       }
     } else {
       this.warehouseMove = ((WarehouseMove)this.warehouseMoveService.getModel(this.warehouseMove.getId()));
       initModel(false, this.warehouseMove, loginMan);
     }
     return "edit_warehouseMove";
   }
 
   public void save()
   {
     logger.info("start to update Customer information");
     try {
       if (this.warehouseMove == null) {
         this.warehouseMove = new WarehouseMove();
       }
       if (StringUtils.isBlank(this.warehouseMove.getId()))
       {
         String id = this.warehouseMoveService.makeId();
         this.warehouseMove.setId(id);
         this.warehouseMoveService.insert(this.warehouseMove);
       }
       else {
         this.warehouseMoveService.update(this.warehouseMove);
       }
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save warehouseMove information", e);
     }
     try {
       this.warehouseMoveWareService.deleteByWarehouseMoveId(this.warehouseMove.getId());
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when delete warehouseMove warehouseMoveWare", e);
     }
     logger.info("finish to save warehouseMove information");
 
     String warehouseMoveId = this.warehouseMove.getId();
     if ((this.fwarehousePositionIdArr != null) && (this.fwarehousePositionIdArr.length != 0)) {
       for (int i = 0; i < this.fwarehousePositionIdArr.length; i++) {
         WarehouseMoveWare warehouseMoveWare = new WarehouseMoveWare();
         warehouseMoveWare.setWarehouseMoveId(warehouseMoveId);
         warehouseMoveWare.setFwarehousePositionId(this.fwarehousePositionIdArr[i]);
         warehouseMoveWare.setFwarehousePositionName(this.fwarehousePositionNameArr[i]);
         warehouseMoveWare.setSwarehousePositionId(this.swarehousePositionIdArr[i]);
         warehouseMoveWare.setSwarehousePositionName(this.swarehousePositionNameArr[i]);
         warehouseMoveWare.setWareId(this.wareIdArr[i]);
         warehouseMoveWare.setWareName(this.wareNameArr[i]);
         warehouseMoveWare.setMoveNum(Integer.valueOf(this.moveNumArr[i]));
         warehouseMoveWare.setPriceOut(this.priceOutArr[i]);
         warehouseMoveWare.setMoneyOut(this.moneyOutArr[i]);
         warehouseMoveWare.setPriceIn(this.priceInArr[i]);
         warehouseMoveWare.setMoneyIn(this.moneyInArr[i]);
         warehouseMoveWare.setPriceSale(this.priceSaleArr[i]);
         warehouseMoveWare.setMoneySale(this.moneySaleArr[i]);
         warehouseMoveWare.setSort(Integer.valueOf(i));
         try {
           this.warehouseMoveWareService.insert(warehouseMoveWare);
         } catch (Exception e) {
           responseFlag(false);
           logger.error("error occur when insert a warehouseMoveWare", e);
         }
 
         if ("s".equals(this.warehouseMove.getState())) {
           Map param = new HashMap();
           param.put("wareId", this.wareIdArr[i]);
           param.put("wareName", this.wareNameArr[i]);
           try
           {
             param.put("warehouseId", this.warehouseMove.getFwarehouseId());
             param.put("warehouseName", this.warehouseMove.getFwarehouseName());
             param.put("warehousePositionId", this.fwarehousePositionIdArr[i]);
             param.put("warehousePositionName", this.fwarehousePositionNameArr[i]);
 
             this.warehouseWareService.updateInventory(param, 0 - this.moveNumArr[i], Double.valueOf(-1.0D));
 
             this.warehouseService.updateCostInventory(this.warehouseMove.getFwarehouseId(), Double.valueOf(0.0D - this.moneyOutArr[i].doubleValue()));
 
             this.warehousePositionWareService.updateWareNum(param, 0 - this.moveNumArr[i]);
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when update decrease Inventory", e);
           }
           try
           {
             param.put("warehouseId", this.warehouseMove.getSwarehouseId());
             param.put("warehouseName", this.warehouseMove.getSwarehouseName());
             param.put("warehousePositionId", this.swarehousePositionIdArr[i]);
             param.put("warehousePositionName", this.swarehousePositionNameArr[i]);
 
             this.warehouseWareService.updateInventory(param, this.moveNumArr[i], this.priceInArr[i]);
 
             this.warehouseService.updateCostInventory(this.warehouseMove.getSwarehouseId(), this.moneyInArr[i]);
 
             this.warehousePositionWareService.updateWareNum(param, this.moveNumArr[i]);
           } catch (Exception e) {
             responseFlag(false);
             logger.error("error occur when update add Inventory", e);
           }
         }
       }
     }
     responseFlag(true);
   }
 
   public void delete()
   {
     String id = this.warehouseMove.getId();
     try {
       if (StringUtils.isNotBlank(id)) {
         this.warehouseMoveWareService.deleteByWarehouseMoveId(id);
         this.warehouseMoveService.delete(id);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when delete WarehouseMove,id:" + id, e);
     }
   }
 
   public WarehouseMove getWarehouseMove() {
     return this.warehouseMove;
   }
 
   public void setWarehouseMove(WarehouseMove warehouseMove) {
     this.warehouseMove = warehouseMove;
   }
 
   public int[] getMoveNumArr() {
     return this.moveNumArr;
   }
 
   public void setMoveNumArr(int[] moveNumArr) {
     this.moveNumArr = moveNumArr;
   }
 
   public String[] getFwarehousePositionIdArr() {
     return this.fwarehousePositionIdArr;
   }
 
   public void setFwarehousePositionIdArr(String[] fwarehousePositionIdArr) {
     this.fwarehousePositionIdArr = fwarehousePositionIdArr;
   }
 
   public String[] getFwarehousePositionNameArr() {
     return this.fwarehousePositionNameArr;
   }
 
   public void setFwarehousePositionNameArr(String[] fwarehousePositionNameArr) {
     this.fwarehousePositionNameArr = fwarehousePositionNameArr;
   }
 
   public String[] getSwarehousePositionIdArr() {
     return this.swarehousePositionIdArr;
   }
 
   public void setSwarehousePositionIdArr(String[] swarehousePositionIdArr) {
     this.swarehousePositionIdArr = swarehousePositionIdArr;
   }
 
   public String[] getSwarehousePositionNameArr() {
     return this.swarehousePositionNameArr;
   }
 
   public void setSwarehousePositionNameArr(String[] swarehousePositionNameArr) {
     this.swarehousePositionNameArr = swarehousePositionNameArr;
   }
   public String[] getWareIdArr() {
     return this.wareIdArr;
   }
 
   public String[] getWareNameArr() {
     return this.wareNameArr;
   }
 
   public void setWareIdArr(String[] wareIdArr) {
     this.wareIdArr = wareIdArr;
   }
 
   public void setWareNameArr(String[] wareNameArr) {
     this.wareNameArr = wareNameArr;
   }
 
   public Double[] getPriceOutArr() {
     return this.priceOutArr;
   }
 
   public Double[] getMoneyOutArr() {
     return this.moneyOutArr;
   }
 
   public Double[] getPriceInArr() {
     return this.priceInArr;
   }
 
   public Double[] getMoneyInArr() {
     return this.moneyInArr;
   }
 
   public Double[] getPriceSaleArr() {
     return this.priceSaleArr;
   }
 
   public Double[] getMoneySaleArr() {
     return this.moneySaleArr;
   }
 
   public void setPriceOutArr(Double[] priceOutArr) {
     this.priceOutArr = priceOutArr;
   }
 
   public void setMoneyOutArr(Double[] moneyOutArr) {
     this.moneyOutArr = moneyOutArr;
   }
 
   public void setPriceInArr(Double[] priceInArr) {
     this.priceInArr = priceInArr;
   }
 
   public void setMoneyInArr(Double[] moneyInArr) {
     this.moneyInArr = moneyInArr;
   }
 
   public void setPriceSaleArr(Double[] priceSaleArr) {
     this.priceSaleArr = priceSaleArr;
   }
 
   public void setMoneySaleArr(Double[] moneySaleArr) {
     this.moneySaleArr = moneySaleArr;
   }
 }

/* 
 
 
 */