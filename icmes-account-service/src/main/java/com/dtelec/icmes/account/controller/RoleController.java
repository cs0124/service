package com.dtelec.icmes.account.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.account.controller.vo.AccountOrgCollection;
import com.dtelec.icmes.account.controller.vo.ReqCreateRoleVO;
import com.dtelec.icmes.account.controller.vo.ReqUpdateRoleVO;
import com.dtelec.icmes.account.service.IRoleService;
import com.dtelec.icmes.account.service.model.FeatureModel;
import com.dtelec.icmes.account.service.model.RoleCollection;
import com.dtelec.icmes.account.service.model.RoleCreateModel;
import com.dtelec.icmes.account.service.param.AccountOrgPageableSearchParam;
import com.dtelec.icmes.account.service.param.RolePageableSearchParam;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.common.utility.ConditionUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService service;
	
	/**
	 * 角色查询列表
	 * @param condition
	 * @return
	 */
	@ApiOperation(value = "角色查询列表--作者：张瑞晗")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id",value="角色编码"),
			@ApiImplicitParam(name="name",value="角色名称"),
			@ApiImplicitParam(name="orderBy",value="排序列名"),
			@ApiImplicitParam(name="ascending",value="正序倒序"),
			@ApiImplicitParam(name="pageNo",value="当前页数"),
			@ApiImplicitParam(name="pageSize",value="每页条数")
	})
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误") })
	@RequestMapping(path="/list/{condition}",method = RequestMethod.GET)
	public RoleCollection searchRole(@PathVariable @ApiParam(name = "condition", value = "传入模型") String condition) {
		//初始化
		ConditionUtils util = new ConditionUtils(condition);
		String id = util.getValueString("id", null);
		String name = util.getValueString("name", null);
		String orderBy = util.getValueString("orderBy", null);
		boolean ascending = util.getValueBoolean("ascending", false);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		
		//赋值
		RolePageableSearchParam params = new RolePageableSearchParam(id, name, pageNo, pageSize);
		params.setOrderBy(orderBy);
		params.setAscending(ascending);
		
		//调用service层
		RoleCollection coll = service.searchRoleByParam(params);
		return coll;
	}
	
	
	/**
	 * 角色权限列表查询
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "角色权限列表查询--作者：徐宏亮")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误") })
	@RequestMapping(path = "/{id}/features/list", method = RequestMethod.GET)
	public List<FeatureModel> searchAccountFeature(@PathVariable @ApiParam(name = "id", value = "角色编码") String id) {
		return service.getAllFeatureByRoleId(id);
	}
	
	
	/**
	 * 角色用户列表查询
	 * @param id
	 * @param condition
	 * @return
	 */
	@ApiOperation(value = "角色用户列表查询--作者：徐宏亮")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNo",value="当前页数"),
		@ApiImplicitParam(name="pageSize",value="每页条数")
	})
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误") })
	@RequestMapping(path = "/{id}/account/list/{condition}", method = RequestMethod.GET)
	public AccountOrgCollection searchRoleAccount(@PathVariable @ApiParam(name = "id", value = "角色编号") String id, @PathVariable @ApiParam(name = "condition", value = "传入模型") String condition) {
		//初始化参数
		ConditionUtils util = new ConditionUtils(condition);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		AccountOrgPageableSearchParam params = new AccountOrgPageableSearchParam(id, pageNo, pageSize);
		//调用service层
		AccountOrgCollection coll = service.searchAccountOrg(params);
		
		return coll;
	}	
	
	
	/**
	 * 角色删除（强制）
	 * @param id
	 * @param condition
	 * @return
	 * @throws IcmesBusinessException
	 */
	@ApiOperation(value = "角色删除（强制）--作者：张瑞晗")
	@ApiImplicitParams({
		@ApiImplicitParam(name="force",value="是否强制删除",type="boolean")
	})
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误"),
		@ApiResponse(code = 108, message = "查询到相关用户，不能删除！"),
		@ApiResponse(code = 109, message = "请传入id！删除失败！") 
		
	})
	@RequestMapping(path = "/{id}/{condition}", method = RequestMethod.DELETE)
	public String deleteRoleForce(@PathVariable @ApiParam(name = "id", value = "角色ID") String id,@PathVariable @ApiParam(name = "condition", value = "是否强制删除") String condition) throws IcmesBusinessException {
		// 初始化参数
		ConditionUtils utils = new ConditionUtils(condition);
		Boolean force = utils.getValueBoolean("force", null);
		// 判断传入参数是否符合条件
		if (id != null) {
			int count = service.checkRole(id);
			if (count == 0 && force == true) {
				service.deleteRole(id);
			} else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ROLE_DELETE_HASUSER, "查询到相关用户，不能删除！");
			}
		} else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ROLE_DELETE_NOFOUND_ID, "请传入id！删除失败！");
		}
		return "{}";
	}
	
	
	/**
	 * 角色删除
	 * @param id
	 * @return
	 * @throws IcmesBusinessException
	 */
	@ApiOperation(value = "角色删除--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误") })
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteRole(@PathVariable @ApiParam(name = "id", value = "角色ID") String id) throws IcmesBusinessException {
		return this.deleteRoleForce(id, "force=true");
	}

	
	/**
	 * 角色新增
	 * @param reqVo
	 * @throws IcmesBusinessException 
	 */
	@ApiOperation(value = "角色新增--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误"),
		@ApiResponse(code = 114, message = "该角色已经存在，不能新建！")
	})
	@RequestMapping(method = RequestMethod.POST)
	public void createRole(@RequestBody @ApiParam(name = "reqCreateRoleVO", value = "传入模型") ReqCreateRoleVO reqVo) throws IcmesBusinessException {
		//初始化参数模型
		RoleCreateModel model =new RoleCreateModel();
		model.setFeatures(reqVo.features);
		model.setId(reqVo.id);
		model.setName(reqVo.name);
		model.setRemark(reqVo.remark);
		model.setVersionTag(UUID.randomUUID().toString());
		
		//调用service
		service.createRole(model);
	}
	
	
	/**
	 * 角色修改
	 * @param id
	 * @param reqVO
	 * @throws IcmesBusinessException
	 */
	@ApiOperation(value = "角色修改--作者：张瑞晗")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误") ,
		@ApiResponse(code = 110, message = "当前数据不是最新版本，请刷新后再操作！") 
	})
	@RequestMapping(path="/{id}",method = RequestMethod.PUT)
	public void updateRole(@PathVariable @ApiParam(name = "id", value = "角色id") String id,@RequestBody @ApiParam(name = "reqUpdateRoleVO", value = "传入模型") ReqUpdateRoleVO reqVO) throws IcmesBusinessException {
		//判断版本控制
		String versionTag = reqVO.versionTag;
		reqVO.id = id;
		String currentVersionTag=service.checkRoleVersionTag(id);
		//版本控制相等，先删除后新增
		if(currentVersionTag.equals(versionTag)) {
			
			//初始化参数模型
			RoleCreateModel model =new RoleCreateModel();
			model.setFeatures(reqVO.features);
			model.setId(reqVO.id);
			model.setName(reqVO.name);
			model.setRemark(reqVO.remark);
			model.setVersionTag(UUID.randomUUID().toString());
			service.updateRole(model);
		}else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ROLE_UPDATE_VERSION_ERROR, "当前数据不是最新版本，请刷新后再操作！");
		}
	}
	
	
	

	
	
}
