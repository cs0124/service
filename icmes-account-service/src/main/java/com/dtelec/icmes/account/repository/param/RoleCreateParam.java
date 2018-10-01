package com.dtelec.icmes.account.repository.param;

import java.util.List;

public class RoleCreateParam {
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
	 * 版本控制
	 */
	private String versionTag;
	/**
	 * 角色权限列表
	 */
	private List<String> features;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

}
