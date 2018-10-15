package com.dtelec.icmes.information.controller.vo;

import java.util.List;

import com.dtelec.icmes.information.service.model.OrganizationAccountTreeModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResOrganizationAccountTreeVO {
	
	@ApiModelProperty(value = "返回数据数组")
	public List<OrganizationAccountTreeModel> items;
	
}
