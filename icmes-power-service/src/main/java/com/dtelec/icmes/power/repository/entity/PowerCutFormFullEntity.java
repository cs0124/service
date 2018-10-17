package com.dtelec.icmes.power.repository.entity;

import java.util.Date;

/**
 * 停电申请单fullEntity
 * @author dell
 *
 */
public class PowerCutFormFullEntity extends PowerCutFormBaseEntity {
	/**
	 * 设备编码
	 */
	private String mainDeviceCode;
	
	/**
	 * 设备名称
	 */	
	private String mainDeviceName;
	


	public PowerCutFormFullEntity(){
		
	}

	public PowerCutFormFullEntity(String mainDeviceCode, String mainDeviceName) {
		super();
		this.mainDeviceCode = mainDeviceCode;
		this.mainDeviceName = mainDeviceName;
	}


	public String getMainDeviceCode() {
		return mainDeviceCode;
	}

	
	public void setMainDeviceCode(String mainDeviceCode) {
		this.mainDeviceCode = mainDeviceCode;
	}
	

	public String getMainDeviceName() {
		return mainDeviceName;
	}
	

	public void setMainDeviceName(String mainDeviceName) {
		this.mainDeviceName = mainDeviceName;
	}
	
	
	


}
