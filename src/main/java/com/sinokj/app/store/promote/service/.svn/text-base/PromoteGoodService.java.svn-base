 package com.sinokj.app.store.promote.service;
 
 import com.sinokj.app.store.promote.model.PromoteGood;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class PromoteGoodService extends BaseService<PromoteGood>
 {
   public void deleteByPromoteId(String intoId)
     throws Exception
   {
     if (StringUtils.isBlank(intoId)) {
       throw new Exception("intoId is null");
     }
     Map param = new HashMap();
     param.put("promoteId", intoId);
     this.publicDAO.delete("PromoteGood.PromoteGood", param);
   }
 
   public List<PromoteGood> getPromoteGoodByPromoteId(String promoteId) throws Exception
   {
     if (StringUtils.isBlank(promoteId)) {
       throw new Exception("promoteId is null");
     }
     Map param = new HashMap();
     param.put("promoteId", promoteId);
     List list = this.publicDAO.select("PromoteGood.PromoteGood_promoteId", param);
     return list;
   }
 }

/* 
 
 
 */