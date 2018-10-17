package com.dtelec.icmes.power.repository;

import com.dtelec.icmes.power.repository.entity.PowerDelayFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerDelayFormFullEntity;
import com.dtelec.icmes.power.repository.param.PowerDelayPageableQueryParam;
import com.dtelec.icmes.power.repository.entity.PageableQueryBaseEntity;

/**
 * 延迟送电申请表repo层接口
 * @author Shaoyi Chen
 *
 */
public interface IPowerDelayRepository {
	
	
	/**
	 * 根据申请单标识 获取申请单详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PowerDelayFormFullEntity getPowerDelayFormById(String id) throws Exception;
	
	
	/**
	 * 新增延迟送电申请单
	 * @param entity
	 * @throws Exception
	 */
	void createPowerDelayForm(PowerDelayFormBaseEntity entity) throws Exception;
	
	
	/**
	 * 修改延迟送电申请单
	 * @param entity
	 * @throws Exception
	 */
	void updatePowerDelayForm(PowerDelayFormBaseEntity entity) throws Exception;

	/**
	 * 获取延迟送电申请单列表
	 * @param params
	 * @return
	 */
	PageableQueryBaseEntity<PowerDelayFormBaseEntity> searchPowerDelayForm(PowerDelayPageableQueryParam params);

	/**
	 *获取当天最大延迟送电id
	 * @param nowTime
	 * @return
	 * @throws Exception
	 */
	String getMaxDelayFormId(String nowTime)  throws Exception;
	
	/**
	 *查看停电申请单是否有未审批的延迟送电申请单
	 * @param powerCutFormId
	 * @return
	 * @throws Exception
	 */
	boolean hasUnapprovedPowerDelayForm(String powerCutFormId)  throws Exception;
}
