package com.dtelec.icmes.power.repository.entity;


import io.swagger.annotations.ApiModelProperty;

public class PowerDelayFormFullEntity extends PowerDelayFormBaseEntity{

	/**
	 * 设备标识符
	 */
	@ApiModelProperty(value = "设备标识符")
	private int mainDeviceId;
	
	/**
	 * 设备编码
	 */
	@ApiModelProperty(value = "设备编码")
	private String mainDeviceCode;
	
	/**
	 * 设备名称
	 */
	@ApiModelProperty(value = "设备名称")
	private String mainDeviceName;
	

	public int getMainDeviceId() {
		return mainDeviceId;
	}

	public void setMainDeviceId(int mainDeviceId) {
		this.mainDeviceId = mainDeviceId;
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
