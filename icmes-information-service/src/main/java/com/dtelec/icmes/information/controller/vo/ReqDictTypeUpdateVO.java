package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqDictTypeUpdateVO extends  ReqDictTypeAddVO {
	@ApiModelProperty(value = "版本控制")
	public String versionTag;

	
}
