package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqAccountLoginVO {

	@ApiModelProperty(value = "员工工号")
	public String employeeId;
	@ApiModelProperty(value = "登录密码")
	public String password;
	
}
