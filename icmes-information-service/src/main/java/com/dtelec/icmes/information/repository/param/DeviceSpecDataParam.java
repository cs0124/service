package com.dtelec.icmes.information.repository.param;
/**
 * 设备规格参数类
 * @author 张瑞晗
 *
 */
public class DeviceSpecDataParam {
	/**
	 * 设备id
	 */
	private int deviceId;
	/**
	 * 规格数据id
	 */
	private int specDataId;
	/**
	 * 规格名
	 */
	private String name;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 值
	 */
	private String value;
	/**
	 * 是否额外显示
	 */
	private boolean isExtraDisplayMode;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getSpecDataId() {
		return specDataId;
	}

	public void setSpecDataId(int specDataId) {
		this.specDataId = specDataId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isExtraDisplayMode() {
		return isExtraDisplayMode;
	}

	public void setExtraDisplayMode(boolean isExtraDisplayMode) {
		this.isExtraDisplayMode = isExtraDisplayMode;
	}
}
