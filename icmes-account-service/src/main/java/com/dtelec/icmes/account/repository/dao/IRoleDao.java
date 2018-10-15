package com.dtelec.icmes.account.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dtelec.icmes.account.repository.entity.RoleEntity;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableReturnParam;
import com.dtelec.icmes.account.repository.param.RoleCreateParam;
import com.dtelec.icmes.account.repository.param.RolePageableQueryParam;

/**
 * 用于Role的角色 Dao层接口
 * @author hlxu
 *
 */

@Mapper
public interface IRoleDao {
	
	/**
	 * 检查role是否有关联User的数据
	 * @param id
	 * @return
	 */
	int checkRoleCount(@Param("id") String id);
	
	/**
	 * 删除role
	 * @param id
	 */
	void deleteRole(@Param("id") String id);
	
	/**
	 * 新增role和feature
	 * @param param
	 */
	void createRole(@Param("param") RoleCreateParam param);
	
	/**
	 * 修改role和feature
	 * @param param
	 */
	void updateRole(@Param("param") RoleCreateParam param);
	
	/**
	 * 检查role的versionTag
	 * @param id
	 * @return
	 */
	String checkRoleVersionTag(@Param("id") String id);
	
	/**
	 * 查询role列表
	 * @param params
	 * @return
	 */
	List<RoleEntity> searchRoleByParam(@Param("params") RolePageableQueryParam params);
	
	/**
	 * 查询role列表总数
	 * @param param
	 * @return
	 */
	long searchRoleTotalCountByParam(@Param("params") RolePageableQueryParam param);
	
	/**
	 * 查询roleAccountOrg关系
	 * @param params
	 * @return
	 */
	List<AccountOrgPageableReturnParam> searchAccountOrgByParams(@Param("params") AccountOrgPageableQueryParam params);
	
	/**
	 * 查询roleAccountOrg条数
	 * @param params
	 * @return
	 */
	long searchAccountOrgByParamsCount(@Param("params") AccountOrgPageableQueryParam params);
	
	/**
	 * 查询角色是否存在
	 * @param id
	 * @return
	 */
	int countRole(@Param("id") String id);
}
