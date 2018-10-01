package com.dtelec.icmes.information.service.model;


import com.dtelec.icmes.information.repository.entity.DictDataBaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DictDataBaseModel {
	@ApiModelProperty(value = "字典编码")
	private String code;
	@ApiModelProperty(value = "字典类型编码")
	private String typeCode;
	@ApiModelProperty(value = "字典名称")
	private String name;
	@ApiModelProperty(value = "排序")
	private Integer order;	
	@ApiModelProperty(value = "控制版本")
	private String VersionTag;	
	@ApiModelProperty(value = "更新时间")
	private Long lastUpdateTime;	
	@ApiModelProperty(value = "更新人UserId")
	private Integer lastUpdateUserId;	
	@ApiModelProperty(value = "创建时间")
	private Long CreateTime;	
	@ApiModelProperty(value = "创建人userId")
	private Integer CreateUserId;	
	@ApiModelProperty(value = "是否启用")
	private boolean disabled;	
	
	
	public String getVersionTag() {
		return VersionTag;
	}
	
	
	public void setVersionTag(String versionTag) {
		VersionTag = versionTag;
	}
	
	
	public Long getCreateTime() {
		return CreateTime;
	}
	
	
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	
	
	public Integer getCreateUserId() {
		return CreateUserId;
	}
	
	
	public void setCreateUserId(Integer createUserId) {
		CreateUserId = createUserId;
	}
	
	
	public boolean getDisabled() {
		return disabled;
	}
	
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	
	public String getCode() {
		return code;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getTypeCode() {
		return typeCode;
	}
	
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getOrder() {
		return order;
	}
	
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	
	public Long getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	
	public void setLastUpdateTime(Long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	public Integer getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	
	
	public void setLastUpdateUserId(Integer lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	
	
	


/**
 * entity to model
 * @param entity
 */
	public void fill(DictDataBaseEntity entity) {
		if (entity != null) {
			this.code = entity.getCode();
			this.name = entity.getName();
			this.typeCode = entity.getTypeCode();
			this.CreateTime = entity.getCreateTime().getTime();
			this.CreateUserId = entity.getCreateUserId();
			this.disabled = entity.getDisabled();
			this.lastUpdateTime = entity.getLastUpdateTime().getTime();
			this.lastUpdateUserId = entity.getLastUpdateUserId();
			this.VersionTag = entity.getVersionTag();	
			this.order = entity.getOrder();
					
		
		}
	
		
	}
	
	

}
