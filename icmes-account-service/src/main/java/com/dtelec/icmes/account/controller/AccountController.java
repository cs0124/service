package com.dtelec.icmes.account.controller;

import com.dtelec.icmes.account.config.SystemSettingConfig;
import com.dtelec.icmes.account.controller.vo.ReqAccountLoginVO;
import com.dtelec.icmes.account.controller.vo.ReqCreateAccountVO;
import com.dtelec.icmes.account.controller.vo.ReqPasswordInitializeVO;
import com.dtelec.icmes.account.controller.vo.ReqRelationRoleOrganizationVO;
import com.dtelec.icmes.account.controller.vo.ReqChangePasswordVO;
import com.dtelec.icmes.account.controller.vo.ResAccountLoginVO;
import com.dtelec.icmes.account.service.IAccountService;
import com.dtelec.icmes.account.service.model.UserModel;
import com.dtelec.icmes.account.service.model.AccountAssignProxyCollection;
import com.dtelec.icmes.account.service.model.AccountCollection;
import com.dtelec.icmes.account.service.model.AccountConsignProxyCollection;
import com.dtelec.icmes.account.service.model.AccountModel;
import com.dtelec.icmes.account.service.model.AccountRoleCollection;
import com.dtelec.icmes.account.service.model.EmployeeBaseModel;
import com.dtelec.icmes.account.service.model.EmployeeModel;
import com.dtelec.icmes.account.service.model.FeatureCollection;
import com.dtelec.icmes.account.service.model.FeatureModel;
import com.dtelec.icmes.account.service.param.AccountAssignProxyPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountConsignProxyPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountPageableSearchParam;
import com.dtelec.icmes.account.service.param.AccountRolePageableSearchParam;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.common.error.IcmesException;
import com.dtelec.icmes.common.utility.ConditionUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

	@Autowired
	private IAccountService accSev;

	/**
	 * 系统登录
	 * @param reqVo
	 * @return ResAccountLoginVO
	 */
	@ApiOperation(value = "系统登录--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResAccountLoginVO loginAccount(@RequestBody ReqAccountLoginVO reqVo) throws IcmesException {
		AccountModel model = accSev.fetchAccountDetail(reqVo.employeeId);
		if (model == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_LOGIN_NOFOUND_EMPLOYEE, "login don't found employee");
		}
		if (model.isLocked() == true) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_LOGIN_ISLOCKED_ERROR, "login locked for the employee");
		}
		//获取登录失败次数
		int retryCount = SystemSettingConfig.getAllConfig().getLoginRetryCount();
		if (model.getRetryCount() > retryCount) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_LOGIN_RETRYCOUNT_ERROR, "login retry count times");
		}
		if (!StringUtils.trimToEmpty(model.getPassword()).equals(reqVo.password)) {
			accSev.updateAccountLoginTimes(reqVo.employeeId);
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_LOGIN_PASSWORD_ERROR, "login password is wrong.");
		}
		
		//通过工号和密码获取账号信息
		UserModel account = accSev.findByIdAndPassword(reqVo.employeeId, reqVo.password);
		EmployeeModel employee = accSev.getEmployeeDetail(account.getUsername(), account.getAccessToken());
		FeatureCollection features = accSev.getFeaturesByRoles(account.getRoles());
		
		ResAccountLoginVO resVo = new ResAccountLoginVO();
		resVo.accessToken = account.getAccessToken();
		resVo.employeeId = employee.getId();
		resVo.name = employee.getName();
		//员工头像路径
		resVo.avatar = employee.getAvatar();
		resVo.changePassword = account.isChangePassword();
		resVo.features = features.getFeatureMapping();
		
		return resVo;
	}

	/**
	 * 系统登出
	 * @return boolean
	 */
	@ApiOperation(value = "系统登出--作者：徐宏亮")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "成功"), 
			@ApiResponse(code = 401, message = "验证失败"), 
			@ApiResponse(code = 404, message = "未找到"),
			@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/exit", method = RequestMethod.GET)
	public boolean logoutAccount(Principal principal) {
		if (principal instanceof DefaultOAuth2AccessToken) {
			DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) principal;
			
		}
		
		System.out.print("aaaaaa");
		return true;
	}
	
	/**
	 * 修改密码
	 * @param principal
	 * @param reqVo
	 * @return boolean
	 */
	@ApiOperation(value = "修改密码--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/password/", method = RequestMethod.PUT)
	public boolean changeAccountPassword(Principal principal, @RequestBody ReqChangePasswordVO reqVo) {
		accSev.changeAccountPassword(principal.getName(), reqVo.confirmPassword);
        return true;
	}
	
	/**
	 * 初始化密码
	 * @param principal
	 * @param reqVo
	 * @return boolean
	 */
	@ApiOperation(value = "初始化密码--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/password/initialize", method = RequestMethod.PUT)
	public boolean initAccountPassword(Principal principal, @RequestBody ReqPasswordInitializeVO reqVo) {
        accSev.changeAccountPassword(principal.getName(), reqVo.confirmPassword);
        return true;
	}
	
	/**
	 * 上传头像
	 */
	@ApiOperation(value = "上传头像--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/profile/avatar", method = RequestMethod.POST)
	public void uploadProfileAvatar() {
        // To Do
	}
	
	
	/**
	 * 账号角色列表查询
	 * @param id
	 * @param condition
	 * @return AccountRoleCollection
	 */
	@ApiOperation(value = "账号角色列表查询--作者：张瑞晗")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderBy",value="排序列名"),
		@ApiImplicitParam(name="ascending",value="正序倒序"),
		@ApiImplicitParam(name="pageNo",value="当前页数"),
		@ApiImplicitParam(name="pageSize",value="每页条数")
    })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/roles/list/{condition}", method = RequestMethod.GET)
	public AccountRoleCollection searchAccountRole(@PathVariable @ApiParam(name = "id", value = "员工工号") String id, @PathVariable @ApiParam(name = "condition", value = "参数列表") String condition) {
		ConditionUtils util = new ConditionUtils(condition);
		String orderBy = util.getValueString("orderBy", null);
		boolean ascending = util.getValueBoolean("ascending", false);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		
		//初始化查询参数
		AccountRolePageableSearchParam params = new AccountRolePageableSearchParam(id, pageNo, pageSize);
		params.setOrderBy(orderBy);
		params.setAscending(ascending);
		
		AccountRoleCollection coll = accSev.searchAccountRoleByParams(params);
		return coll;
	}
	
	/**
	 * 账号指派代理人列表查询
	 * @param id
	 * @param condition
	 * @return AccountConsignProxyCollection
	 */
	@ApiOperation(value = "账号指派代理人列表查询--作者：徐宏亮")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderBy",value="排序列名"),
		@ApiImplicitParam(name="ascending",value="正序倒序"),
		@ApiImplicitParam(name="pageNo",value="当前页数"),
		@ApiImplicitParam(name="pageSize",value="每页条数")
    })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/consignProxies/list/{condition}", method = RequestMethod.GET)
	public AccountConsignProxyCollection searchAccountConsignProxy(@PathVariable @ApiParam(name = "id", value = "员工工号") String id, @PathVariable @ApiParam(name = "condition", value = "参数列表") String condition) {
		ConditionUtils util = new ConditionUtils(condition);
		String orderBy = util.getValueString("orderBy", null);
		boolean ascending = util.getValueBoolean("ascending", false);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		
		//初始化查询参数
		AccountConsignProxyPageableSearchParam params = new AccountConsignProxyPageableSearchParam(id, pageNo, pageSize);
		params.setOrderBy(orderBy);
		params.setAscending(ascending);
		
		AccountConsignProxyCollection coll = accSev.searchAccountConsignProxyByParams(params);
		return coll;
	}
	
	/**
	 * 账号接手代理人查询
	 * @param id
	 * @param condition
	 * @return AccountAssignProxyCollection
	 */
	@ApiOperation(value = "账号接手代理人查询--作者：张瑞晗")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderBy",value="排序列名"),
		@ApiImplicitParam(name="ascending",value="正序倒序"),
		@ApiImplicitParam(name="pageNo",value="当前页数"),
		@ApiImplicitParam(name="pageSize",value="每页条数")
	})
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/assignProxies/list/{condition}", method = RequestMethod.GET)
	public AccountAssignProxyCollection searchAccountAssignProxy(@PathVariable @ApiParam(name = "id", value = "员工工号") String id,@PathVariable @ApiParam(name = "condition", value = "参数列表") String condition) {
		ConditionUtils util = new ConditionUtils(condition);
		String orderBy = util.getValueString("orderBy", null);
		boolean ascending = util.getValueBoolean("ascending", false);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		
		AccountAssignProxyPageableSearchParam params = new AccountAssignProxyPageableSearchParam(id, pageNo, pageSize);
		params.setOrderBy(orderBy);
		params.setAscending(ascending);
		
		AccountAssignProxyCollection coll = accSev.searchAccountAssignProxyByParams(params);
		return coll;
	}
	
	
	/**
	 * 获取账号列表
	 * @param condition
	 * @return AccountCollection
	 */
	@ApiOperation(value = "获取账号列表--作者：徐宏亮")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="员工工号"),
		@ApiImplicitParam(name="name", value="员工名称"),
		@ApiImplicitParam(name="specialDevice", value="专用设备号"),
		@ApiImplicitParam(name="orderBy", value="排序列名"),
		@ApiImplicitParam(name="ascending", value="正序倒序"),
		@ApiImplicitParam(name="pageNo", value="当前页数"),
		@ApiImplicitParam(name="pageSize", value="每页条数")
    })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public AccountCollection searchAccount(@PathVariable @ApiParam(name = "condition", value = "传入模型") String condition) {
		//初始化
		ConditionUtils util = new ConditionUtils(condition);
		String id = util.getValueString("id", null);
		String name = util.getValueString("name", null);
		String specialDevice = util.getValueString("specialDevice", null);
		String orderBy = util.getValueString("orderBy", null);
		boolean ascending = util.getValueBoolean("ascending", false);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		
		AccountPageableSearchParam params = new AccountPageableSearchParam(id, name, specialDevice, pageNo, pageSize);
		params.setOrderBy(orderBy);
		params.setAscending(ascending);
		
		AccountCollection coll = accSev.searchAccountByParams(params);
		return coll;
	}
	
	/**
	 * 账号权限列表查询
	 * @param id
	 * @return List<FeatureModel>
	 */
	@ApiOperation(value = "账号权限列表查询--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/features/list", method = RequestMethod.GET)
	public List<FeatureModel> searchAccountFeature(@PathVariable @ApiParam(name = "id", value = "员工工号") String id) {		
		FeatureCollection coll = accSev.getAccountAllFeatures(id);
		
		return coll.getList();
	}
	
	/**
	 * 获取账号详情
	 * @param id
	 * @return EmployeeBaseModel
	 * @throws IcmesBusinessException
	 */
	@ApiOperation(value = "获取账号详情--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public EmployeeBaseModel fetchAccount(@PathVariable @ApiParam(name = "id", value = "员工账号") String id) throws IcmesBusinessException {
		return accSev.fetchAccountDetailByEmployeeId(id);
	}
	
	/**
	 * 账号删除
	 * @param id
	 * @return boolean
	 */
	@ApiOperation(value = "账号删除--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteAccount(@PathVariable @ApiParam(name = "id", value = "员工账号") String id) {
        accSev.deleteAccountByEmployeeId(id);
        return true;
	}
	
	/**
	 * 创建账号
	 * @param reqVo
	 * @return boolean
	 * @throws IcmesBusinessException
	 */
	@ApiOperation(value = "创建账号--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public boolean createAccount(@RequestBody @ApiParam(name = "ReqCreateAccountVO", value = "传入模型") ReqCreateAccountVO reqVo) throws IcmesBusinessException {
		EmployeeBaseModel model = new EmployeeBaseModel();
		model.setEmployeeId(reqVo.id);
		model.setEmployeeName(reqVo.name);
		model.setSpecialDevice(reqVo.specialDevice);
		String password = SystemSettingConfig.getAllConfig().getInitPassword();
		
		accSev.createAccount(model, password);
		return true;
	}
	
	/**
	 * 编辑账号
	 * @param id
	 * @param reqVO
	 * @return boolean
	 * @throws IcmesBusinessException
	 */
	@ApiOperation(value = "编辑账号--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public boolean updateAccount(@PathVariable @ApiParam(name = "id", value = "员工账号") String id, @RequestBody @ApiParam(name = "ReqCreateAccountVO", value = "传入模型") ReqCreateAccountVO reqVO) throws IcmesBusinessException {
		EmployeeBaseModel model = new EmployeeBaseModel();
		model.setEmployeeId(id);
		model.setEmployeeName(reqVO.name);
		model.setSpecialDevice(reqVO.specialDevice);
		
		accSev.updateAccount(model);
		return true;
	}	
	
	
	/**
	 * 用户角色编辑(分配角色)
	 * @param id
	 * @param reqVo
	 * @return boolean
	 */
	@ApiOperation(value = "用户角色编辑(分配角色)--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/relation/role-organization", method = RequestMethod.POST)
	public boolean createRoleOrgAss(@PathVariable String id, @RequestBody @ApiParam(name = "ReqRelationRoleOrganizationVO", value = "员工模型") ReqRelationRoleOrganizationVO reqVo) {
		accSev.setAccountRelationRoleorganization(id, reqVo.roleId, reqVo.orgId);
		return true;
	}
	
	
	/**
	 * 账号角色删除
	 * @param id
	 * @param roleIds
	 * @return boolean
	 */
	@ApiOperation(value = "账号角色删除--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@RequestMapping(path = "/{id}/roles/{roleId}", method = RequestMethod.DELETE)
	public boolean deleteAccountRole(@PathVariable @ApiParam(name = "id", value = "员工账号") String id, @PathVariable @ApiParam(name = "roleId", value = "角色ID") String roleId) throws IcmesBusinessException {
		List<String> roleIds = new ArrayList<>();
		roleIds.add(roleId);
		accSev.deleteAccountRoles(id, roleIds);
		return true;
	}
	
	
	/**
	 * 锁定账号
	 * @param id
	 * @return boolean
	 */
	@ApiOperation(value = "锁定账号--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/lock", method = RequestMethod.PUT)
	public boolean lockAccount(@PathVariable @ApiParam(name = "id", value = "员工账号") String id) {
        accSev.setAccountLockStatus(id, true);
        return true;
	}
	
	
	/**
	 * 解锁锁定账号
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "解锁锁定账号--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/unlock", method = RequestMethod.PUT)
	public boolean unlockAccount(@PathVariable @ApiParam(name = "id", value = "员工账号") String id) {
        accSev.setAccountLockStatus(id, false);
        return true;
	}
	
	
	/**
	 * 账号初始密码
	 * @param id
	 * @return boolean
	 */
	@ApiOperation(value = "账号初始密码--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
			})
	@RequestMapping(path = "/{id}/password/reset", method = RequestMethod.PUT)
	public boolean initAccountPassword(@PathVariable @ApiParam(name = "id", value = "员工账号ID") String id) {
		String password = SystemSettingConfig.getAllConfig().getInitPassword();
        accSev.changeAccountPassword(id, password);
        return true;
	}
	

}
