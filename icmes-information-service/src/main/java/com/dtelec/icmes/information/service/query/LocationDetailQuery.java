package com.dtelec.icmes.information.service.query;

import com.dtelec.icmes.information.service.model.LocationModel;

/**
 * Location Detail Query
 * 作者：孔轩
 */
public class LocationDetailQuery implements IQuery<LocationModel> {
    /**
     * 位置Id
     */
	private int Id;	

	public LocationDetailQuery(int Id) {
		this.Id = Id;
	}

	
	public int getId() {
		return Id;
	}
	

	public void setId(int Id) {
		this.Id = Id;
	}

	

}