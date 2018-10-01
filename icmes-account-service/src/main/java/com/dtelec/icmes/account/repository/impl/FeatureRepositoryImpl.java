package com.dtelec.icmes.account.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.account.repository.IFeatureRepository;
import com.dtelec.icmes.account.repository.dao.IFeatureDao;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;

@Repository
public class FeatureRepositoryImpl implements IFeatureRepository {

	@Autowired
	private IFeatureDao featureDao;
	
	/**
	 * 通过角色ids获取功能
	 */
	@Override
	public List<FeatureEntity> findByRoleIds(List<String> roleIds) {
		if (roleIds != null && roleIds.size() > 0) {
			return featureDao.findByRoleIds(roleIds);	
		}
		
		return null;
	}
	
	/**
	 * 获取全部功能
	 */
	@Override
	public List<FeatureEntity> getAllFeatures() {
		return featureDao.getAllFeatures();
	}

}
