package com.dtelec.icmes.information.repository.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备类型实体类
 * @author schi
 *
 */
@ApiModel
public class DeviceCategoryBaseEntity {

	@ApiModelProperty(value = "设备类型标识符")
	private int id;
	@ApiModelProperty(value = "设备类型编号")
	private String code;
	@ApiModelProperty(value = "设备类型名称")
	private String name;
	@ApiModelProperty(value = "设备类型是否是主设备大类  0 - 是主设备大类  1 - 是附属设备大类")
	private boolean isPrimary;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	
	
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
	
	public String getVersionTag() {
		return versionTag;
	}
	
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
