package com.dtelec.icmes.power.repository.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.power.repository.entity.PowerCutFormApprovalProcessEntity;



/**
 * 停电申请审批dao层接口
 * @author 戴常怡
 *
 */
@Mapper
public interface IPowerCutApprovalDao {

	/**
	 * 根据停电申请审批标识获取停电申请审批
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PowerCutFormApprovalProcessEntity getApprovalProcessById(@Param("id") int id);
	
	/**
	 * 新增停电申请审批
	 * @param entity
	 * @throws Exception
	 */
	void createPowerCutFormApprovalProcess(PowerCutFormApprovalProcessEntity entity);
	
	/**
	 *修改停电申请审批
	 * @param entity
	 * @throws Exception
	 */
	void updatePowerCutFormApprovalProcess(PowerCutFormApprovalProcessEntity entity);
}
