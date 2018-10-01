package com.dtelec.icmes.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.account.controller.vo.AccountOrgCollection;
import com.dtelec.icmes.account.repository.IRoleRepository;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.entity.RoleEntity;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountOrgPageableReturnParam;
import com.dtelec.icmes.account.repository.param.RoleCreateParam;
import com.dtelec.icmes.account.repository.param.RolePageableQueryParam;
import com.dtelec.icmes.account.service.IRoleService;
import com.dtelec.icmes.account.service.model.FeatureModel;
import com.dtelec.icmes.account.service.model.RoleCollection;
import com.dtelec.icmes.account.service.model.RoleCreateModel;
import com.dtelec.icmes.account.service.param.AccountOrgPageableSearchParam;
import com.dtelec.icmes.account.service.param.RolePageableSearchParam;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepo;

	
	/**
	 * 查询角色信息
	 */
	@Override
	public RoleCollection searchRoleByParam(RolePageableSearchParam params) {
		//分页初始化
		int pageNo = params.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = params.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		//赋值
		RolePageableQueryParam query = new RolePageableQueryParam();
		query.setId(params.getId());
		query.setName(params.getName());
		query.setOrderBy(query.getOrderBy());
		query.setAscending(params.isAscending());
		query.setPageSize(pageSize);
		query.setStartIndex(startIndex);
		
		//调用持久层
		PageableQueryBaseEntity<RoleEntity> entities = roleRepo.searchRoleByParam(query);
		RoleCollection coll = new RoleCollection();
		coll.fill(entities, params.getCount());

		return coll;
	}
	
	
	/**
	 * 获取角色权限
	 */
	@Override
	public List<FeatureModel> getAllFeatureByRoleId(String roleId) {
		//初始化模型列表
		List<FeatureModel> models = new ArrayList<>();
		List<FeatureEntity> entities = roleRepo.getAllFeatureByRoleId(roleId);
		//循环赋值
		if (entities != null) {
			for (FeatureEntity entity : entities) {
				FeatureModel model = new FeatureModel();
				model.fill(entity);
				models.add(model);
			}
		}
		return models;
	}
	
	
	
	/**
	 * 查询是否有角色
	 */
	@Override
	public int checkRole(String id) {
		int count = roleRepo.checkRole(id);
		return count;
	}

	
	/**
	 * 删除角色
	 */
	@Override
	public void deleteRole(String id) {
		roleRepo.deleteRole(id);
	}

	
	/**
	 * 创建角色
	 * @throws IcmesBusinessException 
	 */
	@Override
	public void createRole(RoleCreateModel model) throws IcmesBusinessException {
		int count = roleRepo.countRole(model.getId());

		if (count > 0) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ROLE_HAS_EXIST, "该角色已经存在，不能新建！");
		} else {

			RoleCreateParam param = new RoleCreateParam();
			// 参数赋值
			param.setId(model.getId());
			param.setName(model.getName());
			param.setRemark(model.getRemark());
			param.setVersionTag(model.getVersionTag());
			// 如果list为null，防止在sql中空指针，给list实例化
			List<String> features = model.getFeatures();
			if (features == null) {
				features = new ArrayList<String>();
			}

			param.setFeatures(features);
			roleRepo.createRole(param);

		}

	}
	
	/**
	 * 修改角色
	 */
	@Override
	public void updateRole(RoleCreateModel model) {
		RoleCreateParam param = new RoleCreateParam();
		//参数赋值
		param.setId(model.getId());
		param.setName(model.getName());
		param.setRemark(model.getRemark());
		param.setVersionTag(model.getVersionTag());
		//如果list为null，防止在sql中空指针，给list实例化
		List<String> features = model.getFeatures();
		if(features==null) {
			features = new ArrayList<String>();
		}
		param.setFeatures(features);
		roleRepo.updateRole(param);

	}

	
	/**
	 * 检测版本信息
	 */
	@Override
	public String checkRoleVersionTag(String id) {

		return roleRepo.checkRoleVersionTag(id);
	}

	
	/**
	 * 根据role查询账户组织
	 */
	@Override
	public AccountOrgCollection searchAccountOrg(AccountOrgPageableSearchParam params) {
		//分页初始化
		int pageNo = params.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = params.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		
		//参数赋值
		AccountOrgPageableQueryParam param = new AccountOrgPageableQueryParam();
		param.setStartIndex(startIndex);
		param.setPageSize(pageSize);
		param.setRoleId(params.getRoleId());

		PageableQueryBaseEntity<AccountOrgPageableReturnParam> model = roleRepo.searchAccountOrgByParams(param);
		
		AccountOrgCollection coll = new AccountOrgCollection();
		coll.fill(model, pageSize);
		return coll;
	}

}
