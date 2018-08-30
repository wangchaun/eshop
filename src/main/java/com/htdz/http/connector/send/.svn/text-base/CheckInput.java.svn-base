package com.htdz.http.connector.send;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import com.htdz.http.connector.xml.HexConver;

public class CheckInput {
	private static boolean txnCodEff = true;

	public static Map CheckInput(Map m) {
		// String sendMsg = "";
		String xml = "";
		try {
			SAXReader reader = new SAXReader();
			URL url = Thread.currentThread().getContextClassLoader().getResource("transactionConfig.xml");// 获得交易配置文件地址。
			Document doc = reader.read(url.toString());
			Element root = doc.getRootElement();// 得到交易配置文件对象树。
			List transactionList = root.elements("transaction");
			if (m.get("txnCod") != null && ((String) m.get("txnCod")).length() != 0) {
				for (int i = 0; i < transactionList.size(); i++) {
					Element transactionElement = (Element) transactionList.get(i);
					if (transactionElement.attributeValue("code").equals((String) m.get("txnCod"))) {// 匹配并判断交易码的有效性。
						txnCodEff = false;
						List traInfoList = transactionElement.elements();
						for (int j = 0; j < traInfoList.size(); j++) {
							Node temp = (Node) traInfoList.get(j);
							if (temp.getNodeType() == Node.ELEMENT_NODE) {// 判断对象的类型的节点是不是元素。
								Element tempElement = (Element) temp;// 转换类型到元素。
								if (m.get(tempElement.getName()) != null) {
									if (((String) m.get(tempElement.getName())).trim().getBytes().length > Integer.parseInt(tempElement.attributeValue("length"))) {
										throw new Exception(tempElement.getName() + " " + ((tempElement.attributeValue("desc") != null) ? (tempElement.attributeValue("desc")) : ("")) + " 字段长度超长");
									}
									String elmval = ((String) m.get(tempElement.getName())).trim();
									// xml += "&" + tempElement.getName() + "="
									// + elmval;
									if (tempElement.getName().equals("prdName") || tempElement.getName().equals("prdShortName") || tempElement.getName().equals("prdDesc")
											|| tempElement.getName().equals("merRemark")) {
										elmval = HexConver.Str2Hex(elmval);
										System.out.println("转16进制 >> " + tempElement.getName() + ":" + elmval);
									}
									xml += "&" + tempElement.getName() + "=" + elmval;
									// sendMsg += "&" + tempElement.getName() +
									// "=" + elmval;
								} else {
									// sendMsg += ("&" + tempElement.getName() +
									// "=");
									xml += ("&" + tempElement.getName() + "=");
								}
							}
						}
						break;
					}
				}
				if (txnCodEff) {
					throw new Exception("所传入的交易码：" + (String) m.get("txnCod") + " 有误");
				}
			} else if (m.get("txnCod") == null) {
				throw new Exception("交易码不存在，请传入正确的交易码！");
			} else {
				throw new Exception("交易码为空，请传入正确的交易码！");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// m.put("sendMsg", sendMsg);
		m.put("xml", xml);
		return m;
	}

}
