package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.ProcessEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 工艺模型
 *
 */
@ApiModel
public class ProcessModel {
	@ApiModelProperty(value = "工艺标识符")
	/**工艺标识符*/
	private int id;
	@ApiModelProperty(value = "工艺编码")
	/**工艺编码*/
	private String code;
	@ApiModelProperty(value = "工艺名称")
	/**工艺名称*/
	private String name;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	/**用于高并发的数据版本控制*/
	private String versionTag;
	@ApiModelProperty(value = "创建时间")
	/**创建时间*/
	private long createTime;
	@ApiModelProperty(value = "更新时间")
	/**更新时间*/
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
	public void fill(ProcessEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.code = entity.getCode();
			this.name = entity.getName();
			this.versionTag = entity.getVersionTag();
		}
	}
	
	
	/**
	 * 给持久层模型赋值
	 * @return 持久层实体类
	 */
	public ProcessEntity covert() {
		ProcessEntity entity = new ProcessEntity();
		
		entity.setId(this.id);
		entity.setCode(this.code);
		entity.setName(this.name);
		entity.setVersionTag(this.versionTag);
		
		return entity;
	}
}
