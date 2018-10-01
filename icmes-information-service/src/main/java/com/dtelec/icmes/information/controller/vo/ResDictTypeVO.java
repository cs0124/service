package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResDictTypeVO {
	@ApiModelProperty(value = "字典类型code")
	private String code;
	@ApiModelProperty(value = "字典类型名称")
	private String name;	
	@ApiModelProperty(value = "上次更新时间")
	private Long lastUpdateTime ;
	@ApiModelProperty(value = "上次更新人")
	private Integer lastUpdateUser;
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
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(Integer lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}


	
	
}
