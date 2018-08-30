 package com.sinokj.app.front.browse.service;
 
 import com.sinokj.app.front.browse.model.BrowseOthers;
import com.sinokj.app.good.goodType.service.GoodTypeService;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class BrowseOthersService extends BaseService<BrowseOthers>
 {
   private GoodTypeService goodTypeService;
 
   public void setGoodTypeService(GoodTypeService goodTypeService)
   {
     this.goodTypeService = goodTypeService;
   }
 
   public Double getClickNumber(String goodTypeId)
     throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId or childrenId is null");
     }
     Map objParam = new HashMap();
     objParam.put("goodTypeId", goodTypeId);
     Double clickNumber = (Double)this.publicDAO.selectOne("BrowseOthers.BrowseOthers_click_number", objParam);
     return clickNumber;
   }
 
   public List<BrowseOthers> selectClickCount(String goodTypeId)
     throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId or childrenId is null");
     }
     Map objParam = new HashMap();
     objParam.put("goodTypeId", goodTypeId);
     List list = this.publicDAO.select("BrowseOthers.BrowseOthers_lookup", objParam);
 
     return list;
   }
 
   public Double getClickNumberTwo(String goodTypeId) throws Exception
   {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId or childrenId is null");
     }
     Map objParam = new HashMap();
     objParam.put("goodTypeId", goodTypeId);
     Double clickNumber = (Double)this.publicDAO.selectOne("BrowseOthers.BrowseOthers_click_numberTwo", objParam);
     return clickNumber;
   }
 
   public List<BrowseOthers> selectClickCountTwo(String goodTypeId) throws Exception {
     if (StringUtils.isBlank(goodTypeId)) {
       throw new Exception("goodTypeId or childrenId is null");
     }
     Map objParam = new HashMap();
     objParam.put("goodTypeId", goodTypeId);
     List list = this.publicDAO.select("BrowseOthers.BrowseOthers_lookupTwo", objParam);
 
     return list;
   }
 }

/* 
 
 
 */