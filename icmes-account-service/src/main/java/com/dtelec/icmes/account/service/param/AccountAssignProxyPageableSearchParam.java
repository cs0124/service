package com.dtelec.icmes.account.service.param;
/**
 * 账户接手代理分页查询参数
 * @author zturnking
 *
 */
public class AccountAssignProxyPageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 员工id
	 */
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
