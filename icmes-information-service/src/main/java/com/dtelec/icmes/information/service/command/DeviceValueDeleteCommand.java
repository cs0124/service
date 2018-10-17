package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DeviceValueModel;
/**
 * 设备净值删除操作命令
 * 作者：孔轩
 */
public class DeviceValueDeleteCommand implements ICommand<DeviceValueModel> {

	private DeviceValueModel model;

	public DeviceValueDeleteCommand(DeviceValueModel model) {
		this.model = model;
	}

	public DeviceValueModel getModel() {
		return model;
	}

	public void setModel(DeviceValueModel model) {
		this.model = model;
	}
}
