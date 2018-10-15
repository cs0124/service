package com.dtelec.icmes.information.service.query;


import com.dtelec.icmes.information.service.model.OrganizationAccountTreeCollection;

public class OrganizationAccountsTreeQuery  implements IQuery<OrganizationAccountTreeCollection> {
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
