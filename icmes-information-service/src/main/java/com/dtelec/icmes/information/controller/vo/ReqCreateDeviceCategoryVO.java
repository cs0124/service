package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建设备类型模型
 * @author schi
 *
 */
@ApiModel
public class ReqCreateDeviceCategoryVO {

	@ApiModelProperty(value = "设备类型编号")
	public String code;
	@ApiModelProperty(value = "设备类型名称")
	public String name;
	@ApiModelProperty(value = "设备类型是否是主设备大类 true - 是主设备大类  false - 是附属设备大类")
	public boolean isPrimary;
	@ApiModelProperty(value = "设备参数ids")
	public int[] specDataIds;
	
}
