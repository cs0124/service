package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.DeviceValueModel;

/**
 * Location Detail Query
 * 作者：孔轩
 */
public class DeviceValueDetailQuery implements IQuery<DeviceValueModel> {
    /**
     * 位置Id
     */
	private int Id;	

	public DeviceValueDetailQuery(int Id) {
		this.Id = Id;
	}

	
	public int getId() {
		return Id;
	}
	

	public void setId(int Id) {
		this.Id = Id;
	}

	

}