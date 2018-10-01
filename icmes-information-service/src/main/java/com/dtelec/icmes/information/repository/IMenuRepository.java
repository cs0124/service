package com.dtelec.icmes.information.repository;

import java.util.List;

import com.dtelec.icmes.information.repository.entity.MenuEntity;

public interface IMenuRepository {

	List<MenuEntity> getMenuList();
	
}
