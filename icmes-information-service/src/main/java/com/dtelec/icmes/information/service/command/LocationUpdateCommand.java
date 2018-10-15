package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.LocationModel;

/**
 * 位置信息更新操作命令
 * 作者：孔轩
 */
public class LocationUpdateCommand implements ICommand<LocationModel> {

	private LocationModel model;
	
	public LocationUpdateCommand(LocationModel model) {
		this.model = model;
	}

	public LocationModel getModel() {
		return model;
	}

	public void setModel(LocationModel model) {
		this.model = model;
	}
}
