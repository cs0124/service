package com.dtelec.icmes.information.service.query;


import com.dtelec.icmes.information.service.model.EmployeesCollection;

public class EmployeeSearchQuery extends PageableSearchBaseQuery implements IQuery<EmployeesCollection> {

	private String id;
	private String name;
	private String specialDevice;
	private String organizationId;
	private String category;
	private String workType;
	private Long joinDateStart;
	private Long joinDateEnd;


	public EmployeeSearchQuery(int page, int count) {
		super(page, count);
	}

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

	public Long getJoinDateStart() {
		return joinDateStart;
	}

	public void setJoinDateStart(Long joinDateStart) {
		this.joinDateStart = joinDateStart;
	}

	public Long getJoinDateEnd() {
		return joinDateEnd;
	}

	public void setJoinDateEnd(Long joinDateEnd) {
		this.joinDateEnd = joinDateEnd;
	}
	
}
