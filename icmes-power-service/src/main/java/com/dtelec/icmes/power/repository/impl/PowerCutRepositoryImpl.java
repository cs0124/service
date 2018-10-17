package com.dtelec.icmes.power.repository.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.power.repository.IPowerCutRepository;
import com.dtelec.icmes.power.repository.dao.IPowerCutDao;
import com.dtelec.icmes.power.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.power.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormFullEntity;
import com.dtelec.icmes.power.repository.param.PowerCutPageableQueryParam;
import com.dtelec.icmes.power.repository.param.powerCutAssDeviceQueryParam;

/**
 * 停电申请repository
 * @author dell
 *
 */
@Repository
public class PowerCutRepositoryImpl implements IPowerCutRepository {
	
	/**
	 * 注入停电申请单dao
	 */
	@Autowired
	private IPowerCutDao powerCutDao;
	
	
	/**
	 * 根据申请单标识获取申请单详情
	 */
	@Override
	public PowerCutFormFullEntity getPowerCutFormById(String id) throws Exception {
		return  powerCutDao.getPowerCutFormById(id);
		
	}

	
	/**
	 * 新增停电申请单
	 */
	@Override
	public void createPowerCutForm(PowerCutFormBaseEntity entity) throws Exception {
		powerCutDao.createPowerCutForm(entity);	
	}

	
	
	/**
	 * 修改停电申请单
	 */
	//@Override
	/*public void updatePowerCutForm(PowerCutFormBaseEntity entity) throws Exception {
		powerCutDao.updatePowerCutForm(entity);
	}*/

	
	@Override
	public PageableQueryBaseEntity<PowerCutFormBaseEntity> searchPowerCutForm(PowerCutPageableQueryParam params) {
		PageableQueryBaseEntity<PowerCutFormBaseEntity> entity = new PageableQueryBaseEntity<PowerCutFormBaseEntity>();
		List<PowerCutFormBaseEntity> entities = powerCutDao.searchPowerCutByParams(params);
		//统计条数
		long totalCount = powerCutDao.searchPowerCutTotalCountByParams(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		return entity;
	}
	
	/**
	 * 新增停电申请关联设备
	 */
	@Override
	public void createPowerCutFormAssociatedDevice(String cutFormId, List<Integer> assDeviceIds) throws Exception {
		powerCutDao.createPowerCutFormAssociatedDevice(cutFormId, assDeviceIds);		
	}

	/**
	 * 新增停电申请工作票
	 */
	@Override
	public void createPowerCutFormWorkTicketPhoto(String cutFormId, List<String> ticketPhotos) throws Exception {
		powerCutDao.createPowerCutFormWorkTicketPhoto(cutFormId, ticketPhotos);
	}

	/**
	 * 获取最大申请单id
	 */
	@Override
	public String getMaxCutFormId(String nowTime) throws Exception {
		return powerCutDao.getMaxCutFormId(nowTime);
	}


	/**
	 * 根据申请单标识获取工作票
	 */
	@Override
	public List<String> getWorkTicketPhotosById(String id) throws Exception {
		return powerCutDao.getWorkTicketPhotosById(id);
	}
	
	
	/**
	 * 根据申请单标识获取关联设备
	 */
	@Override
	public	List<DeviceBaseEntity> getAssociatedDevicesById(String id)throws Exception {
		return powerCutDao.getAssociatedDevicesById(id);
	}


	/**
	 *  根据主设备申请单标识获取关联设备申请单
	 */
	@Override
	public List<PowerCutFormFullEntity> getAssDeviceCutFormsById(powerCutAssDeviceQueryParam param) throws Exception {
		
		return powerCutDao.getAssDeviceCutFormsById(param);
		
		
	}
}
