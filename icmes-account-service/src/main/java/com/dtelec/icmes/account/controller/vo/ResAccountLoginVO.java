package com.dtelec.icmes.account.controller.vo;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 登陆返回
 * @author zturnking
 *
 */
@ApiModel
public class ResAccountLoginVO {
	/**
	 * token
	 */
	@ApiModelProperty(value = "登录权限验证token")
	public String accessToken;
	/**
	 * 员工工号
	 */
	@ApiModelProperty(value = "员工工号")
	public String employeeId;
	/**
	 * 表示账号是否需要更改密码
	 */
	@ApiModelProperty(value = "表示账号是否需要更改密码")
	public boolean changePassword;
	/**
	 * 员工头像路径
	 */
	@ApiModelProperty(value = "员工头像路径")
	public String avatar;
	/**
	 * 员工姓名
	 */
	@ApiModelProperty(value = "员工姓名")
	public String name;
	/**
	 * 员工所属部门
	 */
	@ApiModelProperty(value = "员工所属部门")
	public String organization;
	/**
	 * 专用设备号
	 */
	@ApiModelProperty(value = "专用设备号")
	public String specialDevice;
	/**
	 * 功能映射map
	 */
	@ApiModelProperty(value = "功能映射map")
	public Map<String, Map<String, Boolean>> features;
	
}
