package com.dtelec.icmes.information.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.information.repository.IMenuRepository;
import com.dtelec.icmes.information.service.annotation.QueryAction;
import com.dtelec.icmes.information.service.core.IQueryHandler;
import com.dtelec.icmes.information.service.model.MenuCollection;
import com.dtelec.icmes.information.service.query.MenuListQuery;
import com.dtelec.icmes.information.repository.entity.MenuEntity;

@Service
public class MenuQueryHandler implements IQueryHandler {

	@Autowired
	private IMenuRepository menuRepo;
	
	@QueryAction
	public MenuCollection loadMenuList(MenuListQuery query) {
		MenuCollection coll = new MenuCollection();
		List<MenuEntity> entities = menuRepo.getMenuList();
		coll.fill(entities);
		
		return coll;
	}
	
}
