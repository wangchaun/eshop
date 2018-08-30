 package com.sinokj.app.order.sale.saleWare.service;
 
 import com.sinokj.app.order.sale.saleWare.model.SaleWare;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.commons.lang3.StringUtils;
 
 public class SaleWareService extends BaseService<SaleWare>
 {
   public void deleteBySaleId(String saleId)
     throws Exception
   {
     if (StringUtils.isBlank(saleId)) {
       throw new Exception("saleId is null");
     }
     Map param = new HashMap();
     param.put("saleId", saleId);
     this.publicDAO.delete("SaleWare.SaleWare", param);
   }
 
   public List<SaleWare> getWareBySaleId(String saleId)
     throws Exception
   {
     if (StringUtils.isBlank(saleId)) {
       throw new Exception("saleId is null");
     }
     Map map = new HashMap();
     map.put("saleId", saleId);
     List list = this.publicDAO.select("SaleWare.SaleWare", map);
     return list;
   }
 
   public List<SaleWare> getSaleDetailList(SaleWare saleware)
   {
     List list = this.publicDAO.select("SaleWare.SaleWare_saledetail", saleware);
     return list;
   }
 
   public List<SaleWare> getSummaryList(SaleWare saleware)
   {
     List list = this.publicDAO.select("SaleWare.SaleWare_summary", saleware);
     return list;
   }
 
   public List<String> getSaleWareByCustomerId(String customerId)
     throws Exception
   {
     if (customerId == null) {
       throw new Exception("customerId is null!");
     }
     Map param = new HashMap();
     param.put("customerId", customerId);
     List list = this.publicDAO.select("SaleWare.SaleWare_customerId", param);
     return list;
   }
 }

/* 
 
 
 */