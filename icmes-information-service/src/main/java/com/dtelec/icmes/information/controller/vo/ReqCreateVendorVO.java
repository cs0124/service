package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqCreateVendorVO {
	
	@ApiModelProperty(value = "供应商编号" )
	public String code;
	@ApiModelProperty(value = "供应商名称" )
	public String name;
	@ApiModelProperty(value = "供应商地址" )
	public String address;
	@ApiModelProperty(value = "联系人姓名1" )
	public String contactName1;
	@ApiModelProperty(value = "联系人电话1" )
	public String contactPhone1;
	@ApiModelProperty(value = "联系人姓名2" )
	public String contactName2;
	@ApiModelProperty(value = "联系人电话2" )
	public String contactPhone2;
	@ApiModelProperty(value = "联系人姓名3" )
	public String contactName3;
	@ApiModelProperty(value = "联系人电话3" )
	public String contactPhone3;
}
