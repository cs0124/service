package com.dtelec.icmes.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.account.repository.IProxyRepository;
import com.dtelec.icmes.account.repository.entity.UserProxyAssignmentBaseEntity;
import com.dtelec.icmes.account.service.IProxyService;
import com.dtelec.icmes.account.service.model.UserProxyAssignmentModel;


/**
 * 指派代理service实现类
 * @author dell
 *
 */

@Service 
public class ProxyServicelmpl implements IProxyService{
	@Autowired
	private IProxyRepository repository;
	
	/**
	 * 新增指派代理
	 */
	@Override
	public void addUserProxyAssignment(UserProxyAssignmentModel model) throws Exception {
		//调用持久层
		repository.addUserProxyAssignment(model.convert());
		
	}
	
	
	/**
	 * 根据指派代理id获取指派代理
	 */
	@Override
	public UserProxyAssignmentModel getUserProxyAssignmentById(int id) throws Exception {
		UserProxyAssignmentModel model = null;
		//调用持久层
		UserProxyAssignmentBaseEntity entity = repository.getUserProxyAssignmentById(id);
		if (entity != null) {
			//entity to model
			model = new UserProxyAssignmentModel();
			model.fill(entity);
		}
		return model;
	}
	
	
	/**
	 * 更新指派代理
	 */
	@Override
	public void updateUserProxyAssignment(UserProxyAssignmentModel model) throws Exception {
		//model to entity
		UserProxyAssignmentBaseEntity entity = model.convert();
		//调用持久层
		repository.updateUserProxyAssignment(entity);
		
	}
	
	
	/**
	 * 根据指派代理id 删除代理信息
	 */
	@Override
	public void delUserProxyAssignmentById(int id) throws Exception {
		//调用持久层
		repository.delUserProxyAssignmentById(id);
		
	}


}
