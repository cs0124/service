package com.dtelec.icmes.power.repository.entity;

import java.util.Date;

public class PowerSupplyFormBaseEntity {

	/**
	 * 送电申请单号
	 */
	private String id;
	
	/**
	 * 关联的停电申请单单号
	 */
	private String powerCutFormId;
	
	/**
	 * 送电申请单状态
	 */
	private String status;
	
	/**
	 * 实际送电时间
	 */
	private Date actualSupplyTime;

	/**
	 * 用于高并发的数据版本控制
	 */
	private String versionTag;
	
	/**
	 * 停电申请单创建时间
	 */
	private Date createTime;
	
	/**
	 * 申请人标识符
	 */
	private int createUserId;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 更新表单的账号标识
	 */
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

	public Date getActualSupplyTime() {
		return actualSupplyTime;
	}

	public void setActualSupplyTime(Date actualSupplyTime) {
		this.actualSupplyTime = actualSupplyTime;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}


	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
