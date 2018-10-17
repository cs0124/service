package com.dtelec.icmes.account.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.account.repository.entity.AccountAssignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountConsignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountEntity;
import com.dtelec.icmes.account.repository.entity.AccountRoleEntity;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.repository.entity.UserEntity;
import com.dtelec.icmes.account.repository.param.AccountAssignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountConsignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountRolePageableQueryParam;

/**
 * 用于User相关的Dao接口
 * @author hlxu
 *
 */

@Mapper
public interface IUserDao {

	/**
	 * 获取账号列表
	 * @param params
	 * @return
	 */
	List<AccountEntity> searchAccountByParams(@Param("params") AccountPageableQueryParam params);
	
	/**
	 * 获取账号列表总数
	 * @param params
	 * @return
	 */
	long searchAccountTotalCountByParams(@Param("params") AccountPageableQueryParam params);
	
	/**
	 * 查询当前员工ID的角色和组织机构
	 * @param params
	 * @return
	 */
	List<AccountRoleEntity> searchAccountRoleByParams(@Param("params") AccountRolePageableQueryParam params);
	
	/**
	 * 查询当前员工ID的角色和组织机构总记录数
	 * @param params
	 * @return
	 */
	long searchAccountRoleTotalCountByParams(@Param("params") AccountRolePageableQueryParam params);
	
	/**
	 * 账号权限列表查询
	 * @param employeeId
	 * @return
	 */
	List<FeatureEntity> getAccountAllFeatures(@Param("employeeId") String employeeId);
	
	/**
	 * 账号指派代理人列表查询
	 * @param params
	 * @return
	 */
	List<AccountConsignProxyEntity> searchAccountConsignProxyByParams(@Param("params") AccountConsignProxyPageableQueryParam params);
	
	/**
	 * 账号指派代理人列表查询总记录数
	 * @param params
	 * @return
	 */
	long searchAccountConsignProxyTotalCountByParams(@Param("params") AccountConsignProxyPageableQueryParam params);

	/**
	 * 账号接手代理人查询
	 * @param params
	 * @return
	 */
	List<AccountAssignProxyEntity> searchAccountAssignProxyByParams(@Param("params") AccountAssignProxyPageableQueryParam params);
	
	/**
	 * 账号接手代理人查询总数
	 * @param params
	 * @return
	 */
	long searchAccountAssignProxyTotalCountByParams(@Param("params") AccountAssignProxyPageableQueryParam params);
	
	/**
	 * 创建账号
	 * @param employeeId
	 * @param password
	 */
	void createAccount(@Param("employeeId") String employeeId, @Param("password") String password);
	
	/**
	 * 通过员工工号获取账号信息
	 * @param employeeId
	 * @return
	 */
	UserEntity findUserByEmployeeId(@Param("employeeId") String employeeId);
	
	/**
	 * 通过员工工号获取账号详细信息
	 */
	AccountEntity findAccountByEmployeeId(@Param("employeeId") String employeeId);
	/**
	 * 检测角色权限代理
	 * @param employeeId
	 * @param roleIds
	 * @return
	 */
	int checkUserRoleAssProxy(@Param("employeeId")String employeeId, @Param("roleIds")List<String> roleIds);
	
	/**
	 * 账号角色删除
	 * @param employeeId
	 * @param roleIds
	 */
	void deleteAccountRoleAss(@Param("employeeId")String employeeId, @Param("roleIds")List<String> roleIds);
	
	/**
	 * 根据组织机构id删除账号角色
	 * @param employeeId
	 * @param organizationId
	 * @param roleIds
	 */
	void deleteAccountRoleAssByOrganizationId(@Param("employeeId")String employeeId,@Param("organizationId")String organizationId, @Param("roleIds")List<String> roleIds);
	
	/**
	 * 修改密码
	 * @param employeeId
	 * @param password
	 */
	void changeAccountPassword(@Param("employeeId")String employeeId, @Param("password") String password,@Param("changePassword") int changePassword);
	
	/**
	 * 账号锁定或解锁
	 * @param employeeId
	 * @param isLocked
	 */
	void setAccountLockStatus(@Param("employeeId")String employeeId, @Param("isLocked") boolean isLocked);
	
	/**
	 * 账号删除
	 * @param employeeId
	 */
	void deleteAccountByEmployeeId(@Param("employeeId")String employeeId);
	
	/**
	 * 检测账号分配角色和组织机构是否重复
	 * @param employeeId
	 * @param roleId
	 * @param orgId
	 */
	int checkAccountRelationRoleorganization(@Param("employeeId") String employeeId, @Param("roleId")String roleId, @Param("orgId")String orgId);
	
	/**
	 * 给账号分配角色和组织机构
	 * @param employeeId
	 * @param roleId
	 * @param orgId
	 */
	void setAccountRelationRoleorganization(@Param("employeeId") String employeeId, @Param("roleId")String roleId, @Param("orgId")String orgId);
	
	/**
	 * 通过员工工号修改登录失败次数
	 * @param employeeId
	 */
	void updateAccountLoginTimes(@Param("employeeId") String employeeId);
}
