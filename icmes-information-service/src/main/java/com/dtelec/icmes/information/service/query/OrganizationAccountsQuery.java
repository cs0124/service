package com.dtelec.icmes.information.service.query;


import com.dtelec.icmes.information.service.model.OrganizationAccountCollection;

public class OrganizationAccountsQuery  implements IQuery<OrganizationAccountCollection> {
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
