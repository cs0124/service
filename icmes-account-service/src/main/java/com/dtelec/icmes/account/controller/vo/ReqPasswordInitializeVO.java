package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 初始化密码请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqPasswordInitializeVO {
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	public String password;
	/**
	 * 确认密码
	 */
	@ApiModelProperty(value = "确认密码")
	public String confirmPassword;
	
}
