package com.dtelec.icmes.power.service.param;

import java.util.List;

public class PowerCutPageableSearchParam extends PageableSearchBaseParam {
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
	
	/**
	 * 查询重构
	 * @param device
	 * @param number
	 * @param status
	 * @param page
	 * @param count
	 */
	public PowerCutPageableSearchParam(int device, String number, List<String> statusList, String globalName, int page, int count) {
		super(page, count);
		
		this.device = device;
		this.number = number;
		this.statusList = statusList;
		this.globalName = globalName;
	}
	
	
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
