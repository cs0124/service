package com.dtelec.icmes.power.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dtelec.icmes.power.repository.IPowerSupplyFormApprovalProcessRepository;
import com.dtelec.icmes.power.repository.dao.IPowerSupplyApprovalDao;
import com.dtelec.icmes.power.repository.entity.PowerSupplyFormApprovalProcessEntity;

/**
 * 申请送电审批持久层实现类
 * @author 戴常怡
 *
 */
public class PowerSupplyFormApprovalProcessRepositoryImpl implements IPowerSupplyFormApprovalProcessRepository{

	@Autowired
	IPowerSupplyApprovalDao powerSupplyApprovalDao;

	/**
	 * 根据id查询申请送电审批
	 */
	@Override
	public PowerSupplyFormApprovalProcessEntity getPowerSupplyFormApprovalProcessById(int id) {
		return powerSupplyApprovalDao.getApprovalProcessById(id);
	}
	
	/**
	 * 新增申请送电审批
	 */
	@Override
	public void addPowerSupplyFormApprovalProcess(PowerSupplyFormApprovalProcessEntity entity) {
		powerSupplyApprovalDao.createPowerSupplyFormApprovalProcess(entity);
	}

	/**
	 * 修改申请送电审批
	 */
	@Override
	public void updatePowerSupplyFormApprovalProcess(PowerSupplyFormApprovalProcessEntity entity) {
		powerSupplyApprovalDao.updatePowerSupplyFormApprovalProcess(entity);
	}
	
}
