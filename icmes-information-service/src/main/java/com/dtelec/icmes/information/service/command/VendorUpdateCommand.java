package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.VendorModel;

public class VendorUpdateCommand implements ICommand<VendorModel>{
	private VendorModel model = null;
	
	public VendorUpdateCommand(VendorModel vendorModel) {
		this.model = vendorModel;
	}
	public VendorModel getModel() {
		return model;
	}
	public void setModel(VendorModel model) {
		this.model = model;
	}
	
}
