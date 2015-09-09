package com.itboye.api.testsms;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.junit.Test;

import com.itboye.api.sms.SMSException;
import com.itboye.api.sms.haiyan.HaiyanBlanceResultModel;
import com.itboye.api.sms.haiyan.HaiyanSMS;
import com.itboye.api.sms.haiyan.HaiyanSendResultModel;

public class TestHttpClient {

	@Test
	public void TestHaiyanSMS() {

		HaiyanSMS sms = new HaiyanSMS();

		try {
			HaiyanBlanceResultModel model = sms.QueryBlance();
			System.out.println(model.toString());
		} catch (SMSException e) {
			e.printStackTrace();
		}

		fail("No TEST");
	}

	@Test
	public void TestRandom() {

		Random rdm = new Random(System.currentTimeMillis());
		for (int i = 0; i < 10; i++) {
			Integer Rd = Math.abs(rdm.nextInt()) % 899999 + 100000;
			System.out.println(Rd);
		}
	}

	public void TestSendHaiyanSMS() {

		HaiyanSMS sms = new HaiyanSMS();

		try {
			Random rdm = new Random(System.currentTimeMillis());
			Integer Rd = Math.abs(rdm.nextInt()) % 899999 + 1;
			// 6位 100000-999999
			sms.setParams("15858199064", "您的验证码是:" + Rd.toString(), "注册手机验证码");
			HaiyanSendResultModel model = sms.send();
			System.out.println(model.toString());
		} catch (SMSException e) {
			e.printStackTrace();
		}

		fail("No TEST");
	}
	
	@Test 
	public void TestJuheSMS(){
		String city = "suzhou";//参数
		String url = "http://v.juhe.cn/sms/send";//url为请求的api接口地址
	    String key= "d349133a9ea2f7a12ce0a75abef0bb2d";//申请的对应key
		String urlAll = new StringBuffer(url).append(city).append("&key=").append(key).toString(); 
		String charset ="UTF-8";
		String jsonResult = get(urlAll, charset);//得到JSON字符串
		
		System.out.println(jsonResult);
		fail("no test");
		
	}

	
	
	/**
	 * 
	 * @param urlAll:请求接口
	 * @param charset:字符编码
	 * @return 返回json结果
	 */
	public static String get(String urlAll, String charset) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";// 模拟浏览器
		try {
			URL url = new java.net.URL(urlAll);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
