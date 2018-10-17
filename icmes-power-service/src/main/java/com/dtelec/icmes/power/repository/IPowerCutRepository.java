package com.dtelec.icmes.power.repository;

import java.util.List;

import com.dtelec.icmes.power.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.power.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormFullEntity;
import com.dtelec.icmes.power.repository.param.PowerCutPageableQueryParam;
import com.dtelec.icmes.power.repository.param.powerCutAssDeviceQueryParam;;

public interface IPowerCutRepository {
	
	
	/**
	 * 根据申请单标识 获取申请单详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PowerCutFormFullEntity getPowerCutFormById(String id) throws Exception;
	
	
	/**
	 * 新增停电申请单
	 * @param entity
	 * @throws Exception
	 */
	void createPowerCutForm(PowerCutFormBaseEntity entity) throws Exception;
	
	
	/**
	 * 新增停电申请单
	 * @param entity
	 * @throws Exception
	 */
	//void updatePowerCutForm(PowerCutFormBaseEntity entity) throws Exception;

	/**
	 * 获取停电申请单列表
	 * @param params
	 * @return
	 */
	PageableQueryBaseEntity<PowerCutFormBaseEntity> searchPowerCutForm(PowerCutPageableQueryParam params);
	
	/**
	 * 新增申请单关联设备
	 * @param cutFormId
	 * @param assDeviceIds
	 * @throws Exception
	 */
	void createPowerCutFormAssociatedDevice(String cutFormId, List<Integer> assDeviceIds) throws Exception;
	
	
	/**
	 * 新增申请单工作票
	 * @param cutFormId
	 * @param assDeviceIds
	 * @throws Exception
	 */
	void createPowerCutFormWorkTicketPhoto(String cutFormId, List<String> ticketPhotos) throws Exception;
	
	
	/**
	 * 获取最大id
	 * @param nowTime
	 * @return
	 * @throws Exception
	 */
	String getMaxCutFormId(String nowTime) throws Exception;
	
	
	/**
	 * 根据申请单标识获取工作票
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<String> getWorkTicketPhotosById(String id) throws Exception;
	
	
	
	/**
	 * 根据申请单标识获取关联设备
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<DeviceBaseEntity> getAssociatedDevicesById(String id) throws Exception;
	
	
	/**
	 * 根据主设备申请单标识获取关联设备申请单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<PowerCutFormFullEntity> getAssDeviceCutFormsById(powerCutAssDeviceQueryParam param) throws Exception;
}
