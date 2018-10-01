package com.dtelec.icmes.account.service.param;

public class AccountRolePageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 员工Id
	 */
	private String employeeId;
	
	/**
	 * 角色关系初始化
	 * @param employeeId
	 * @param page
	 * @param count
	 */
	public AccountRolePageableSearchParam(String employeeId, int page, int count) {
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
