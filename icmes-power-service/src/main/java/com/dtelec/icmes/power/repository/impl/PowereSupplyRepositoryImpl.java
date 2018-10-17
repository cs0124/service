package com.dtelec.icmes.power.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.power.repository.IPowereSupplyRepository;
import com.dtelec.icmes.power.repository.dao.IPowerSupplyDao;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormFullEntity;

@Repository
public class PowereSupplyRepositoryImpl implements IPowereSupplyRepository {

	@Autowired
	IPowerSupplyDao supplyDao;

	/**
	 *  通过当前时间获取最大送电单号
	 */
	@Override
	public String getMaxcutFormId(String nowTime) {
		return supplyDao.getMaxcutFormId(nowTime);
	}

	/**
	 *  新建送电申请单
	 */
	@Override
	public void createPowerSupplyFrom(PowerSupplyFormBaseEntity entity) {
		supplyDao.createPowerSupplyFrom(entity);
	}

	/**
	 * 通过送电申请单标识获取送电申请单详细信息
	 */
	@Override
	public PowerSupplyFormFullEntity getPowerSupplyFormById(String id) {
		return supplyDao.getPowerSupplyFormById(id);
	}
}
