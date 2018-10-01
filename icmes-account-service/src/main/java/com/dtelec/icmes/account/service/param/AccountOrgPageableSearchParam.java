package com.dtelec.icmes.account.service.param;

public class AccountOrgPageableSearchParam extends PageableSearchBaseParam {

	private String roleId;
	
	public AccountOrgPageableSearchParam(String roleId, int page, int count) {
		super(page, count);
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	
	
	
	
}
