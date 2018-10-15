package com.dtelec.icmes.account.controller.vo;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 角色编辑请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqUpdateRoleVO {
	/**
	 * 角色id
	 */
	@ApiModelProperty(value = "角色id")
	public String id;
	/**
	 * 角色名称
	 */
	@ApiModelProperty(value = "角色名称")
	public String name;
	/**
	 * 角色描述
	 */
	@ApiModelProperty(value = "角色描述")
	public String remark;
	/**
	 * 版本控制
	 */
	@ApiModelProperty(value = "版本控制")
	public String versionTag;
	/**
	 * 角色权限
	 */
	@ApiModelProperty(value = "角色权限")
	public List<String> features;
}
