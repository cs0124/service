package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.information.repository.entity.ProcessEntity;
import com.dtelec.icmes.information.repository.param.ProcessPageableSearchParam;

/**
 * 工艺dao接口
 *
 */
@Mapper
public interface IProcessDao {

	/**
	 * 新建工艺信息
	 * @param entity 持久层实体类
	 */
	void createProcess(@Param("entity") ProcessEntity entity);

	/**
	 * 通过标识符获取工艺详细信息
	 * @param id 标识符
	 * @return 工艺实体类
	 */
	ProcessEntity getProcessById(@Param("id") int id);

	/**
	 * 删除工艺信息
	 * @param id 标识符
	 */
	void deleteProcess(@Param("id") int id);

	/**
	 * 编辑工艺信息
	 * @param entity 工艺实体类
	 */
	void updateProcess(@Param("entity") ProcessEntity entity);

	/**
	 * 工艺列表
 	 * @param params 查询参数
	 * @return 工艺实体类
	 */
	List<ProcessEntity> getProcess(@Param("param") ProcessPageableSearchParam params);

	/**
	 * 根据查询条件返回总记录数
	 * @param params 查询参数
	 * @return 总记录数
	 */
	int getProcessCount(@Param("param") ProcessPageableSearchParam params);

	/**
	 *通过工艺编号查询数据库里是否存在工艺
	 * @param code 工艺编号
	 * @return 持久层实体类
	 */
	ProcessEntity getProcessByCode(@Param("code") String code);

}
