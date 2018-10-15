package com.dtelec.icmes.account.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.account.repository.IFeatureRepository;
import com.dtelec.icmes.account.repository.dao.IFeatureDao;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
/**
 * 权限持久层实现类
 * @author zturnking
 *
 */
@Repository
public class FeatureRepositoryImpl implements IFeatureRepository {
	/**
	 * 注入权限dao
	 */
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
