package com.dtelec.icmes.account.repository.param;
/**
 * 账户组织查询参数
 * @author zturnking
 *
 */
public class AccountOrgPageableQueryParam extends PageableQueryBaseParam {
	/**
	 * 角色id
	 */
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	
	
}
