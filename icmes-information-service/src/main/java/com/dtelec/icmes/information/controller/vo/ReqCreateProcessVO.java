package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建工艺模型
 *
 */
@ApiModel
public class ReqCreateProcessVO {

	@ApiModelProperty(value = "工艺编码")
	/**工艺编码*/
	public String code;
	@ApiModelProperty(value = "工艺名称")
	/**工艺名称*/
	public String name;
	
}
