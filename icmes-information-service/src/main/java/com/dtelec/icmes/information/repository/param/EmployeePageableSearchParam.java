package com.dtelec.icmes.information.repository.param;

import java.util.Date;

public class EmployeePageableSearchParam extends PageableSearchBaseParam {

	private String id;
	private String name;
	private String specialDevice;
	private String organizationId;
	private String category;
	private String workType;
	private Date joinDateStart;
	private Date joinDateEnd;
	
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

	public String getSpecialDevice() {
		return specialDevice;
	}

	public void setSpecialDevice(String specialDevice) {
		this.specialDevice = specialDevice;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public Date getJoinDateStart() {
		return joinDateStart;
	}

	public void setJoinDateStart(Date joinDateStart) {
		this.joinDateStart = joinDateStart;
	}

	public Date getJoinDateEnd() {
		return joinDateEnd;
	}

	public void setJoinDateEnd(Date joinDateEnd) {
		this.joinDateEnd = joinDateEnd;
	}
	
}
