package com.dtelec.icmes.account.service.model;

import java.util.Date;

import com.dtelec.icmes.account.repository.entity.AccountConsignProxyEntity;

public class AccountConsignProxyModel {

	private int id;
	private int assId;
	private String fullOrgName;
	private String roleName;
	private String assignProxyName;
	private long proxyStartDate;
	private long proxyEndDate;
	private String periodDays;
	private String assignProxyId;
	private int assignProxyUserId;
	private String roleId;
	private String versionTag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAssId() {
		return assId;
	}

	public void setAssId(int assId) {
		this.assId = assId;
	}

	public String getFullOrgName() {
		return fullOrgName;
	}

	public void setFullOrgName(String fullOrgName) {
		this.fullOrgName = fullOrgName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAssignProxyName() {
		return assignProxyName;
	}

	public void setAssignProxyName(String assignProxyName) {
		this.assignProxyName = assignProxyName;
	}

	public long getProxyStartDate() {
		return proxyStartDate;
	}

	public void setProxyStartDate(long proxyStartDate) {
		this.proxyStartDate = proxyStartDate;
	}

	public long getProxyEndDate() {
		return proxyEndDate;
	}

	public void setProxyEndDate(long proxyEndDate) {
		this.proxyEndDate = proxyEndDate;
	}

	public String getPeriodDays() {
		return periodDays;
	}

	public void setPeriodDays(String periodDays) {
		this.periodDays = periodDays;
	}

	public String getAssignProxyId() {
		return assignProxyId;
	}

	public void setAssignProxyId(String assignProxyId) {
		this.assignProxyId = assignProxyId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	public int getAssignProxyUserId() {
		return assignProxyUserId;
	}

	public void setAssignProxyUserId(int assignProxyUserId) {
		this.assignProxyUserId = assignProxyUserId;
	}

	public void fill(AccountConsignProxyEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.fullOrgName = entity.getFullOrgName();
			this.roleName = entity.getRoleName();
			this.assignProxyName = entity.getAssignProxyName();
			Date proxyStartDate = entity.getProxyStartDate();
			this.proxyStartDate = (proxyStartDate == null) ? 0 : proxyStartDate.getTime();
			Date proxyEndDate = entity.getProxyEndDate();
			this.proxyEndDate = (proxyEndDate == null) ? 0 : proxyEndDate.getTime();
			this.periodDays = entity.getPeriodDays();
			this.assignProxyId = entity.getAssignProxyId();
			this.roleId = entity.getRoleId();
			this.versionTag = entity.getVersionTag();
			this.assId = entity.getAssId();
			this.assignProxyUserId = entity.getAssignProxyUserId();
		}
	}

}
