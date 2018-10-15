package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.LocationModel;

/**
 * Location Create Command
 * 作者：孔轩
 */
public class LocationCreateCommand implements ICommand<LocationModel> {

	/**
	 * 位置信息Model
	 */
	private LocationModel model;
	
	public LocationCreateCommand(LocationModel model) {
		this.model = model;
	}

	public LocationModel getModel() {
		return model;
	}

	public void setModel(LocationModel model) {
		this.model = model;
	}
}
