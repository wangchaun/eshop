 package com.sinokj.app.front.browse.service;
 
 import com.sinokj.app.front.browse.model.BrowseBuy;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class BrowseBuyService extends BaseService<BrowseBuy>
 {
   public List<BrowseBuy> getAllBuy(String goodTypeId)
     throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId or parentId is null");
     }
     Map param = new HashMap();
     param.put("goodTypeId", goodTypeId);
     List list = this.publicDAO.select("BrowseBuy.BrowseBuy_allbuy", param);
     return list;
   }
 
   public List<BrowseBuy> getBuyByGoodId(BrowseBuy browseBuy)
     throws Exception
   {
     if (browseBuy == null) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("goodId", browseBuy.getGoodId());
     param.put("customerIdStr", browseBuy.getCustomerIdStr());
     List list = this.publicDAO.select("BrowseBuy.BrowseBuy", param);
     return list;
   }
 
   public List<BrowseBuy> getAllBuyByGoodId(String goodId)
     throws Exception
   {
     if (goodId == null) {
       throw new Exception("goodId is null");
     }
     Map param = new HashMap();
     param.put("goodId", goodId);
     List list = this.publicDAO.select("BrowseBuy.BrowseBuy_goodId", param);
     return list;
   }
 }