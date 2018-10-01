package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.OrganizationModel;

public class OrganizationDeleteCommand implements ICommand<OrganizationModel> {
	private String id;
	private String name;
	private String parentId;
	private String versionTag;
	
	public void fill(OrganizationModel model) {
		this.id = model.getId();
		this.name = model.getName();
		this.parentId = model.getParentId();
		this.versionTag = model.getVersionTag();
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
