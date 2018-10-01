package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqDictTypeAddVO {
	@ApiModelProperty(value = "字典类型code")
	public String code;
	@ApiModelProperty(value = "字典类型名称")
	public String name;	
	
}
