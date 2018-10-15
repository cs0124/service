package com.dtelec.icmes.common.model;

/**
 * 用于权限验证系统的公用角色对象
 * @author hlxu
 *
 */
public class AuthRoleModel {

	/**
	 * 角色编码
	 */
	private String id;
	
	/**
	 * 角色名称
	 */
	private String name;
	
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
}
