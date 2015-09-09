/**
 * 
 */
package com.itboye.api.sms.haiyan;

/**
 * 海岩短信余额查询参数模型
 * @author hebidu
 * @date 2015年9月8日
 * @version 1.0
 */
public class HaiyanBlanceQueryModel {

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "action="+action+"&userid=" + userid + "&account=" + account + "&password=" + password;
	}

	/**
	 * 
	 */
	public HaiyanBlanceQueryModel() {
		this.action = "overage";
	}
	
	/**
	 * 
	 */
	public HaiyanBlanceQueryModel(String userid,String account,String password) {
		this.action = "overage";
		this.userid = userid;
		this.account = account;
		this.password = password;
	}
	
	private String userid;

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	private String account;
	
	private String password;
	
	private String action;
	
}
