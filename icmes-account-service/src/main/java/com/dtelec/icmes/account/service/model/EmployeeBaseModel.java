package com.dtelec.icmes.account.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 员工基类模型
 * @author zturnking
 *
 */
@ApiModel
public class EmployeeBaseModel {
	/**
	 * 员工工号
	 */
	@ApiModelProperty(value = "员工工号")
	private String employeeId;
	/**
	 * 员工姓名
	 */
	@ApiModelProperty(value = "员工姓名")
	private String employeeName;
	/**
	 * 专用设备号
	 */
	@ApiModelProperty(value = "专用设备号")
	private String specialDevice;
	/**
	 * 当前员工是否有账号
	 */
	@ApiModelProperty(value = "当前员工是否有账号")
	private boolean hasAccount;
	
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

	public boolean isHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}
	
}
