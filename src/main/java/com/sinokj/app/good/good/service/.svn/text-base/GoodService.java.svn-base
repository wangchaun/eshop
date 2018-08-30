 package com.sinokj.app.good.good.service;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.good.good.model.Good;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.app.warehouse.warehouseInto.action.WarehouseIntoAction;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;
import com.sun.org.apache.bcel.internal.generic.NEW;

 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodService extends BaseService<Good>
 {
   
   private WareService wareService;
   private FileUploadService fileUploadService;
   private static final Logger logger = Logger.getLogger(GoodService.class);
   public void setWareService(WareService wareService)
   {
     this.wareService = wareService;
   }
 
   public void setFileUploadService(FileUploadService fileUploadService) {
     this.fileUploadService = fileUploadService;
   }
   public void insertGood(Good model) throws Exception {
     if (model == null) {
       throw new Exception("Object Good is null,can not insert Goods Information!");
     }
     super.insert(model);
 
     if (StringUtils.isNotBlank(model.getPicId()))
       this.fileUploadService.updateAppId(model.getPicId(), model.getId());
   }
 
   public List<Good> getGoodsByTypeId(String[] typeIdArr)
     throws Exception
   {
     if (typeIdArr == null) {
       throw new Exception("typeIdArr is null!");
     }
     Map param = new HashMap();
     param.put("typeIdArr", typeIdArr);
     List list = this.publicDAO.select("Good.Good_type", param);
     return list;
   }
    
 
   public List<Good> getGoodsByTypeId(String goodTypeId)
     throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId is null!");
     }
     Map param = new HashMap();
     param.put("goodTypeId", goodTypeId);
     List list = this.publicDAO.select("Good.Good", param);
     return list;
   }
   
   public List<Good> list(String[] idArr)
     throws Exception
   {
     if (idArr == null) {
       throw new Exception("object id array is empty, can not query Goods information");
     }
     Map map = new HashMap();
     map.put("idArr", idArr);
     List list = this.publicDAO.select("Good.Good_by_ids", map);
     return list;
   }
 
   public void updateGoodState(String id, String state)throws Exception
   {
     if (id == null) {
       throw new Exception("primary key id is empty, can not query Goods information");
     }
     Good good = (Good)super.getModel(id);
     if (good == null) {
       throw new Exception("good is null");
     }
     good.setState(state);
     if ("s".equals(state)) {
       good.setBeginSaleTime(new Date());
     }
     super.update(good);
   }
 
   public void updateGoodInventoryInfo(String goodId, Double totalCostInventory, Integer purchaseNum)
     throws Exception{
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     //单位成本=存放成本/存放数量
     Double averageCostInventory = Double.valueOf(totalCostInventory.doubleValue() / purchaseNum.intValue());
     Map param = new HashMap();
     param.put("id", goodId);
     param.put("totalCostInventory", totalCostInventory);
     param.put("averageCostInventory", averageCostInventory);
     param.put("purchaseNum", purchaseNum);
     this.publicDAO.update("Good.Good_info", param);
   }
 
   public void updateGoodInventory(String goodId, Integer purchaseNum)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("id", goodId);
     param.put("purchaseNum", purchaseNum);
     this.publicDAO.update("Good.Good_info", param);
   }
 
   public Good getGoodByWareId(String wareId)throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     Ware ware = (Ware)this.wareService.getModel(wareId);
     Good good = null;
     if (ware != null) {
       good = (Good)getModel(ware.getGoodId());
     }
     return good;
   }
 
   public void updatePrice(String goodId, Double price)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("id", goodId);
     param.put("price", price);
     this.publicDAO.update("Good.Good_info", param);
   }
 
   public void updatePurchasePrice(String goodId, Double purchasePrice)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("id", goodId);
     param.put("purchasePrice", purchasePrice);
     this.publicDAO.update("Good.Good_info", param);
   }
 
   public void update(String str, Object param)
     throws Exception
   {
     this.publicDAO.update(str, param);
   }
 
   public List<Good> getGoodsByType(String goodTypeId)
     throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId is null!");
     }
     Map param = new HashMap();
     param.put("goodTypeId", goodTypeId);
     List list = this.publicDAO.select("Good.Good_sales", param);
     return list;
   }
 
   public List<Good> getGoodsByTotalsales()
     throws Exception
   {
     List list = this.publicDAO.select("Good.Good_totalsales", null);
     return list;
   }
 
   public List<Good> getGoodsByParentId(String parentId)
     throws Exception
   {
     if (parentId == null) {
       throw new Exception("parentId is null!");
     }
     Map param = new HashMap();
     param.put("parentId", parentId);
     List list = this.publicDAO.select("Good.Good_goodTypeId", param);
     return list;
   }
 
   public List<Good> getGoodsBydailyNetSalesByParentId(String parentId)
     throws Exception
   {
     if (parentId == null) {
       throw new Exception("parentId is null!");
     }
     Map param = new HashMap();
     param.put("parentId", parentId);
     List list = this.publicDAO.select("Good.Good_goodTypeId_dailyNetSales", param);
     return list;
   }
 
   public List<Good> getGoodsBydailyNetSales(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_dailyNetSales", param);
     return list;
   }
 
   public List<Good> getGoodsBySaleTime(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_SaleTime", param);
     return list;
   }
 
   public List<Good> getGoodsByTag(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_goodTag", param);
     return list;
   }
 
   public List<Good> getGoodsByGoodType(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
 
     List list = this.publicDAO.select("Good.Good_goodType", param);
     return list;
   }
 
   public List<Good> getGoodsByGoodTypeId(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_goodsTypeId", param);
     return list;
   }
 
   public List<Good> getGoodByType(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_goodByType", param);
     return list;
   }
 
   public List<Good> getGoodOrderByTime(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_goodOrderByTime", param);
     return list;
   }
 
   public List<Good> getGoodOrderBySale(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_goodOrderBySale", param);
     return list;
   }
 
   public List<Good> getGoodOrderByTag(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Good.Good_goodOrderByTag", param);
     return list;
   }
 
   public Good getGoodByCode(String code)
     throws Exception
   {
     if (StringUtils.isBlank(code)) {
       throw new Exception("code is null");
     }
     Map param = new HashMap();
     param.put("code", code);
     Good good = (Good)this.publicDAO.selectOne("Good.Good", param);
     return good;
   }
 
   public List<Good> getSaleriseList(Good good)
   {
     List list = this.publicDAO.select("Good.Good_sales", good);
     return list;
   }
 
   public List<Good> getGroupGoodList(Good good)
   {
     List list = this.publicDAO.select("Good.Good_query", good);
     return list;
   }
 
   public List<Good> getGoodpropertyList(String property)
   {
     Map param = new HashMap();
     param.put("property", property);
 
     List list = this.publicDAO.select("Good.Good_Property", param);
     return list;
   }
 
   public List<Good> getSaleGoodList(String saleId)
   {
     Map param = new HashMap();
     param.put("saleId", saleId);
 
     List list = this.publicDAO.select("Good.Good_by_orderid", param);
     return list;
   }
 
   public List<Good> selectHDgood(String inventory)
   {
     return this.publicDAO.select("Good.Good_isInventory", inventory);
   }
 }

/* 
 
 
 */