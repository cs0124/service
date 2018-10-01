package com.dtelec.icmes.account.repository.entity;

import java.util.Date;

public class AccountAssignProxyEntity {

	private int id;
	private int assId;
	private String fullOrgName;
	private String roleName;
	private String organizationId;
	private String consignProxyName;
	private Date proxyStartDate;
	private Date proxyEndDate;
	private String periodDays;
	private String consignProxyId;
	private int consignProxyUserId;
	private int roleId;
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

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
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

	public String getConsignProxyName() {
		return consignProxyName;
	}

	public void setConsignProxyName(String consignProxyName) {
		this.consignProxyName = consignProxyName;
	}

	public String getPeriodDays() {
		return periodDays;
	}

	public void setPeriodDays(String periodDays) {
		this.periodDays = periodDays;
	}

	public String getConsignProxyId() {
		return consignProxyId;
	}

	public void setConsignProxyId(String consignProxyId) {
		this.consignProxyId = consignProxyId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	public int getConsignProxyUserId() {
		return consignProxyUserId;
	}

	public void setConsignProxyUserId(int consignProxyUserId) {
		this.consignProxyUserId = consignProxyUserId;
	}
	
}
