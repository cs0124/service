package com.dtelec.icmes.account.service.model;


import com.dtelec.icmes.account.repository.entity.AccountEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 账户模型
 * @author zturnking
 *
 */
@ApiModel
public class AccountModel {
	/**
	 * 登陆账号流水号
	 */
	@ApiModelProperty(value = "登录账号流水号")
	private int id;
	/**
	 * 员工工号
	 */
	@ApiModelProperty(value = "员工工号")
	private String employeeId;
	/**
	 * 账号登录密码
	 */
	@ApiModelProperty(value = "账号登录密码")
	private String password;
	/**
	 * 表示账号是否已经被锁定
	 */
	@ApiModelProperty(value = "表示账号是否已经被锁定")
	private boolean isLocked;
	/**
	 * 表示账号被错误登录的次数
	 */
	@ApiModelProperty(value = "表示账号被错误登录的次数")
	private int retryCount;
	/**
	 * 员工姓名
	 */
	@ApiModelProperty(value = "员工姓名")
	private String name;
	/**
	 * 专用设备号
	 */
	@ApiModelProperty(value = "专用设备号")
	private String specialDevice;
	/**
	 * 用于高并发的数据版本控制
	 */
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
			this.password = entity.getPassword();
			this.isLocked = entity.isLocked();
			this.specialDevice = entity.getSpecialDevice();
			this.versionTag = entity.getVersionTag();
			this.retryCount = entity.getRetryCount();
		}
	}
}
