package com.dtelec.icmes.power.repository.param;

import java.util.List;

/**
 * 账户分页参数
 * @author zturnking
 *
 */
public class PowerCutPageableQueryParam extends PageableQueryBaseParam {
	/**
	 * 设备标识符
	 */
	private int device;
	/**
	 * 停电申请单号
	 */
	private String number;
	/**
	 * 停电申请单状态
	 */
	private List<String> statusList;
	/**
	 * 全局搜索
	 */
	private String globalName;
	
	public int getDevice() {
		return this.device;
	}
	
	public void setDevice(int device) {
		this.device = device;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public String getGlobalName() {
		return this.globalName;
	}
	
	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}
}
