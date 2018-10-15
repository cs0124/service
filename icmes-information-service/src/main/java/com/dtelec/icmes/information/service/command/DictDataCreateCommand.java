package com.dtelec.icmes.information.service.command;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.DictDataBaseEntity;
import com.dtelec.icmes.information.service.model.DictDataBaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class DictDataCreateCommand implements  ICommand<DictDataBaseModel>{
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
	private Long LastUpdateTime;	
	@ApiModelProperty(value = "更新人UserId")
	private Integer LastUpdateUserId;	
	@ApiModelProperty(value = "创建时间")
	private Long createTime;	
	@ApiModelProperty(value = "创建人userId")
	private Integer createUserId;
	@ApiModelProperty(value = "是否启用")
	private boolean disabled;		

	
	public DictDataCreateCommand(String code, String name, String typeCode, Integer order, boolean disabled,
			String versionTag, Long createTime, Integer createUserId, Long lastUpdateTime, Integer lastUpdateUserId) {
		super();
		this.code = code;
		this.name = name;
		this.typeCode = typeCode;
		this.order = order;
		this.disabled = disabled;
		VersionTag = versionTag;
		this.createTime = createTime;
		this.createUserId = createUserId;
		LastUpdateTime = lastUpdateTime;
		LastUpdateUserId = lastUpdateUserId;
	}
	
	
	/**
	 * @param dictDataModel 字典数据模型
	 */
	public DictDataCreateCommand(DictDataBaseModel dictDataModel) {
		this.code=dictDataModel.getCode();
		this.name=dictDataModel.getName();
		this.VersionTag=dictDataModel.getVersionTag();
		this.createTime=dictDataModel.getCreateTime();
		this.createUserId=dictDataModel.getCreateUserId();
		this.LastUpdateTime=dictDataModel.getLastUpdateTime();
		this.LastUpdateUserId=dictDataModel.getLastUpdateUserId();
		this.order=dictDataModel.getOrder();
		this.createTime=dictDataModel.getCreateTime();
		this.createUserId=dictDataModel.getCreateUserId();
		this.typeCode=dictDataModel.getTypeCode();
		this.disabled=dictDataModel.getDisabled();					
		
	}
	
	
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
	
	
	public String getTypeCode() {
		return typeCode;
	}
	
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	
	public Integer getOrder() {
		return order;
	}
	
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	
	public boolean getDisabled() {
		return disabled;
	}
	
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	
	/**
	 * @return 字典数据实体类
	 */
public DictDataBaseEntity convert() {	
	DictDataBaseEntity entity = new DictDataBaseEntity();
	entity.setCode(this.code);
	entity.setName(this.name);
	entity.setVersionTag(this.VersionTag);
	entity.setLastUpdateTime(new Date(this.LastUpdateTime));
	entity.setLastUpdateUserId(this.LastUpdateUserId);
	entity.setCreateTime(new Date(this.createTime));
	entity.setCreateUserId(this.createUserId);
	entity.setOrder(this.order);
	entity.setDisabled(this.disabled);
	entity.setTypeCode(this.typeCode);
	return entity;
}


}
