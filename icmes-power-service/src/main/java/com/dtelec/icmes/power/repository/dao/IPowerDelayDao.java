package com.dtelec.icmes.power.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.power.repository.entity.PowerDelayFormBaseEntity;
import com.dtelec.icmes.power.repository.entity.PowerDelayFormFullEntity;
import com.dtelec.icmes.power.repository.param.PowerDelayPageableQueryParam;


/**
 * 延迟送电申请表dao层接口
 * @author Shaoyi Chen
 *
 */
@Mapper
public interface IPowerDelayDao {

	
	/**
	 * 根据申请单标识获取申请单详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PowerDelayFormFullEntity getPowerDelayFormById(@Param("id")  String id) throws Exception;
	
	
	/**
	 * 新增延迟送电申请单
	 * @param entity
	 * @throws Exception
	 */
	void createPowerDelayForm( PowerDelayFormBaseEntity entity) throws Exception;
	
	
	/**
	 *修改停电申请单
	 * @param entity
	 * @throws Exception
	 */
	void updatePowerDelayForm(@Param("entity") PowerDelayFormBaseEntity entity) throws Exception;

	/**
	 * 获取停电申请表列表
	 * @param params
	 * @return
	 */
	List<PowerDelayFormBaseEntity> searchPowerDelayByParams(@Param("params") PowerDelayPageableQueryParam params);
	
	/**
	 * 获取停电申请表列表总数
	 * @param params
	 * @return
	 */
	long searchPowerDelayTotalCountByParams(@Param("params") PowerDelayPageableQueryParam params);

	/**
	 *获取当天最大延迟送电id
	 * @param nowTime
	 * @return
	 */
	String getMaxDelayFormId(String nowTime);
	
	/**
	 *查看停电申请单是否有未审批的延迟送电申请单
	 * @param powerCutFormId
	 * @return
	 */
	Integer getUnapprovedPowerDelayFormNumber(String powerCutFormId);
}
