package com.dtelec.icmes.account.repository.entity;

import java.util.Date;

public class AccountConsignProxyEntity {

	private int id;
	private int assId;
	private String fullOrgName;
	private String organizationId;
	private String roleName;
	private String assignProxyName;
	private Date proxyStartDate;
	private Date proxyEndDate;
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

	public Date getProxyStartDate() {
		return proxyStartDate;
	}

	public void setProxyStartDate(Date proxyStartDate) {
		this.proxyStartDate = proxyStartDate;
	}

	public Date getProxyEndDate() {
		return proxyEndDate;
	}

	public void setProxyEndDate(Date proxyEndDate) {
		this.proxyEndDate = proxyEndDate;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
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

}
