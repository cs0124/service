package com.dtelec.icmes.information.controller.vo;

import java.util.List;

import com.dtelec.icmes.information.service.model.OrganizationAccountModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResOrganizationAccountVO {
	
	@ApiModelProperty(value = "返回数据数组")
	public List<OrganizationAccountModel> items;
	
}
