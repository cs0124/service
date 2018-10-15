package com.dtelec.icmes.information.service.model;

import java.util.Date;
import java.util.List;
import com.dtelec.icmes.information.repository.entity.DeviceCategoryBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备类型展示层实体类
 * @author dell
 *
 */
@ApiModel
public class DeviceCategoryModel {
	@ApiModelProperty(value = "设备类型标识符")
	private int id;
	@ApiModelProperty(value = "设备类型编号")
	private String code;
	@ApiModelProperty(value = "设备类型名称")
	private String name;
	@ApiModelProperty(value = "设备类型是否是主设备大类  0 - 是主设备大类  1 - 是附属设备大类")
	private boolean isPrimary;
	@ApiModelProperty(value = "规格模版数据集合")
	private List<SpecDataModel> specDataList;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	@ApiModelProperty(value = "创建时间")
	private long createTime;
	@ApiModelProperty(value = "更新时间")
	private long updateTime;
	
	
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
	
	public boolean isPrimary() {
		return isPrimary;
	}
	
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	
	public List<SpecDataModel> getSpecDataList() {
		return specDataList;
	}
	
	public void setSpecDataList(List<SpecDataModel> specDataList) {
		this.specDataList = specDataList;
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
	
	
	/**
	 * 给展示层模型赋值
	 * @param entity 持久层实体类
	 */
	public void fill(DeviceCategoryBaseEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.code = entity.getCode();
			this.name = entity.getName();
			this.isPrimary = entity.isPrimary();
			this.versionTag = entity.getVersionTag();
		}
	}
	
	/**
	 * 给持久层模型赋值
	 * @return 设备类型实体类
	 */
	public DeviceCategoryBaseEntity convert() {
		DeviceCategoryBaseEntity entity = new DeviceCategoryBaseEntity();
		entity.setId(this.id);
		entity.setCode(this.code);
		entity.setName(this.name);
		entity.setPrimary(this.isPrimary);
		entity.setVersionTag(this.versionTag);
		
		if (this.createTime > 0) {
			entity.setCreateTime(new Date(this.createTime));
		}
		else {
			entity.setCreateTime(null);
		}
		
		if (this.updateTime > 0) {
			entity.setUpdateTime(new Date(this.updateTime));
		}
		else {
			entity.setUpdateTime(null);
		}
		
		return entity;
	}

	
}
