package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class ReqCreateAccountVO {
	@ApiModelProperty(value = "员工工号")
	public String id;
	@ApiModelProperty(value = "员工名称")
	public String name;
	@ApiModelProperty(value = "专用设备")
	public String specialDevice;
}
