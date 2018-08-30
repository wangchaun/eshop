 package com.sinokj.app.good.groupgood.service;
 
 import com.sinokj.app.component.file.service.FileUploadService;
import com.sinokj.app.good.groupgood.model.Groupgood;
import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.app.good.ware.service.WareService;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class GroupgoodService extends BaseService<Groupgood>
 {
   private WareService wareService;
   private FileUploadService fileUploadService;
 
   public void setWareService(WareService wareService)
   {
     this.wareService = wareService;
   }
 
   public void setFileUploadService(FileUploadService fileUploadService) {
     this.fileUploadService = fileUploadService;
   }
   public void insertGood(Groupgood model) throws Exception {
     if (model == null) {
       throw new Exception("Object Groupgood is null,can not insert Groupgoods Information!");
     }
     super.insert(model);
 
     if (StringUtils.isNotBlank(model.getPicId()))
       this.fileUploadService.updateAppId(model.getPicId(), model.getId());
   }
 
   public List<Groupgood> getGoodsByTypeId(String[] typeIdArr)
     throws Exception
   {
     if (typeIdArr == null) {
       throw new Exception("typeIdArr is null!");
     }
     Map param = new HashMap();
     param.put("typeIdArr", typeIdArr);
     List list = this.publicDAO.select("Groupgood.Groupgood_type", param);
     return list;
   }
 
   public List<Groupgood> getGoodsByTypeId(String goodTypeId)
     throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("groupgoodTypeId is null!");
     }
     Map param = new HashMap();
     param.put("goodTypeId", goodTypeId);
     List list = this.publicDAO.select("Groupgood.Groupgood", param);
     return list;
   }
 
   public List<Groupgood> list(String[] idArr)
     throws Exception
   {
     if (idArr == null) {
       throw new Exception("object id array is empty, can not query Goods information");
     }
     Map map = new HashMap();
     map.put("idArr", idArr);
     List list = this.publicDAO.select("Groupgood.Groupgood_by_ids", map);
     return list;
   }
 
   public void updateGoodState(String id, String state)
     throws Exception
   {
     if (id == null) {
       throw new Exception("primary key id is empty, can not query Groupgoods information");
     }
     Groupgood groupgood = (Groupgood)super.getModel(id);
     if (groupgood == null) {
       throw new Exception("groupgood is null");
     }
     groupgood.setState(state);
     if ("s".equals(state)) {
       groupgood.setBeginSaleTime(new Date());
     }
     super.update(groupgood);
   }
 
   public void updateGoodInventoryInfo(String goodId, Double totalCostInventory, Integer purchaseNum)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     Double averageCostInventory = Double.valueOf(totalCostInventory.doubleValue() / purchaseNum.intValue());
     Map param = new HashMap();
     param.put("id", goodId);
     param.put("totalCostInventory", totalCostInventory);
     param.put("averageCostInventory", averageCostInventory);
     param.put("purchaseNum", purchaseNum);
     this.publicDAO.update("Groupgood.Groupgood_info", param);
   }
 
   public Groupgood getGoodByWareId(String wareId)
     throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     Ware ware = (Ware)this.wareService.getModel(wareId);
     Groupgood groupgood = null;
     if (ware != null) {
       groupgood = (Groupgood)getModel(ware.getGoodId());
     }
     return groupgood;
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
     this.publicDAO.update("Groupgood.Groupgood_info", param);
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
     this.publicDAO.update("Groupgood.Groupgood_info", param);
   }
 
   public List<Groupgood> getGoodsByType(String goodTypeId)
     throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId is null!");
     }
     Map param = new HashMap();
     param.put("goodTypeId", goodTypeId);
     List list = this.publicDAO.select("Groupgood.Groupgood_sales", param);
     return list;
   }
 
   public List<Groupgood> getGoodsByTotalsales()
     throws Exception
   {
     List list = this.publicDAO.select("Groupgood.Groupgood_totalsales", null);
     return list;
   }
 
   public List<Groupgood> getGoodsByParentId(String parentId)
     throws Exception
   {
     if (parentId == null) {
       throw new Exception("parentId is null!");
     }
     Map param = new HashMap();
     param.put("parentId", parentId);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodTypeId", param);
     return list;
   }
 
   public List<Groupgood> getGoodsBydailyNetSalesByParentId(String parentId)
     throws Exception
   {
     if (parentId == null) {
       throw new Exception("parentId is null!");
     }
     Map param = new HashMap();
     param.put("parentId", parentId);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodTypeId_dailyNetSales", param);
     return list;
   }
 
   public List<Groupgood> getGoodsBydailyNetSales(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_dailyNetSales", param);
     return list;
   }
 
   public List<Groupgood> getGoodsBySaleTime(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_SaleTime", param);
     return list;
   }
 
   public List<Groupgood> getGoodsByTag(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodTag", param);
     return list;
   }
 
   public List<Groupgood> getGoodsByGoodType(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
 
     List list = this.publicDAO.select("Groupgood.Groupgood_goodType", param);
     return list;
   }
 
   public List<Groupgood> getGoodsByGoodTypeId(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodsTypeId", param);
     return list;
   }
 
   public List<Groupgood> getGoodByType(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodByType", param);
     return list;
   }
 
   public List<Groupgood> getGoodOrderByTime(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodOrderByTime", param);
     return list;
   }
 
   public List<Groupgood> getGoodOrderBySale(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodOrderBySale", param);
     return list;
   }
 
   public List<Groupgood> getGoodOrderByTag(String id)
     throws Exception
   {
     if (id == null) {
       throw new Exception("id is null!");
     }
     Map param = new HashMap();
     param.put("id", id);
     List list = this.publicDAO.select("Groupgood.Groupgood_goodOrderByTag", param);
     return list;
   }
 
   public Groupgood getGoodByCode(String code)
     throws Exception
   {
     if (StringUtils.isBlank(code)) {
       throw new Exception("code is null");
     }
     Map param = new HashMap();
     param.put("code", code);
     Groupgood groupgood = (Groupgood)this.publicDAO.selectOne("Groupgood.Groupgood", param);
     return groupgood;
   }
 
   public List<Groupgood> getSaleriseList(Groupgood groupgood)
   {
     List list = this.publicDAO.select("Groupgood.Groupgood_sales", groupgood);
     return list;
   }
 
   public List<Groupgood> getGroupGoodList(Groupgood groupgood)
   {
     List list = this.publicDAO.select("Groupgood.Groupgood_query", groupgood);
     return list;
   }
 
   public List<Groupgood> getGoodpropertyList(String property)
   {
     Map param = new HashMap();
     param.put("property", property);
 
     List list = this.publicDAO.select("Groupgood.Groupgood_Property", param);
     return list;
   }
 }

/* 
 
 
 */