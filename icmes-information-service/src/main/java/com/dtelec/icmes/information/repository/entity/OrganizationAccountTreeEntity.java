package com.dtelec.icmes.information.repository.entity;

public class OrganizationAccountTreeEntity {
	/**
	 * 父类Id
	 */
	private String parentId;
	/**
	 * 父类名称
	 */
	private String parentName;
	/**
	 * 组织id
	 */
	private String id;
	/**
	 * 组织名称
	 */
	private String Name;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 是否有子集
	 */
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
