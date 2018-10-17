package com.dtelec.icmes.power.repository.entity;
/**
 * 申请单关联设备实体类
 * @author dell
 *
 */
public class DeviceBaseEntity {

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
	
}
