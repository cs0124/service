package com.dtelec.icmes.power.repository.param;

import java.util.Date;
/**
 * 获取关联设备申请单查询条件类
 * @author dell
 *
 */
public class powerCutAssDeviceQueryParam {
	private String id;
	private Date scheduledCutOffTime;
	private Date scheduledSupplyTime;
	
	
	public powerCutAssDeviceQueryParam(){
		
	}
	
	public powerCutAssDeviceQueryParam(String id, Date scheduledCutOffTime, Date scheduledSupplyTime) {
		super();
		this.id = id;
		this.scheduledCutOffTime = scheduledCutOffTime;
		this.scheduledSupplyTime = scheduledSupplyTime;
	}
	
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Date getScheduledCutOffTime() {
		return this.scheduledCutOffTime;
	}
	
	
	public void setScheduledCutOffTime(Date scheduledCutOffTime) {
		this.scheduledCutOffTime = scheduledCutOffTime;
	}
	
	
	public Date getScheduledSupplyTime() {
		return scheduledSupplyTime;
	}
	
	
	public void setScheduledSupplyTime(Date scheduledSupplyTime) {
		this.scheduledSupplyTime = scheduledSupplyTime;
	}
	
	
	
	

}
