package com.dtelec.icmes.account.service.param;
/**
 * 账号组织分页参数
 * @author zturnking
 *
 */
public class AccountOrgPageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 角色id
	 */
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
