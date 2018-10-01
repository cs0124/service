package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

public class OrganizationEntity {
	/**
	 * 组织结构编号
	 */
	private String id;//组织结构编号
	/**
	 * 组织结构名称
	 */
	private String name;//组织结构名称
	/**
	 * 组织机构电话
	 */
	private String phone;//组织机构电话
	/**
	 * 组织机构上层机构编号
	 */
	private String parentId;//组织机构上层机构编号
	/**
	 * 用于高并发的数据版本控制
	 */
	private String versionTag;//用于高并发的数据版本控制
	/**
	 * 组织结构创建时间
	 */
	private Date createTime;//组织结构创建时间
	/**
	 * 组织机构更新时间
	 */
	private Date updateTime;//组织机构更新时间

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
