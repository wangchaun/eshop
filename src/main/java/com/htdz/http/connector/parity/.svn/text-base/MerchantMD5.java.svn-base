package com.htdz.http.connector.parity;

import java.security.MessageDigest;

public class MerchantMD5 {

	// MD5加密 <param
	// name="source">加密的数据源,测试结果为f1c728f403a814c2d09512e835263dfe</param>
	// <returns>加密串</returns>
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	// / <returns>加密串</returns>
	// public static string GetMD5(string source)
	// {
	// string md5String = string.Empty;
	// try
	// {
	// byte[] byteCode= System.Text.Encoding.Default.GetBytes(source.Trim());
	// byteCode= new
	// System.Security.Cryptography.MD5CryptoServiceProvider().ComputeHash(byteCode);
	//	           
	// for (int i = 0; i < byteCode.Length; i++)
	// {
	// md5String += byteCode[i].ToString("x").PadLeft(2, '0');
	// }
	// }
	// catch (Exception ex)
	// {
	// log.Warn("MD5加密错误:" + ex.ToString());
	// md5String = ex.ToString();
	// return md5String;
	// }
	// return md5String;
	// }
	// #endregion

	// 可逆的加密算法
	public static String KL(String inStr) {
		// String s = new String(inStr);
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}

	// 加密后解密
	public static String JM(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}

	public static void main(String[] args) {
		String versionId = "2";
		String merchantId = "987456";
		String orderId = "t0628";
		String accmount = "1089";
		String date = "2011-06-16";
		String type = "RMB";
		String type1 = "0101";
		String key = "ag8ch6hbttbl";

		StringBuilder sb = new StringBuilder();
		sb.append(versionId).append(merchantId).append(orderId).append(accmount).append(date).append(type).append(type1).append(key);
		System.out.println(MD5(sb.toString()));
	}

}
