package com.dtelec.icmes.information.controller;

import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ReqCreateEmployeeVO;
import com.dtelec.icmes.information.controller.vo.ReqPersistentEmployeeVO;
import com.dtelec.icmes.information.controller.vo.ReqUpdateEmployeeVO;
import com.dtelec.icmes.information.controller.vo.ResEmployeesVO;
import com.dtelec.icmes.information.service.command.EmployeeCreatetCommand;
import com.dtelec.icmes.information.service.command.EmployeeDeleteCommand;
import com.dtelec.icmes.information.service.command.EmployeePersistentCommand;
import com.dtelec.icmes.information.service.command.EmployeeUpdateCommand;
import com.dtelec.icmes.information.service.model.EmployeeModel;
import com.dtelec.icmes.information.service.model.EmployeesCollection;
import com.dtelec.icmes.information.service.model.EmployeesFullNameModel;
import com.dtelec.icmes.information.service.query.EmployeeDetailQuery;
import com.dtelec.icmes.information.service.query.EmployeeSearchQuery;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	/**
	 * 获取员工信息
	 * @param id 员工工号
	 * @return  员工模型
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(value="获取员工信息-作者：迟山", notes="根据url的id来获取员工详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "员工工号")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public EmployeeModel getEmployeeDetail(@PathVariable String id) throws Exception {
		//通过员工工号获取员工详细信息
		EmployeeDetailQuery query = new EmployeeDetailQuery(id);
		EmployeeModel model = query.queryAndWait();
		
		return model;
	}
	
	/**
	 * 修改员工信息
	 * @param id 员工工号
	 * @throws Exception 抛出异常
	 * @param reqVo 编辑员工模型
	 */
	@ApiOperation(value="修改员工信息-作者：迟山", notes="根据url的id来修改员工信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "员工工号")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateEmployeeDetail(
			@PathVariable 
			@ApiParam(name = "id", value = "员工工号") 
			String id, 
			@Valid 
			@RequestBody 
			@ApiParam(name = "employeeModel", value ="员工模型")
			ReqUpdateEmployeeVO reqVo
			) throws Exception {
		EmployeeModel model = new EmployeeModel();
		model.setId(id);
		model.setSpecialDevice(reqVo.specialDevice);
		model.setOrganizationId(reqVo.organizationId);
		model.setOfficePhone(reqVo.officePhone);
		model.setOfficePhoneArea(reqVo.officePhoneArea);
		model.setOfficePhoneExt(reqVo.officePhoneExt);
		model.setJoinDate(reqVo.joinDate);
		//员工类型
		model.setCategory(reqVo.category);
		model.setWorkType(reqVo.workType);
		model.setName(reqVo.name);
		model.setMobilePhone(reqVo.mobilePhone);
		model.setGender(reqVo.gender);
		model.setEmail(reqVo.email);
		//出生日期
		model.setBirthDate(reqVo.birthDate);
		model.setIdentityCard(reqVo.identityCard);
		model.setGraduateSchool(reqVo.graduateSchool);
		model.setSpecialty(reqVo.specialty);
		model.setQualification(reqVo.qualification);
		model.setGraduationDate(reqVo.graduationDate);
		model.setHighEducation(reqVo.highEducation);
		model.setHighDegree(reqVo.highDegree);
		model.setVersionTag(reqVo.versionTag);
		//把任务交给UpdateCommand执行
		EmployeeUpdateCommand command = new EmployeeUpdateCommand(model);
		command.sendAndWait();
	}
	
	
	/**
	 *删除员工信息
	 * @param id 员工工号
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(value="删除员工信息-作者：迟山", notes="根据url的id来删除员工信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "员工工号")
	})
	//id为员工工号
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable @ApiParam(name = "id",value ="员工id")String id ) throws Exception {
		//初始化command
		EmployeeDeleteCommand command = new EmployeeDeleteCommand(id);
		command.sendAndWait();
	}
	
	
	/**
	 * 创建员工信息
	 * @param reqVo 新建员工模型
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(value="创建员工-作者：迟山", notes="id和name是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseBody
	public void createEmployee(@Valid @RequestBody @ApiParam(name = "employeeModel",value ="员工模型")ReqCreateEmployeeVO reqVo) throws Exception {
		EmployeeModel model = new EmployeeModel();
		model.setId(reqVo.id);
		model.setSpecialDevice(reqVo.specialDevice);
		model.setOrganizationId(reqVo.organizationId);
		//员工办公室电话
		model.setOfficePhone(reqVo.officePhone);
		model.setOfficePhoneArea(reqVo.officePhoneArea);
		model.setOfficePhoneExt(reqVo.officePhoneExt);
		model.setJoinDate(reqVo.joinDate);
		model.setCategory(reqVo.category);
		model.setWorkType(reqVo.workType);
		model.setName(reqVo.name);
		model.setMobilePhone(reqVo.mobilePhone);
		model.setGender(reqVo.gender);
		//邮箱
		model.setEmail(reqVo.email);
		model.setBirthDate(reqVo.birthDate);
		model.setIdentityCard(reqVo.identityCard);
		model.setGraduateSchool(reqVo.graduateSchool);
		model.setSpecialty(reqVo.specialty);
		model.setQualification(reqVo.qualification);
		model.setGraduationDate(reqVo.graduationDate);
		model.setHighEducation(reqVo.highEducation);
		model.setHighDegree(reqVo.highDegree);
		//把任务交给CreateCommand执行
		EmployeeCreatetCommand command = new EmployeeCreatetCommand(model);
		command.sendAndWait();
	}
	
	
	
	/**
	 * 获取员工列表
	 * @param condition 查询条件
	 * @return 员工信息模型
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(value="获取员工列表-作者：迟山", notes="condition是查询条件")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "id", value = "员工工号",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "name", value = "员工名称",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "specialDevice", value = "专用设备号",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "organizationId", value = "组织机构",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "category", value = "员工类型",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "workType", value = "工种",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "joinDateStart", value = "入职开始时间",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "joinDateStart", value = "入职结束时间",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "string", paramType = "query"),
		 })
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public ResEmployeesVO<EmployeesFullNameModel> getEmployees(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils conditionUtil = new ConditionUtils(condition);
		String id = conditionUtil.getValueString("id", null);
		String name = conditionUtil.getValueString("name", null);
		String specialDevice = conditionUtil.getValueString("specialDevice", null);
		String organizationId = conditionUtil.getValueString("organizationId", null);
		//员工类型
		String category = conditionUtil.getValueString("category", null);
		String workType = conditionUtil.getValueString("workType", null);
		Long joinDateStart = conditionUtil.getValueLong("joinDateStart", 0L);
		Long joinDateEnd = conditionUtil.getValueLong("joinDateEnd", 0L);
		Integer pageNo = conditionUtil.getValueInteger("pageNo", 1);
		Integer pageSize = conditionUtil.getValueInteger("pageSize", 0);
		String orderBy = conditionUtil.getValueString("orderBy", null);
		Boolean ascend = conditionUtil.getValueBoolean("ascending", true);
		
		//给实体类model赋值
		EmployeeSearchQuery query = new EmployeeSearchQuery(pageNo, pageSize);
		query.setId(id);
		query.setName(name) ;
		query.setSpecialDevice(specialDevice);
		query.setOrganizationId(organizationId);
		query.setCategory(category);
		query.setWorkType(workType);
		query.setJoinDateStart(joinDateStart);
		query.setJoinDateEnd(joinDateEnd);
		query.setOrderBy(orderBy);
		query.setAscending(ascend);
		
		//调用handler
		EmployeesCollection coll = query.queryAndWait();
		//返回参数
		ResEmployeesVO<EmployeesFullNameModel> resVO = new ResEmployeesVO<>(coll);
		return resVO;
	}
	
	
	/**
	 * 创建账号
	 * @param reqVo 新建账号模型
	 */
	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(path = "/persistent", method = RequestMethod.POST)
	public void createOrUpdateEmployeeBaseInfo(@Valid @RequestBody @ApiParam(name = "ReqPersistentEmployeeVO",value ="员工模型") ReqPersistentEmployeeVO reqVo) {
		EmployeePersistentCommand command = new EmployeePersistentCommand(reqVo.employeeId, reqVo.employeeName, reqVo.specialDevice);
		command.sendAndWait();
	}
	
}
