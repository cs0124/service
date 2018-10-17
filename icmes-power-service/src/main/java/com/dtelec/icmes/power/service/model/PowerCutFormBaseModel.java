package com.dtelec.icmes.power.service.model;


import java.util.Date;

import com.dtelec.icmes.power.repository.entity.PowerCutFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormFullEntity;

import io.swagger.annotations.ApiModelProperty;

public class PowerCutFormBaseModel {
	/**
	 * 停电申请单号
	 */
	@ApiModelProperty(value = "停电申请单号")
	private String id;
	
	/**
	 * 停电申请单状态
	 */
	@ApiModelProperty(value = "停电申请单状态")
	private String status;
	
	/**
	 * 停电申请单类型
	 */
	@ApiModelProperty(value = "停电申请单类型")
	private String type;
	
	/**
	 * 停电申请单理由
	 */
	@ApiModelProperty(value = "停电申请单理由")
	private String reason;
	
	/**
	 * 计划供电时间
	 */
	@ApiModelProperty(value = "计划供电时间")
	private long scheduledSupplyTime;
	
	/**
	 * 计划停电时间
	 */
	@ApiModelProperty(value = "计划停电时间")
	private long scheduledCutOffTime;
	
	/**
	 * 实际停电时间
	 */
	@ApiModelProperty(value = "实际停电时间")
	private long actualCutOffTime;
	
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
	 * 专业措施
	 */
	@ApiModelProperty(value = "专业措施")
	private String measures;
	
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
	 * 停电申请单修改时间
	 */
	@ApiModelProperty(value = "停电申请单创建时间")
	private long updateTime;
	
	/**
	 * 申请人
	 */
	@ApiModelProperty(value = "修改人")
	private int updateUserId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getScheduledSupplyTime() {
		return scheduledSupplyTime;
	}

	public void setScheduledSupplyTime(long scheduledSupplyTime) {
		this.scheduledSupplyTime = scheduledSupplyTime;
	}

	public long getScheduledCutOffTime() {
		return scheduledCutOffTime;
	}

	public void setScheduledCutOffTime(long scheduledCutOffTime) {
		this.scheduledCutOffTime = scheduledCutOffTime;
	}

	public long getActualCutOffTime() {
		return actualCutOffTime;
	}

	public void setActualCutOffTime(long actualCutOffTime) {
		this.actualCutOffTime = actualCutOffTime;
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

	public String getMeasures() {
		return measures;
	}

	public void setMeasures(String measures) {
		this.measures = measures;
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

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public int getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}

	public void fillFullEntity(PowerCutFormFullEntity entity) {
		this.id = entity.getId();
		this.status = entity.getStatus();
		this.type = entity.getType();
		this.reason = entity.getReason();
		this.scheduledSupplyTime = entity.getScheduledSupplyTime().getTime();
		this.scheduledCutOffTime = entity.getScheduledCutOffTime().getTime();
		this.actualCutOffTime = entity.getActualCutOffyTime().getTime();
		this.mainDeviceId = entity.getMainDeviceId();
		this.mainDeviceCode = entity.getMainDeviceCode();
		this.mainDeviceName = entity.getMainDeviceName();
		this.versionTag = entity.getVersionTag();
		this.measures = entity.getMeasures();
		this.createTime = entity.getCreateTime().getTime();
		this.createUserId = entity.getCreateUserId();
		this.updateTime = entity.getUpdateTime().getTime();
		this.updateUserId = entity.getUpdateUserId();
		
		
	}
	
	
	public void fill(PowerCutFormBaseEntity entity) {
		this.id = entity.getId();
		this.status = entity.getStatus();
		this.type = entity.getType();
		this.reason = entity.getReason();
		this.scheduledSupplyTime = entity.getScheduledSupplyTime().getTime();
		this.scheduledCutOffTime = entity.getScheduledCutOffTime().getTime();
		
	} 
	public PowerCutFormBaseEntity convert() {
		PowerCutFormBaseEntity entity = new PowerCutFormBaseEntity();
		entity.setId(this.id);
		entity.setStatus(this.status);
		entity.setType(this.type);
		entity.setReason(this.reason);
		entity.setScheduledSupplyTime(new Date(this.scheduledSupplyTime));
		entity.setScheduledCutOffTime(new Date(this.scheduledCutOffTime));
		entity.setActualCutOffyTime(new Date(this.actualCutOffTime));
		entity.setMainDeviceId(this.mainDeviceId);
		entity.setMeasures(this.measures);
		entity.setVersionTag(this.versionTag);		
		entity.setCreateUserId(this.createUserId);
		entity.setUpdateUserId(this.updateUserId);
	
		
		return entity;
	}

}
