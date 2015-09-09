/**
 * 
 */
package com.itboye.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 常用方法集合
 * @author hebidu
 * @date 2015年9月3日
 * @version 1.0
 */
public class Functions {
	
	/**
	 * 获取异常的字符串描述信息
	 * @param e 异常
	 * @return 描述信息
	 */
	public static String getExceptionDescription(Exception e){
		StringWriter sw  = new StringWriter();
		PrintWriter s = new PrintWriter(sw);
		e.printStackTrace(s);
		return sw.toString();
	}
	
}
