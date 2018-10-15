package com.dtelec.icmes.information.repository.entity;

public class EmployeeFullNameEntity extends EmployeeEntity {
	private boolean isLocked;
	private boolean isDeleted;
	private String fullName;
	
	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String getFullName() {
		return fullName;
	}
	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
