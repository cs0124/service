package com.dtelec.icmes.account.repository.param;

/**
 * 账户角色分页参数
 * @author zturnking
 *
 */
public class AccountRolePageableQueryParam extends PageableQueryBaseParam {
	/**
	 * 员工id
	 */
	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}



}
