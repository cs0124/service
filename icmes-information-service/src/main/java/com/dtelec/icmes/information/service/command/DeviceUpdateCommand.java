package com.dtelec.icmes.information.service.command;


import com.dtelec.icmes.information.service.model.DeviceModel;

/**
 * 设备编辑command
 * @author schi
 *
 */
public class DeviceUpdateCommand implements ICommand<Void> {

	private DeviceModel model;

	public DeviceUpdateCommand(DeviceModel model) {
		this.model = model;
	}

	public DeviceModel getModel() {
		return model;
	}

	public void setModel(DeviceModel model) {
		this.model = model;
	}	
	
}
