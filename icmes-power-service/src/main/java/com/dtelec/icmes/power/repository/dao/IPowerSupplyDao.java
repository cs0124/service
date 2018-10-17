package com.dtelec.icmes.power.repository.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.power.repository.entity.PowerSupplyFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormFullEntity;

@Mapper
public interface IPowerSupplyDao {

	/**
	 * 通过当前时间获取最大送电单号
	 * @param nowTime 当前时间
	 * @return 最大送电单号
	 */
	String getMaxcutFormId(String nowTime);

	/**
	 * 新建送电申请单
	 * @param entity 送电申请单model
	 */ 
	void createPowerSupplyFrom(PowerSupplyFormBaseEntity entity);

	/**
	 * 通过送电申请单标识获取送电申请单详细信息
	 * @param id 送电申请单标识符
	 * @return 送电申请单entity
	 */
	PowerSupplyFormFullEntity getPowerSupplyFormById(@Param("id") String id);

}
