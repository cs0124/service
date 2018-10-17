package com.dtelec.icmes.power.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dtelec.icmes.power.repository.IPowerCutFormApprovalProcessRepository;
import com.dtelec.icmes.power.repository.dao.IPowerCutApprovalDao;
import com.dtelec.icmes.power.repository.entity.PowerCutFormApprovalProcessEntity;

/**
 * 申请停电审批持久层实现类
 * @author 戴常怡
 *
 */
public class PowerCutFormApprovalProcessRepositoryImpl implements IPowerCutFormApprovalProcessRepository{

	@Autowired
	IPowerCutApprovalDao powerCutApprovalDao;
	
	/**
	 * 根据id查询申请停电审批
	 */
	@Override
	public PowerCutFormApprovalProcessEntity getPowerCutFormApprovalProcessById(int id) {
		return powerCutApprovalDao.getApprovalProcessById(id);
	}

	/**
	 * 新增申请停电审批
	 */
	@Override
	public void addPowerCutFormApprovalProcess(PowerCutFormApprovalProcessEntity entity) {

		powerCutApprovalDao.createPowerCutFormApprovalProcess(entity);		
	}
	
	/**
	 * 修改申请停电审批
	 */
	@Override
	public void updatePowerCutFormApprovalProcess(PowerCutFormApprovalProcessEntity entity) {
		
		powerCutApprovalDao.updatePowerCutFormApprovalProcess(entity);
	}

}
