package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.DictTypeEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictTypeModel {

	@ApiModelProperty(value = "字典类型code")
	private String code;
	@ApiModelProperty(value = "字典类型名称")	
	private String name;
	@ApiModelProperty(value = "是否是系统内嵌")
	private String IsBuiltIn;
	@ApiModelProperty(value = "版本控制")
	private String VersionTag;
	@ApiModelProperty(value = "创建时间")
	private Long createTime;
	@ApiModelProperty(value = "创建人userId")
	private Integer createUserId;	
	@ApiModelProperty(value = "上次更新时间")
	private Long LastUpdateTime;
	@ApiModelProperty(value = "上次更新人userId")
	private Integer LastUpdateUserId;
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
	public String getIsBuiltIn() {
		return IsBuiltIn;
	}
	public void setIsBuiltIn(String isBuiltIn) {
		IsBuiltIn = isBuiltIn;
	}
	public String getVersionTag() {
		return VersionTag;
	}
	public void setVersionTag(String versionTag) {
		VersionTag = versionTag;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Long getLastUpdateTime() {
		return LastUpdateTime;
	}
	public void setLastUpdateTime(Long lastUpdateTime) {
		LastUpdateTime = lastUpdateTime;
	}
	public Integer getLastUpdateUserId() {
		return LastUpdateUserId;
	}
	public void setLastUpdateUserId(Integer lastUpdateUserId) {
		LastUpdateUserId = lastUpdateUserId;
	}
	 public void fill(DictTypeEntity entity) {
		 if(entity != null) {
			 this.code = entity.getCode();
			 this.name = entity.getName();
			 this.IsBuiltIn = entity.getIsBuiltIn();
			 this.VersionTag = entity.getVersionTag();
			 this.createTime = entity.getCreateTime().getTime();
			 this.createUserId = entity.getCreateUserId();
			 this.LastUpdateTime = entity.getLastUpdateTime().getTime();
			 this.LastUpdateUserId = entity.getLastUpdateUserId();
		 }
		 
	 }



}
