 package com.sinokj.app.component.chinaBank.service;
 
 import beartool.MD5;

import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.code.util.ConfigUtil;
import com.sinokj.code.util.NumberUtil;

 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class ChinaBankService
 {
   private static final Logger logger = Logger.getLogger(ChinaBankService.class);
   private static final String BANK_GATEWAY_NEW = "https://pay3.chinabank.com.cn/PayGate";
   public static String return_url = ConfigUtil.getBankReturnUrl();
   private SaleOrderService saleOrderService;
   private SaleOrder saleOrder;
 
   public SaleOrder getSaleOrder()
   {
     return this.saleOrder;
   }
   public void setSaleOrder(SaleOrder saleOrder) {
     this.saleOrder = saleOrder;
   }
   public void setSaleOrderService(SaleOrderService saleOrderService) {
     this.saleOrderService = saleOrderService;
   }
 
   public String buildchinaBanktoForm(String orderId) {
     Map sParaTemp = null;
     SaleOrder saleOrder = (SaleOrder)this.saleOrderService.getModel(orderId);
     sParaTemp = new HashMap();
 
     String key = "quanshetongxingdu202400";
     String v_mid = "22160294";
     String v_url = return_url;
     String v_oid = saleOrder.getCode();
     Double orderMoney = saleOrder.getOrderMoney();
     String v_amount = "0";
     if (orderMoney != null) {
       v_amount = NumberUtil.double2Str(orderMoney);
     }
 
     String v_moneytype = "CNY";
     String v_md5info = "quanshetongxingdu202400";
     String text = v_amount + v_moneytype + v_oid + v_mid + v_url + key;
     MD5 md5 = new MD5();
     v_md5info = md5.getMD5ofStr(text);
 
     sParaTemp.put("v_md5info", v_md5info);
     sParaTemp.put("v_mid", v_mid);
     sParaTemp.put("v_oid", v_oid);
     sParaTemp.put("v_amount", v_amount);
     sParaTemp.put("v_moneytype", v_moneytype);
     sParaTemp.put("v_url", v_url);
 
     List keys = new ArrayList((Collection)sParaTemp.keySet());
     StringBuffer sbHtml = new StringBuffer();
 
     for (int i = 0; i < keys.size(); i++) {
       String name = (String)keys.get(i);
       String value = (String)sParaTemp.get(name);
       sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
     }
     return sbHtml.toString();
   }
 }