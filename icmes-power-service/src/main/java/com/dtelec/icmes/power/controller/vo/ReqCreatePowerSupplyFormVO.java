package com.dtelec.icmes.power.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建送电申请单VO
 * @author schi
 *
 */
@ApiModel
public class ReqCreatePowerSupplyFormVO {

	@ApiModelProperty(value="停电申请表单标识符")
	public String powerCutFormId;
	
}
