package com.dtelec.icmes.account.repository.entity;

/**
 * 账号实体类
 * @author zturnking
 *
 */
public class AccountEntity {
	/**
	 * 账号id
	 */
	private int id;
	/**
	 * 员工id
	 */
	private String employeeId;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 是否被锁定
	 */
	private boolean isLocked;
	/**
	 * 重试次数
	 */
	private int retryCount;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 设备号
	 */
	private String specialDevice;
	/**
	 * 版本控制
	 */
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
	
}
