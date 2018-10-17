package com.dtelec.icmes.power.repository.param;
/**
 * 延迟送电分页参数
 * @author Shaoyi Chen
 *
 */
public class PowerDelayPageableQueryParam extends PageableQueryBaseParam {
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
	private String status;
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
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getGlobalName() {
		return this.globalName;
	}
	
	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}
}
