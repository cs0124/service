package com.dtelec.icmes.account.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dtelec.icmes.account.repository.entity.FeatureEntity;
/**
 * 权限集合
 * @author zturnking
 *
 */
public class FeatureCollection {
	/**
	 * 权限列表
	 */
	private List<FeatureModel> list;
		
	public FeatureCollection() {
		list = new ArrayList<>();
	}
	/**
	 * 新增实体
	 * @param entities
	 */
	public void add(List<FeatureEntity> entities) {
		if (entities != null) {
			for (FeatureEntity entity : entities) {
				FeatureModel model = new FeatureModel();
				model.fill(entity);
				list.add(model);
			}
		}
	}
	
	
	public List<FeatureModel> getList() {
		return list;
	}

	public Map<String, Map<String, Boolean>> getFeatureMapping() {
		Map<String, Map<String, Boolean>> mapping = new HashMap<>();
		for (FeatureModel model : this.list) {
			String key = String.valueOf(model.getMenuId());
			Map<String, Boolean> item = null;
			if (mapping.containsKey(key)) {
				item = mapping.get(key);
			}
			else {
				item = new HashMap<>();
				mapping.put(key, item);
			}
			item.put(model.getCode(), true);
		}
		return mapping;
	}
	
	public Map<String, List<FeatureModel>> getFeatureModelMapping() {
		Map<String, List<FeatureModel>> mapping = new HashMap<>();
		for (FeatureModel model : this.list) {
			String key = String.valueOf(model.getMenuId());
			List<FeatureModel> featureList = null;
			if (mapping.containsKey(key)) {
				featureList = mapping.get(key);
			}
			else {
				featureList = new ArrayList<>();
				mapping.put(key, featureList);
			}
			featureList.add(model);
		}
		
		return mapping;
	}
	
}
