/**
 * 
 */
package com.itboye.api.sms;

/**
 * @author hebidu
 * @date 2015年9月8日
 * @version 1.0
 */
public interface ISMS {

	/**
	 * 发送短信接口
	 * @return
	 */
	public String send()  throws SMSException ;
	
	
}
