package com.dtelec.icmes.power.repository;

import com.dtelec.icmes.power.repository.entity.PowerCutFormApprovalProcessEntity;

/**
 * 申请停电审批持久层接口
 * @author 戴常怡
 *
 */
public interface IPowerCutFormApprovalProcessRepository {
	/**
	 * 根据id查询申请停电审批
	 * @param id 参数
	 * @return 申请停电审批实体类
	 */
	PowerCutFormApprovalProcessEntity getPowerCutFormApprovalProcessById(int id);
	
	/**
	 * 新增申请停电审批
	 * @param entity 申请停电审批实体类
	 */
	void addPowerCutFormApprovalProcess(PowerCutFormApprovalProcessEntity entity);
	
	/**
	 * 修改申请停电审批
	 * @param entity 申请停电审批实体类
	 */
	void updatePowerCutFormApprovalProcess(PowerCutFormApprovalProcessEntity entity);
}
