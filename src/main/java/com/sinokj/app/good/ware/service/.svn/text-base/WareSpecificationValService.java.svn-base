 package com.sinokj.app.good.ware.service;
 
 import com.sinokj.app.good.ware.model.WareSpecificationVal;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class WareSpecificationValService extends BaseService<WareSpecificationVal>
 {
   public List<WareSpecificationVal> getByWareId(String wareId)
   {
     if (StringUtils.isBlank(wareId)) {
       return null;
     }
     Map param = new HashMap();
     param.put("wareId", wareId);
     List list = this.publicDAO.select("WareSpecificationVal.WareSpecificationVal", param);
     return list;
   }
 
   public WareSpecificationVal getSpecificationVal(String wareId, String goodSpecificationValId)
   {
     Map param = new HashMap();
     param.put("wareId", wareId);
     param.put("goodSpecificationValId", goodSpecificationValId);
     WareSpecificationVal wareSpecificationVal = 
       (WareSpecificationVal)this.publicDAO.selectOne("WareSpecificationVal.WareSpecificationVal_ware", param);
     return wareSpecificationVal;
   }
 
   public void deleteByWareId(String wareId)
     throws Exception
   {
     if (StringUtils.isBlank(wareId)) {
       throw new Exception("wareid is null");
     }
     Map param = new HashMap();
     param.put("wareId", wareId);
     this.publicDAO.delete("WareSpecificationVal.WareSpecificationVal", param);
   }
 }

/* 
 
 
 */