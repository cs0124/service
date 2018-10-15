package com.dtelec.icmes.information.controller.vo;

import org.apache.commons.codec.language.bm.Lang;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqUpdateLocationVO {
	@ApiModelProperty(value = "位置编码")
	public String code;
	@ApiModelProperty(value = "位置名称")
	public String name;
	@ApiModelProperty(value = "父层级关系")
	public int parentId;
	@ApiModelProperty(value = "修改时间")
	public Lang updateTime;
	@ApiModelProperty(value = "版本标识")
	public String versionTag;
	
}
