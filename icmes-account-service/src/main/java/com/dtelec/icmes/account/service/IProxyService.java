package com.dtelec.icmes.account.service;


import com.dtelec.icmes.account.service.model.UserProxyAssignmentModel;
/**
 * 代理service接口
 * @author dell
 *
 */
public interface IProxyService {
	//新增指派代理	
	public void addUserProxyAssignment( UserProxyAssignmentModel model)  throws Exception;
	//修改指派代理
	public void updateUserProxyAssignment( UserProxyAssignmentModel model)  throws Exception;	
	//根据指派代理编号获取指派代理
	public UserProxyAssignmentModel getUserProxyAssignmentById( int id) throws Exception;
	//根据指派代理id删除指派代理
	public void delUserProxyAssignmentById(int id) throws Exception;

}
