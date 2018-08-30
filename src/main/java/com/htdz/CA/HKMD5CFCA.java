package com.htdz.CA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Properties;

import org.bouncycastle.util.encoders.Base64;

import com.hkrt.http.connector.parity.CAUtil;


public class HKMD5CFCA {
	public static String HKMD5(String inStr) throws Exception {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
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

	public static X509Certificate loadCertificate(String pfx, String password)
			throws Exception {
		KeyStore store = KeyStore.getInstance("PKCS12", "BC");
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL url = classLoader.getResource(pfx);
		InputStream is = null;
		if (url != null)
			try {
				is = new FileInputStream(url.getFile());
			} catch (FileNotFoundException e) {
				is = classLoader.getResourceAsStream(pfx);
			}
		else {
			is = new FileInputStream(pfx);
		}
		store.load(is, password.toCharArray());
		is.close();
		String keyAlias = null;
		Enumeration<?> e = store.aliases();
		if (e.hasMoreElements())
			keyAlias = (String) e.nextElement();
		else
			return null;
		X509Certificate certificate = (X509Certificate) store
				.getCertificate(keyAlias);
		return certificate;
	}

	public static int HKCFCA(String sourceData, String signData, String pfx,
			String passWord) throws Exception {
		// if (StringUtils.isEmpty(sourceData)) {
		// Log.error("ԭ��ݲ���Ϊ��!");
		// return 1;
		// }
		// if (StringUtils.isEmpty(signData)) {
		// Log.error("ǩ����ݲ���Ϊ��!");
		// return 1;
		// }
		Signature sig = Signature.getInstance("SHA1WithRSA");
		// ��ù�Կ
		X509Certificate certificate = loadCertificate(pfx, passWord);
		sig.initVerify(certificate);
		sig.update(sourceData.getBytes());
		System.out.println(signData);
		byte[] b = Base64.decode(signData.getBytes());
		System.out.println(new String(b));
		try {
			if (sig.verify(b)) {
				// Log.info(new String(b));
				return 0;
			} else {
				// Log.info(new String(b));
				return 1;
			}
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return 1;
	}

	static Properties properties = new Properties();

	public static void loadPfx() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			InputStream config = cl.getResourceAsStream("payConfig.properties");
			properties.load(config);
			config.close();
			CAUtil.loadPrivPFX(properties.getProperty("keyFile"), properties
					.getProperty("password"));
			CAUtil.loadCertificate(properties.getProperty("certFile"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
	 

		String source = "versionId=3&merchantId=00000000001616&orderId=59349743903454&orderAmount=9500&orderDate=2010-01-01&currency=RMB&transType=&retUrl=http://172.16.85.111:9082/supplierWeb/rePayment&bizType=01&returnUrl=http://172.16.85.111:9082/supplierWeb/rePayment&prdDisUrl=www.tempus.cn&prdName=313030&prdShortName=&prdDesc=&merRemark=&rptType=1&prdUnitPrice=9500&buyCount=1&defPayWay=&buyMobNo=13725574658&cpsFlg=1&signType=ZJCA";
		String sign = "mtt6ernil21ZgCaWSuuobDylKwVKJXt9Ci1xY1I6k7LzTmgTQn9wsWjIF+Ft/6ec27wdA8m75L78y6hGZZX3dGvw4O1SQfhPjpoWZ0xr/QkbxR3Um1nVaPNgRlDJNci+FIJ++FqbySqYT+1U+cAx3OJ8kApmgSaQ+YXZQXw3NqJnAczE/CmI6AdT3syfCeMw0L+IRQkGeQkdULQ/9CSY/B+3ZlKIU4o8T1dpB21KF2iebIqATxGDlGbwOk3Eog92BJbTPkHpO95N+d77yhQ4EUs41afSDe4Xmv1AeL+xlAsINVp4eVyk7SlxVUQIMUtKpD2yo8HUBehHMGlLFhHZ4g==";
		String pfx = "00001616.pfx";
		String pwd = "hkrt123";
		int n = HKCFCA(source, sign, pfx, pwd);
		System.out.println(n);

		loadPfx();
		source = new String(CAUtil.sign(source.getBytes("UTF-8")));
		System.out.println(source);
	}
}
