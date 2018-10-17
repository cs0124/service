package com.dtelec.icmes.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtelec.icmes.account.repository.IFeatureRepository;
import com.dtelec.icmes.account.repository.IUserRepository;
import com.dtelec.icmes.account.repository.entity.FeatureEntity;
import com.dtelec.icmes.account.repository.entity.AccountAssignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountConsignProxyEntity;
import com.dtelec.icmes.account.repository.entity.AccountEntity;
import com.dtelec.icmes.account.repository.entity.AccountRoleEntity;
import com.dtelec.icmes.account.repository.entity.PageableQueryBaseEntity;
import com.dtelec.icmes.account.repository.entity.UserEntity;
import com.dtelec.icmes.account.repository.param.AccountAssignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountConsignProxyPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountPageableQueryParam;
import com.dtelec.icmes.account.repository.param.AccountRolePageableQueryParam;
import com.dtelec.icmes.account.service.IAccountService;
import com.dtelec.icmes.account.service.client.InfoServiceClient;
import com.dtelec.icmes.account.service.model.UserModel;
import com.dtelec.icmes.account.service.param.AccountAssignProxyPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountConsignProxyPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountRolePageableSearchParam;
import com.dtelec.icmes.account.service.model.AccountAssignProxyCollection;
import com.dtelec.icmes.account.service.model.AccountCollection;
import com.dtelec.icmes.account.service.model.AccountConsignProxyCollection;
import com.dtelec.icmes.account.service.model.AccountModel;
import com.dtelec.icmes.account.service.model.AccountRoleCollection;
import com.dtelec.icmes.account.service.model.AuthModel;
import com.dtelec.icmes.account.service.model.EmployeeBaseModel;
import com.dtelec.icmes.account.service.model.EmployeeModel;
import com.dtelec.icmes.account.service.model.FeatureCollection;
import com.dtelec.icmes.account.service.model.RoleModel;
import com.dtelec.icmes.account.utility.RestTemplateUtils;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;

/**
 * 账户相关服务操作类封装
 * @author hlxu
 *
 */

@Service
public class AccountServiceImpl implements IAccountService {
	/**
	 * 注入权限
	 */
	@Autowired
	private IFeatureRepository featureRepo;
	/**
	 * 注入账户
	 */
	@Autowired
	private IUserRepository userRepo;
	/**
	 * 注入信息
	 */
	@Autowired
	private InfoServiceClient infoClientSev;

	/**
	 * Login account by given employeeId and password
	 */
	@Override
	public UserModel findByIdAndPassword(String employeeId, String password) {
		final String url = String.format(
				"http://auth-service/uaa/oauth/token?username=%s&password=%s&grant_type=password&scope=ui", employeeId,
				password);
		AuthModel auth = RestTemplateUtils.getRestResponse(url, "Basic YnJvd3Nlcjo=", AuthModel.class);
		UserModel account = auth.getAccountModel();

		return account;
	}

	/**
	 * 通过员工工号和token获取员工详细信息
	 */
	@Override
	public EmployeeModel getEmployeeDetail(String employeeId, String token) {
		final String url = String.format("http://information-service/info/employees/%s", employeeId);
		EmployeeModel employee = RestTemplateUtils.getRestResponse(url, String.format("Bearer %s", token),
				EmployeeModel.class);

		return employee;
	}

	/**
	 * 通过角色信息获取功能
	 */
	@Override
	public FeatureCollection getFeaturesByRoles(List<RoleModel> roles) {
		FeatureCollection coll = new FeatureCollection();
		if (roles != null) {
			List<String> roleIds = new ArrayList<>();
			for (RoleModel role : roles) {
				roleIds.add(role.getId());
			}

			List<FeatureEntity> entities = featureRepo.findByRoleIds(roleIds);
			coll.add(entities);
		}

		return coll;
	}
	
	/**
	 * 获取账号列表
	 */
	@Override
	public AccountCollection searchAccountByParams(AccountPageableSearchParam params) {
		int pageNo = params.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = params.getCount();
		pageSize = (pageSize < 0) ? 0 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;

		AccountPageableQueryParam query = new AccountPageableQueryParam();
		query.setEmployeeId(params.getEmployeeId());
		query.setEmployeeName(params.getEmployeeName());
		query.setSpecialDevice(params.getSpecialDevice());
		query.setOrderBy(query.getOrderBy());
		query.setAscending(params.isAscending());
		query.setPageSize(pageSize);
		query.setStartIndex(startIndex);

		PageableQueryBaseEntity<AccountEntity> entities = userRepo.searchAccount(query);
		AccountCollection coll = new AccountCollection();
		coll.fill(entities, params.getCount());

		return coll;
	}
	
	/**
	 * 账号角色列表查询
	 */
	@Override
	public AccountRoleCollection searchAccountRoleByParams(AccountRolePageableSearchParam params) {
		int pageNo = params.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = params.getCount();
		pageSize = (pageSize < 0) ? 1 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;

		AccountRolePageableQueryParam query = new AccountRolePageableQueryParam();
		query.setEmployeeId(params.getEmployeeId());
		query.setOrderBy(query.getOrderBy());
		query.setAscending(params.isAscending());
		query.setPageSize(pageSize);
		query.setStartIndex(startIndex);

		PageableQueryBaseEntity<AccountRoleEntity> entity = userRepo.searchAccountRoleByParams(query);
		AccountRoleCollection coll = new AccountRoleCollection();
		coll.fill(entity, pageSize);

		return coll;
	}
	
	/**
	 * 账号权限列表查询
	 */
	@Override
	public FeatureCollection getAccountAllFeatures(String employeeId) {
		List<FeatureEntity> entities = userRepo.getAccountAllFeatures(employeeId);
		FeatureCollection coll = new FeatureCollection();
		coll.add(entities);
		
		return coll;
	}
	
	/**
	 * 账号指派代理人列表查询
	 */
	@Override
	public AccountConsignProxyCollection searchAccountConsignProxyByParams(
			AccountConsignProxyPageableSearchParam params) {
		int pageNo = params.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = params.getCount();
		pageSize = (pageSize < 0) ? 1 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		//查询赋值
		AccountConsignProxyPageableQueryParam query = new AccountConsignProxyPageableQueryParam();
		query.setEmployeeId(params.getEmployeeId());
		query.setOrderBy(query.getOrderBy());
		query.setAscending(params.isAscending());
		query.setPageSize(pageSize);
		query.setStartIndex(startIndex);

		PageableQueryBaseEntity<AccountConsignProxyEntity> entity = userRepo.searchAccountConsignProxyByParams(query);
		AccountConsignProxyCollection coll = new AccountConsignProxyCollection();
		coll.fill(entity, pageSize);

		return coll;
	}
	
	/**
	 * 账号接手代理人查询
	 */
	@Override
	public AccountAssignProxyCollection searchAccountAssignProxyByParams(
			AccountAssignProxyPageableSearchParam params) {
		int pageNo = params.getPage();
		pageNo = (pageNo < 1) ? 1 : pageNo;
		int pageSize = params.getCount();
		pageSize = (pageSize < 0) ? 1 : pageSize;
		int startIndex = (pageNo - 1) * pageSize;
		//代理查询赋值
		AccountAssignProxyPageableQueryParam query = new AccountAssignProxyPageableQueryParam();
		query.setEmployeeId(params.getEmployeeId());
		query.setOrderBy(query.getOrderBy());
		query.setAscending(params.isAscending());
		query.setPageSize(pageSize);
		query.setStartIndex(startIndex);
		
		PageableQueryBaseEntity<AccountAssignProxyEntity> entity = userRepo.searchAccountAssignProxyByParams(query);
		AccountAssignProxyCollection coll = new AccountAssignProxyCollection();
		coll.fill(entity, pageSize);
		
		return coll;
	}
	
	/**
	 * 创建账号
	 */
	@Override
	public void createAccount(EmployeeBaseModel model, String password) throws IcmesBusinessException {
		UserEntity user = userRepo.findUserByEmployeeId(model.getEmployeeId());
		if (user != null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_CREATEEMPLOYEE_ISNOTNULL, "员工已经存在");
		}
		
		userRepo.createAccount(model.getEmployeeId(), password);
		infoClientSev.persistentEmployeeBase(model);
	}
	
	/**
	 * 编辑账号
	 */
	@Override
	public void updateAccount(EmployeeBaseModel model) throws IcmesBusinessException {
		AccountEntity account = userRepo.findAccountByEmployeeId(model.getEmployeeId());
		if (account == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_EMPLOYEE_CREATEEMPLOYEE_ISNOTNULL, "员工已经存在");
		}
		
		infoClientSev.persistentEmployeeBase(model);
	}
	
	/**
	 * 账号角色删除
	 */
	@Override
	public void deleteAccountRoles(String employeeId,String organizationId, List<String> roleIds) throws IcmesBusinessException {
		if (roleIds != null) {
			int count = userRepo.checkUserRoleAssProxy(employeeId, roleIds);
			if(count == 0) {
				userRepo.deleteAccountRoleAss(employeeId,organizationId, roleIds);	
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ROLE_ACCOUNT_ASS_DELETE_FAILE, "该成员存在代理关系，不能删除！");
			}
			
		}
	}
	
	/**
	 * 修改密码
	 */
	@Override
	public void changeAccountPassword(String employeeId, String password  ,boolean changePassword) {
		userRepo.changeAccountPassword(employeeId, password,changePassword);
	}
	
	/**
	 * 账号删除
	 */
	@Override
	public void deleteAccountByEmployeeId(String employeeId) {
		userRepo.deleteAccountByEmployeeId(employeeId);
	}

	/**
	 * 账号锁定或解锁
	 */
	@Override
	public void setAccountLockStatus(String employeeId, boolean isLocked) {
		userRepo.setAccountLockStatus(employeeId, isLocked);
	}

	/**
	 * 给账号分配角色和组织机构
	 * @param employeeId 员工工号
	 * @param roleId 角色编码
	 * @param orgId 组织结构编码
	 * @throws IcmesBusinessException 分配组织机构的关系的逻辑异常
	 */
	@Override
	public void setAccountRelationRoleorganization(String employeeId, String roleId, String orgId) throws IcmesBusinessException {
		int count = userRepo.checkAccountRelationRoleorganization(employeeId, roleId, orgId);
		if(count>0) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ROLE_ORG_HAS_EXIST, "重复分配！分配失败！");
		}else {
			userRepo.setAccountRelationRoleorganization(employeeId, roleId, orgId);
		}
	}

	/**
	 * 通过员工工号 获取账号详情
	 */
	@Override
	public EmployeeBaseModel fetchAccountDetailWithEmployee(String employeeId) {
		EmployeeBaseModel model = null;
		EmployeeModel employee = null;
		try {
			employee = infoClientSev.getEmployeeDetail(employeeId);
		}
		catch(Exception ex) {
			// do nothing
		}
		//不为空赋值
		if (employee != null) {
			model = new EmployeeBaseModel();
			model.setEmployeeId(employee.getId());
			model.setEmployeeName(employee.getName());
			model.setSpecialDevice(employee.getSpecialDevice());
			
			AccountEntity account = userRepo.findAccountByEmployeeId(employee.getId());
			model.setHasAccount(account != null);
		}
		
		return model;
	}

	/**
	 * 通过员工工号获取账号详细信息
	 */
	@Override
	public AccountModel fetchAccountDetail(String employeeId) {
		AccountModel model = null;
		//判断数据库是否存在账号
		AccountEntity entity = userRepo.findAccountByEmployeeId(employeeId);
		if (entity != null) {
			model = new AccountModel();
			model.fill(entity);
		}
		
		return model;
	}

	/**
	 * 通过员工工号修改登录失败次数
	 */
	@Override
	public void updateAccountLoginTimes(String employeeId) {
		userRepo.updateAccountLoginTimes(employeeId);
	}

}
