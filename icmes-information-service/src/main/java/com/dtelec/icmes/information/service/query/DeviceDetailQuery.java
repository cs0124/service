package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.DeviceModel;

public class DeviceDetailQuery implements IQuery<DeviceModel>{
	private int id;
	
	public DeviceDetailQuery(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
