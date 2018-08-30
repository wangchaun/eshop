 package com.sinokj.app.store.gift.service;
 
 import com.sinokj.app.store.gift.model.GiftGood;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class GiftGoodService extends BaseService<GiftGood>
 {
   public void deleteByPromoteId(String intoId)
     throws Exception
   {
     if (StringUtils.isBlank(intoId)) {
       throw new Exception("intoId is null");
     }
     Map param = new HashMap();
     param.put("promoteId", intoId);
     this.publicDAO.delete("GiftGood.GiftGood", param);
   }
 }

/* 
 
 
 */