package com.dtelec.icmes.information.service.command;

import com.dtelec.icmes.information.service.model.DeviceCategoryModel;

/**
 * 设备类型删除
 * @author schi
 *
 */
public class DeviceCategoryDeleteCommand implements ICommand<DeviceCategoryModel>{

	private int id;
	
	public DeviceCategoryDeleteCommand(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
