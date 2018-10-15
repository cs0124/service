package com.dtelec.icmes.account.controller.vo;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 创建角色请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqCreateRoleVO {
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
	 * 角色权限列表
	 */
	@ApiModelProperty(value = "角色权限")
	public List<String> features;
	/**
	 * 实体类填充
	 * @param vo
	 */
	public void fill(ReqUpdateRoleVO vo) {
		this.id = vo.id;
		this.name = vo.name;
		this.remark = vo.remark;
		this.features = vo.features;
	}
}
