package com.dtelec.icmes.information.service.command;


import com.dtelec.icmes.information.service.model.DeviceModel;

/**
 * 设备新建command
 * @author schi
 *
 */
public class DeviceCreateCommand implements ICommand<Void> {

	private DeviceModel model;

	public DeviceCreateCommand(DeviceModel model) {
		this.model = model;
	}

	public DeviceModel getModel() {
		return model;
	}

	public void setModel(DeviceModel model) {
		this.model = model;
	}	
	
}
