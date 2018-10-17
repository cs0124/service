package com.dtelec.icmes.power.service.model;

import java.util.Date;
import java.util.List;

import com.dtelec.icmes.power.repository.entity.PowerSupplyFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormFullEntity;

import io.swagger.annotations.ApiModelProperty;

public class PowerSupplyFormFullModel {

	/**
	 * 送电申请单号
	 */
	@ApiModelProperty(value = "送电申请单号")
	private String id;
	
	/**
	 * 关联的停电申请单单号
	 */
	@ApiModelProperty(value = "关联的停电申请单单号")
	private String powerCutFormId;
	
	/**
	 * 送电申请单状态
	 */
	@ApiModelProperty(value = "送电申请单状态")
	private String status;
	
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
	
	/**
	 * 关联设备
	 */
	private List<DeviceBaseModel> associatedDevices;
	
	/**
	 * 实际送电时间
	 */
	@ApiModelProperty(value = "实际送电时间")
	private long actualSupplyTime;

	/**
	 * 用于高并发的数据版本控制
	 */
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	
	/**
	 * 停电申请单创建时间
	 */
	@ApiModelProperty(value = "停电申请单创建时间")
	private long createTime;
	
	/**
	 * 申请人标识符
	 */
	@ApiModelProperty(value = "申请人标识符")
	private int createUserId;
	
	
	/**
	 * 申请人
	 */
	@ApiModelProperty(value = "申请人")
	private String createUserName;
	
	private int updateUserId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPowerCutFormId() {
		return powerCutFormId;
	}

	public void setPowerCutFormId(String powerCutFormId) {
		this.powerCutFormId = powerCutFormId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public List<DeviceBaseModel> getAssociatedDevices() {
		return associatedDevices;
	}

	public void setAssociatedDevices(List<DeviceBaseModel> associatedDevices) {
		this.associatedDevices = associatedDevices;
	}

	public long getActualSupplyTime() {
		return actualSupplyTime;
	}

	public void setActualSupplyTime(long actualSupplyTime) {
		this.actualSupplyTime = actualSupplyTime;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
	public int getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 送电申请单model转entity
	 * @return 送电申请单entity
	 */
	public PowerSupplyFormBaseEntity convert() {
		PowerSupplyFormBaseEntity entity = new PowerSupplyFormBaseEntity();
		
		entity.setId(this.id);
		entity.setPowerCutFormId(this.powerCutFormId);
		entity.setStatus(this.status);
		entity.setActualSupplyTime(new Date(this.actualSupplyTime));
		entity.setVersionTag(this.versionTag);
		entity.setCreateUserId(this.createUserId);
		entity.setUpdateUserId(this.updateUserId);
		
		return entity;
	}
	
	/**
	 * 填充送电申请单model
	 * @param entity 送电申请单实体类
	 */
	public void fill(PowerSupplyFormFullEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			if (entity.getActualSupplyTime() != null) {
				
				this.actualSupplyTime = entity.getActualSupplyTime().getTime();
			}
			this.createTime = entity.getCreateTime().getTime();
			this.createUserId = entity.getCreateUserId();
			this.mainDeviceCode = entity.getMainDeviceCode();
			this.mainDeviceId = entity.getMainDeviceId();
			this.mainDeviceName = entity.getMainDeviceName();
			this.powerCutFormId = entity.getPowerCutFormId();
			this.status = entity.getStatus();
			this.updateUserId = entity.getUpdateUserId();
			this.versionTag = entity.getVersionTag();
		}
	
	}
}