package com.dtelec.icmes.information.service.command;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.DictTypeEntity;
import com.dtelec.icmes.information.service.model.DictTypeModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class DictTypeCreateCommand implements  ICommand<DictTypeModel>{
	@ApiModelProperty(value = "字典类型code")
	private String code;
	@ApiModelProperty(value = "字典类型名称")	
	private String name;
	@ApiModelProperty(value = "是否是系统内嵌")
	private String isBuiltIn;
	@ApiModelProperty(value = "版本控制")
	private String versionTag;
	@ApiModelProperty(value = "创建时间")
	private Long createTime;
	@ApiModelProperty(value = "创建人userId")
	private Integer createUserId;	
	@ApiModelProperty(value = "上次更新时间")
	private Long lastUpdateTime;
	@ApiModelProperty(value = "上次更新人userId")
	private Integer lastUpdateUserId;
	
	/**
	 * 构造方法
	 * @param code
	 * @param name
	 * @param isBuiltIn
	 * @param versionTag
	 * @param createTime
	 * @param createUserId
	 * @param lastUpdateTime
	 * @param lastUpdateUserId
	 */
	public DictTypeCreateCommand(String code, String name, String isBuiltIn, String versionTag, Long createTime,
			Integer createUserId, Long lastUpdateTime, Integer lastUpdateUserId) {
		super();
		this.code = code;
		this.name = name;
		this.isBuiltIn = isBuiltIn;
		this.versionTag = versionTag;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.lastUpdateTime = lastUpdateTime;
		this.lastUpdateUserId = lastUpdateUserId;
	}
	
	
	/**
	 * model to command
	 * @param dictTypeModel
	 */
	public DictTypeCreateCommand(DictTypeModel dictTypeModel) {
		this.code=dictTypeModel.getCode();
		this.name=dictTypeModel.getName();
		this.isBuiltIn=dictTypeModel.getIsBuiltIn();
		this.versionTag=dictTypeModel.getVersionTag();
		this.createTime=dictTypeModel.getCreateTime();
		this.createUserId=dictTypeModel.getCreateUserId();
		this.lastUpdateTime=dictTypeModel.getLastUpdateTime();
		this.lastUpdateUserId=dictTypeModel.getLastUpdateUserId();
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
		return isBuiltIn;
	}
	
	public void setIsBuiltIn(String isBuiltIn) {
		this.isBuiltIn = isBuiltIn;
	}
	
	public String getVersionTag() {
		return versionTag;
	}
	
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
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
 * command to entity
 * @return
 */
	public DictTypeEntity  convert() {
		DictTypeEntity entity = new DictTypeEntity();
		entity.setCode(this.code);
		entity.setName(this.name);
		entity.setIsBuiltIn(this.isBuiltIn);
		entity.setVersionTag(this.versionTag);
		entity.setCreateTime(new Date(this.createTime));
		entity.setCreateUserId(this.createUserId);
		entity.setLastUpdateTime(new Date(this.lastUpdateTime));
		entity.setLastUpdateUserId(this.lastUpdateUserId);
		return entity;
		 
		
	}


}
