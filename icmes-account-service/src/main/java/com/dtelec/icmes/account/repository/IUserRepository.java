package com.dtelec.icmes.account.repository;


import java.util.List;


import com.dtelec.icmes.account.repository.entity.AccountAssignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountConsignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountEntity;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.repository.entity.AccountRoleEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.entity.UserEntity;
import com.dtelec.icmes.account.repository.param.AccountAssignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountConsignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountRolePageableQueryParam;

public interface IUserRepository {
	/**
	 * 获取账号列表
	 * @param params
	 * @return
	 */
	PageableQueryBaseEntity<AccountEntity> searchAccount(AccountPageableQueryParam params);
	
	/**
	 *查询当前员工ID的角色和组织机构
	 * @param params
	 * @return
	 */
	PageableQueryBaseEntity<AccountRoleEntity> searchAccountRoleByParams(AccountRolePageableQueryParam params);
	
	/**
	 * 账号指派代理人列表查询
	 * @param params
	 * @return
	 */
	PageableQueryBaseEntity<AccountConsignProxyEntity> searchAccountConsignProxyByParams(AccountConsignProxyPageableQueryParam params);
	
	/**
	 * 账号权限列表查询
	 * @param employeeId
	 * @return
	 */
	List<FeatureEntity> getAccountAllFeatures(String employeeId);
	
	/**
	 * 账号接手代理人查询
	 * @param params
	 * @return
	 */
	PageableQueryBaseEntity<AccountAssignProxyEntity> searchAccountAssignProxyByParams(AccountAssignProxyPageableQueryParam params);
	
	/**
	 * 创建账号
	 * @param employeeId
	 * @param password
	 */
	void createAccount(String employeeId, String password);
	
	/**
	 * 通过员工工号获取账号信息
	 * @param employeeId
	 * @return
	 */
	UserEntity findUserByEmployeeId(String employeeId);
	
	/**
	 *  通过员工工号获取账号详细信息
	 * @param employeeId
	 * @return
	 */
	AccountEntity findAccountByEmployeeId(String employeeId);
	/**
	 * 检测是否和代理表有关联
	 * @param employeeId
	 * @param roleIds
	 * @return
	 */
	int checkUserRoleAssProxy(String employeeId, List<String> roleIds);
	
	/**
	 * 账号角色删除
	 * @param employeeId
	 * @param roleIds
	 */
	void deleteAccountRoleAss(String employeeId, String organizationId, List<String> roleIds);
	
	/**
	 * 修改密码
	 * @param employeeId
	 * @param password
	 */
	void changeAccountPassword(String employeeId, String password, boolean changePassword);
	
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
	 * 给账号分配角色和组织机构
	 */
    int checkAccountRelationRoleorganization(String employeeId, String roleId, String orgId);
	
	/**
	 * 给账号分配角色和组织机构
	 * @param employeeId
	 * @param roleId
	 * @param orgId
	 */
	void setAccountRelationRoleorganization(String employeeId, String roleId, String orgId);
	
	/**
	 * 通过员工工号修改登录失败次数
	 * @param employeeId
	 */
	void updateAccountLoginTimes(String employeeId);
}
