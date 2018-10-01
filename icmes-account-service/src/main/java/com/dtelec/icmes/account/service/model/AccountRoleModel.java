package com.dtelec.icmes.account.service.model;

import com.dtelec.icmes.account.repository.entity.AccountRoleEntity;

public class AccountRoleModel {
	/**
	 * 组织机构全称
	 */
	private String fullOrgName;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 组织id
	 */
	private String organizationId;
	/**
	 * 角色关系id
	 */
	private int assId;
	
	/**
	 * 模型填充
	 * @param entity
	 */
	public void fill(AccountRoleEntity entity) {
		this.fullOrgName = entity.getFullOrgName();
		this.roleName = entity.getRoleName();
		this.roleId = entity.getRoleId();
		this.organizationId = entity.getOrganizationId();
		this.assId = entity.getAssId();
	}

	public String getFullOrgName() {
		return fullOrgName;
	}

	public void setFullOrgName(String fullOrgName) {
		this.fullOrgName = fullOrgName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public int getAssId() {
		return assId;
	}

	public void setAssId(int assId) {
		this.assId = assId;
	}

}
