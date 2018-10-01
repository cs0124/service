package com.dtelec.icmes.account.repository.entity;

import java.util.Date;
/**
 * 指派代理fullEntity
 * @author dell
 *
 */

public class UserProxyAssignmentFullEntity {
	
	private Integer id;
	private Integer assignUserId;
	private Integer consignUserRoleAss;
	private String periodDays;
	private Date proxyStartDate;
	private Date proxyEndDate;
	private Integer createUserId;
	private String versionTag;
	private Date createTime;
	private Date updateTime;
	private String organizationName;
	private String roleName;
	private String name;
	 
	
	public UserProxyAssignmentFullEntity(){
		
	}


	public UserProxyAssignmentFullEntity(Integer id, Integer assignUserId, Integer consignUserRoleAss,
			String periodDays, Date proxyStartDate, Date proxyEndDate, Integer createUserId, String versionTag,
			Date createTime, Date updateTime, String organizationName, String roleName, String name) {
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
		this.organizationName = organizationName;
		this.roleName = roleName;
		this.name = name;
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


	public String getOrganizationName() {
		return organizationName;
	}


	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
