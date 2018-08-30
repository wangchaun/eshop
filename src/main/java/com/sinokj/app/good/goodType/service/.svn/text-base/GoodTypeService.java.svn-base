 package com.sinokj.app.good.goodType.service;
 
 import com.sinokj.app.good.goodType.model.GoodType;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class GoodTypeService extends BaseService<GoodType>
 {
   private static final Logger logger = Logger.getLogger(GoodTypeService.class);
 
   public List<GoodType> pageList1(Object objParam) { List result = null;
     result = this.publicDAO.select("GoodType.GoodType_query_select1", objParam);
     return result; }
 
   public List<GoodType> pageList2(Object objParam)
   {
     List result = null;
     result = this.publicDAO.select("GoodType.GoodType_query_select2", objParam);
     return result;
   }
 
   public List<GoodType> pageList3(Object objParam) {
     List result = null;
     result = this.publicDAO.select("GoodType.GoodType_query_select3", objParam);
     return result;
   }
 
   public List<GoodType> getAllGoodType(String typeId)
   {
     List typeList = null;
     if (StringUtils.isNotBlank(typeId)) {
       GoodType type = (GoodType)getModel(typeId);
       typeList = new ArrayList();
       if (type != null) {
         typeList.add(type);
         getChildren(typeList, typeId);
       }
     }
     return typeList;
   }
 
   public void getChildren(List<GoodType> typeList, String typeId)
   {
     if (StringUtils.isNotBlank(typeId)) {
       Map map = new HashMap();
       map.put("parentId", typeId);
       List list = super.select(map);
       if ((list != null) && (!list.isEmpty())) {
         typeList.addAll(list);
         for (int i = 0; i < list.size(); i++) {
           GoodType gt = (GoodType)list.get(i);
           getChildren(typeList, gt.getId());
         }
       }
     }
   }
 
   public List<GoodType> getParentList(String parentId)
   {
     List list = null;
     if (StringUtils.isNotBlank(parentId)) {
       list = new ArrayList();
       getParent(list, parentId);
     }
     return list;
   }
 
   public void getParent(List<GoodType> goodsTypeList, String parentId)
   {
     if (StringUtils.isNotBlank(parentId)) {
       Map map = new HashMap();
       map.put("id", parentId);
       List list = super.select(map);
       if ((list != null) && (!list.isEmpty())) {
         goodsTypeList.addAll(list);
         for (int i = 0; i < list.size(); i++) {
           GoodType gt = (GoodType)list.get(i);
           getParent(goodsTypeList, gt.getParentId());
         }
       }
     }
   }
 
   public void delete(GoodType goodsType)
     throws Exception
   {
     if ((StringUtils.isBlank(goodsType.getId())) || (goodsType == null)) {
       throw new Exception("the primary key is null,can not delete");
     }
     List list = getAllGoodType(goodsType.getId());
     if ((list != null) && (!list.isEmpty()))
       for (int i = 0; i < list.size(); i++)
         super.delete(((GoodType)list.get(i)).getId());
   }
 
   public Integer count()
   {
     Integer num = (Integer)this.publicDAO.selectOne("GoodType.GoodType_count", null);
     if ((num == null) || (num.intValue() < 0)) {
       num = Integer.valueOf(0);
     }
     return Integer.valueOf(num.intValue() + 1);
   }
 
   public GoodType getSecondLevelType(String id)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("the primary key is null!");
     }
     GoodType goodType = null;
     Map map = new HashMap();
     map.put("id", id);
     Object obj = this.publicDAO.selectOne("GoodType.GoodType_second_level", map);
     if (obj != null) {
       goodType = (GoodType)obj;
     }
     return goodType;
   }
 
   public GoodType getByCode(String code)
     throws Exception
   {
     if (StringUtils.isBlank(code)) {
       throw new Exception("code is null!");
     }
     Map map = new HashMap();
     map.put("code", code);
     GoodType goodType = (GoodType)this.publicDAO.selectOne("GoodType.GoodType", map);
     return goodType;
   }
 
   public List<GoodType> queryTypeTree(GoodType goodType)
   {
     List result = null;
     if (goodType == null) {
       logger.warn("goodType is null!");
       return result;
     }
     Integer level = goodType.getLevel();
     if (level == null) {
       logger.warn("level is null!");
       return result;
     }
     
     
     result = this.publicDAO.select(this.sqlIdPrefix, goodType);
 
     if ((result != null) && (!result.isEmpty())) {
       getChildren(result);
     }
     return result;
   }
 
   public void getChildren(List<GoodType> listGoodType)
   {
     if ((listGoodType != null) && (!listGoodType.isEmpty()))
       for (GoodType goodType : listGoodType)
         if (goodType != null) {
           String parentId = goodType.getId();
           Integer level = Integer.valueOf(goodType.getLevel().intValue() + 1);
 
           Map objParam = new HashMap();
           objParam.put("parentId", parentId);
           objParam.put("level", level);
 
           List children = super.select(objParam);
           if ((children != null) && (!children.isEmpty())) {
             goodType.setChildren(children);
             getChildren(children);
           }
         }
   }
 
   public GoodType getLevelType(String parentId)
     throws Exception
   {
     if (StringUtils.isBlank(parentId)) {
       throw new Exception("the parentId  is null!");
     }
     GoodType goodType = null;
     Map map = new HashMap();
     map.put("id", parentId);
     Object obj = this.publicDAO.selectOne("GoodType.GoodType", map);
     if (obj != null) {
       goodType = (GoodType)obj;
     }
     return goodType;
   }
 
   public List<GoodType> getparentIdGoodType(String parentId)
     throws Exception
   {
     if (StringUtils.isBlank(parentId)) {
       throw new Exception("the parentId  is null!");
     }
     Map map = new HashMap();
     map.put("parentId", parentId);
     List list = this.publicDAO.select("GoodType.GoodType", map);
 
     return list;
   }
 
   public GoodType getLevelTypeNo(String id)
     throws Exception
   {
     if (StringUtils.isBlank(id)) {
       throw new Exception("the id  is null!");
     }
     List list = null;
     GoodType goodType = (GoodType)getModel(id);
     if (goodType != null) {
       list = this.publicDAO.select("GoodType.GoodType_level", goodType);
     }
 
     return (GoodType)list.get(0);
   }
 
   public List<GoodType> getGoodTypeByParentId(String parentId)
     throws Exception
   {
     if (StringUtils.isBlank(parentId)) {
       throw new Exception("the parentId  is null!");
     }
     Map map = new HashMap();
     map.put("id", parentId);
     List list = this.publicDAO.select("GoodType.GoodType", map);
     return list;
   }
 
   public List<GoodType> getGoodTypeListAd()
     throws Exception
   {
     return this.publicDAO.select("GoodType.GoodType_adver", null);
   }
 
   public List<GoodType> selectDelAndPays(GoodType goodType)
     throws Exception
   {
     if (goodType == null) {
       throw new Exception("the goodType  is null!");
     }
     return this.publicDAO.select("GoodType.GoodType_jiesuan", goodType);
   }
 }

/* 
 
 
 */