package com.dtelec.icmes.account.controller.vo;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResAccountLoginVO {
	@ApiModelProperty(value = "登录权限验证token")
	public String accessToken;
	@ApiModelProperty(value = "员工工号")
	public String employeeId;
	@ApiModelProperty(value = "表示账号是否需要更改密码")
	public boolean changePassword;
	@ApiModelProperty(value = "员工头像路径")
	public String avatar;
	@ApiModelProperty(value = "员工姓名")
	public String name;
	@ApiModelProperty(value = "功能映射map")
	public Map<String, Map<String, Boolean>> features;
	
}
