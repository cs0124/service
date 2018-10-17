package com.dtelec.icmes.account.service;

import java.util.List;


import com.dtelec.icmes.account.service.model.UserModel;
import com.dtelec.icmes.account.service.param.AccountAssignProxyPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountConsignProxyPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountRolePageableSearchParam;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.account.service.model.AccountAssignProxyCollection;
import com.dtelec.icmes.account.service.model.AccountCollection;
import com.dtelec.icmes.account.service.model.AccountConsignProxyCollection;
import com.dtelec.icmes.account.service.model.AccountModel;
import com.dtelec.icmes.account.service.model.AccountRoleCollection;
import com.dtelec.icmes.account.service.model.EmployeeBaseModel;
import com.dtelec.icmes.account.service.model.EmployeeModel;
import com.dtelec.icmes.account.service.model.FeatureCollection;
import com.dtelec.icmes.account.service.model.RoleModel;


/**
 * 账户service接口
 * @author hlxu
 */
public interface IAccountService {
	
	/**
	 * Login account by given employeeId and password
	 * 
	 * @param employeeId
	 * @param password
	 * 
	 * @return found account
	 */
	UserModel findByIdAndPassword(String employeeId, String password);
	
	/**
	 * 通过员工工号和token获取员工详细信息
	 * @param employeeId
	 * @param token
	 * @return
	 */
	EmployeeModel getEmployeeDetail(String employeeId, String token);
	
	/**
	 * 通过角色信息获取功能
	 * @param roles
	 * @return
	 */
	FeatureCollection getFeaturesByRoles(List<RoleModel> roles);
	
	/**
	 * 获取账号列表
	 * @param params
	 * @return
	 */
	AccountCollection searchAccountByParams(AccountPageableSearchParam params);
	
	/**
	 * 账号角色列表查询
	 * @param params
	 * @return
	 */
	AccountRoleCollection searchAccountRoleByParams(AccountRolePageableSearchParam params);
	
	/**
	 * 账号权限列表查询
	 * @param employeeId
	 * @return
	 */
	FeatureCollection getAccountAllFeatures(String employeeId);
	
	/**
	 * 账号指派代理人列表查询
	 * @param params
	 * @return
	 */
	AccountConsignProxyCollection searchAccountConsignProxyByParams(AccountConsignProxyPageableSearchParam params);
	
	/**
	 * 账号接手代理人查询
	 * @param params
	 * @return
	 */
	AccountAssignProxyCollection searchAccountAssignProxyByParams(AccountAssignProxyPageableSearchParam params);
	
	/**
	 * 创建账号
	 * @param model
	 * @param password
	 * @throws IcmesBusinessException
	 */
	void createAccount(EmployeeBaseModel model, String password) throws IcmesBusinessException;
	
	/**
	 * 编辑账号
	 * @param model
	 * @throws IcmesBusinessException
	 */
	void updateAccount(EmployeeBaseModel model) throws IcmesBusinessException;
	
	/**
	 * 账号角色删除
	 * @param employeeId
	 * @param roleIds
	 * @throws IcmesBusinessException
	 */
	void deleteAccountRoles(String employeeId,String organizationId, List<String> roleIds) throws IcmesBusinessException;
	
	/**
	 * 修改密码
	 * @param employeeId
	 * @param password
	 */
	void changeAccountPassword(String employeeId, String password,boolean changePassword);
	
	/**
	 * 账号锁定或解锁
	 * @param employeeId
	 * @param isLocked
	 */
	void setAccountLockStatus(String employeeId, boolean isLocked);
	
	/**
	 * 账号删除
	 * @param employeeId
	 */
	void deleteAccountByEmployeeId(String employeeId);
	
	/**
	 *通过员工工号 获取账号详情
	 * @param employeeId
	 * @return
	 */
	EmployeeBaseModel fetchAccountDetailWithEmployee(String employeeId);
	
	/**
	 * 给账号分配角色和组织机构
	 * @param employeeId
	 * @param roleId
	 * @param orgId
	 * @throws IcmesBusinessException 
	 */
    void setAccountRelationRoleorganization(String employeeId, String roleId, String orgId) throws IcmesBusinessException;
    
    /**
     * 通过员工工号获取账号详细信息
     * @param employeeId
     * @return
     */
    AccountModel fetchAccountDetail(String employeeId);
    
    /**
     * 通过员工工号修改登录失败次数
     * @param employeeId
     */
    void updateAccountLoginTimes(String employeeId);
	
}
