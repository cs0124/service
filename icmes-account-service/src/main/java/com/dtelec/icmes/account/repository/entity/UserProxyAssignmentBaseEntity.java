package com.dtelec.icmes.account.repository.entity;

import java.util.Date;
/**
 * 指派代理BaseEntity
 * @author dell
 *
 */

public class UserProxyAssignmentBaseEntity {
	
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 接手人id
	 */
	private Integer assignUserId;
	/**
	 * 委托人角色权限关系id
	 */
	private Integer consignUserRoleAss;
	/**
	 * 持续时间
	 */
	private String periodDays;
	/**
	 * 代理开始时间
	 */
	private Date proxyStartDate;
	/**
	 * 代理结束时间
	 */
	private Date proxyEndDate;
	/**
	 * 创建用户ID
	 */
	private Integer createUserId;
	/**
	 * 版本控制
	 */
	private String versionTag;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 委托人employeeId
	 * **/
	private String assignEmployeeId;
	/**
	 * 委托人名称
	 * **/
	private String name;
	/**
	 * 组织机构名称
	 * **/
	private String fullOrgName;
	/**
	 * 角色名称
	 * **/
	private String roleName;
	
	
	public UserProxyAssignmentBaseEntity() {
		
	}
	
	
	public UserProxyAssignmentBaseEntity(Integer id, Integer assignUserId, Integer consignUserRoleAss, String periodDays,
			Date proxyStartDate, Date proxyEndDate, Integer createUserId, String versionTag, Date createTime,
			Date updateTime, String assignEmployeeId) {
		super();
		this.id = id;
		this.assignUserId = assignUserId;
		this.consignUserRoleAss = consignUserRoleAss;
		this.periodDays = periodDays;
		this.proxyStartDate = proxyStartDate;
		this.proxyEndDate = proxyEndDate;
		this.createUserId = createUserId;
		this.versionTag = versionTag;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.assignEmployeeId = assignEmployeeId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAssignUserId() {
		return assignUserId;
	}


	public void setAssignUserId(Integer assignUserId) {
		this.assignUserId = assignUserId;
	}


	public Integer getConsignUserRoleAss() {
		return consignUserRoleAss;
	}


	public void setConsignUserRoleAss(Integer consignUserRoleAss) {
		this.consignUserRoleAss = consignUserRoleAss;
	}


	public String getPeriodDays() {
		return periodDays;
	}


	public void setPeriodDays(String periodDays) {
		this.periodDays = periodDays;
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


	public Integer getCreateUserId() {
		return createUserId;
	}


	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
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


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getAssignEmployeeId() {
		return assignEmployeeId;
	}


	public void setAssignEmployeeId(String assignEmployeeId) {
		this.assignEmployeeId = assignEmployeeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
	
	
	

}
