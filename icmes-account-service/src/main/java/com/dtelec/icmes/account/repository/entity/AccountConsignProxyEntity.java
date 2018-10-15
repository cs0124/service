package com.dtelec.icmes.account.repository.entity;

import java.util.Date;
/**
 * 账号委托代理实体
 * @author zturnking
 *
 */
public class AccountConsignProxyEntity {
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
	 * 组织机构id
	 */
	private String organizationId;
	/**
	 * 角色姓名
	 */
	private String roleName;
	/**
	 * 接手代理人姓名
	 */
	private String assignProxyName;
	/**
	 * 代理开始时间
	 */
	private Date proxyStartDate;
	/**
	 * 代理结束时间
	 */
	private Date proxyEndDate;
	/**
	 * 持续时间
	 */
	private String periodDays;
	/**
	 * 接手代理id
	 */
	private String assignProxyId;
	/**
	 * 接手代理人id
	 */
	private int assignProxyUserId;
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
