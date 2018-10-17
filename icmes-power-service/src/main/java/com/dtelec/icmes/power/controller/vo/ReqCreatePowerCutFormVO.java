package com.dtelec.icmes.power.controller.vo;

import java.util.List;


import io.swagger.annotations.ApiModel;

/**
 * 新建申请单模型
 *
 */
@ApiModel
public class ReqCreatePowerCutFormVO {
	
	//public String status;
	public String type;
	public String reason;
	public long scheduledCutOffTime;
	public long scheduledSupplyTime;
	public int mainDeviceId;
	public String measures;
	public List<Integer> assDeviceIds;
	public List<String> ticketPhotos;
	
}
