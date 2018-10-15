package com.dtelec.icmes.account.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtelec.icmes.account.repository.IRoleRepository;
import com.dtelec.icmes.account.repository.dao.IFeatureDao;
import com.dtelec.icmes.account.repository.dao.IRoleDao;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.entity.RoleEntity;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableReturnParam;
import com.dtelec.icmes.account.repository.param.RoleCreateParam;
import com.dtelec.icmes.account.repository.param.RolePageableQueryParam;
/**
 * 角色持久层实现类
 * @author zturnking
 *
 */
@Repository
public class RoleRepositoryImpl implements IRoleRepository {
	/**
	 * 注入角色dao
	 */
	@Autowired
	private IRoleDao dao;
	/**
	 * 注入权限dao
	 */
	@Autowired
	private IFeatureDao featureDao;

	
	/**
	 * 查询角色
	 */
	@Override
	public PageableQueryBaseEntity<RoleEntity> searchRoleByParam(RolePageableQueryParam params) {
		PageableQueryBaseEntity<RoleEntity> entity = new PageableQueryBaseEntity<RoleEntity>();
		List<RoleEntity> entities = dao.searchRoleByParam(params);
		//统计条数
		long totalCount = dao.searchRoleTotalCountByParam(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		
		return entity;
	}
	
	/**
	 * 查询所有角色权限
	 */
	@Override
	public List<FeatureEntity> getAllFeatureByRoleId(String roleId) {
		return featureDao.getAllFeatureByRoleId(roleId);
	}
	

	/**
	 * 角色检测
	 */
	@Override
	public int checkRole(String id) {
		int count = dao.checkRoleCount(id);
		return count;
	}

	
	/**
	 * 删除角色
	 */
	@Override
	public void deleteRole(String id) {
		dao.deleteRole(id);
	}

	
	/**
	 * 创建角色
	 */
	@Override
	public void createRole(RoleCreateParam param) {
		dao.createRole(param);
	}
	
	/**
	 * 修改角色
	 */
	@Override
	public void updateRole(RoleCreateParam param) {
		dao.updateRole(param);
	}

	
	/**
	 * 检测版本信息
	 */
	@Override
	public String checkRoleVersionTag(String id) {
		return dao.checkRoleVersionTag(id);
	}
	
	
	/**
	 * 查询角色账户信息
	 */
	@Override
	public PageableQueryBaseEntity<AccountOrgPageableReturnParam> searchAccountOrgByParams(
			AccountOrgPageableQueryParam params) {
		PageableQueryBaseEntity<AccountOrgPageableReturnParam> entity = new PageableQueryBaseEntity<AccountOrgPageableReturnParam>();
		List<AccountOrgPageableReturnParam> entities = dao.searchAccountOrgByParams(params);
		//统计条数
		long totalCount = dao.searchAccountOrgByParamsCount(params);
		entity.setTotalCount(totalCount);
		entity.setItems(entities);
		return entity;
	}
	
	/**
	 * 查询角色是否存在
	 * @param id
	 * @return
	 */
	@Override
	public int countRole(String id) {
		return dao.countRole(id);
	}


}
