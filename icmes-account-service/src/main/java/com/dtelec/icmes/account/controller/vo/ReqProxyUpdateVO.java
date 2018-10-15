package com.dtelec.icmes.account.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 权限编辑请求
 * @author zturnking
 *
 */
@ApiModel
public class ReqProxyUpdateVO extends ReqProxyAddVO {	
	/**
	 * 版本控制
	 */
	@ApiModelProperty(value = "versionTag")
	public String versionTag;
}
