package com.htdz.http.connector.send;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;

import com.htdz.http.connector.parity.CAUtil;
import com.htdz.http.connector.parity.MerchantMD5;
import com.htdz.http.connector.xml.XMLConvertor;

public class SendMessage {
	private static String url;
	private static String merchantId;
	private static String versionId;
	private static String charset;
	private static String sendMsg;
	private static String signature;
	private static String signType;
	private static String md5Key;
	private static Properties properties = new Properties();
	private static String defenc = Charset.defaultCharset().displayName();
	private static HttpURLConnection conn;

	static {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			InputStream config = cl.getResourceAsStream("payConfig.properties");
			properties.load(config);
			config.close();

			url = properties.getProperty("connSvr");
			merchantId = properties.getProperty("merchantId");
			versionId = properties.getProperty("versionId");
			charset = properties.getProperty("charset");
			signType = properties.getProperty("signType");
			md5Key = properties.getProperty("md5Key");
			if (properties.getProperty("keyFile") == "") {
				CAUtil.loadPrivPFX(properties.getProperty("keyFile"), properties.getProperty("password"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map send(Map m) throws Exception {
		sendMsg = encrypt(m); // 数据拼接和加密
		String urlbak = "";
		urlbak = url + properties.getProperty((String) m.get("txnCod") + "URL");// 获取并拼接连接地址
		Map rtnMap = sendHttp(urlbak, sendMsg, (String) m.get("txnCod"), signType);

		return rtnMap;
	}

	public static String senda(Map m) throws Exception {
		sendMsg = encrypt(m); // 数据拼接和加密
		String urlbak = "";
		urlbak = url + properties.getProperty((String) m.get("txnCod") + "URL");// 获取并拼接连接地址
		String str = sendHttpa(urlbak, sendMsg, (String) m.get("txnCod"), signType);

		return str;
	}

	public static String reqPay(Map m) throws Exception {
	 
		sendMsg = encrypt(m); // 数据拼接和加密
		String urlbak = "";
		urlbak = url + properties.getProperty((String) m.get("txnCod") + "URL");// 获取并拼接连接地址
		System.out.println(urlbak + "---------" + sendMsg);
		return urlbak + "?" + URLEncoder.encode(sendMsg, "utf-8");
	}

	private static String sendHttpa(String url, String message, String txnCod, String signType) throws Exception {
		Map rtnMap = null;
		try {
			URL urlObj = new URL(url);
			System.out.println("准备连接URL==>[" + url + "]");
			conn = (HttpURLConnection) urlObj.openConnection();// 连接URL
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		conn.setConnectTimeout(10000);
		conn.setRequestProperty("Encoding", charset);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);

		OutputStream os = null;
		String ReceiveMsg = "";
		try {
			os = conn.getOutputStream();
			byte[] d = message.getBytes("utf-8");
			os.write(d);// 发送数据
			os.flush();
			System.out.println("向请求URL发送数据[" + new String(d, "utf-8") + "]完成");
			int retCod = conn.getResponseCode();
			if (retCod == 200) {
				System.out.println("接收服务器端成功[200]响应");
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
				ReceiveMsg = br.readLine();
				System.out.println("返回：" + ReceiveMsg);
				rtnMap = XMLConvertor.xml2Map(ReceiveMsg);
			} else {
				String errmsg = conn.getResponseMessage();
				throw new IOException("HTTP返回失败:" + Integer.valueOf(retCod) + errmsg);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}
		}

		return ReceiveMsg;
	}

	private static Map sendHttp(String url, String message, String txnCod, String signType) throws Exception {
		Map rtnMap = null;
		try {
			URL urlObj = new URL(url);
			System.out.println("准备连接URL==>[" + url + "]");
			conn = (HttpURLConnection) urlObj.openConnection();// 连接URL
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		conn.setConnectTimeout(10000);
		conn.setRequestProperty("Encoding", charset);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);

		OutputStream os = null;
		try {
			os = conn.getOutputStream();
			byte[] d = message.getBytes("utf-8");
			os.write(d);// 发送数据
			os.flush();
			System.out.println("向请求URL发送数据[" + new String(d, "utf-8") + "]完成");
			String ReceiveMsg;
			int retCod = conn.getResponseCode();
			if (retCod == 200) {
				System.out.println("接收服务器端成功[200]响应");
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
				ReceiveMsg = br.readLine();
				System.out.println("返回：" + ReceiveMsg);
				rtnMap = XMLConvertor.xml2Map(ReceiveMsg);
				// if (txnCod.equals("MerchantmerchantTransQuery")) { // 不需验证签名
				//					
				// } else { // 需验证签名
				// MsgVerify.verify(rtnMap, signType);
				// }
			} else {
				String errmsg = conn.getResponseMessage();
				throw new IOException("HTTP返回失败:" + Integer.valueOf(retCod) + errmsg);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}
		}

		return rtnMap;
	}

	public static String encrypt(Map m) throws Exception {
		Map ChkMap = CheckInput.CheckInput(m);
		String xml = (String) ChkMap.get("xml");
		// sendMsg = "versionId="+versionId + "&merchantId="+merchantId +
		// (String) ChkMap.get("sendMsg");
		xml = "versionId=" + versionId + "&merchantId=" + merchantId + xml + "&signType=" + signType;
		// 针对签名方式进行签名
		System.out.println("signType:" + signType);
		if (signType.equals("MD5")) {
			System.out.println("MD5原数据:" + xml + md5Key);
			signature = MerchantMD5.MD5(xml + md5Key);
		} else if (signType.equals("CFCA") || signType.equals("ZJCA")) {
			try {
				signature = new String(CAUtil.sign(xml.getBytes("UTF-8")));
			} catch (Exception e) {
				throw new Exception("签名失败");
			}
		} else {
			throw new Exception("签名方式有误");
		}

		xml += "&signature=" + signature;
		return xml;
	}

}
