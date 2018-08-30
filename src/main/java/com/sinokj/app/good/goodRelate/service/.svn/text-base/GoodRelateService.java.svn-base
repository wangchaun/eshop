 package com.sinokj.app.good.goodRelate.service;
 
 import com.sinokj.app.good.goodRelate.model.GoodRelate;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class GoodRelateService extends BaseService<GoodRelate>
 {
   public List<GoodRelate> getGoodRelateByGoodId(String goodId)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("GoodRelate.GoodRelate", param);
     return list;
   }
 
   public void deleteByGoodId(String goodId)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null,can not delete");
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     this.publicDAO.delete("GoodRelate.GoodRelate", param);
   }
 }

/* 
 
 
 */