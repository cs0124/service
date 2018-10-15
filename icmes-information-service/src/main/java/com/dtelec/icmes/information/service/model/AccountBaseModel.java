package com.dtelec.icmes.information.service.model;

public class AccountBaseModel {

	private String employeeId;
	private String employeeName;
	private String specialDevice;
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

	public boolean getHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}
	
}
