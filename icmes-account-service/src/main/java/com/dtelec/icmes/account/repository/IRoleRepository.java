package com.dtelec.icmes.account.repository;

import java.util.List;

import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.entity.RoleEntity;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableReturnParam;
import com.dtelec.icmes.account.repository.param.RoleCreateParam;
import com.dtelec.icmes.account.repository.param.RolePageableQueryParam;

public interface IRoleRepository {
	/**
	 * 角色检查
	 * @param id
	 * @return
	 */
	public int checkRole(String id);
	
	/**
	 * 删除角色
	 * @param id
	 */
	public void deleteRole(String id);
	
	/**
	 * 查询角色是否存在
	 * @param id
	 * @return
	 */
	public int countRole(String id);
	
	/**
	 * 创建角色
	 * @param param
	 */
	public void createRole(RoleCreateParam param);
	
	/**
	 * 修改角色
	 * @param param
	 */
	public void updateRole(RoleCreateParam param);
	
	/**
	 * 检测版本信息
	 * @param id
	 * @return
	 */
	public String checkRoleVersionTag(String id);
	
	/**
	 * 查询角色
	 * @param param
	 * @return
	 */
	public PageableQueryBaseEntity<RoleEntity> searchRoleByParam(RolePageableQueryParam param);
	
	/**
	 * 查询所有角色权限
	 * @param roleId
	 * @return
	 */
	public List<FeatureEntity> getAllFeatureByRoleId(String roleId);
	
	/**
	 * 查询角色-账户-组织
	 * @param params
	 * @return
	 */
	public PageableQueryBaseEntity<AccountOrgPageableReturnParam> searchAccountOrgByParams(AccountOrgPageableQueryParam params);

}
