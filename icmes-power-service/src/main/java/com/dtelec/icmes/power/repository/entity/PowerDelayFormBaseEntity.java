package com.dtelec.icmes.power.repository.entity;


import java.sql.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 延迟送电申请单实体类
 * @author Shaoyi Chen
 *
 */
public class PowerDelayFormBaseEntity {

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
	private Date scheduledDelaySupplyTime;

	/**
	 * 用于高并发的数据版本控制
	 */
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	
	/**
	 * 延迟送电申请单创建时间
	 */
	@ApiModelProperty(value = "延迟送电申请单创建时间")
	private Date createTime;
	
	/**
	 * 申请人
	 */
	@ApiModelProperty(value = "申请人")
	private int createUserId;

	/**
	 * 延迟送电申请单修改时间
	 */
	@ApiModelProperty(value = "延迟送电申请单修改时间")
	private Date updateTime;
	
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

	public Date getScheduledDelaySupplyTime() {
		return scheduledDelaySupplyTime;
	}

	public void setScheduledDelaySupplyTime(Date scheduledDelaySupplyTime) {
		this.scheduledDelaySupplyTime = scheduledDelaySupplyTime;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}
}
