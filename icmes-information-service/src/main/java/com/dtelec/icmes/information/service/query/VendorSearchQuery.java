package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.VendorCollection;

public class VendorSearchQuery extends PageableSearchBaseQuery implements IQuery<VendorCollection>{
	
	private String globalName;
	private String code;
	private String name;
	
	public VendorSearchQuery(int page, int count) {
		super(page, count);
	}
	
	public String getGlobalName() {
		return globalName;
	}

	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
