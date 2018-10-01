package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqUpdateEmployeeVO {
	@ApiModelProperty(value = "员工的专用设备号")
	public String specialDevice;
	@ApiModelProperty(value = "员工所属组织机构编号")
	public String organizationId;
	@ApiModelProperty(value = "员工办公室电话")
	public String officePhone;
	@ApiModelProperty(value = "员工办公室电话区号")
	public String officePhoneArea;
	@ApiModelProperty(value = "员工办公室电话分机号")
	public String officePhoneExt;
	@ApiModelProperty(value = "员工入职日期")
	public long joinDate;
	@ApiModelProperty(value = "员工类型")
	public String category;
	@ApiModelProperty(value = "员工工种")
	public String workType;
	@ApiModelProperty(value = "员工姓名")
	public String name;
	@ApiModelProperty(value = "员工手机号码")
	public String mobilePhone;
	@ApiModelProperty(value = "员工性别")
	public String gender;
	@ApiModelProperty(value = "员工电子邮件地址")
	public String email;
	@ApiModelProperty(value = "员工出生日期")
	public long birthDate;
	@ApiModelProperty(value = "员工身份证号码")
	public String identityCard;
	@ApiModelProperty(value = "员工毕业学校")
	public String graduateSchool;
	@ApiModelProperty(value = "员工所学专业")
	public String specialty;
	@ApiModelProperty(value = "员工职业资格")
	public String qualification;
	@ApiModelProperty(value = "员工毕业时间")
	public long graduationDate;
	@ApiModelProperty(value = "员工最高学历")
	public String highEducation;
	@ApiModelProperty(value = "员工最高学位")
	public String highDegree;
	@ApiModelProperty(value = "用于高并发的数据版本控制")
	public String versionTag;
	
}
