package com.dtelec.icmes.account.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dtelec.icmes.account.repository.IUserRepository;
import com.dtelec.icmes.account.repository.dao.IUserDao;
import com.dtelec.icmes.account.repository.entity.AccountAssignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountConsignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountEntity;
import com.dtelec.icmes.account.repository.entity.AccountRoleEntity;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.entity.UserEntity;
import com.dtelec.icmes.account.repository.param.AccountAssignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountConsignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountRolePageableQueryParam;

@Repository
public class UserRepositoryImpl implements IUserRepository {

	@Autowired
	private IUserDao dao;

	/**
	 * 获取账号列表
	 */
	@Override
	public PageableQueryBaseEntity<AccountEntity> searchAccount(AccountPageableQueryParam params) {
		PageableQueryBaseEntity<AccountEntity> entity = new PageableQueryBaseEntity<AccountEntity>();
		List<AccountEntity> entities = dao.searchAccountByParams(params);
		//统计条数
		long totalCount = dao.searchAccountTotalCountByParams(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		return entity;
	}
	
	/**
	 * 查询当前员工ID的角色和组织机构
	 */
	@Override
	public PageableQueryBaseEntity<AccountRoleEntity> searchAccountRoleByParams(AccountRolePageableQueryParam params) {
		PageableQueryBaseEntity<AccountRoleEntity> entity = new PageableQueryBaseEntity<AccountRoleEntity>();
		List<AccountRoleEntity> entities = dao.searchAccountRoleByParams(params);
		//统计条数
		long totalCount = dao.searchAccountRoleTotalCountByParams(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		return entity;
	}
	
	/**
	 * 账号权限列表查询
	 */
	@Override
	public List<FeatureEntity> getAccountAllFeatures(String employeeId) {
		return dao.getAccountAllFeatures(employeeId);
	}
	
	/**
	 * 账号指派代理人列表查询
	 */
	@Override
	public PageableQueryBaseEntity<AccountConsignProxyEntity> searchAccountConsignProxyByParams(
			AccountConsignProxyPageableQueryParam params) {
		PageableQueryBaseEntity<AccountConsignProxyEntity> entity = new PageableQueryBaseEntity<AccountConsignProxyEntity>();
		List<AccountConsignProxyEntity> entities = dao.searchAccountConsignProxyByParams(params);
		//统计条数
		long totalCount = dao.searchAccountConsignProxyTotalCountByParams(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		
		return entity;
	}
	
	/**
	 * 账号接手代理人查询
	 */
	@Override
	public PageableQueryBaseEntity<AccountAssignProxyEntity> searchAccountAssignProxyByParams(
			AccountAssignProxyPageableQueryParam params) {
		PageableQueryBaseEntity<AccountAssignProxyEntity> entity = new PageableQueryBaseEntity<AccountAssignProxyEntity>();
		List<AccountAssignProxyEntity> entities = dao.searchAccountAssignProxyByParams(params);
		//统计条数
		long totalCount = dao.searchAccountAssignProxyTotalCountByParams(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		
		return entity;
	}
	
	/**
	 * 创建账号
	 */
	@Override
	public void createAccount(String employeeId, String password) {
		dao.createAccount(employeeId, password);
	}
	
	/**
	 * 通过员工工号获取账号信息
	 */
	@Override
	public UserEntity findUserByEmployeeId(String employeeId) {
		return dao.findUserByEmployeeId(employeeId);
	}
	
	/**
	 * 通过员工工号获取账号详细信息
	 */
	@Override
	public AccountEntity findAccountByEmployeeId(String employeeId) {
		return dao.findAccountByEmployeeId(employeeId);
	}
	
	/**
	 * 账号角色删除
	 */
	@Override
	public void deleteAccountRoleAss(String employeeId, List<String> roleIds) {
		dao.deleteAccountRoleAss(employeeId, roleIds);
	}
	
	/**
	 * 修改密码
	 */
	@Override
	public void changeAccountPassword(String employeeId, String password) {
		dao.changeAccountPassword(employeeId, password);
	}
	
	/**
	 * 账号锁定或解锁
	 */
	@Override
	public void setAccountLockStatus(String employeeId, boolean isLocked) {
		dao.setAccountLockStatus(employeeId, isLocked);
	}
	
	/**
	 * 账号删除
	 */
	@Override
	public void deleteAccountByEmployeeId(String employeeId) {
		dao.deleteAccountByEmployeeId(employeeId);
	}

	/**
	 * 给账号分配角色和组织机构
	 */
	@Override
	public void setAccountRelationRoleorganization(String employeeId, String roleId, String orgId) {
		dao.setAccountRelationRoleorganization(employeeId, roleId, orgId);
	}

	/**
	 * 通过员工工号修改登录失败次数
	 */
	@Override
	public void updateAccountLoginTimes(String employeeId) {
		dao.updateAccountLoginTimes(employeeId);
	}
	
	/**
	 * 检测是否和代理表有关联
	 */
	@Override
	public int checkUserRoleAssProxy(String employeeId, List<String> roleIds) {
		int count = dao.checkUserRoleAssProxy(employeeId, roleIds);
		return count;
	}

}
