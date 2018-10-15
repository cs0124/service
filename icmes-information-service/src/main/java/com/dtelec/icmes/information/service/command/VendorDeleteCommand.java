package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.VendorModel;

public class VendorDeleteCommand implements ICommand<VendorModel>{
	private Integer vendorId;
	
	public VendorDeleteCommand(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getVendorId() {
		return this.vendorId;
	}
}
