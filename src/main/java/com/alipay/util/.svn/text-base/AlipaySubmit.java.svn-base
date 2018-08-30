 package com.alipay.util;
 
 import com.alipay.config.AlipayConfig;
 import com.alipay.util.httpClient.HttpProtocolHandler;
 import com.alipay.util.httpClient.HttpRequest;
 import com.alipay.util.httpClient.HttpResponse;
 import com.alipay.util.httpClient.HttpResultType;
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.List;
 import java.util.Map;
 import java.util.Map.Entry;
 import org.apache.commons.httpclient.NameValuePair;
 
 public class AlipaySubmit
 {
   private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp)
   {
     Map sPara = AlipayCore.paraFilter(sParaTemp);
 
     String mysign = AlipayCore.buildMysign(sPara);
 
     sPara.put("sign", mysign);
     sPara.put("sign_type", AlipayConfig.sign_type);
 
     return sPara;
   }
 
   public static String buildForm(Map<String, String> sParaTemp, String gateway, String strMethod, String strButtonName)
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
 
     sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
     sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
 
     return sbHtml.toString();
   }
 
   private static NameValuePair[] generatNameValuePair(Map<String, String> properties)
   {
     NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
     int i = 0;
     for (Map.Entry entry : properties.entrySet()) {
       nameValuePair[(i++)] = new NameValuePair((String)entry.getKey(), (String)entry.getValue());
     }
 
     return nameValuePair;
   }
 
   public static String sendPostInfo(Map<String, String> sParaTemp, String gateway)
     throws Exception
   {
     Map sPara = buildRequestPara(sParaTemp);
 
     HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();
 
     HttpRequest request = new HttpRequest(HttpResultType.BYTES);
 
     request.setCharset(AlipayConfig.input_charset);
 
     request.setParameters(generatNameValuePair(sPara));
     request.setUrl(gateway + "_input_charset=" + AlipayConfig.input_charset);
 
     HttpResponse response = httpProtocolHandler.execute(request);
     if (response == null) {
       return null;
     }
 
     String strResult = response.getStringResult();
 
     return strResult;
   }
 }