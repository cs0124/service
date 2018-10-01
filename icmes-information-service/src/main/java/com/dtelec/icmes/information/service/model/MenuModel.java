package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.MenuEntity;

public class MenuModel {
	
	private int id;
	private String name;
	private int displayOrder;
	private int parentId;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDisplayOrder() {
		return displayOrder;
	}
	
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public void fill(MenuEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.name = entity.getName();
			this.displayOrder = entity.getDisplayOrder();
			this.parentId = entity.getParentId();
		}
	}
	
}
