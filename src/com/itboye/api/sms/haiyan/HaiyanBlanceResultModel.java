/**
 * 
 */
package com.itboye.api.sms.haiyan;

import java.util.List;

import org.dom4j.DocumentException;

import com.itboye.utils.xml.XMLUtils;

/**
 * @author hebidu
 * @date 2015年9月8日
 * @version 1.0
 */
public class HaiyanBlanceResultModel {

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HaiyanBlanceResultModel [returnstatus=" + returnstatus + ", message=" + message + ", payinfo=" + payinfo
				+ ", overage=" + overage + ", sendTotal=" + sendTotal + "]";
	}

	/**
	 * 
	 */
	public HaiyanBlanceResultModel() {
		
	}
	
	public HaiyanBlanceResultModel(String xmlStr)  throws DocumentException{
		getValuesFrom(xmlStr);
	}
	
	public void getValuesFrom(String xmlStr)  throws DocumentException{

		org.dom4j.Document doc = XMLUtils.getXMLDocument(xmlStr);
		
		this.returnstatus = XMLUtils.getNodeText("returnstatus", doc);
		this.message = XMLUtils.getNodeText("message", doc);
		
		
		
		if(this.returnstatus.toLowerCase().equals("faild")){
			this.payinfo = "";
			this.overage = 0;
			this.sendTotal = 0;
		}else{
			this.payinfo = XMLUtils.getNodeText("payinfo", doc);
			this.overage = Integer.parseInt(XMLUtils.getNodeText("overage", doc));
			this.sendTotal = Integer.parseInt(XMLUtils.getNodeText("sendTotal", doc));
		}
	}
	
	
	private String returnstatus;
	
	private String message;
	
	private String payinfo;
	
	private int overage;
	
	private int sendTotal;

	/**
	 * @return the returnstatus
	 */
	public Boolean getReturnstatus() {
		
		if(returnstatus.toLowerCase().equals("faild")){
			return false;
		}else{
			return true;
		}
		
	}

	/**
	 * @param returnstatus the returnstatus to set
	 */
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	/**
	 * 返回信息
	 * 1. 用户名或密码不能为空
	 * 2. 用户名或密码错误
	 * 3. 返回的是 "" 空字符串
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 信息
	 * 1. 用户名或密码不能为空
	 * 2. 用户名或密码错误
	 * 3. 返回的是 "" 空字符串
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the payinfo
	 */
	public String getPayinfo() {
		return payinfo;
	}

	/**
	 * @param payinfo the payinfo to set
	 */
	public void setPayinfo(String payinfo) {
		this.payinfo = payinfo;
	}

	/**
	 * @return the overage
	 */
	public int getOverage() {
		return overage;
	}

	/**
	 * @param overage the overage to set
	 */
	public void setOverage(int overage) {
		this.overage = overage;
	}

	/**
	 * @return the sendTotal
	 */
	public int getSendTotal() {
		return sendTotal;
	}

	/**
	 * @param sendTotal the sendTotal to set
	 */
	public void setSendTotal(int sendTotal) {
		this.sendTotal = sendTotal;
	}
	
	

}
