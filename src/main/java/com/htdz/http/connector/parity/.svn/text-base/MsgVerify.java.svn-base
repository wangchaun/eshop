package com.htdz.http.connector.parity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sinokj.code.util.IOUtils;

public class MsgVerify {

	public static boolean verify(Map map, String signType) throws Exception {
		boolean flag = false;
		try {
			if (signType.equals("")) {
				if (map.get("signType").equals("MD5")) {
					flag = MerchantMD5.MD5(((String) map.get("xml")).toString()).equals((String) map.get("sign"));
				} else if (map.get("signType").equals("CFCA")) {
					flag = CAUtil.verify(((String) map.get("xml")).getBytes(), ((String) map.get("sign")).getBytes());
				} else {
					throw new Exception("签名方式有误");
				}
			} else {
				if (signType.equals("MD5")) {
					flag = MerchantMD5.MD5((String) map.get("xml")).equals((String) map.get("sign"));
				} else if (signType.equals("CFCA")) {
					flag = CAUtil.verify(((String) map.get("xml")).getBytes(), ((String) map.get("sign")).getBytes());
				} else {
					throw new Exception("签名方式有误");
				}
			}

			if (!flag) {
				throw new Exception("验证签名失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public static boolean verify(HttpServletRequest request, String charset) throws Exception {
		boolean flag = false;
		String xml = "";
		try {
			byte[] rsp = IOUtils.readBytesFromStream(request.getInputStream());
			String s = new String(rsp, charset);
			String[] str = s.split("&signature=" + request.getParameter("signature"));
			for (int i = 0; i < str.length; i++) {
				xml += str[i];
			}

			if (request.getParameter("signType").equals("MD5")) {
				flag = MerchantMD5.MD5(xml.toString()).equals(request.getParameter("signature"));
			} else if (request.getParameter("signType").equals("CFCA")) {
				flag = CAUtil.verify(xml.getBytes(), (request.getParameter("signature")).getBytes());
			} else {
				throw new Exception("签名方式有误");
			}

			if (!flag) {
				throw new Exception("验证签名失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}
