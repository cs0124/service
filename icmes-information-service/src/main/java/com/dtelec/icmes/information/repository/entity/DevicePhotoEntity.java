package com.dtelec.icmes.information.repository.entity;

public class DevicePhotoEntity {
	/**
	 * 设备编号
	 */
	private int deviceId;
	
	/**
	 * 设备照片
	 */
	private String photo;
	
	/**
	 * 设备照片顺序
	 */
	private int orderId;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
