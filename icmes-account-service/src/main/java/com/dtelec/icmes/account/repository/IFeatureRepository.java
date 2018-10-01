package com.dtelec.icmes.account.repository;

import java.util.List;


import com.dtelec.icmes.account.repository.entity.FeatureEntity;

public interface IFeatureRepository {
	/**
	 * 通过角色ids获取功能
	 * @param roleIds
	 * @return
	 */
	public List<FeatureEntity> findByRoleIds(List<String> roleIds);
	
	/**
	 * 获取全部功能
	 * @return
	 */
	public List<FeatureEntity> getAllFeatures();
	
}
