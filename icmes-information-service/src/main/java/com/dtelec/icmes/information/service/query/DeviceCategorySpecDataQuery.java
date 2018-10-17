package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.SpecDataCollection;

public class DeviceCategorySpecDataQuery implements IQuery<SpecDataCollection> {

	private int deviceCategoryId;
	
	public DeviceCategorySpecDataQuery(int deviceCategoryId) {
		this.deviceCategoryId = deviceCategoryId;
	}

	public int getDeviceCategoryId() {
		return deviceCategoryId;
	}

	public void setDeviceCategoryId(int deviceCategoryId) {
		this.deviceCategoryId = deviceCategoryId;
	}
	
}
