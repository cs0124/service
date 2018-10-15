package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.DeviceCategoryModel;

/**
 * 设备类型Query
 * @author schi
 *
 */
public class DeviceCategoryDetailQuery implements IQuery<DeviceCategoryModel>{

	private int id;
	
	public DeviceCategoryDetailQuery(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
