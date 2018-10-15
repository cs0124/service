package com.dtelec.icmes.account.service.param;
/**
 * 账号委托代理分页查询参数
 * @author zturnking
 *
 */
public class AccountConsignProxyPageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 员工id
	 */
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
