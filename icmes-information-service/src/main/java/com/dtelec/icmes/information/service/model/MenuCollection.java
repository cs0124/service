package com.dtelec.icmes.information.service.model;

import java.util.ArrayList;
import java.util.List;

import com.dtelec.icmes.information.repository.entity.MenuEntity;

public class MenuCollection {

	private List<MenuModel> list;
	
	public MenuCollection() {
		this.list = new ArrayList<>();
	}
	
	public void fill(List<MenuEntity> entities) {
		if (entities != null) {
			for (MenuEntity entity : entities) {
				MenuModel model = new MenuModel();
				model.fill(entity);
				this.list.add(model);
			}
		}
	}

	public List<MenuModel> getList() {
		return list;
	}
	
}
