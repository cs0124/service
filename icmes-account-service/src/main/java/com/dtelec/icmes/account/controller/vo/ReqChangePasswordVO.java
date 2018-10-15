package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 修改密码请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqChangePasswordVO {
	/**
	 * 原始密码
	 */
	@ApiModelProperty(value = "原始密码")
	public String orgPassword;
	/**
	 * 新密码
	 */
	@ApiModelProperty(value = "新密码")
	public String password;
	/**
	 * 确认密码
	 */
	@ApiModelProperty(value = "确认密码")
	public String confirmPassword;
	
}
