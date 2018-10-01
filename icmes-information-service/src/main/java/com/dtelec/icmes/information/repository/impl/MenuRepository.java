package com.dtelec.icmes.information.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.information.repository.IMenuRepository;
import com.dtelec.icmes.information.repository.dao.IMenuDao;
import com.dtelec.icmes.information.repository.entity.MenuEntity;

@Repository
public class MenuRepository implements IMenuRepository {

	@Autowired
	private IMenuDao menuDao;
	
	@Override
	public List<MenuEntity> getMenuList() {
		return this.menuDao.getMenuList();
	}
	
	

}
