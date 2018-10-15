package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 账号登陆请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqAccountLoginVO {
	/**
	 * 员工工号
	 */
	@ApiModelProperty(value = "员工工号")
	public String employeeId;
	/**
	 * 登陆密码
	 */
	@ApiModelProperty(value = "登录密码")
	public String password;
	
}
