package com.dtelec.icmes.account.repository.entity;

public class AccountRoleEntity {

	private String fullOrgName;
	private String roleName;
	private String roleId;
	private String organizationId;
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
