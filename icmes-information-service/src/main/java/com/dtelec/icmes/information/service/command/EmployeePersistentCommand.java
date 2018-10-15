package com.dtelec.icmes.information.service.command;

public class EmployeePersistentCommand implements ICommand<Void> {

	private String employeeId;
	private String employeeName;
	private String specialDevice;
	
	public EmployeePersistentCommand(String employeeId, String employeeName, String specialDevice) {
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
