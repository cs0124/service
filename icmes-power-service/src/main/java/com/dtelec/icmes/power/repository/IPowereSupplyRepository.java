package com.dtelec.icmes.power.repository;

import com.dtelec.icmes.power.repository.entity.PowerSupplyFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormFullEntity;

public interface IPowereSupplyRepository {

	/**
	 * 通过当前时间获取最大送电单号
	 * @param nowTime 当前时间
	 * @return 最大送电单号
	 */
	String getMaxcutFormId(String nowTime);

	/**
	 * 新建送电申请单
	 * @param entity 送电申请单实体类
	 */ 
	void createPowerSupplyFrom(PowerSupplyFormBaseEntity entity);

	/**
	 * 通过送电申请单标识获取送电申请单详细信息
	 * @param id 送电申请单标识符
	 * @return 送电申请单entity
	 */
	PowerSupplyFormFullEntity getPowerSupplyFormById(String id);

}
