package com.dtelec.icmes.information.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel	
public class ReqPersistentEmployeeVO {
	@ApiModelProperty(value = "员工工号")
	public String employeeId;
	@ApiModelProperty(value = "员工姓名")
	public String employeeName;
	@ApiModelProperty(value = "专用设备号")
	public String specialDevice;
	
}
