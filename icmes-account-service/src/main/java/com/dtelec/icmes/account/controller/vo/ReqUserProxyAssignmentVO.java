package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 接手代理请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqUserProxyAssignmentVO {
	/**
	 * 代理id
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
	
	
}
