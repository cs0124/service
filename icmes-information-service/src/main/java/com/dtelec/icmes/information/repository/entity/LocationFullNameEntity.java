package com.dtelec.icmes.information.repository.entity;

/**
 * 位置全名实体
 * 作者：孔轩
 */
public class LocationFullNameEntity extends LocationEntity {
	/**
	 * 组织机构全名
	 */
	private String fullName;
	/**
	 * 父类机构全名
	 */
	private String parentFullName;
	/**
	 * 是否有子集
	 */
	private Boolean hasChild;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
}
