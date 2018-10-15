package com.dtelec.icmes.information.service.command;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.DictTypeEntity;
import com.dtelec.icmes.information.service.model.DictTypeModel;

import io.swagger.annotations.ApiModelProperty;

public class DictTypeUpdateCommand implements  ICommand<DictTypeModel>{

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

	
	public DictTypeUpdateCommand(String code, String name, String isBuiltIn, String versionTag, Long createTime,
			Integer createUserId, Long lastUpdateTime, Integer lastUpdateUserId) {
		super();
		this.code = code;
		this.name = name;
		IsBuiltIn = isBuiltIn;
		VersionTag = versionTag;
		this.createTime = createTime;
		this.createUserId = createUserId;
		LastUpdateTime = lastUpdateTime;
		LastUpdateUserId = lastUpdateUserId;
	}
	
	
	/**
	 * @param dictTypeModel 字典类型模型
	 */
	public DictTypeUpdateCommand(DictTypeModel dictTypeModel) {
		this.code=dictTypeModel.getCode();
		this.name=dictTypeModel.getName();
		this.IsBuiltIn=dictTypeModel.getIsBuiltIn();
		this.VersionTag=dictTypeModel.getVersionTag();
		this.createTime=dictTypeModel.getCreateTime();
		this.createUserId=dictTypeModel.getCreateUserId();
		this.LastUpdateTime=dictTypeModel.getLastUpdateTime();
		this.LastUpdateUserId=dictTypeModel.getLastUpdateUserId();
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

	
	/**
	 * @return 字典类型实体类
	 */
	public DictTypeEntity  convert() {
		DictTypeEntity entity = new DictTypeEntity();
		entity.setCode(this.getCode());
		entity.setName(this.getName());
		entity.setIsBuiltIn(this.IsBuiltIn);
		entity.setVersionTag(this.VersionTag);
		entity.setCreateTime(new Date(this.createTime));
		entity.setCreateUserId(this.createUserId);
		entity.setLastUpdateTime(new Date(this.LastUpdateTime));
		entity.setLastUpdateUserId(this.LastUpdateUserId);
		return entity;
		 
		
	}



}
