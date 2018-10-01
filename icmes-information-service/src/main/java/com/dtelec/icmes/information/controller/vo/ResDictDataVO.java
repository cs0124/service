package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResDictDataVO {
	@ApiModelProperty(value = "字典编码")
	private String code;
	@ApiModelProperty(value = "字典类型")
	private String name;
	@ApiModelProperty(value = "排序")
	private String order;
	@ApiModelProperty(value = "是否启用")
	private boolean disabled;
	@ApiModelProperty(value = "更新人")
	private String lastUpdateUser;	
	@ApiModelProperty(value = "更新时间")
	private Long LastUpdateTime;
	@ApiModelProperty(value = "控制版本")
	private String versionTag;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLastUpdateTime() {
		return LastUpdateTime;
	}

	public void setLastUpdateTime(Long lastUpdateTime) {
		LastUpdateTime = lastUpdateTime;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	
	
}
