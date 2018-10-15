package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.OrganizationEntity;
import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class OrganizationModel {
	@ApiModelProperty(value = "组织机构ID")
	private String id;
	@ApiModelProperty(value = "组织机构名称")
	private String name;
	@ApiModelProperty(value = "父级机构ID")
	private String parentId;
	@ApiModelProperty(value = "版本标志")
	private String versionTag;

	/**
	 * 组织全名模型赋值
	 * @param entity 组织全名实体类
	 */
	public void fillModel(OrganizationFullNameEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.parentId = entity.getParentId();
		this.versionTag = entity.getVersionTag();
	}
	/**
	 * 组织模型复制
	 * @param entity 组织全名实体类
	 */
	public void fillModel(OrganizationEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.parentId = entity.getParentId();
		this.versionTag = entity.getVersionTag();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}


	


}
