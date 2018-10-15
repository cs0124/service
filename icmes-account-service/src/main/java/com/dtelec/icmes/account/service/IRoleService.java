package com.dtelec.icmes.account.service;

import java.util.List;

import com.dtelec.icmes.account.controller.vo.AccountOrgCollection;
import com.dtelec.icmes.account.service.model.FeatureModel;
import com.dtelec.icmes.account.service.model.RoleCollection;
import com.dtelec.icmes.account.service.model.RoleCreateModel;
import com.dtelec.icmes.account.service.param.AccountOrgPageableSearchParam;
import com.dtelec.icmes.account.service.param.RolePageableSearchParam;
import com.dtelec.icmes.common.error.IcmesBusinessException;
/**
 * 角色service接口
 */
public interface IRoleService {
	/**
	 * 查询是否有角色
	 * @param id
	 * @return
	 */
	int checkRole(String id);
	
	/**
	 * 删除角色
	 * @param id
	 */
	void deleteRole(String id);
	
	/**
	 * 创建角色
	 * @param model
	 * @throws IcmesBusinessException 
	 */
	void createRole(RoleCreateModel model) throws IcmesBusinessException;
	
	/**
	 * 修改角色
	 * @param model
	 */
	void updateRole(RoleCreateModel model);
	
	/**
	 * 检测角色版本号
	 * @param id
	 * @return
	 */
	String checkRoleVersionTag(String id);
	
	/**
	 * 获取角色权限
	 * @param roleId
	 * @return
	 */
	List<FeatureModel> getAllFeatureByRoleId(String roleId);
	
	/**
	 * 查询角色信息
	 * @param params
	 * @return
	 */
	RoleCollection searchRoleByParam(RolePageableSearchParam params);
	
	/**
	 * 按角色查询用户和组织机构
	 * @param params
	 * @return
	 */
	AccountOrgCollection searchAccountOrg(AccountOrgPageableSearchParam params);
	
}
