 package com.sinokj.app.customer.service;
 
 import com.sinokj.app.customer.model.CustomerAddress;
import com.sinokj.code.ibatis.impl.PublicDAO;
import com.sinokj.code.service.BaseService;

 import java.util.HashMap;
 import java.util.Map;
 import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
 
 public class CustomerAddressService extends BaseService<CustomerAddress>
 {
   private static final Logger logger = Logger.getLogger(CustomerService.class);
 
   public CustomerAddress getAdress(String customerId, String isDefault)
     throws Exception
   {
     CustomerAddress address = null;
     if (StringUtils.isBlank(isDefault)) {
       throw new Exception("customer code is empty,can not query customer information");
     }
     Map map = new HashMap();
 
     map.put("isDefault", isDefault);
     map.put("customerId", customerId);
     Object obj = this.publicDAO.selectOne("CustomerAddress.CustomerAddress", map);
     if (obj != null) {
       address = (CustomerAddress)obj;
     }
     return address;
   }
 }