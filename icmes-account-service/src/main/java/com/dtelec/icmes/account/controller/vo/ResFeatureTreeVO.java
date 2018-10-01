package com.dtelec.icmes.account.controller.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dtelec.icmes.account.service.model.FeatureCollection;
import com.dtelec.icmes.account.service.model.FeatureModel;
import com.dtelec.icmes.account.service.model.MenuModel;


public class ResFeatureTreeVO {

	public String id;
	public String label;
	public String code;
	public boolean isFeature;
	public List<ResFeatureTreeVO> children;
	
	
	public static List<ResFeatureTreeVO> convertFeatureTree(List<MenuModel> menuList, FeatureCollection featureList) {
		List<ResFeatureTreeVO> tree = new ArrayList<>();
		if (menuList != null && menuList.isEmpty() == false) {
			Map<String, List<FeatureModel>> featureMap = featureList.getFeatureModelMapping();
			if (featureMap == null) {
				featureMap = new HashMap<>();
			}
			
			tree = new ArrayList<>();
			Map<String, List<ResFeatureTreeVO>> menuMap = new HashMap<>();
			for (MenuModel model : menuList) {
				String id = String.valueOf(model.getId());
				String parentId = String.valueOf(model.getParentId());
				ResFeatureTreeVO vo = new ResFeatureTreeVO();
				vo.id = String.valueOf(model.getId());
				vo.label = model.getName();
				vo.code = String.valueOf(model.getDisplayOrder());
				vo.isFeature = false;
				vo.children = new ArrayList<>();
				
				if (menuMap.containsKey(parentId)) {
					List<ResFeatureTreeVO> childrenNodes = menuMap.get(parentId);
					childrenNodes.add(vo);
				}
				else {
					menuMap.put(id, vo.children);
					tree.add(vo);
				}
				
				List<FeatureModel> featureItems = featureMap.get(id);
				if (featureItems != null && featureItems.isEmpty() == false) {
					for (FeatureModel featureModel : featureItems ) {
						ResFeatureTreeVO fvo = new ResFeatureTreeVO();
						fvo.id = String.valueOf(featureModel.getId());
						fvo.label = featureModel.getName();
						fvo.code = featureModel.getCode();
						fvo.isFeature = true;
						fvo.children = new ArrayList<>();
						
						vo.children.add(fvo);
					}
				}
				
			}
		}
		
		return tree;
	}	
}
