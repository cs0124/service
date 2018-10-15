package com.dtelec.icmes.account.repository.param;
/**
 * 账户代理查询参数
 * @author zturnking
 *
 */
public class AccountAssignProxyPageableQueryParam extends PageableQueryBaseParam {
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
