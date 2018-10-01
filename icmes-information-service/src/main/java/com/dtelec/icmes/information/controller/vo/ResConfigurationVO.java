package com.dtelec.icmes.information.controller.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dtelec.icmes.information.service.model.DictCollection;
import com.dtelec.icmes.information.service.model.DictModel;
import com.dtelec.icmes.information.service.model.FeatureTreeModel;
import com.dtelec.icmes.information.service.model.MenuCollection;
import com.dtelec.icmes.information.service.model.MenuModel;

public class ResConfigurationVO {

	public Map<String, MenuVO> menus;
	public Map<String, DictVO> dicts;
    public List<FeatureTreeModel> features;
	
	public class MenuVO {
		public String name;
		public int order;
		public Map<String, MenuVO> childs;
	}
	
	public class DictVO {
		public String name;
		public int order;
		public boolean disabled;
		public Map<String, DictVO> options;
	}
	
	public void fillVo(MenuCollection menuColl, DictCollection dictColl) {
		if (menuColl != null) {
			List<MenuModel> list = menuColl.getList();
			if (list != null && list.isEmpty() == false) {
				this.menus = new HashMap<>();
				for (MenuModel model : list) {
					String id = String.valueOf(model.getId());
					String parentId = String.valueOf(model.getParentId());
					MenuVO vo = new MenuVO();
					vo.name = model.getName();
					vo.order = model.getDisplayOrder();
					vo.childs = null;
						
					if (this.menus.containsKey(parentId)) {
						MenuVO parentVo = this.menus.get(parentId);
						Map<String, MenuVO> childMap;
						if (parentVo.childs == null) {
							parentVo.childs = childMap = new HashMap<>();
						}
						else {
							 childMap= parentVo.childs;
						}
						childMap.put(id, vo);
					}
					else {
						this.menus.put(id, vo);
					}
				}
			}
		}	
		if (dictColl != null) {
			List<DictModel> list = dictColl.getList();
			if (list != null && list.isEmpty() == false) {
				this.dicts = new HashMap<>();
				for (DictModel model : list) {
					String code = model.getCode();
					String typeCode = model.getTypeCode();
					DictVO vo = new DictVO();
					vo.name = model.getName();
					vo.order = model.getOrder();
					vo.disabled = model.isDisabled();
					vo.options = null;
						
					if (this.dicts.containsKey(typeCode)) {
						DictVO typeVo = this.dicts.get(typeCode);
						Map<String, DictVO> optMap;
						if (typeVo.options == null) {
							typeVo.options = optMap = new HashMap<>();
						}
						else {
							optMap= typeVo.options;	
						}
						optMap.put(code, vo);
					}
					else {
						DictVO typeVo = new DictVO();
						typeVo.name = model.getTypeName();
						typeVo.order = 0;
						typeVo.disabled = false;
						typeVo.options = new HashMap<>();
						typeVo.options.put(code, vo);
							
						this.dicts.put(typeCode, typeVo);
					}
				}
			}
		}
	}
	
}
