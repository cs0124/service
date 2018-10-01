package com.dtelec.icmes.account.service.model;

import com.dtelec.icmes.account.repository.entity.RoleEntity;


public class RoleModel {
	/**
	 * 角色id
	 */
	private String id;
	/**
	 * 角色编码
	 */
	private String code;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色描述
	 */
	private String remark;
	/**
	 * 角色版本控制
	 */
	private String versionTag;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	public void fill(RoleEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.remark = entity.getRemark();
		this.versionTag = entity.getVersionTag();
	}
}
