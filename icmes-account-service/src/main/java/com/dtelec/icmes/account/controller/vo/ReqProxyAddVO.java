package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqProxyAddVO {	
	@ApiModelProperty(value = "接手代理人UserId")
	public Integer assignUserId;
	@ApiModelProperty(value = "指派的代理账号及角色关系流水号")
	public Integer consignUserRoleAss;
	@ApiModelProperty(value = "代理开始时间")
	public Long proxyStartDate;
	@ApiModelProperty(value = "代理结束时间")
	public Long proxyEndDate;
	@ApiModelProperty(value = "代理周期")
	public String periodDays;

	

}
