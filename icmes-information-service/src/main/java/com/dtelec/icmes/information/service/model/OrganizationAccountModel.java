package com.dtelec.icmes.information.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OrganizationAccountModel {

	@ApiModelProperty(value = "组织ID")
	private String parentId;
	@ApiModelProperty(value = "组织节点名称")
	private String parentName;
	@ApiModelProperty(value = "员工ID")
	private String id;
	@ApiModelProperty(value = "员工名称")
	private String Name;
	@ApiModelProperty(value = "用户ID")
	private int userId;
	@ApiModelProperty(value = "是否有子集")
	private boolean hasChild;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

}
