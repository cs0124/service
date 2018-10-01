package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.EmployeeModel;

public class EmployeeDetailQuery implements IQuery<EmployeeModel>{
	
	private String id;
	
	public EmployeeDetailQuery(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
