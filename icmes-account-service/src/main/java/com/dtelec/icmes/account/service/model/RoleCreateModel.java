package com.dtelec.icmes.account.service.model;

import java.util.List;

public class RoleCreateModel extends RoleModel {
	/**
	 * 角色描述
	 */
	private String remark;
	/**
	 * 版本控制
	 */
	private String versionTag;
	/**
	 * 权限列表
	 */
	private List<String> features;

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

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	

}
