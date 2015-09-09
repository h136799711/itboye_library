/**
 * 
 */
package com.itboye.api.sms;

/**
 * @author hebidu
 * @date 2015年9月8日
 * @version 1.0
 */
public class SMSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -127165728573093944L;

	/**
	 * 
	 */
	public SMSException() {
	}
	
	/**
	 * @param message
	 */
	public SMSException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SMSException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SMSException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SMSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
