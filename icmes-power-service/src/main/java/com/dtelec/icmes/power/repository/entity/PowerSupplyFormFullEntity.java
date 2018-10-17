package com.dtelec.icmes.power.repository.entity;

/**
 * 送电申请单实体类
 * @author schi
 *
 */
public class PowerSupplyFormFullEntity extends PowerSupplyFormBaseEntity{

	/**
	 * 设备编码
	 */
	private String mainDeviceCode;
	
	/**
	 * 设备名称
	 */	
	private String mainDeviceName;
	
	/**
	 * 设备标识符
	 */
	private int mainDeviceId;

	public PowerSupplyFormFullEntity() {
		
	}

	
	public PowerSupplyFormFullEntity(String mainDeviceCode, String mainDeviceName, int mainDeviceId) {
		super();
		this.mainDeviceCode = mainDeviceCode;
		this.mainDeviceName = mainDeviceName;
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

	public int getMainDeviceId() {
		return mainDeviceId;
	}

	public void setMainDeviceId(int mainDeviceId) {
		this.mainDeviceId = mainDeviceId;
	}
	
	
	
}
