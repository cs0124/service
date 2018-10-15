package com.dtelec.icmes.information.repository.entity;

public class SpecDataEntity {
	
    private int id;
    private int typeId;
    private String typeName;
    private String name;
    private String unit;
    private boolean isExtraDisplayMode;
    
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public boolean isExtraDisplayMode() {
		return isExtraDisplayMode;
	}
	
	public void setExtraDisplayMode(boolean isExtraDisplayMode) {
		this.isExtraDisplayMode = isExtraDisplayMode;
	}
}
