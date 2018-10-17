package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DeviceValueModel;


/**
 * 设备净值 Update Command
 * 作者：孔轩
 */
public class DeviceValueUpdateCommand implements ICommand<DeviceValueModel> {

	/**
	 * 设备净值Model
	 */
	private DeviceValueModel model;
	
	public DeviceValueUpdateCommand(DeviceValueModel model) {
		this.model = model;
	}

	public DeviceValueModel getModel() {
		return model;
	}

	public void setModel(DeviceValueModel model) {
		this.model = model;
	}
}