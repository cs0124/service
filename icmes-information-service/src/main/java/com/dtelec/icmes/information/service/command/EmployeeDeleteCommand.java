package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.EmployeeModel;

public class EmployeeDeleteCommand implements ICommand<EmployeeModel>{
	
	private String employeeId;
	
	public EmployeeDeleteCommand(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}	
	
}
