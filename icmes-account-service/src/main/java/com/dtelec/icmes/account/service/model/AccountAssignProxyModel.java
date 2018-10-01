package com.dtelec.icmes.account.service.model;

import java.util.Date;

import com.dtelec.icmes.account.repository.entity.AccountAssignProxyEntity;

public class AccountAssignProxyModel {
	private int id;
	private int assId;
	private String fullOrgName;
	private String roleName;
	private String organizationId;
	private String consignProxyName;
	private long proxyStartDate;
	private long proxyEndDate;
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

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public int getConsignProxyUserId() {
		return consignProxyUserId;
	}

	public void setConsignProxyUserId(int consignProxyUserId) {
		this.consignProxyUserId = consignProxyUserId;
	}

	public void fill(AccountAssignProxyEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.fullOrgName = entity.getFullOrgName();
			this.roleName = entity.getRoleName();
			this.organizationId = entity.getOrganizationId();
			this.consignProxyName = entity.getConsignProxyName();
			Date proxyStartDate = entity.getProxyStartDate();
			this.proxyStartDate = (proxyStartDate == null) ? 0 : proxyStartDate.getTime();
			Date proxyEndDate = entity.getProxyEndDate();
			this.proxyEndDate = (proxyEndDate == null) ? 0 : proxyEndDate.getTime();
			this.periodDays = entity.getPeriodDays();
			this.consignProxyId = entity.getConsignProxyId();
			this.roleId = entity.getRoleId();
			this.versionTag = entity.getVersionTag();
			this.assId = entity.getAssId();
			this.consignProxyUserId = entity.getConsignProxyUserId();
		}
	}

}
