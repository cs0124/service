package com.dtelec.icmes.account.repository.param;
/**
 * 账户委托代理参数
 * @author zturnking
 *
 */
public class AccountConsignProxyPageableQueryParam extends PageableQueryBaseParam {
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
