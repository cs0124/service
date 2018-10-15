package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.VendorModel;

public class VendorDetailQuery implements IQuery<VendorModel>{
	private Integer id;
	
	public VendorDetailQuery(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
