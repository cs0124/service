package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class ReqUserProxyAssignmentVO {
	@ApiModelProperty(value = "代理Id")
	public  int id;		
	@ApiModelProperty(value = "组织机构")
	public String organizationName;
	@ApiModelProperty(value = "角色")
	public String roleName;
	@ApiModelProperty(value = "接手人")
	public String name;
	@ApiModelProperty(value = "代理开始时间")
	public Long startTime;
	@ApiModelProperty(value = "代理结束时间")
	public Long endTime;	
	@ApiModelProperty(value = "代理周期")
	public String cycle;
	
	
}
