 package com.alipay.services;
 
 import com.alipay.config.AlipayConfig;
 import com.alipay.util.AlipaySubmit;
 import java.io.IOException;
 import java.net.MalformedURLException;
 import java.net.URL;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import org.dom4j.Document;
 import org.dom4j.DocumentException;
 import org.dom4j.Node;
 import org.dom4j.io.SAXReader;
 
 public class AlipayService
 {
   private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
 
   public static String create_direct_pay_by_user(Map<String, String> sParaTemp)
   {
     sParaTemp.put("service", "create_direct_pay_by_user");
     sParaTemp.put("partner", AlipayConfig.partner);
     sParaTemp.put("return_url", AlipayConfig.return_url);
     sParaTemp.put("notify_url", AlipayConfig.notify_url);
     sParaTemp.put("seller_email", AlipayConfig.seller_email);
     sParaTemp.put("_input_charset", AlipayConfig.input_charset);
 
     String strButtonName = "确认";
 
     return AlipaySubmit.buildForm(sParaTemp, "https://mapi.alipay.com/gateway.do?", "get", strButtonName);
   }
 
   public static String query_timestamp()
     throws MalformedURLException, DocumentException, IOException
   {
     String strUrl = "https://mapi.alipay.com/gateway.do?service=query_timestamp&partner=" + AlipayConfig.partner;
     StringBuffer result = new StringBuffer();
 
     SAXReader reader = new SAXReader();
     Document doc = reader.read(new URL(strUrl).openStream());
 
     List nodeList = doc.selectNodes("//alipay/*");
     Iterator localIterator2;
     label171: for (Iterator localIterator1 = nodeList.iterator(); localIterator1.hasNext(); 
       localIterator2.hasNext())
     {
       Node node = (Node)localIterator1.next();
 
       if ((!node.getName().equals("is_success")) || (!node.getText().equals("T")))
         break label171;
       List nodeList1 = doc.selectNodes("//response/timestamp/*");
       localIterator2 = nodeList1.iterator();
       //这里改过
       Node node1 = (Node)localIterator2.next();
       result.append(node1.getText());
     }
 
     return result.toString();
   }
 }