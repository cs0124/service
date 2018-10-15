package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 代理返回
 * @author hlxu
 */
@ApiModel
public class ResUserProxyAssignmentVO {
	/**
	 * 代理Id
	 */
	@ApiModelProperty(value = "代理Id")
	public  int id;	
	/** 
	 * 组织机构
	 */	
	@ApiModelProperty(value = "组织机构")
	public String organizationName;
	/**
	 * 角色
	 */
	@ApiModelProperty(value = "角色")
	public String roleName;
	/**
	 * 接手人
	 */
	@ApiModelProperty(value = "接手人")
	public String name;
	/**
	 * 代理开始时间
	 */
	@ApiModelProperty(value = "代理开始时间")
	public Long startTime;
	/**
	 * 代理结束时间
	 */
	@ApiModelProperty(value = "代理结束时间")
	public Long endTime;	
	/**
	 * 代理周期
	 */
	@ApiModelProperty(value = "代理周期")
	public String cycle;
	/**
	 * 版本标签
	 */
	@ApiModelProperty(value = "版本标签")
	public String versionTag;
	/**
	 * 指派人Id
	 */
	@ApiModelProperty(value = "指派人Id")
	public Integer assignUserId;
	/**
	 * 指派的代理账号及角色关系流水号
	 */
	@ApiModelProperty(value = "指派的代理账号及角色关系流水号")
	public Integer consignUserRoleAss;
	/**
	 * 当前指派人EmployeeId
	 */
	@ApiModelProperty(value = "指派人employeeId")
	public String assignEmployeeId;
	
}
