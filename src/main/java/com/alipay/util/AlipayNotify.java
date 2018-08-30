 package com.alipay.util;
 
 import com.alipay.config.AlipayConfig;
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import java.util.Map;
 
 public class AlipayNotify
 {
   public static final String HTTPS_VERIFY_URL = "https://www.alipay.com/cooperate/gateway.do?service=notify_verify&";
   public static final String HTTP_VERIFY_URL = "http://notify.alipay.com/trade/notify_query.do?";
 
   public static boolean verify(Map<String, String> params)
   {
     String mysign = getMysign(params);
     String responseTxt = "true";
     if (params.get("notify_id") != null) responseTxt = verifyResponse((String)params.get("notify_id"));
     String sign = "";
     if (params.get("sign") != null) sign = (String)params.get("sign");
 
     if ((mysign.equals(sign)) && (responseTxt.equals("true"))) {
       return true;
     }
     return false;
   }
 
   private static String getMysign(Map<String, String> Params)
   {
     Map sParaNew = AlipayCore.paraFilter(Params);
     String mysign = AlipayCore.buildMysign(sParaNew);
     return mysign;
   }
 
   private static String verifyResponse(String notify_id)
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