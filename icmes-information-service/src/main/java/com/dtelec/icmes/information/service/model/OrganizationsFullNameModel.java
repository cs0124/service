package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.OrganizationFullNameEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OrganizationsFullNameModel {
	@ApiModelProperty(value = "组织机构ID")
	private String id;
	@ApiModelProperty(value = "组织机构名称")
	private String name;
	@ApiModelProperty(value = "组织机构全称")
	private String fullName;
	@ApiModelProperty(value = "父级机构ID")
	private String parentId;
	@ApiModelProperty(value = "父级机构全称")
	private String parentFullName;
	@ApiModelProperty(value = "版本标志")
	private String versionTag;
	@ApiModelProperty(value = "是否有子集")
	private Boolean hasChild;
	
	/**
	 * 给模型赋值
	 * @param entity
	 */
	public void fillModel(OrganizationFullNameEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.fullName = entity.getFullName();
		this.parentId = entity.getParentId();
		this.versionTag = entity.getVersionTag();
		this.hasChild = entity.getHasChild();
		this.parentFullName = entity.getParentFullName();
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}

	public String getParentFullName() {
		return parentFullName;
	}

	public void setParentFullName(String parentFullName) {
		this.parentFullName = parentFullName;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

}
