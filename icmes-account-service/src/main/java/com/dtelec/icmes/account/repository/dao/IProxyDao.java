package com.dtelec.icmes.account.repository.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dtelec.icmes.account.repository.entity.UserProxyAssignmentBaseEntity;

/**
 * 指派代理dao层接口
 * @author dell
 *
 */
@Mapper
public interface IProxyDao {
	//新增指派代理
	public void addUserProxyAssignment(UserProxyAssignmentBaseEntity entity);
	//修改指派代理
	public void updateUserProxyAssignment(UserProxyAssignmentBaseEntity entity) throws Exception;
	//根据指派代理id 获取指派代理
	public UserProxyAssignmentBaseEntity getUserProxyAssignmentById(int id );
	//根据指派代理id 删除指派代理
	public void delUserProxyAssignmentById(int id) throws Exception ;

}
