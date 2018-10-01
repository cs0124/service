package com.dtelec.icmes.account.service.model;


import com.dtelec.icmes.account.repository.entity.AccountEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AccountModel {
	@ApiModelProperty(value = "登录账号流水号")
	private int id;
	@ApiModelProperty(value = "员工工号")
	private String employeeId;
	@ApiModelProperty(value = "账号登录密码")
	private String password;
	@ApiModelProperty(value = "表示账号是否已经被锁定")
	private boolean isLocked;
	@ApiModelProperty(value = "表示账号被错误登录的次数")
	private int retryCount;
	@ApiModelProperty(value = "员工姓名")
	private String name;
	@ApiModelProperty(value = "专用设备号")
	private String specialDevice;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	
	
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
	
	public boolean isLocked() {
		return isLocked;
	}
	
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
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

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * AccountModel型转AccountEntity型
	 * @param entity
	 */
	public void fill(AccountEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.name = entity.getName();
			this.employeeId = entity.getEmployeeId();
			this.isLocked = entity.isLocked();
			this.specialDevice = entity.getSpecialDevice();
			this.versionTag = entity.getVersionTag();
			this.retryCount = entity.getRetryCount();
			this.password = entity.getPassword();
		}
	}
}
