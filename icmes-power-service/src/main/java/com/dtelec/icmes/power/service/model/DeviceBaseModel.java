package com.dtelec.icmes.power.service.model;

import com.dtelec.icmes.power.repository.entity.DeviceBaseEntity;

public class DeviceBaseModel {

	private int id;
	private String code;
	private String name;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void fill(DeviceBaseEntity entity) {
		if(entity != null) {			
			this.id = entity.getId();
			this.code = entity.getCode();
			this.name = entity.getName();
		}
	}
	
}
