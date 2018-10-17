package com.dtelec.icmes.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.power.repository.IPowerDelayRepository;
import com.dtelec.icmes.power.repository.entity.PowerDelayFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerDelayFormFullEntity;
import com.dtelec.icmes.power.service.IPowerDelayService;

import com.dtelec.icmes.power.service.model.PowerDelayFormBaseModel;
import com.dtelec.icmes.power.service.model.PowerDelayFormFullModel;


@Service
public class PowerDelayServiceImpl implements IPowerDelayService {
	
	@Autowired
	private IPowerDelayRepository powerDelayRepository;
	
	
	/**
	 * 通过申请单标识获取申请单详情
	 */
	@Override
	public PowerDelayFormFullModel getPowerDelayFullFormDetailById(String id) throws Exception {
		PowerDelayFormFullModel model = null;
		PowerDelayFormFullEntity entity = powerDelayRepository.getPowerDelayFormById(id);
		if(entity != null) {
			model = new PowerDelayFormFullModel();
			model.fill(entity);
			model.setMainDeviceId(entity.getMainDeviceId());
			model.setMainDeviceName(entity.getMainDeviceName());
			model.setMainDeviceCode(entity.getMainDeviceCode());
		}
		
		return model;
	}

	
	/**
	 * 新增延迟送电申请单
	 */
	@Override
	public void createPowerDelayBaseForm(PowerDelayFormBaseModel model) throws Exception {
		PowerDelayFormBaseEntity entity = model.convert();
		powerDelayRepository.createPowerDelayForm(entity);
	}

	
	/**
	 * 修改停电申请单
	 */
	@Override
	public void updatePowerDelayForm(PowerDelayFormBaseModel model) throws Exception {
		PowerDelayFormBaseEntity entity = model.convert();
		powerDelayRepository.updatePowerDelayForm(entity);
		
	}


	@Override
	public String getMaxDelayFormId(String nowTime) throws Exception {
		return powerDelayRepository.getMaxDelayFormId(nowTime);
	}


	@Override
	public boolean hasUnapprovedPowerDelayForm(String powerCutFormId) throws Exception {
		return powerDelayRepository.hasUnapprovedPowerDelayForm(powerCutFormId);
	}


}
