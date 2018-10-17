package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DeviceModel;

public class DeviceDeleteCommand implements ICommand<DeviceModel>{
	private int id;
	
	public DeviceDeleteCommand(int id) {
		this.id = id;
	}

	public int getId() {
		
		return id;
	}
}
