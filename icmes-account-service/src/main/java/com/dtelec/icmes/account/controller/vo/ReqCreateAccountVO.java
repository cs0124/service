package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建账户请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqCreateAccountVO {
	/**
	 * 员工工号
	 */
	@ApiModelProperty(value = "员工工号")
	public String id;
	/**
	 * 员工名称
	 */
	@ApiModelProperty(value = "员工名称")
	public String name;
	/**
	 * 专用设备
	 */
	@ApiModelProperty(value = "专用设备")
	public String specialDevice;
}
