package com.dtelec.icmes.account.controller.vo;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqCreateRoleVO {
	@ApiModelProperty(value = "角色id")
	public String id;
	@ApiModelProperty(value = "角色名称")
	public String name;
	@ApiModelProperty(value = "角色描述")
	public String remark;
	@ApiModelProperty(value = "角色权限")
	public List<String> features;
	
	public void fill(ReqUpdateRoleVO vo) {
		this.id = vo.id;
		this.name = vo.name;
		this.remark = vo.remark;
		this.features = vo.features;
	}
}
