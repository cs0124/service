package com.dtelec.icmes.power.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.power.repository.IPowerCutRepository;
import com.dtelec.icmes.power.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.power.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormFullEntity;
import com.dtelec.icmes.power.repository.param.PowerCutPageableQueryParam;
import com.dtelec.icmes.power.repository.param.powerCutAssDeviceQueryParam;
import com.dtelec.icmes.power.service.IPowerCutService;
import com.dtelec.icmes.power.service.model.DeviceBaseModel;
import com.dtelec.icmes.power.service.model.PowerCutFormBaseModel;
import com.dtelec.icmes.power.service.model.PowerCutFormCollection;
import com.dtelec.icmes.power.service.model.PowerCutFormFullModel;
import com.dtelec.icmes.power.service.param.PowerCutPageableSearchParam;

/**
 * 停电申请service
 * @author dell
 *
 */
@Service
public class PowerCutServiceImpl implements IPowerCutService {
	
	/**
	 * 注入停电申请单
	 */
	@Autowired
	private IPowerCutRepository powerCutRepository;
	
	
	/**
	 * 通过申请单标识获取申请单详情
	 */
	@Override
	public PowerCutFormFullModel getPowerCutFormDetailById(String id) throws Exception {
		PowerCutFormFullModel fullModel = null;	
		List<DeviceBaseModel> baseModels = new ArrayList<DeviceBaseModel>();
		
		PowerCutFormFullEntity entity = powerCutRepository.getPowerCutFormById(id);		
		List<DeviceBaseEntity> divices= powerCutRepository.getAssociatedDevicesById(id);
		List<String> photos = powerCutRepository.getWorkTicketPhotosById(id);
		
		for(DeviceBaseEntity divice: divices) {
			DeviceBaseModel diviceModel = new DeviceBaseModel();
			diviceModel.fill(divice);
			baseModels.add(diviceModel);
			
			
		}
		
		if(entity != null) {
			fullModel = new PowerCutFormFullModel();
			fullModel.setWorkTicketPhotos(photos);
			fullModel.setAssociatedDevices(baseModels);
			fullModel.fillFullEntity(entity);
		}
		
		return fullModel;
	}

	
	/**
	 * 新增停电申请单
	 */
	@Override
	public void createPowerCutForm(PowerCutFormBaseModel model, List<Integer> assDeviceIds, List<String> ticketPhotos) throws Exception {
		if(model !=null) {
			for(Integer assDeviceId : assDeviceIds) {
				int mainDeviceId = model.getMainDeviceId();
				if(mainDeviceId == assDeviceId) {
					throw new IcmesBusinessException(IcmesErrorTypeEnum.POWER_CUTFORM_CREATECUTFORM_DEVICEIDERROR, "关联设备不能与主设备相同！");
				    
				}
			}
			
			PowerCutFormBaseEntity entity = model.convert();
			try {				
				powerCutRepository.createPowerCutForm(entity);			
			}catch(DuplicateKeyException e){
				throw new IcmesBusinessException(IcmesErrorTypeEnum.POWER_CUTFORM_CREATECUTFORM_ISNOTNULL, "该停电申请单号已存在！");
			    
			}
			powerCutRepository.createPowerCutFormAssociatedDevice(entity.getId(), assDeviceIds);
			powerCutRepository.createPowerCutFormWorkTicketPhoto(entity.getId(), ticketPhotos);
		}

	}
	
	
	
	
	/**
	 * 获取停电申请单列表
	 * @param params
	 * @return
	 */
	@Override
	public PowerCutFormCollection searchPowerCutFormByParams(PowerCutPageableSearchParam params) {
		int pageNo = params.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = params.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		PowerCutPageableQueryParam queryParam = new PowerCutPageableQueryParam();
		queryParam.setDevice(params.getDevice());
		queryParam.setNumber(params.getNumber());
		queryParam.setStatusList(params.getStatusList());
		queryParam.setGlobalName(params.getGlobalName());
		queryParam.setOrderBy(params.getOrderBy());
		queryParam.setAscending(params.isAscending());
		queryParam.setPageSize(pageSize);
		queryParam.setStartIndex(startIndex);
		
		PageableQueryBaseEntity<PowerCutFormBaseEntity> powerCutFormEntities= powerCutRepository.searchPowerCutForm(queryParam);
		PowerCutFormCollection powerCutCollection = new PowerCutFormCollection();
		powerCutCollection.fill(powerCutFormEntities, params.getCount());
		return powerCutCollection;
	}


	
	/**
	 * 获取最大id
	 */
	@Override
	public String getMaxcutFormId(String nowTime) throws Exception {
	
		return powerCutRepository.getMaxCutFormId(nowTime);
	}


	/**
	 * 根据申请单表示获取相关设备申请单
	 */
	@Override
	public PowerCutFormCollection getAssDeviceCutFormsById(String id) throws Exception {
		
		PowerCutFormCollection powerCutFormCollection = new PowerCutFormCollection();
		List<PowerCutFormBaseModel> modelList = new ArrayList<PowerCutFormBaseModel>();	
		powerCutAssDeviceQueryParam param = new powerCutAssDeviceQueryParam();
		
		//根据申请单标识获取该申请单
		PowerCutFormFullEntity powerCutForm = powerCutRepository.getPowerCutFormById(id);
		//主设备计划停电时间
		Date scheduledCutOffTime = powerCutForm.getScheduledCutOffTime();
		//主设备计划供电时间
		Date scheduledSupplyTime = powerCutForm.getScheduledSupplyTime();	
		
		param.setId(id);
		param.setScheduledCutOffTime(scheduledCutOffTime);
		param.setScheduledSupplyTime(scheduledSupplyTime);
		//调用持久层
		List<PowerCutFormFullEntity>  entitylist = powerCutRepository.getAssDeviceCutFormsById(param);
		for(PowerCutFormFullEntity entity : entitylist) {
			PowerCutFormBaseModel model = new PowerCutFormBaseModel();
			model.fillFullEntity(entity);
			modelList.add(model);
		}
		powerCutFormCollection.setItems(modelList);
		
		return powerCutFormCollection;
	}

}
