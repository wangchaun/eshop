 package com.sinokj.app.component.alipay.service;
 
 import com.alipay.config.AlipayConfig;
 import com.alipay.util.AlipayCore;
 import com.alipay.util.AlipayMd5Encrypt;
import com.sinokj.app.order.sale.saleOrder.model.SaleOrder;
import com.sinokj.app.order.sale.saleOrder.service.SaleOrderService;
import com.sinokj.code.util.NumberUtil;

 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
import org.apache.log4j.Logger;
 
 public class ZfbService
 {
   private static final Logger logger = Logger.getLogger(ZfbService.class);
   private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
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
   
   /**建立支付宝平台*/
   public String buildPayForm(String orderId) {
     Map<String, String> sParaTemp = null;
     SaleOrder saleOrder = (SaleOrder)this.saleOrderService.getModel(orderId);
     sParaTemp = new HashMap();
 
     String out_trade_no = saleOrder.getCode();
 
     String subject = out_trade_no;
 
     String body = subject;
 
     Double orderMoney = saleOrder.getOrderMoney();
     String price = "0";
     if (orderMoney != null) {
       price = NumberUtil.double2Str(orderMoney);
     }
 
     String paymethod = "";
 
     String defaultbank = "";
     String receive_name = saleOrder.getLinkman();
     String receive_address = saleOrder.getAddress();
     String receive_zip = saleOrder.getZipCode();
     String receive_phone = saleOrder.getTelephone();
     String receive_mobile = saleOrder.getMobile();
 
     String anti_phishing_key = "";
 
     String exter_invoke_ip = "";
 
     String extra_common_param = "";
 
     String buyer_email = "";
 
     String show_url = "http://www.sinokj.com";
 
     String royalty_type = "";
 
     String royalty_parameters = "";
 
     sParaTemp.put("payment_type", "1");
     sParaTemp.put("out_trade_no", out_trade_no);
     sParaTemp.put("subject", subject);
     sParaTemp.put("body", body);
     sParaTemp.put("total_fee", price);
     sParaTemp.put("show_url", show_url);
     sParaTemp.put("paymethod", paymethod);
     sParaTemp.put("defaultbank", defaultbank);
     sParaTemp.put("anti_phishing_key", anti_phishing_key);
     sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
     sParaTemp.put("extra_common_param", extra_common_param);
     sParaTemp.put("buyer_email", buyer_email);
     sParaTemp.put("royalty_type", royalty_type);
     sParaTemp.put("royalty_parameters", royalty_parameters);
     sParaTemp.put("receive_name", receive_name);
     sParaTemp.put("receive_address", receive_address);
     sParaTemp.put("receive_zip", receive_zip);
     sParaTemp.put("receive_phone", receive_phone);
     sParaTemp.put("receive_mobile", receive_mobile);
 
     sParaTemp.put("service", "create_direct_pay_by_user");
     sParaTemp.put("partner", AlipayConfig.partner);
     sParaTemp.put("return_url", AlipayConfig.return_url);
     sParaTemp.put("notify_url", AlipayConfig.notify_url);
     sParaTemp.put("seller_email", AlipayConfig.seller_email);
     sParaTemp.put("_input_charset", AlipayConfig.input_charset);
 
     return buildPayForm(sParaTemp, "https://mapi.alipay.com/gateway.do?", "get");
   }
   /*建立银行支付平台*/
   public String buildPayForm2(String orderId, String bankCode)
   {
     Map<String, String> sParaTemp = null;
     SaleOrder saleOrder = (SaleOrder)this.saleOrderService.getModel(orderId);
     sParaTemp = new HashMap();
 
     String out_trade_no = saleOrder.getCode();
 
     String subject = out_trade_no;
 
     String body = subject;
 
     Double orderMoney = saleOrder.getOrderMoney();
     String price = "0";
     if (orderMoney != null) {
       price = NumberUtil.double2Str(orderMoney);
     }
 
     String paymethod = "bankPay";
 
     String defaultbank = bankCode;
     String receive_name = saleOrder.getLinkman();
     String receive_address = saleOrder.getAddress();
     String receive_zip = saleOrder.getZipCode();
     String receive_phone = saleOrder.getTelephone();
     String receive_mobile = saleOrder.getMobile();
 
     String anti_phishing_key = "";
 
     String exter_invoke_ip = "";
 
     String extra_common_param = "";
 
     String buyer_email = "";
 
     String show_url = "http://www.sinokj.com";
 
     String royalty_type = "";
 
     String royalty_parameters = "";
 
     String default_login = "Y";
 
     sParaTemp.put("payment_type", "1");
     sParaTemp.put("out_trade_no", out_trade_no);
     sParaTemp.put("subject", subject);
     sParaTemp.put("body", body);
     sParaTemp.put("total_fee", price);
     sParaTemp.put("show_url", show_url);
     sParaTemp.put("paymethod", paymethod);
     sParaTemp.put("defaultbank", defaultbank);
     sParaTemp.put("anti_phishing_key", anti_phishing_key);
     sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
     sParaTemp.put("extra_common_param", extra_common_param);
     sParaTemp.put("buyer_email", buyer_email);
     sParaTemp.put("royalty_type", royalty_type);
     sParaTemp.put("royalty_parameters", royalty_parameters);
     sParaTemp.put("receive_name", receive_name);
     sParaTemp.put("receive_address", receive_address);
     sParaTemp.put("receive_zip", receive_zip);
     sParaTemp.put("receive_phone", receive_phone);
     sParaTemp.put("receive_mobile", receive_mobile);
     sParaTemp.put("default_login", default_login);
 
     sParaTemp.put("service", "create_direct_pay_by_user");
     sParaTemp.put("partner", AlipayConfig.partner);
     sParaTemp.put("return_url", AlipayConfig.return_url);
     sParaTemp.put("notify_url", AlipayConfig.notify_url);
     sParaTemp.put("seller_email", AlipayConfig.seller_email);
     sParaTemp.put("_input_charset", AlipayConfig.input_charset);
 
     return buildPayForm(sParaTemp, "https://mapi.alipay.com/gateway.do?", "get");
   }
 
   public static String buildPayForm(Map<String, String> sParaTemp, String gateway, String strMethod)
   {
     Map sPara = buildRequestPara(sParaTemp);
     List keys = new ArrayList((Collection)sPara.keySet());
 
     StringBuffer sbHtml = new StringBuffer();
 
     sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway + 
       "_input_charset=" + AlipayConfig.input_charset + "\" method=\"" + strMethod + 
       "\">");
 
     for (int i = 0; i < keys.size(); i++) {
       String name = (String)keys.get(i);
       String value = (String)sPara.get(name);
 
       sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
     }
 
     sbHtml.append("<input type=\"submit\" value=\"确认\" style=\"display:none;\"></form>");
     sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
 
     return sbHtml.toString();
   }
 
   private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp)
   {
     Map sPara = AlipayCore.paraFilter(sParaTemp);
 
     String mysign = AlipayCore.buildMysign(sPara);
 
     sPara.put("sign", mysign);
     sPara.put("sign_type", AlipayConfig.sign_type);
 
     return sPara;
   }
 
   private String buildMysign(Map<String, String> sArray, String key)
   {
     String prestr = AlipayCore.createLinkString(sArray);
     prestr = prestr + key;
     String mysign = AlipayMd5Encrypt.md5(prestr);
     return mysign;
   }
 
   public static boolean verify(Map<String, String> params)
   {
     String mysign = getMysign(params);
     String responseTxt = "true";
     if (params.get("notify_id") != null) {
       responseTxt = verifyResponse((String)params.get("notify_id"));
     }
     String sign = "";
     if (params.get("sign") != null) {
       sign = (String)params.get("sign");
     }
 
     if ((mysign.equals(sign)) && (responseTxt.equals("true"))) {
       return true;
     }
     return false;
   }
 
   public static String getMysign(Map<String, String> Params)
   {
     Map sParaNew = AlipayCore.paraFilter(Params);
     String mysign = AlipayCore.buildMysign(sParaNew);
     return mysign;
   }
 
   public static String verifyResponse(String notify_id)
   {
     String transport = AlipayConfig.transport;
     String partner = AlipayConfig.partner;
     String veryfy_url = "";
 
     if (transport.equalsIgnoreCase("https"))
       veryfy_url = "https://www.alipay.com/cooperate/gateway.do?service=notify_verify&";
     else {
       veryfy_url = "http://notify.alipay.com/trade/notify_query.do?";
     }
     veryfy_url = veryfy_url + "partner=" + partner + "&notify_id=" + notify_id;
     return checkUrl(veryfy_url);
   }
 
   public static String checkUrl(String urlvalue)
   {
     String inputLine = "";
     try
     {
       URL url = new URL(urlvalue);
       HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(
         urlConnection.getInputStream()));
       inputLine = in.readLine().toString();
     } catch (Exception e) {
       e.printStackTrace();
       inputLine = "";
     }
 
     return inputLine;
   }
 }