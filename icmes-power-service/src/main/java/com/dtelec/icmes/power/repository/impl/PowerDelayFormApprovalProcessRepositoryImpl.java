package com.dtelec.icmes.power.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dtelec.icmes.power.repository.IPowerDelayFormApprovalProcessRepository;
import com.dtelec.icmes.power.repository.dao.IPowerDelayApprovalDao;
import com.dtelec.icmes.power.repository.entity.PowerDelayFormApprovalProcessEntity;

/**
 * 申请延时送电审批持久层实现类
 * @author 戴常怡
 *
 */
public class PowerDelayFormApprovalProcessRepositoryImpl implements IPowerDelayFormApprovalProcessRepository{
	
	@Autowired
	IPowerDelayApprovalDao powerDelayApprovalDao;
	
	/**
	 * 根据id查询申请延时送电审批
	 */
	@Override
	public PowerDelayFormApprovalProcessEntity getPowerDelayFormApprovalProcessById(int id) {
		return powerDelayApprovalDao.getApprovalProcessById(id);
	}

	/**
	 * 新增申请延时送电审批
	 */
	@Override
	public void addPowerDelayFormApprovalProcess(PowerDelayFormApprovalProcessEntity entity) {

		powerDelayApprovalDao.createPowerDelayFormApprovalProcess(entity);		
	}

	/**
	 * 修改申请延时送电审批
	 */
	@Override
	public void updatePowerDelayFormApprovalProcess(PowerDelayFormApprovalProcessEntity entity) {
		
		powerDelayApprovalDao.updatePowerDelayFormApprovalProcess(entity);
	}

}
