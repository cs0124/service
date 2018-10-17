package com.dtelec.icmes.power.service.model;


import java.sql.Date;

import com.dtelec.icmes.power.repository.entity.PowerDelayFormBaseEntity;

import io.swagger.annotations.ApiModelProperty;

public class PowerDelayFormBaseModel {

	/**
	 * 延迟送电申请单号
	 */
	@ApiModelProperty(value = "延迟送电申请单号")
	private String id;
	
	/**
	 * 关联的停电申请单单号
	 */
	@ApiModelProperty(value = "关联的停电申请单单号")
	private String powerCutFormId;
	
	/**
	 * 延迟送电申请单状态
	 */
	@ApiModelProperty(value = "延迟送电申请单状态")
	private String status;
	
	/**
	 * 延迟送电的计划送电时间
	 */
	@ApiModelProperty(value = "延迟送电的计划送电时间")
	private long scheduledDelaySupplyTime;

	/**
	 * 用于高并发的数据版本控制
	 */
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	
	/**
	 * 延迟送电申请单创建时间
	 */
	@ApiModelProperty(value = "延迟送电申请单创建时间")
	private long createTime;
	
	/**
	 * 申请人标识符
	 */
	@ApiModelProperty(value = "申请人标识符")
	private int createUserId;

	/**
	 * 延迟送电申请单修改时间
	 */
	@ApiModelProperty(value = "延迟送电申请单修改时间")
	private long updateTime;
	
	/**
	 * 修改人
	 */
	@ApiModelProperty(value = "修改人")
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

	public long getScheduledDelaySupplyTime() {
		return scheduledDelaySupplyTime;
	}

	public void setScheduledDelaySupplyTime(long scheduledDelaySupplyTime) {
		this.scheduledDelaySupplyTime = scheduledDelaySupplyTime;
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
	
	public void fill(PowerDelayFormBaseEntity entity) {
		this.id = entity.getId();
		this.powerCutFormId = entity.getPowerCutFormId();
		this.status = entity.getStatus();
		this.scheduledDelaySupplyTime = entity.getScheduledDelaySupplyTime().getTime();
		this.versionTag = entity.getVersionTag();
		this.createTime = entity.getCreateTime().getTime();
		this.createUserId = entity.getCreateUserId();
		this.updateTime = entity.getUpdateTime().getTime();
		this.updateUserId = entity.getUpdateUserId();
	}
	
	public PowerDelayFormBaseEntity convert() {
		PowerDelayFormBaseEntity entity = new PowerDelayFormBaseEntity();
		entity.setId(this.id);
		entity.setPowerCutFormId(this.powerCutFormId);
		entity.setStatus(this.status);
		entity.setScheduledDelaySupplyTime(new Date(scheduledDelaySupplyTime));
		entity.setVersionTag(this.versionTag);
		entity.setCreateTime(new Date(createTime));
		entity.setCreateUserId(this.createUserId);
		entity.setUpdateTime(new Date(updateTime));
		entity.setUpdateUserId(this.updateUserId);
		
		return entity;
	}
}
