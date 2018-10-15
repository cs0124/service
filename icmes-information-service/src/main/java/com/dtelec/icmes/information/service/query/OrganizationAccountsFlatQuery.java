package com.dtelec.icmes.information.service.query;


import com.dtelec.icmes.information.service.model.OrganizationAccountFlatCollection;


public class OrganizationAccountsFlatQuery extends PageableSearchBaseQuery implements IQuery<OrganizationAccountFlatCollection> {
	private String search;

	public OrganizationAccountsFlatQuery(String search, int page, int count) {
		super(page, count);
		this.search = search;
	}

	public String getSearch() {
		return search;
	}
}
