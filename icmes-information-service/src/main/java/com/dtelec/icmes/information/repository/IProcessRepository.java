package com.dtelec.icmes.information.repository;

import com.dtelec.icmes.information.repository.entity.PageableSearchBaseEntity;
import com.dtelec.icmes.information.repository.entity.ProcessEntity;
import com.dtelec.icmes.information.repository.param.ProcessPageableSearchParam;

/**
 * 工艺持久层接口
 */
public interface IProcessRepository {

	/**
	 * 新建工艺信息
	 * @param entity 持久层实体类
	 */
	void createProcess(ProcessEntity entity);

	/**
	 * 通过标识符获取工艺详细信息
	 * @param id 标识符
	 * @return 返回实体
	 */
	ProcessEntity getProcessById(int id);

	/**
	 * 编辑工艺信息
	 * @param entity 持久层实体类
	 */
	void updateProcess(ProcessEntity entity);
	
	/**
	 * 删除工艺信息
	 * @param id 标识符
	 */
	void deleteProcess(int id);

	/**
	 * 工艺系统列表
	 * @param params 查询参数
	 * @return 工艺集合
	 */
	PageableSearchBaseEntity<ProcessEntity> updateProcess(ProcessPageableSearchParam params);

	/**
	 * 通过工艺编号查询数据库里是否存在工艺
	 * @param code 工艺编号
	 * @return 持久层实体类
	 */
	ProcessEntity getProcessByCode(String code);

	

}
