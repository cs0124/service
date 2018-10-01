package com.dtelec.icmes.account.service.param;

public class AccountAssignProxyPageableSearchParam extends PageableSearchBaseParam {

    private String employeeId;
	
	public AccountAssignProxyPageableSearchParam(String employeeId, int page, int count) {
		super(page, count);
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
}
