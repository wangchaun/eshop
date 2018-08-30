 package com.sinokj.app.good.goodSpecification.service;
 
 import com.sinokj.app.good.goodSpecification.model.GoodSpecification;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class GoodSpecificationService extends BaseService<GoodSpecification>
 {
   public List<GoodSpecification> getWareSpecification(String wareId)
   {
     if (StringUtils.isBlank(wareId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("wareId", wareId);
     List list = this.publicDAO.select("GoodSpecification.GoodSpecification_ware", param);
     return list;
   }
 }

/* 
 
 
 */