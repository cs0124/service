package com.dtelec.icmes.account.repository.param;

public class AccountAssignProxyPageableQueryParam extends PageableQueryBaseParam {

	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
}
