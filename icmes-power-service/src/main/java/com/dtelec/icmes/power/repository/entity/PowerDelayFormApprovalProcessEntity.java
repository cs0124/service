package com.dtelec.icmes.power.repository.entity;

import java.util.Date;

public class PowerDelayFormApprovalProcessEntity {
	/**
	 * 标识符
	 */
	private Integer id;
	
	/**
	 * 延时送电申请单标识符id
	 */
	private String powerDelayFormId;
	
	/**
	 * 批准是否延时送电
	 */
	private boolean isApproved;
	
	/**
	 * 审批说明
	 */
	private String approvalComment;
	
	/**
	 * 审批时间
	 */
	private Date approvalTime;
	
	/**
	 * 审批人编号
	 */
	private Integer approvalUserId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPowerDelayFormId() {
		return powerDelayFormId;
	}

	public void setPowerDelayFormId(String powerDelayFormId) {
		this.powerDelayFormId = powerDelayFormId;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getApprovalComment() {
		return approvalComment;
	}

	public void setApprovalComment(String approvalComment) {
		this.approvalComment = approvalComment;
	}

	public Date getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public Integer getApprovalUserId() {
		return approvalUserId;
	}

	public void setApprovalUserId(Integer approvalUserId) {
		this.approvalUserId = approvalUserId;
	}
}
