package com.dtelec.icmes.account.service.model;

import java.util.List;
/**
 * 创建角色模型
 * @author zturnking
 *
 */
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
	@Override
	public String getRemark() {
		return remark;
	}
	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String getVersionTag() {
		return versionTag;
	}
	@Override
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
