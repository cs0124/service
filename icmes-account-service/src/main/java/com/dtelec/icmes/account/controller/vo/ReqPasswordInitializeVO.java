package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqPasswordInitializeVO {
	@ApiModelProperty(value = "密码")
	public String password;
	@ApiModelProperty(value = "确认密码")
	public String confirmPassword;
	
}
