package com.dtelec.icmes.auth.service.model;

import com.dtelec.icmes.auth.repository.entity.RoleEntity;

public class RoleModel {

	private String id;
	private String name;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public RoleEntity covert() {
	    RoleEntity entity = new RoleEntity();
	    entity.setId(this.id);
	    entity.setName(this.name);
	    
	    return entity;
	}
	
	public void fill(RoleEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.name = entity.getName();
		}
	}
}
