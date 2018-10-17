package com.dtelec.icmes.power.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.power.repository.IPowerCutRepository;
import com.dtelec.icmes.power.repository.IPowereSupplyRepository;
import com.dtelec.icmes.power.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormFullEntity;
import com.dtelec.icmes.power.service.IPowerSupplyService;
import com.dtelec.icmes.power.service.model.DeviceBaseModel;
import com.dtelec.icmes.power.service.model.PowerSupplyFormFullModel;

@Service
public class PowerSupplyServiceImpl implements IPowerSupplyService {

	@Autowired
	IPowereSupplyRepository supplyRepository;
	
	@Autowired
	private IPowerCutRepository powerCutRepository;

	/**
	 * 通过当前时间获取最大送电单号
	 */
	@Override
	public String getMaxcutFormId(String nowTime) {
		return supplyRepository.getMaxcutFormId(nowTime);
	}

	/**
	 *  新建送电申请单
	 * @throws IcmesBusinessException 
	 */
	@Override
	public void createPowerSupplyFrom(PowerSupplyFormFullModel model) throws IcmesBusinessException {
		if (model != null) {
			PowerSupplyFormBaseEntity entity = model.convert();
			try {	
				
				supplyRepository.createPowerSupplyFrom(entity);
				
			}catch(DuplicateKeyException e){
				throw new IcmesBusinessException(IcmesErrorTypeEnum.POWER_CUTFORM_CREATECUTFORM_ISNOTNULL, "该停电申请单号已存在");
			    
			}
		}
	}

	/**
	 * 获取送电申请单详细信息
	 * @throws Exception 
	 */
	@Override
	public PowerSupplyFormFullModel getPowerSupplyFormDetail(String id) throws Exception {
		PowerSupplyFormFullModel model = null;
		
		List<DeviceBaseModel> baseModels = new ArrayList<DeviceBaseModel>();
		
		PowerSupplyFormFullEntity entity = supplyRepository.getPowerSupplyFormById(id);		
		List<DeviceBaseEntity> divices= powerCutRepository.getAssociatedDevicesById(entity.getPowerCutFormId());
		
		for(DeviceBaseEntity divice: divices) {
			DeviceBaseModel diviceModel = new DeviceBaseModel();
			diviceModel.fill(divice);
			baseModels.add(diviceModel);
			
			
		}
		
		if(entity != null) {
			model = new PowerSupplyFormFullModel();
			model.setAssociatedDevices(baseModels);
			model.fill(entity);
		}
		
		return model;
	}
}
