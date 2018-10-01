package com.dtelec.icmes.information.controller;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ResOrganizationAccountVO;
import com.dtelec.icmes.information.controller.vo.ResOrganizationsVO;
import com.dtelec.icmes.information.service.command.OrganizationCreatetCommand;
import com.dtelec.icmes.information.service.command.OrganizationDeleteCommand;
import com.dtelec.icmes.information.service.command.OrganizationUpdateCommand;
import com.dtelec.icmes.information.service.model.OrganizationAccountCollection;
import com.dtelec.icmes.information.service.model.OrganizationModel;
import com.dtelec.icmes.information.service.model.OrganizationsCollection;
import com.dtelec.icmes.information.service.model.OrganizationsFullNameModel;
import com.dtelec.icmes.information.service.query.OrganizationAccountsQuery;
import com.dtelec.icmes.information.service.query.OrganizationSearchQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
	
	/**
	 * 组织机构查询
	 * @author RHZhang
	 *
	 */
	@ApiOperation(value="组织机构查询--作者：张瑞晗" )
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "id", value = "组织机构id",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "name", value = "组织机构名称",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "parentId", value = "组织结构上层机构编号",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "hierarchy", value = "递归的层级次数0标识全部子孙",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "string", paramType = "query"),
		 })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public ResOrganizationsVO<OrganizationsFullNameModel> getOrganizations(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils util = new ConditionUtils(condition);
		String id=util.getValueString("id", null);
		String name = util.getValueString("name", null);
		String parentId = util.getValueString("parentId", null);
		//初始化分页
		String hierarchy = util.getValueString("hierarchy", null);
		String orderBy = util.getValueString("orderBy", null);
		Boolean ascending = util.getValueBoolean("ascending", null);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);
		//给实体类赋值
		OrganizationSearchQuery query = new OrganizationSearchQuery(pageNo, pageSize);
		query.setId(id) ;
		query.setName(name) ;
		query.setParentId(parentId) ;
		query.setHierarchy(hierarchy) ;
		query.setOrderBy(orderBy) ;
		query.setAscending(ascending) ;
		//调用handler
		OrganizationsCollection coll = query.queryAndWait();
		//返回参数
		ResOrganizationsVO<OrganizationsFullNameModel> resVO = new ResOrganizationsVO<>(coll);
		return resVO;
	}
	
	
	/**
	 * 组织机构挂接人员查询
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="组织机构挂接人员查询--作者：张瑞晗" )
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "name", value = "员工名称",  dataType = "string", paramType = "query")
	})
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path = "/account/list/{condition}", method = RequestMethod.GET)
	public ResOrganizationAccountVO getOrganizationAccounts(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils util = new ConditionUtils(condition);
		String name = util.getValueString("name", null);
		
		ResOrganizationAccountVO resVO = new ResOrganizationAccountVO();
		OrganizationAccountsQuery query = new OrganizationAccountsQuery();
		//入参赋值
		query.setName(name);
		//返回集合
		OrganizationAccountCollection queryList = query.queryAndWait();
		resVO.items = queryList.getList();
		return resVO;
	}
	
	
	/**
	 * 查询组织机构（无参接口）
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="组织机构查询(无参接口)--作者：张瑞晗" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ResOrganizationsVO<OrganizationsFullNameModel> getOrganizationsAll() throws Exception {
		return this.getOrganizations("");
	}
	
	
	/**
	 * 组织机构新增
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="组织机构新增--作者：张瑞晗" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(method = RequestMethod.POST)
	public String createOrganization(@RequestBody @ApiParam(name = "employeeModel",value ="员工模型")OrganizationModel model ) throws Exception {
		//初始化command
		OrganizationCreatetCommand command = new OrganizationCreatetCommand();
		command.fill(model);
		//调用handler
		command.sendAndWait();
		return "{}";
	}
	
	
	/**
	 * 组织机构编辑
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="组织机构编辑--作者：张瑞晗" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误"),
		@ApiResponse(code = 209, message = "传入ID不能为空"),
		@ApiResponse(code = 210, message = "不能修改根目录的父类机构"),
		@ApiResponse(code = 212, message = "当前数据不是最新版本，请刷新后再操作")
		})
	@RequestMapping(path = "/{id}",method = RequestMethod.PUT)
	public String updateOrganization(@RequestBody @ApiParam(name = "organizationModel",value ="组织机构模型")OrganizationModel model ,@PathVariable @ApiParam(name = "id",value ="组织机构id") String id) throws Exception {
		String parentId = model.getParentId();
		//检测id是否为空
		if (id == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_ORGANIZATION_UPDATEORGANIZATION_NOFOUND_ID, "传入ID不能为空");
		}else if("0".equals(id) && parentId!=null && (!parentId.equals(""))) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_ORGANIZATION_UPDATEORGANIZATION_ROOT_PARENTID_ERROR, "不能修改根目录的父类机构");
		} else {
			//符合条件进行编辑
			model.setId(id);
			OrganizationUpdateCommand command = new OrganizationUpdateCommand();
			command.fill(model);
			command.sendAndWait();
			return "{}";
		}
	}
	
	
	/**
	 * 组织机构删除
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="组织机构删除--作者：张瑞晗" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 500, message = "内部程序错误"),
		@ApiResponse(code = 211, message = "当前机构存在子机构或关联其他用户，不能删除")
		})
	@RequestMapping(path="/{id}",method = RequestMethod.DELETE)
	public String deleteOrganization(@PathVariable @ApiParam(name = "id",value ="组织id")String id ) throws Exception {
		//初始化command
		OrganizationDeleteCommand command = new OrganizationDeleteCommand();
		OrganizationModel model = new OrganizationModel();
		model.setId(id);
		command.fill(model);
		//调用handler
		command.sendAndWait();
		return "{}";
	}
	

}
