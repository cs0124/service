package com.dtelec.icmes.account.repository;


import com.dtelec.icmes.account.repository.entity.UserProxyAssignmentBaseEntity;
/**
 * 指派代理持久层接口
 * @author dell
 *
 */
public interface IProxyRepository {	
	//新增指派代理
	public void addUserProxyAssignment( UserProxyAssignmentBaseEntity entity)  throws Exception; 
	//修改指派代理
	public void updateUserProxyAssignment(UserProxyAssignmentBaseEntity entity) throws Exception;
	//根据指派代理id获取指派代理
	public UserProxyAssignmentBaseEntity getUserProxyAssignmentById(int id) throws Exception; 
	//根据指派代理id删除指派代理
	public void delUserProxyAssignmentById(int id) throws Exception ;
	
	
}
