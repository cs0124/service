package com.dtelec.icmes.account.service.model;

import java.util.Date;

import com.dtelec.icmes.account.repository.entity.UserProxyAssignmentBaseEntity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 账户接手代理模型
 * @author zturnking
 *
 */
@ApiModel
public class UserProxyAssignmentModel {
	@ApiModelProperty(value = "代理Id")
	private Integer id;
	@ApiModelProperty(value = "接手代理人UserId")
	private Integer assignUserId;
	@ApiModelProperty(value = "指派的代理账号及角色关系流水号")
	private Integer consignUserRoleAss;
	@ApiModelProperty(value = "代理周期")
	private String periodDays;
	@ApiModelProperty(value = "代理开始时间")
	private Long proxyStartDate;
	@ApiModelProperty(value = "代理结束时间")
	private Long proxyEndDate;
	@ApiModelProperty(value = "创建人UserId")
	private Integer createUserId;
	@ApiModelProperty(value = "versionTag")
	private String versionTag;
	@ApiModelProperty(value = "创建时间")
	private Long createTime;
	@ApiModelProperty(value = "更新时间")
	private Long updateTime;	
	@ApiModelProperty(value = "组织机构")
	private String organizationName;
	@ApiModelProperty(value = "角色")
	private String roleName;
	@ApiModelProperty(value = "接手人")
	private String name;
	@ApiModelProperty(value = "指派人employeeId")
	public String assignEmployeeId;
	
	
	public UserProxyAssignmentModel() {
		
	}
	
	
	public UserProxyAssignmentModel(Integer id, Integer assignUserId, Integer consignUserRoleAss, String periodDays,
			Long proxyStartDate, Long proxyEndDate, Integer createUserId, String versionTag, Long createTime,
			Long updateTime, String assignEmployeeId) {
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


	public Long getProxyStartDate() {
		return proxyStartDate;
	}


	public void setProxyStartDate(Long proxyStartDate) {
		this.proxyStartDate = proxyStartDate;
	}


	public Long getProxyEndDate() {
		return proxyEndDate;
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


	public Long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Long updateTime) {
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


	public void setProxyEndDate(Long proxyEndDate) {
		this.proxyEndDate = proxyEndDate;
	}
	
	public String getAssignEmployeeId() {
		return assignEmployeeId;
	}


	public void setAssignEmployeeId(String assignEmployeeId) {
		this.assignEmployeeId = assignEmployeeId;
	}


	public UserProxyAssignmentBaseEntity convert() {
		UserProxyAssignmentBaseEntity entity = new UserProxyAssignmentBaseEntity();
		entity.setAssignUserId(this.assignUserId);
		entity.setConsignUserRoleAss(this.consignUserRoleAss);
		entity.setId(this.id);
		if (this.proxyEndDate > 0) {
			entity.setProxyEndDate(new Date(this.proxyEndDate));
		}
		else {
			entity.setProxyEndDate(null);
		}
		
		if (this.proxyStartDate > 0) {
			entity.setProxyStartDate(new Date(this.proxyStartDate));
		}
		else {
			entity.setProxyStartDate(null);
		}
		entity.setPeriodDays(this.periodDays);
		entity.setVersionTag(this.versionTag);
		entity.setCreateUserId(0);
		if (this.updateTime != null && this.updateTime > 0) {
			entity.setUpdateTime(new Date(this.updateTime));
		}
		else {
			entity.setUpdateTime(null);
		}
		
		return entity;
	}
	
	public void fill(UserProxyAssignmentBaseEntity entity) {
		if(entity != null) {			
			this.assignUserId = entity.getAssignUserId();
			this.consignUserRoleAss = entity.getConsignUserRoleAss();
			this.createTime = entity.getCreateTime().getTime();
			this.createUserId = entity.getCreateUserId();
			this.id = entity.getId();
			this.versionTag= entity.getVersionTag();
			this.periodDays = entity.getPeriodDays();
			Date proxyStartDate = entity.getProxyStartDate();
			this.proxyStartDate = (proxyStartDate == null) ? 0 : proxyStartDate.getTime();
			Date proxyEndDate = entity.getProxyEndDate();
			this.proxyEndDate = (proxyEndDate == null) ? 0 : proxyEndDate.getTime();
			Date updateTime = entity.getUpdateTime();
			this.updateTime = (updateTime == null) ? 0 : updateTime.getTime();
			this.assignEmployeeId = entity.getAssignEmployeeId();
			this.name = entity.getName();
			this.organizationName = entity.getFullOrgName();
			this.roleName = entity.getRoleName();
		}
	}
	
}
