 package com.sinokj.app.good.goodExtend.service;
 
 import com.sinokj.app.good.goodExtend.model.GoodExtend;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class GoodExtendService extends BaseService<GoodExtend>
 {
   public GoodExtend getByGoodId(String goodId)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("GoodExtend.GoodExtend", param);
     if ((list == null) || (list.size() == 0)) {
       return null;
     }
     return (GoodExtend)list.get(0);
   }
 
   public GoodExtend getByGroupGoodId(String groupgoodId)
     throws Exception
   {
     if (StringUtils.isBlank(groupgoodId)) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("groupgoodId", groupgoodId);
     List list = this.publicDAO.select("GoodExtend.GoodExtend_groupgood", param);
     if ((list == null) || (list.size() == 0)) {
       return null;
     }
     return (GoodExtend)list.get(0);
   }
 
   public void deleteByGoodId(String goodId)
     throws Exception
   {
     if (StringUtils.isBlank(goodId)) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     this.publicDAO.delete("GoodExtend.GoodExtend", param);
   }
 
   public void updateByGroupGoodId(GoodExtend goodExtend)
     throws Exception
   {
     if (goodExtend == null) {
       throw new Exception("goodExtend is null");
     }
     this.publicDAO.update("GoodExtend.GoodExtend_groupgood", goodExtend);
   }
 }

/* 
 
 
 */