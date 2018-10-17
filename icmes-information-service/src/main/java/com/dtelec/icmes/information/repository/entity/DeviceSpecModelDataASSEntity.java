package com.dtelec.icmes.information.repository.entity;

/**
 * 设备对应规格实体entity
 * 
 * @author RHZhang 张瑞晗
 *
 */
public class DeviceSpecModelDataASSEntity {
	/**
	 * 标识符
	 */
	private int deviceId;
	
	/**
	 *对应的规格类型数值
	 */
	private int specModelDataId;
	
	/**
	 * 对应类型的值
	 */
	private int value;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getSpecModelDataId() {
		return specModelDataId;
	}

	public void setSpecModelDataId(int specModelDataId) {
		this.specModelDataId = specModelDataId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
