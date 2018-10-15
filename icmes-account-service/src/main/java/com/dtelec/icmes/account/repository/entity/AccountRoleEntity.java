package com.dtelec.icmes.account.repository.entity;
/**
 * 账号角色实体类
 * @author zturnking
 *
 */
public class AccountRoleEntity {
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
	 * 组织机构id
	 */
	private String organizationId;
	/**
	 * 关系id
	 */
	private int assId;
	
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
