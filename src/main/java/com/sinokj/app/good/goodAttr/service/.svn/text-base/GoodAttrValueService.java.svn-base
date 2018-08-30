 package com.sinokj.app.good.goodAttr.service;
 
 import com.sinokj.app.good.goodAttr.model.GoodAttrValue;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
import java.util.Map;
 
 public class GoodAttrValueService extends BaseService<GoodAttrValue>
 {
   public void deleteByGoodId(String goodId)
   {
     Map map = new HashMap();
     map.put("goodId", goodId);
     this.publicDAO.delete("GoodAttrValue.GoodAttrValue_goodId", map);
   }
 }

/* 
 
 
 */