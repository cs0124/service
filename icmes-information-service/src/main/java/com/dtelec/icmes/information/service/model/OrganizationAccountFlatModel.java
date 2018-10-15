package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.OrganizationAccountFlatEntity;

public class OrganizationAccountFlatModel {

	/**
	 * 员工工号
	 */
	private String employeeId;
	
	/**
	 * 用户id
	 */
	private int userId;
	
	/**
	 * 用户名称
	 */
	private String name;
	
	/**
	 * 机构全称
	 */
	private String orgFullName;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgFullName() {
		return orgFullName;
	}

	public void setOrgFullName(String orgFullName) {
		this.orgFullName = orgFullName;
	}
	
	public void fill(OrganizationAccountFlatEntity entity) {
		if (entity != null) {
			this.employeeId = entity.getEmployeeId();
			this.userId = entity.getUserId();
			this.name = entity.getName();
			this.orgFullName = entity.getOrgFullName();
		}
	}
	
}
