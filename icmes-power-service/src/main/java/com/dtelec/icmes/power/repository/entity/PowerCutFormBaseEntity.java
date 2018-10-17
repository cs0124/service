package com.dtelec.icmes.power.repository.entity;

import java.util.Date;


/**
 * 账号实体类
 * @author zturnking
 *
 */
public class PowerCutFormBaseEntity {
	/**
	 * 停电申请单号
	 */
	private String id;
	
	/**
	 * 停电申请单状态
	 */
	private String status;
	
	/**
	 * 停电申请单类型
	 */	
	private String type;
	
	/**
	 * 停电申请单理由
	 */	
	private String reason;
	
	/**
	 * 计划停电时间
	 */
	private Date scheduledSupplyTime;
	
	/**
	 * 计划供电时间
	 */
	private Date scheduledCutOffTime;
	
	/**
	 * 实际停电时间
	 */
	private Date actualCutOffTime;
	
	/**
	 * 设备标识符
	 */
	private int mainDeviceId;

	/**
	 * 专业措施
	 */
	private String measures;
	
	/**
	 * 用于高并发的数据版本控制
	 */
	private String versionTag;
	
	/**
	 * 停电申请单创建时间
	 */
	private Date createTime;
	
	/**
	 * 申请人
	 */
	private int createUserId;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 更新人
	 */
	private int updateUserId;
	
	

	public PowerCutFormBaseEntity() {
		// TODO Auto-generated constructor stub
	}

	

	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getStatus() {
		return this.status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getType() {
		return this.type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getReason() {
		return this.reason;
	}
	
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	public Date getScheduledCutOffTime() {
		return this.scheduledCutOffTime;
	}
	
	
	public void setScheduledCutOffTime(Date scheduledCutOffTime) {
		this.scheduledCutOffTime = scheduledCutOffTime;
	}
	
	
	public Date getScheduledSupplyTime() {
		return this.scheduledSupplyTime;
	}
	
	
	public void setScheduledSupplyTime(Date scheduledSupplyTime) {
		this.scheduledSupplyTime = scheduledSupplyTime;
	}
	
	public Date getActualCutOffyTime() {
		return this.actualCutOffTime;
	}
	
	
	public void setActualCutOffyTime(Date actualCutOffTime) {
		this.actualCutOffTime = actualCutOffTime;
	}
	
	
	public int getMainDeviceId() {
		return this.mainDeviceId;
	}
	
	
	public void setMainDeviceId(int mainDeviceId) {
		this.mainDeviceId = mainDeviceId;
	}
	
	
	public String getMeasures() {
		return this.measures;
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
	
	
	public Date getCreateTime() {
		return createTime;
	}

	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public int getCreateUserId() {
		return createUserId;
	}
	
	
	public void setCreateUserId(Integer createUserId) {
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
	
	
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	

}
