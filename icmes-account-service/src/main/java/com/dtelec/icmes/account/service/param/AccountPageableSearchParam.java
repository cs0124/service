package com.dtelec.icmes.account.service.param;
/**
 * 账号分页查询参数
 * @author zturnking
 *
 */
public class AccountPageableSearchParam extends PageableSearchBaseParam {
	/**
	 * 员工id
	 */
	private String employeeId;
	/**
	 * 员工名称
	 */
	private String employeeName;
	/**
	 * 专属设备
	 */
	private String specialDevice;
	/**
	 * 查询重构
	 * @param employeeId
	 * @param employeeName
	 * @param specialDevice
	 * @param page
	 * @param count
	 */
	public AccountPageableSearchParam(String employeeId, String employeeName, String specialDevice, int page, int count) {
		super(page, count);
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.specialDevice = specialDevice;
	}

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
