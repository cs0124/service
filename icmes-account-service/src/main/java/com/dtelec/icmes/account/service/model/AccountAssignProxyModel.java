package com.dtelec.icmes.account.service.model;

import java.util.Date;

import com.dtelec.icmes.account.repository.entity.AccountAssignProxyEntity;
/**
 * 账号代理关系模型
 * @author zturnking
 *
 */
public class AccountAssignProxyModel {
	/**
	 * id
	 */
	private int id;
	/**
	 * 关系id
	 */
	private int assId;
	/**
	 * 组织机构全称
	 */
	private String fullOrgName;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 组织机构id
	 */
	private String organizationId;
	/**
	 * 委托代理名称
	 */
	private String consignProxyName;
	/**
	 * 代理开始时间
	 */
	private long proxyStartDate;
	/**
	 * 代理结束时间
	 */
	private long proxyEndDate;
	/**
	 * 持续时间
	 */
	private String periodDays;
	/**
	 * 委托代理id
	 */
	private String consignProxyId;
	/**
	 * 委托人id
	 */
	private int consignProxyUserId;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 版本控制
	 */
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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
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
