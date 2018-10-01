package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqChangePasswordVO {
	@ApiModelProperty(value = "原始密码")
	public String orgPassword;
	@ApiModelProperty(value = "新密码")
	public String password;
	@ApiModelProperty(value = "确认密码")
	public String confirmPassword;
	
	
}
