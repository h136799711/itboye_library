package com.itboye.api.sms.haiyan;

import org.dom4j.DocumentException;

import com.itboye.utils.xml.XMLUtils;

public class HaiyanSendResultModel {

	
	public HaiyanSendResultModel() {
		
	}

	public HaiyanSendResultModel(String xmlStr) throws DocumentException{
		org.dom4j.Document doc = XMLUtils.getXMLDocument(xmlStr);
		
		this.returnstatus = XMLUtils.getNodeText("returnstatus", doc);
		this.message = XMLUtils.getNodeText("message", doc);
		
		
		
		if(this.returnstatus.toLowerCase().equals("success")){
			this.successCounts = XMLUtils.getNodeText("successCounts", doc);
			this.taskID = (XMLUtils.getNodeText("taskID", doc));
			this.remainpoint = (XMLUtils.getNodeText("remainpoint", doc));
		}else{
			this.successCounts = "0";
			this.taskID = "0";
			this.remainpoint = "0";
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HaiyanSendResultModel [returnstatus=" + returnstatus + ", message=" + message + ", remainpoint="
				+ remainpoint + ", taskID=" + taskID + ", successCounts=" + successCounts + "]";
	}



	private String returnstatus;
	private String message;
	private String remainpoint;
	private String taskID;
	private String successCounts;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the returnstatus
	 */
	public String getReturnstatus() {
		return returnstatus;
	}

	/**
	 * @param returnstatus the returnstatus to set
	 */
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	/**
	 * @return the remainpoint
	 */
	public String getRemainpoint() {
		return remainpoint;
	}

	/**
	 * @param remainpoint the remainpoint to set
	 */
	public void setRemainpoint(String remainpoint) {
		this.remainpoint = remainpoint;
	}

	/**
	 * @return the taskID
	 */
	public String getTaskID() {
		return taskID;
	}

	/**
	 * @param taskID the taskID to set
	 */
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	/**
	 * @return the successCounts
	 */
	public String getSuccessCounts() {
		return successCounts;
	}

	/**
	 * @param successCounts the successCounts to set
	 */
	public void setSuccessCounts(String successCounts) {
		this.successCounts = successCounts;
	}
	
	
}
