package com.dtelec.icmes.account.repository.entity;

import java.util.Date;
/**
 * 用户实体类
 * @author zturnking
 *
 */
public class UserEntity {
	/**
	 * 账户id
	 */
	private int id;
	/**
	 * 员工id
	 */
	private String employeeId;
	/**
	 * 改变密码
	 */
	private boolean changePassword;
	/**
	 * 是否锁定
	 */
	private boolean isLocked;
	/**
	 * 是否删除
	 */
	private boolean isDeleted;
	/**
	 * 重复次数
	 */
	private int retryCount;
	/**
	 * 版本控制
	 */
	private String versionTag;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	
	
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
	
	public boolean isChangePassword() {
		return changePassword;
	}
	
	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}
	
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
	
	public int getRetryCount() {
		return retryCount;
	}
	
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
	
	public String getVersionTag() {
		return versionTag;
	}
	
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
