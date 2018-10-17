package com.dtelec.icmes.power.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.power.repository.entity.DeviceBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerCutFormFullEntity;
import com.dtelec.icmes.power.repository.param.PowerCutPageableQueryParam;
import com.dtelec.icmes.power.repository.param.powerCutAssDeviceQueryParam;


/**
 * 停电申请表dao层接口
 * @author hlxu
 *
 */
@Mapper
public interface IPowerCutDao {

	
	/**
	 * 根据申请单标识获取申请单详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PowerCutFormFullEntity getPowerCutFormById(@Param("id")  String id) throws Exception;
	
	
	/**
	 * 新增停电申请单
	 * @param entity
	 * @throws Exception
	 */
	void createPowerCutForm(PowerCutFormBaseEntity entity) throws Exception;
	
	
	/**
	 * 获取停电申请表列表
	 * @param params
	 * @return
	 */
	List<PowerCutFormBaseEntity> searchPowerCutByParams(@Param("params") PowerCutPageableQueryParam params);
	
	/**
	 * 获取停电申请表列表总数
	 * @param params
	 * @return
	 */
	long searchPowerCutTotalCountByParams(@Param("params") PowerCutPageableQueryParam params);
	
	
	/**
	 * 新增申请单关联设备
	 * @param cutFormId
	 * @param assDeviceIds
	 */
	void createPowerCutFormAssociatedDevice(@Param("cutFormId")String cutFormId,@Param("assDeviceIds") List<Integer> assDeviceIds);
	
	
	/**
	 * 新增申请单工作票
	 * @param cutFormId
	 * @param ticketPhotos
	 */
	void createPowerCutFormWorkTicketPhoto(@Param("cutFormId")String cutFormId, @Param("ticketPhotos")List<String> ticketPhotos);

	
	/**
	 * 获取最大id
	 * @param nowTime
	 * @return
	 */
	String getMaxCutFormId(String nowTime);
	
	
	/**
	 * 根据申请单标识获取工作票
	 * @param id
	 * @return
	 */
	public List<String> getWorkTicketPhotosById(String id);

	
	/**
	 * 根据申请单标识获取工作票
	 * @param id
	 * @return
	 */
	public List<DeviceBaseEntity> getAssociatedDevicesById(String id);
	
	
	/**
	 *  根据主设备申请单标识获取关联设备申请单
	 * @param id
	 * @return
	 */
	public List<PowerCutFormFullEntity> getAssDeviceCutFormsById(@Param("param") powerCutAssDeviceQueryParam param);
}
