 package com.sinokj.app.warehouse.warehouse.action;
 
 import com.sinokj.app.component.serialNumber.service.SerialNumberService;
import com.sinokj.app.good.ware.model.WareSpecificationVal;
import com.sinokj.app.good.ware.service.WareSpecificationValService;
import com.sinokj.app.system.user.model.SysUser;
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
 
 public class WarehouseWareAction extends BaseAction
 {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = Logger.getLogger(WarehouseWareAction.class);
   private WarehouseWare warehouseWare;
   private WarehouseWareService warehouseWareService;
   private SerialNumberService serialNumberService;
   private WareSpecificationValService wareSpecificationValService;
 
   public void setWarehouseWareService(WarehouseWareService warehouseWareService)
   {
     this.warehouseWareService = warehouseWareService;
   }
 
   public void setSerialNumberService(SerialNumberService serialNumberService)
   {
     this.serialNumberService = serialNumberService;
   }
 
   public String list()
   {
     return "list_warehouseWare";
   }
 
   public String listJson()
   {
     logger.info("start list warehouseWare!");
     List resultList = null;
     int totalRows = 0;
     try {
       PageInfo pageInfo = createPageInfo();
       if (this.warehouseWare == null) {
         this.warehouseWare = new WarehouseWare();
       }
       resultList = this.warehouseWareService.pageList(pageInfo, this.warehouseWare, true);
       totalRows = pageInfo.getCount();
 
       for (int i = 0; i < resultList.size(); i++) {
         List wareSpecificationValList = this.wareSpecificationValService.getByWareId(((WarehouseWare)resultList.get(i)).getWareId());
         String specificationVal = "";
         for (int j = 0; j < wareSpecificationValList.size(); j++) {
           specificationVal = specificationVal + ((WareSpecificationVal)wareSpecificationValList.get(j)).getSpecificationValName();
           if (j + 1 != wareSpecificationValList.size()) {
             specificationVal = specificationVal + ",";
           }
         }
         ((WarehouseWare)resultList.get(i)).setWareSpecificationVal(specificationVal);
       }
     } catch (Exception e) {
       logger.error("error occur when list warehouseWare", e);
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
     if (this.warehouseWare == null) {
       this.warehouseWare = new WarehouseWare();
     }
     if (StringUtils.isBlank(this.warehouseWare.getId())) {
       initModel(true, this.warehouseWare, loginMan);
     } else {
       this.warehouseWare = ((WarehouseWare)this.warehouseWareService.getModel(this.warehouseWare.getId()));
       initModel(false, this.warehouseWare, loginMan);
     }
     return "edit_warehouseWare";
   }
 
   public void save()
   {
     try
     {
       if (StringUtils.isBlank(this.warehouseWare.getId())) {
         String code = this.serialNumberService.getSerialNumberNoDate("", 
           "WarehouseWare", 3);
         this.warehouseWare.setCode(code);
         this.warehouseWareService.insert(this.warehouseWare);
       } else {
         this.warehouseWareService.update(this.warehouseWare);
       }
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.error("error occur when save warehouseWare", e);
     }
   }
 
   public void delete()
   {
     SysUser loginMan = getSessionUserInfo();
 
     String id = this.warehouseWare.getId();
     logger.info("delete WarehouseWare,id:" + id);
     try
     {
       String[] idArr = id.split(",");
       for (String idStr : idArr) {
         this.warehouseWareService.delete(idStr);
       }
       logger.info(loginMan.getCode() + " delete WarehouseWare,id:" + id);
       responseFlag(true);
     } catch (Exception e) {
       responseFlag(false);
       logger.info("error occur when " + loginMan.getCode() + " delete WarehouseWare,id:" + id, e);
     }
   }
 
   public WarehouseWare getWarehouseWare() {
     return this.warehouseWare;
   }
 
   public void setWarehouse(WarehouseWare warehouse) {
     this.warehouseWare = warehouse;
   }
 
   public void setWarehouseWare(WarehouseWare warehouseWare) {
     this.warehouseWare = warehouseWare;
   }
 
   public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService)
   {
     this.wareSpecificationValService = wareSpecificationValService;
   }
 }

/* 
 
 
 */