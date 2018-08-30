 package com.sinokj.app.good.ware.service;
 
 import com.sinokj.app.good.ware.model.Ware;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WareService extends BaseService<Ware>
 {
   private WareSpecificationValService wareSpecificationValService;
 
   public void setWareSpecificationValService(WareSpecificationValService wareSpecificationValService)
   {
     this.wareSpecificationValService = wareSpecificationValService;
   }
 
   public List<Ware> getWareByGoodId(String goodId)
   {
     if (StringUtils.isBlank(goodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("Ware.Ware", param);
     return list;
   }
 
   public List<Ware> getWareByGroupGoodId(String groupgoodId)
   {
     if (StringUtils.isBlank(groupgoodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("groupgoodId", groupgoodId);
     List list = this.publicDAO.select("Ware.Ware", param);
     return list;
   }
 
   public Ware getWareById(String goodId)
   {
     if (StringUtils.isBlank(goodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("Ware.Ware", param);
     if ((list == null) || (list.size() == 0)) {
       return null;
     }
     return (Ware)list.get(0);
   }
 
   public Ware getWareByGroupId(String groupgoodId)
   {
     if (StringUtils.isBlank(groupgoodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("groupgoodId", groupgoodId);
     List list = this.publicDAO.select("Ware.Ware", param);
     if ((list == null) || (list.size() == 0)) {
       return null;
     }
     return (Ware)list.get(0);
   }
 
   public void deleteByGoodId(String goodId)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List<Ware> list = getWareByGoodId(goodId);
 
     for (Ware ware : list) {
       this.wareSpecificationValService.deleteByWareId(ware.getId());
     }
     this.publicDAO.delete("Ware.Ware", param);
   }
 
   public Ware getWareByCode(String goodId, String code)
   {
     if ((StringUtils.isBlank(code)) || (StringUtils.isBlank(goodId))) {
       return null;
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     param.put("code", code);
     List list = this.publicDAO.select("Ware.Ware", param);
     if ((list == null) || (list.size() == 0)) {
       return null;
     }
     return (Ware)list.get(0);
   }
 
   public Ware getWareByCodes(String groupgoodId, String code) {
     if ((StringUtils.isBlank(code)) || (StringUtils.isBlank(groupgoodId))) {
       return null;
     }
     Map param = new HashMap();
     param.put("groupgoodId", groupgoodId);
     param.put("code", code);
     List list = this.publicDAO.select("Ware.Ware", param);
     if ((list == null) || (list.size() == 0)) {
       return null;
     }
     return (Ware)list.get(0);
   }
 
   public void updateWareStock(String wareId, int number)
     throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareId is null");
     }
     Ware ware = (Ware)super.getModel(wareId);
     if (ware != null) {
       number += ware.getStock().intValue();
       ware.setStock(Integer.valueOf(number));
       super.update(ware);
     }
   }
 
   public Double getAverageCostInventory(String id)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("id is null");
     }
     Map param = new HashMap();
     param.put("id", id);
     Double averageCostInventory = (Double)this.publicDAO.selectOne("Ware.Ware_good", param);
     return averageCostInventory;
   }
 
   public List<Ware> getWareSpecificationByGoodId(String goodId)
   {
     if (StringUtils.isBlank(goodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("Ware.Ware_specification", param);
     return list;
   }
 
   public Ware selectWareStock(Ware ware)
     throws Exception
   {
     if (ware == null) {
       throw new Exception("ware is null");
     }
     ware=  (Ware) this.publicDAO.selectOne("Ware.Ware_count_specification", ware);
     return   ware;
   }
 }

/* 
 
 
 */