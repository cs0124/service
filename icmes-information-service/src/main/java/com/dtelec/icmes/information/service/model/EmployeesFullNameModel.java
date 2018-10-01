package com.dtelec.icmes.information.service.model;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.EmployeeFullNameEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EmployeesFullNameModel {
	@ApiModelProperty(value = "员工ID")
	private String id;
	@ApiModelProperty(value = "员工名称")
	private String name;
	@ApiModelProperty(value = "专用设备号")
	private String specialDevice;
	@ApiModelProperty(value = "是否被锁定")
	private boolean isLocked;
	@ApiModelProperty(value = "是否被删除")
	private boolean IsDeleted;
	@ApiModelProperty(value = "组织机构全名")
	private String fullName;
	@ApiModelProperty(value = "手机号")
	private String mobilePhone;
	@ApiModelProperty(value = "员工类型")
	private String category;
	@ApiModelProperty(value = "工种")
	private String workType;
	@ApiModelProperty(value = "入职日期")
	private long joinDate;
	
	/**
	 * 给模型赋值
	 * @param entity
	 */
	public void fillModel(EmployeeFullNameEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.specialDevice = entity.getSpecialDevice();
		this.isLocked = entity.isLocked();
		this.IsDeleted = entity.isDeleted();
		this.fullName = entity.getFullName();
		this.mobilePhone = entity.getMobilePhone();
		this.category = entity.getCategory();
		this.workType = entity.getWorkType();
		Date joinDate = entity.getJoinDate();
		this.joinDate = (joinDate == null) ? 0 : joinDate.getTime();
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

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isIsDeleted() {
		return IsDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		IsDeleted = isDeleted;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	public long getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(long joinDate) {
		this.joinDate = joinDate;
	}

	

}
