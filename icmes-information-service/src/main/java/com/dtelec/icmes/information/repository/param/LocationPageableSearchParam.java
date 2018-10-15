package com.dtelec.icmes.information.repository.param;

/**
 * 位置信息分页查询参数
 */
public class LocationPageableSearchParam extends PageableSearchBaseParam {
	
	/**
	 * 位置Id
	 */
	private int id;

	/**
	 * 位置编码
	 */
	private String code;

	/**
	 * 位置名称
	 */
	private String name;

	/**
	 * 父级位置Id
	 */
	private int parentId;

	/**
	 * 父级位置编码
	 */
	private String parentCode;

	/**
	 * 迭代层数
	 */
	private int hierarchy;

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
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentCode() {
		return parentCode;
	}
	
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	public int getHierarchy() {
		return hierarchy;
	}
	
	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}
}
