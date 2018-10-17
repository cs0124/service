package com.dtelec.icmes.power.repository.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.power.repository.entity.PowerSupplyFormApprovalProcessEntity;

/**
 * 送电申请审批dao层接口
 * @author changyi dai
 *
 */
@Mapper
public interface IPowerSupplyApprovalDao {
	/**
	 * 根据送电申请审批标识获取送电申请审批详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PowerSupplyFormApprovalProcessEntity getApprovalProcessById(@Param("id") int id);
	
	/**
	 * 新增送电申请审批
	 * @param entity
	 * @throws Exception
	 */
	void createPowerSupplyFormApprovalProcess(PowerSupplyFormApprovalProcessEntity entity);
	
	/**
	 * 修改送电申请审批
	 * @param entity
	 * @throws Exception
	 */
	void updatePowerSupplyFormApprovalProcess(PowerSupplyFormApprovalProcessEntity entity);
}
