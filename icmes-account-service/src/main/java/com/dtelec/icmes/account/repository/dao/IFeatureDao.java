package com.dtelec.icmes.account.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.account.repository.entity.FeatureEntity;

/**
 * 用于Feature相关的Dao接口
 * 
 * @author hlxu
 *
 */

@Mapper
public interface IFeatureDao {
	/**
	 * 通过角色ids获取功能
	 * @param roleIds
	 * @return
	 */
	List<FeatureEntity> findByRoleIds(@Param("roleIds") List<String> roleIds);
	
	/**
	 * 获取全部功能
	 * @return
	 */
	List<FeatureEntity> getAllFeatures();
	
	/**
	 * 通过角色id获取全部功能
	 * @param roleId
	 * @return
	 */
	List<FeatureEntity> getAllFeatureByRoleId(String roleId);
}
