package com.dtelec.icmes.account.service.param;

public class AccountConsignProxyPageableSearchParam extends PageableSearchBaseParam {

    private String employeeId;
	
	public AccountConsignProxyPageableSearchParam(String employeeId, int page, int count) {
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
