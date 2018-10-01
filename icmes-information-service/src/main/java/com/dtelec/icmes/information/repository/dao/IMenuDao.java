package com.dtelec.icmes.information.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.dtelec.icmes.information.repository.entity.MenuEntity;

@Mapper
public interface IMenuDao {

	List<MenuEntity> getMenuList();
	
}
