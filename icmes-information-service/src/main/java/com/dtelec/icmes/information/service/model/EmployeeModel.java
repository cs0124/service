package com.dtelec.icmes.information.service.model;

import java.util.Date;

import com.dtelec.icmes.information.repository.entity.EmployeeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EmployeeModel {
	@ApiModelProperty(value = "员工ID")
	private String id;
	@ApiModelProperty(value = "员工的专用设备号")
	private String specialDevice;
	@ApiModelProperty(value = "员工所属组织机构编号")
	private String organizationId;
	@ApiModelProperty(value = "员工办公室电话")
	private String officePhone;
	@ApiModelProperty(value = "员工办公室电话区号")
	private String officePhoneArea;
	@ApiModelProperty(value = "员工办公室电话分机号")
	private String officePhoneExt;
	@ApiModelProperty(value = "员工入职日期")
	private long joinDate;
	@ApiModelProperty(value = "员工类型")
	private String category;
	@ApiModelProperty(value = "员工工种")
	private String workType;
	@ApiModelProperty(value = "员工头像路径")
	private String avatar;
	@ApiModelProperty(value = "员工姓名")
	private String name;
	@ApiModelProperty(value = "员工手机号码")
	private String mobilePhone;
	@ApiModelProperty(value = "员工性别")
	private String gender;
	@ApiModelProperty(value = "员工电子邮件地址")
	private String email;
	@ApiModelProperty(value = "员工出生日期")
	private long birthDate;
	@ApiModelProperty(value = "员工身份证号码")
	private String identityCard;
	@ApiModelProperty(value = "员工毕业学校")
	private String graduateSchool;
	@ApiModelProperty(value = "员工所学专业")
	private String specialty;
	@ApiModelProperty(value = "员工职业资格")
	private String qualification;
	@ApiModelProperty(value = "员工毕业时间")
	private long graduationDate;
	@ApiModelProperty(value = "员工最高学历")
	private String highEducation;
	@ApiModelProperty(value = "员工最高学位")
	private String highDegree;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	private String versionTag;
	@ApiModelProperty(value = "员工信息创建时间")
	private long createTime;
	@ApiModelProperty(value = "员工信息更新时间")
	private long updateTime;
	@ApiModelProperty(value = "组织机构全名")
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
	
	public Long getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Long joinDate) {
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
	
	public Long getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Long birthDate) {
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
	
	public Long getGraduationDate() {
		return graduationDate;
	}
	
	public void setGraduationDate(Long graduationDate) {
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

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 给model模型赋值
	 * @param entity
	 */
	public void fill(EmployeeEntity entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.specialDevice = entity.getSpecialDevice();
			this.organizationId = entity.getOrganizationId();
			this.officePhone = entity.getOfficePhone();
			this.officePhoneArea = entity.getOfficePhoneArea();
			this.officePhoneExt = entity.getOfficePhoneExt();
			Date joinDate = entity.getJoinDate();
			this.joinDate = (joinDate == null) ? 0 : joinDate.getTime();
			this.category = entity.getCategory();
			this.workType = entity.getWorkType();
			this.avatar = entity.getAvatar();
			this.name = entity.getName();
			this.mobilePhone = entity.getMobilePhone();
			this.gender = entity.getGender();
			this.email = entity.getEmail();
			Date birthDate = entity.getBirthDate();
			this.birthDate = (birthDate == null) ? 0 : birthDate.getTime();
			this.identityCard = entity.getIdentityCard();
			this.graduateSchool = entity.getGraduateSchool();
			this.specialty = entity.getSpecialty();
			this.qualification = entity.getQualification();
			Date graduationDate = entity.getGraduationDate();
			this.graduationDate = (graduationDate == null) ? 0 : graduationDate.getTime();
			this.highEducation = entity.getHighEducation();
			this.highDegree = entity.getHighDegree();
			this.versionTag = entity.getVersionTag();
			Date createTime = entity.getCreateTime();
			this.createTime = (createTime == null) ? 0 : createTime.getTime();
			Date updateTime = entity.getUpdateTime();
			this.updateTime = (updateTime == null) ? 0 : updateTime.getTime();
			this.fullName = entity.getFullName();
		}
	}
	
	/**
	 * 给entity模型赋值
	 * @return
	 */
	public EmployeeEntity covert() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setId(this.id);
		entity.setSpecialDevice(this.specialDevice);
		entity.setOrganizationId(this.organizationId);
		entity.setOfficePhone(this.officePhone);
		entity.setOfficePhoneArea(this.officePhoneArea);
		entity.setOfficePhoneExt(this.officePhoneExt);
		if (this.joinDate > 0) {
			entity.setJoinDate(new Date(this.joinDate));
		}
		else {
			entity.setJoinDate(null);
		}
		entity.setCategory(this.category);
		entity.setWorkType(this.workType);
		entity.setAvatar(this.avatar);
		entity.setName(this.name);
		entity.setMobilePhone(this.mobilePhone);
		entity.setGender(this.gender);
		entity.setEmail(this.email);		
		if (this.birthDate > 0) {
			entity.setBirthDate(new Date(this.birthDate));
		}
		else {
			entity.setBirthDate(null);
		}
		entity.setIdentityCard(this.identityCard);
		entity.setGraduateSchool(this.graduateSchool);
		entity.setSpecialty(this.specialty);
		entity.setQualification(this.qualification);
		entity.setGraduationDate(new Date(this.graduationDate));
		entity.setHighEducation(this.highEducation);
		entity.setHighDegree(this.highDegree);
		entity.setVersionTag(this.versionTag);
		return entity;
	}
	
}
