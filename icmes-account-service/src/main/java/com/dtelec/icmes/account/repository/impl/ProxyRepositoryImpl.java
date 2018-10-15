package com.dtelec.icmes.account.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.account.repository.IProxyRepository;
import com.dtelec.icmes.account.repository.dao.IProxyDao;
import com.dtelec.icmes.account.repository.entity.UserProxyAssignmentBaseEntity;
/**
 * 代理持久层实现类
 * @author zturnking
 *
 */
@Repository
public class ProxyRepositoryImpl implements IProxyRepository{
	/**
	 * 注入代理dao
	 */
	@Autowired
	IProxyDao dao;

	
	/**
	 * 新增指派代理
	 */
	@Override
	public void addUserProxyAssignment(UserProxyAssignmentBaseEntity entity) throws Exception {
		dao.addUserProxyAssignment(entity);
	}

	
	/**
	 * 根据指派代理id指派代理
	 */
	@Override
	public UserProxyAssignmentBaseEntity getUserProxyAssignmentById(int id) throws Exception {
		return dao.getUserProxyAssignmentById(id);
	}

	
	/**
	 * 修改指派代理
	 */
	@Override
	public void updateUserProxyAssignment(UserProxyAssignmentBaseEntity entity) throws Exception {
		 dao.updateUserProxyAssignment(entity);
	}

	
	/**
	 * 根据指派代理id删除指派代理
	 */
	@Override
	public void delUserProxyAssignmentById(int id) throws Exception {
		dao.delUserProxyAssignmentById(id);
	}

}
