package com.dtelec.icmes.power.repository;
/**
 * 申请送电审批持久层接口
 * @author 戴常怡
 *
 */

import com.dtelec.icmes.power.repository.entity.PowerSupplyFormApprovalProcessEntity;

public interface IPowerSupplyFormApprovalProcessRepository {
	/**
	 * 根据id查询申请送电审批
	 * @param id 参数
	 * @return 申请送电审批实体类
	 */
	PowerSupplyFormApprovalProcessEntity getPowerSupplyFormApprovalProcessById(int id);
	
	/**
	 * 新增申请送电审批
	 * @param entity 申请送电审批实体类
	 */
	void addPowerSupplyFormApprovalProcess (PowerSupplyFormApprovalProcessEntity entity);
	
	/**
	 * 修改申请送电审批
	 * @param entity 申请送电审批实体类
	 */
	void updatePowerSupplyFormApprovalProcess (PowerSupplyFormApprovalProcessEntity entity);
}
