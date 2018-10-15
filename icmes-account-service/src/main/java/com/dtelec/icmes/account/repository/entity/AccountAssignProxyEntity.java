package com.dtelec.icmes.account.repository.entity;

import java.util.Date;
/**
 * 账号委托代理实体类
 * @author zturnking
 *
 */
public class AccountAssignProxyEntity {
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
	 * 角色名字
	 */
	private String roleName;
	/**
	 * 组织机构id
	 */
	private String organizationId;
	/**
	 * 委托人姓名
	 */
	private String consignProxyName;
	/**
	 * 代理开始日期
	 */
	private Date proxyStartDate;
	/**
	 * 代理结束日期
	 */
	private Date proxyEndDate;
	/**
	 * 持续时间
	 */
	private String periodDays;
	/**
	 * 委托人id
	 */
	private String consignProxyId;
	/**
	 * 委托代理id
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

	public int getConsignProxyUserId() {
		return consignProxyUserId;
	}

	public void setConsignProxyUserId(int consignProxyUserId) {
		this.consignProxyUserId = consignProxyUserId;
	}
	
}
