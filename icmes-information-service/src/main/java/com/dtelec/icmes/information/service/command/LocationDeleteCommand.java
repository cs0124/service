package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.LocationModel;
/**
 * 位置信息删除操作命令
 * 作者：孔轩
 */
public class LocationDeleteCommand implements ICommand<LocationModel> {

	private LocationModel model;

	public LocationDeleteCommand(LocationModel model) {
		this.model = model;
	}

	public LocationModel getModel() {
		return model;
	}

	public void setModel(LocationModel model) {
		this.model = model;
	}
}
