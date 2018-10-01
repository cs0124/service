package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.DictEntity;

public class DictModel {
	
	private String code;
	private String name;
	private int order;
	private boolean disabled;
	private String typeCode;
	private String typeName;
	
	
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
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean isDisabled() {
		return disabled;
	}
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public String getTypeCode() {
		return typeCode;
	}
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public void fill(DictEntity entity) {
		if (entity != null) {
			this.code = entity.getCode();
			this.name = entity.getName();
			this.order = entity.getOrder();
			this.disabled = entity.isDisabled();
			this.typeCode = entity.getTypeCode();
			this.typeName = entity.getTypeName();
		}
	}
}
