package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

public class EmployeeEntity {
	//员工id
	private String id;
	//员工的专用设备号
	private String specialDevice;
	//员工所属组织机构编号
	private String organizationId;
	//员工办公室电话
	private String officePhone;
	//员工办公室电话区号
	private String officePhoneArea;
	//员工办公室电话分机号
	private String officePhoneExt;
	//员工入职日期
	private Date joinDate;
	//员工类型
	private String category;
	//员工工种
	private String workType;
	//员工头像路径
	private String avatar;
	//员工姓名
	private String name;
	//员工手机号码
	private String mobilePhone;
	//员工性别
	private String gender;
	//员工电子邮件地址
	private String email;
	//员工出生日期
	private Date birthDate;
	//员工身份证号码
	private String identityCard;
	//员工毕业学校
	private String graduateSchool;
	//员工所学专业
	private String specialty;
	//员工职业资格
	private String qualification;
	//员工毕业时间
	private Date graduationDate;
	//员工最高学历
	private String highEducation;
	//员工最高学位
	private String highDegree;
	//用于高并发的数据版本控制
	private String versionTag;
	//员工信息创建时间
	private Date createTime;
	//员工信息更新时间
	private Date updateTime;
	//组织机构全名
	private String fullName;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public String getOfficePhone() {
		return officePhone;
	}
	
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	
	public String getOfficePhoneArea() {
		return officePhoneArea;
	}
	
	public void setOfficePhoneArea(String officePhoneArea) {
		this.officePhoneArea = officePhoneArea;
	}
	
	public String getOfficePhoneExt() {
		return officePhoneExt;
	}
	
	public void setOfficePhoneExt(String officePhoneExt) {
		this.officePhoneExt = officePhoneExt;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
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
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getIdentityCard() {
		return identityCard;
	}
	
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	
	public String getGraduateSchool() {
		return graduateSchool;
	}
	
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	public String getQualification() {
		return qualification;
	}
	
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public Date getGraduationDate() {
		return graduationDate;
	}
	
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	public String getHighEducation() {
		return highEducation;
	}
	
	public void setHighEducation(String highEducation) {
		this.highEducation = highEducation;
	}
	
	public String getHighDegree() {
		return highDegree;
	}
	
	public void setHighDegree(String highDegree) {
		this.highDegree = highDegree;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
}
