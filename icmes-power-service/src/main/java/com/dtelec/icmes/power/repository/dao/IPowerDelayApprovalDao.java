package com.dtelec.icmes.power.repository.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.power.repository.entity.PowerDelayFormApprovalProcessEntity;

/**
 * 延时送电申请审批dao层接口
 * @author 戴常怡
 *
 */
@Mapper
public interface IPowerDelayApprovalDao {
	/**
	 * 根据延时送电申请审批标识获取延时送电申请审批
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PowerDelayFormApprovalProcessEntity getApprovalProcessById(@Param("id") int id);
	
	/**
	 * 新增延时送电申请审批
	 * @param entity
	 * @throws Exception
	 */
	void createPowerDelayFormApprovalProcess(PowerDelayFormApprovalProcessEntity entity);
	
	/**
	 * 修改延时送电申请审批
	 * @param entity
	 * @throws Exception
	 */
	void updatePowerDelayFormApprovalProcess(PowerDelayFormApprovalProcessEntity entity);
}
