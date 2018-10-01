package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.EmployeeModel;

public class EmployeeUpdateCommand implements ICommand<EmployeeModel>{
	private EmployeeModel model = null;
	
	public EmployeeUpdateCommand(EmployeeModel employeeModel) {
		this.model = employeeModel;
	}
	public EmployeeModel getModel() {
		return model;
	}
	public void setModel(EmployeeModel model) {
		this.model = model;
	}
	
}
