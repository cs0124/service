package com.dtelec.icmes.power.repository.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.power.repository.IPowerDelayRepository;
import com.dtelec.icmes.power.repository.dao.IPowerDelayDao;
import com.dtelec.icmes.power.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerDelayFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerDelayFormFullEntity;
import com.dtelec.icmes.power.repository.param.PowerDelayPageableQueryParam;

/**
 * 延迟送电申请表repo实现
 * @author Shaoyi Chen
 *
 */
@Repository
public class PowerDelayRepositoryImpl implements IPowerDelayRepository {
	
	/**
	 * 注入延迟送电申请单dao
	 */
	@Autowired
	private IPowerDelayDao powerDelayDao;
	
	
	/**
	 * 根据申请单标识获取申请单详情
	 */
	@Override
	public PowerDelayFormFullEntity getPowerDelayFormById(String id) throws Exception {
		return powerDelayDao.getPowerDelayFormById(id);
	}

	
	/**
	 * 新增停电申请单
	 */
	@Override
	public void createPowerDelayForm(PowerDelayFormBaseEntity entity) throws Exception {
		powerDelayDao.createPowerDelayForm(entity);	
	}

	
	@Override
	public void updatePowerDelayForm(PowerDelayFormBaseEntity entity) throws Exception {
		powerDelayDao.updatePowerDelayForm(entity);
	}

	
	@Override
	public PageableQueryBaseEntity<PowerDelayFormBaseEntity> searchPowerDelayForm(PowerDelayPageableQueryParam params) {
		PageableQueryBaseEntity<PowerDelayFormBaseEntity> entity = new PageableQueryBaseEntity<PowerDelayFormBaseEntity>();
		List<PowerDelayFormBaseEntity> entities = powerDelayDao.searchPowerDelayByParams(params);
		//统计条数
		long totalCount = powerDelayDao.searchPowerDelayTotalCountByParams(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		return entity;
	}


	@Override
	public String getMaxDelayFormId(String nowTime) throws Exception {
		return powerDelayDao.getMaxDelayFormId(nowTime);
	}


	@Override
	public boolean hasUnapprovedPowerDelayForm(String powerCutFormId) throws Exception {
		return powerDelayDao.getUnapprovedPowerDelayFormNumber(powerCutFormId)>0?true:false;
	}

}
