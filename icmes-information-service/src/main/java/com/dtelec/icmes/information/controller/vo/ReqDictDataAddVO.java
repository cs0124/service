package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqDictDataAddVO {
	@ApiModelProperty(value = "字典编码")
	public String code;
	@ApiModelProperty(value = "字典名称")
	public String name;	
	@ApiModelProperty(value = "排序")
	public Integer order;
	@ApiModelProperty(value = "字典类型")
	public String typeCode;
	
}
