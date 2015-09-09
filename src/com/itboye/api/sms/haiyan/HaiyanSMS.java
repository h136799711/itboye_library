/**
 * 
 */
package com.itboye.api.sms.haiyan;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.dom4j.DocumentException;

import com.itboye.api.sms.ISMS;
import com.itboye.api.sms.SMSException;
import com.itboye.network.HttpClient;

/**
 * @author hebidu
 * @date 2015年9月8日
 * @version 1.0
 */
public class HaiyanSMS {
	
	
	private String apiAddress = "http://www.duanxin10086.com/sms.aspx";
	
	private String mobile;
	private String content;
	private String taskName;
	
	private HaiyanBlanceResultModel model;
	
	public void setParams(String mobile,String content,String taskName){
		this.mobile = mobile;
		this.content = content;
		this.taskName = taskName;
	}
	
	
	public HaiyanSendResultModel send() throws SMSException {
		
		Map<String,String> config = this.getConfig();
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("action","send"));
		params.add(new BasicNameValuePair("userid",config.get("userid")));
		params.add(new BasicNameValuePair("account",config.get("account")));
		params.add(new BasicNameValuePair("password",config.get("password")));
		
		
		Date now = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("y-M-d H:m:s");
		
		params.add(new BasicNameValuePair("mobile",this.mobile));
		params.add(new BasicNameValuePair("content",this.content));
		params.add(new BasicNameValuePair("taskName",this.taskName));
		
		
		params.add(new BasicNameValuePair("sendTime",format.format(now)));
		
		params.add(new BasicNameValuePair("checkcontent","0"));
		params.add(new BasicNameValuePair("countnumber","1"));
		params.add(new BasicNameValuePair("mobilenumber","1"));
		params.add(new BasicNameValuePair("telephonenumber","0"));
		
		//发送sms短信
		
		if(this.mobile == null || this.mobile.length() == 0
				|| this.content == null || this.content.length() == 0){
			return null;
		}
		
		
		
		String xmlStr="";
		try {
			xmlStr = HttpClient.post(apiAddress, params);
			
			return new HaiyanSendResultModel(xmlStr);
			
		} catch (IOException e) {
			
			throw new SMSException(e.getMessage());
			
		} catch (DocumentException e) {

			throw new SMSException(e.getMessage());
		}
		
	}
	
	
	/**
	 * 查询短信余额
	 * @throws SMSException 
	 */
	public HaiyanBlanceResultModel QueryBlance() throws SMSException{
		
		Map<String,String> config = this.getConfig();
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("action","overage"));
		params.add(new BasicNameValuePair("userid",config.get("userid")));
		params.add(new BasicNameValuePair("account",config.get("account")));
		params.add(new BasicNameValuePair("password",config.get("password")));
		
		
		
		String xmlStr="";
		
		try {
			
			xmlStr = HttpClient.post(apiAddress, params);
			
			return new HaiyanBlanceResultModel(xmlStr);
			
		} catch (IOException e) {
			
			throw new SMSException(e.getMessage());
			
		} catch (DocumentException e) {

			throw new SMSException(e.getMessage());
		}
		
		
		
		
	}

	/**
	 * 
	 */
	public HaiyanSMS() {
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> getConfig(){
		
		HashMap<String,String> config = new HashMap<String,String>();
		
		config.put("userid", "8570");
		config.put("account", "gooraye");
		config.put("password", "hebidu136799711");
		
		return config;
		
	}
	
	
	public HaiyanBlanceResultModel getResultModel(){
		
		return this.model;
	
	}

	
}
