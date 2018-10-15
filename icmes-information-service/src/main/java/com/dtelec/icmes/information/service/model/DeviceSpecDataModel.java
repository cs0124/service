package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.param.DeviceSpecDataParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 设备规格数据模型
 * @author 张瑞晗
 *
 */
@ApiModel
public class DeviceSpecDataModel {
	/**
	 * 设备id
	 */
	@ApiModelProperty(value="设备id")
	private int deviceId;
	/**
	 * 设备规格数据id
	 */
	@ApiModelProperty(value="设备规格数据id")
	private int specDataId;
	/**
	 * 规格名
	 */
	@ApiModelProperty(value="规格名")
    private String name;
    /**
     * 单位
     */
	@ApiModelProperty(value="单位")
    private String unit;
    /**
     * 值
     */
	@ApiModelProperty(value="值")
    private String value;
    /**
     * 是否额外显示
     */
	@ApiModelProperty(value="是否额外显示")
    private boolean isExtraDisplayMode;
    
    public void fill(DeviceSpecDataParam entity) {
    	this.deviceId = entity.getDeviceId();
    	this.specDataId = entity.getSpecDataId();
    	this.name = entity.getName();
    	this.unit = entity.getUnit();
    	this.value = entity.getValue();
    	this.isExtraDisplayMode = entity.isExtraDisplayMode();
    	
    }
    

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
