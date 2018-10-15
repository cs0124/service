package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 新增权限请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqProxyAddVO {	
	/**
	 * 接手代理人UserId
	 */
	@ApiModelProperty(value = "接手代理人UserId")
	public Integer assignUserId;
	/**
	 * 指派的代理账号及角色关系流水号
	 */
	@ApiModelProperty(value = "指派的代理账号及角色关系流水号")
	public Integer consignUserRoleAss;
	/**
	 * 代理开始时间
	 */
	@ApiModelProperty(value = "代理开始时间")
	public Long proxyStartDate;
	/**
	 * 代理结束时间
	 */
	@ApiModelProperty(value = "代理结束时间")
	public Long proxyEndDate;
	/**
	 * 代理周期
	 */
	@ApiModelProperty(value = "代理周期")
	public String periodDays;

	

}
