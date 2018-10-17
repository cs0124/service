package com.dtelec.icmes.power.service.model;


import java.util.List;

import io.swagger.annotations.ApiModelProperty;


public class PowerCutFormFullModel extends PowerCutFormBaseModel {
	
	private List<DeviceBaseModel> associatedDevices;
	
	private List<String> workTicketPhotos;
	
	/**
	 * 申请人
	 */
	@ApiModelProperty(value = "申请人")
	private String createUserName;
	
	
	public List<DeviceBaseModel> getAssociatedDevices() {
		return associatedDevices;
	}

	public void setAssociatedDevices(List<DeviceBaseModel> associatedDevices) {
		this.associatedDevices = associatedDevices;
	}

	public List<String> getWorkTicketPhotos() {
		return workTicketPhotos;
	}

	public void setWorkTicketPhotos(List<String> workTicketPhotos) {
		this.workTicketPhotos = workTicketPhotos;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

}
