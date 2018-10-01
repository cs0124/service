package com.dtelec.icmes.account.repository.param;


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
