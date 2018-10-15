package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqCreateLocationVO {
	@ApiModelProperty(value = "位置编码")
	public String code;
	@ApiModelProperty(value = "位置名称")
	public String name;
	@ApiModelProperty(value = "父层级关系")
	public int parentId;
}
