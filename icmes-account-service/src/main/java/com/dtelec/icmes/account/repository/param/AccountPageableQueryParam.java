package com.dtelec.icmes.account.repository.param;
/**
 * 账户分页参数
 * @author zturnking
 *
 */
public class AccountPageableQueryParam extends PageableQueryBaseParam {
	/**
	 * 员工id
	 */
	private String employeeId;
	/**
	 * 员工名称
	 */
	private String employeeName;
	/**
	 * 设备
	 */
	private String specialDevice;
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getSpecialDevice() {
		return specialDevice;
	}
	
	public void setSpecialDevice(String specialDevice) {
		this.specialDevice = specialDevice;
	}
	
}
