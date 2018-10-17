package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.DevicePhotoEntity;

/**
 * 照片model
 * @author schi
 *
 */
public class DevicePhotoModel {

	/**设备标识符*/
	private int deviceId;
	/**照片标示码*/
    private String photo;
    /**照片显示顺序号*/
    private int order;
    
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
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	//填充Model
	public void fill(DevicePhotoEntity photoEntity) {
		this.deviceId = photoEntity.getDeviceId();
		this.photo = photoEntity.getPhoto();
		this.order = photoEntity.getOrderId();
	}
		
	/**
	 * model转换成entity
	 * @return 设备照片实体类
	 */
	public DevicePhotoEntity convert() {
		DevicePhotoEntity entity = new DevicePhotoEntity();
		
		entity.setDeviceId(this.deviceId);
		entity.setOrderId(this.order);;
		entity.setPhoto(this.photo);
		
		return entity;
	}
	
}
