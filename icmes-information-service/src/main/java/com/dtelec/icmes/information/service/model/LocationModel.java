package com.dtelec.icmes.information.service.model;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.LocationEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LocationModel {

	@ApiModelProperty(value = "标识符")
	private int id;
	@ApiModelProperty(value = "位置编码")
	private String code;
	@ApiModelProperty(value = "位置名称")
	private String name;
	@ApiModelProperty(value = "父层级关系")
	private int parentId;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	@ApiModelProperty(value = "创建时间")
	private long createTime;
	@ApiModelProperty(value = "更新时间")
	private long updateTime;
	
	/**
	 * 位置模型复制
	 * @param entity 实体
	 * 作者：孔轩
	 */
	public void fillModel(LocationEntity entity) {
		this.id = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.parentId = entity.getParentId();
		this.versionTag = entity.getVersionTag();
		Date createTime = entity.getCreateTime();
		this.createTime = (createTime == null) ? 0 : createTime.getTime();
		Date updateTime = entity.getUpdateTime();
		this.updateTime = (updateTime == null) ? 0 : updateTime.getTime();
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String getVersionTag() {
		return versionTag;
	}
	
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	
	public long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	public long getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
}
