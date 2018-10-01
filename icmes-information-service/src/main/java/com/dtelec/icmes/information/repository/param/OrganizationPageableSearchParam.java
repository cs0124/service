package com.dtelec.icmes.information.repository.param;

public class OrganizationPageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 组织id
	 */
	private String id;
	/**
	 * 组织名称
	 */
	private String name;
	/**
	 * 父类id
	 */
	private String parentId;
	/**
	 * 迭代层数
	 */
	private int hierarchy;
	
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
	
	public int getHierarchy() {
		return hierarchy;
	}
	
	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}
}
