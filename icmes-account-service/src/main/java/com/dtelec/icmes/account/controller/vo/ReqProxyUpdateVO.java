package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqProxyUpdateVO extends ReqProxyAddVO {	
	@ApiModelProperty(value = "versionTag")
	public String versionTag;
}
