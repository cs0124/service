package com.dtelec.icmes.auth.repository.entity;

import java.util.List;

public class UserEntity {

	private int id;
    private String employeeId;
    private String password;
    private boolean changePassword;
    private boolean isLock;
    private int retryCount;
    private List<RoleEntity> roles;
    
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isChangePassword() {
		return changePassword;
	}
	
	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}
	
	public boolean isLock() {
		return isLock;
	}
	
	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}
	
	public int getRetryCount() {
		return retryCount;
	}
	
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
	
	public List<RoleEntity> getRoles() {
		return roles;
	}
	
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
}
