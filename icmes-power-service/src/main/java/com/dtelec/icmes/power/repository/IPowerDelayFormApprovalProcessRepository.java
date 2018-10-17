package com.dtelec.icmes.power.repository;

import com.dtelec.icmes.power.repository.entity.PowerDelayFormApprovalProcessEntity;

/**
 * 申请延时送电审批持久层接口
 * @author 戴常怡
 *
 */
public interface IPowerDelayFormApprovalProcessRepository {
	/**
	 * 根据id查询申请延时送电审批
	 * @param id 参数
	 * @return 申请延时送电审批实体类
	 */
	PowerDelayFormApprovalProcessEntity getPowerDelayFormApprovalProcessById(int id);
	
	/**
	 * 新增申请延时送电审批
	 * @param entity 申请延时送电审批实体类
	 */
	void addPowerDelayFormApprovalProcess(PowerDelayFormApprovalProcessEntity entity);
	
	/**
	 * 修改申请延时送电审批
	 * @param entity 申请延时送电审批实体类
	 */
	void updatePowerDelayFormApprovalProcess(PowerDelayFormApprovalProcessEntity entity);
}
