package com.dtelec.icmes.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.account.repository.IFeatureRepository;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.service.IFeatureService;
import com.dtelec.icmes.account.service.model.FeatureCollection;
/**
 * 权限特征实现类
 * @author zturnking
 *
 */
@Service
public class FeatureServiceImpl implements IFeatureService {
	/**
	 * 注入权限
	 */
	@Autowired
	private IFeatureRepository featureRepo;
	
	/**
	 * 获取所欲权限
	 */
	@Override
	public FeatureCollection getAllFeatures() {
		FeatureCollection coll = new FeatureCollection();
		List<FeatureEntity> entities = featureRepo.getAllFeatures();
		coll.add(entities);
		
		return coll;
	}

	
	
}
