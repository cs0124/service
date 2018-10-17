package com.dtelec.icmes.power.service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.power.service.model.PowerSupplyFormFullModel;

public interface IPowerSupplyService {

	/**
	 * 通过当前时间获取最大送电单号
	 * @param nowTime 当前时间
	 * @return 最大送电单号
	 */
	String getMaxcutFormId(String nowTime);

	/**
	 * 新建送电申请单
	 * @param model 送电申请单model
	 * @throws IcmesBusinessException  抛出的异常
	 */ 
	void createPowerSupplyFrom(PowerSupplyFormFullModel model) throws IcmesBusinessException;

	/**
	 * 通过送电申请单标识获取送电申请单详细信息
	 * @param id 送电申请单标识符
	 * @return 送电申请单model
	 * @throws Exception  抛出的异常
	 */
	PowerSupplyFormFullModel getPowerSupplyFormDetail(String id) throws Exception;

}
