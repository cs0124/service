package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResLocationsVO<T> {
	@ApiModelProperty(value = "表示数据总数")
	public long totalCount;
	@ApiModelProperty(value = "表示数据的总页数")
	public long totalPages;
}