 package com.sinokj.app.good.goodCompose.service;
 
 import com.sinokj.app.good.goodCompose.model.GoodCompose;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class GoodComposeService extends BaseService<GoodCompose>
 {
   public List<GoodCompose> getGoodComposeByGoodId(String goodId)
   {
     if (StringUtils.isBlank(goodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("GoodCompose.GoodCompose", param);
     return list;
   }
 
   public List<GoodCompose> getGoodComposeOfGoodId(String goodId)
   {
     if (StringUtils.isBlank(goodId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("GoodCompose.GoodCompose_goodId", param);
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
     this.publicDAO.delete("GoodCompose.GoodCompose", param);
   }
 }

/* 
 
 
 */