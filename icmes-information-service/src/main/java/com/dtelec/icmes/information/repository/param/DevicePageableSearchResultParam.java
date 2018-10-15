package com.dtelec.icmes.information.repository.param;

import com.dtelec.icmes.information.repository.entity.DeviceBaseEntity;
/**
 * 设备分页查询接轨返回实体类
 * @author 张瑞晗
 *
 */
public class DevicePageableSearchResultParam extends DeviceBaseEntity {
	/**
	 * 设备类型名称
	 */
	private String deviceCategoryName;
	/**
	 * 设备类型编码
	 */
	private String deviceCategoryCode;
	/**
	 * 位置编码
	 */
	private String LocationCode;
	/**
	 * 位置名称
	 */
	private String LocationName;

	public String getDeviceCategoryName() {
		return deviceCategoryName;
	}

	public void setDeviceCategoryName(String deviceCategoryName) {
		this.deviceCategoryName = deviceCategoryName;
	}

	public String getDeviceCategoryCode() {
		return deviceCategoryCode;
	}

	public void setDeviceCategoryCode(String deviceCategoryCode) {
		this.deviceCategoryCode = deviceCategoryCode;
	}

	public String getLocationCode() {
		return LocationCode;
	}

	public void setLocationCode(String locationCode) {
		LocationCode = locationCode;
	}

	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}
}
