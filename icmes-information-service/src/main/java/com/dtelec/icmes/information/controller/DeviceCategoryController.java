package com.dtelec.icmes.information.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ReqCreateDeviceCategoryVO;
import com.dtelec.icmes.information.controller.vo.ReqUpdateDeviceCategoryVO;
import com.dtelec.icmes.information.service.command.DeviceCategoryCreateCommand;
import com.dtelec.icmes.information.service.command.DeviceCategoryDeleteCommand;
import com.dtelec.icmes.information.service.command.DeviceCategoryUpdateCommand;
import com.dtelec.icmes.information.service.model.DeviceCategoryCollection;
import com.dtelec.icmes.information.service.model.DeviceCategoryModel;
import com.dtelec.icmes.information.service.query.DeviceCategoryDetailQuery;
import com.dtelec.icmes.information.service.query.DeviceCategorySearchQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 设备类型控制器
 * @author schi
 *
 */
@RestController
@RequestMapping("/deviceCategory")
public class DeviceCategoryController {

	/**
	 * 获取设备类型详细信息
	 * @param id 设备类型标示
	 * @return 设备类型实体类
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="获取设备类型详细信息-作者：迟山", notes="根据url的id来获取设备类型的详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "设备类型标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public DeviceCategoryModel getDeviceCategory(@PathVariable @ApiParam(name = "id", value = "设备类型标示") int id) throws Exception{
		DeviceCategoryDetailQuery query = new DeviceCategoryDetailQuery(id);
		DeviceCategoryModel model = query.queryAndWait();
		
		return model;
	}
	

	/**
	 * 修改设备类型
	 * @param id 设备类型标示
	 * @param reqVo 修改设备类型模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="修改设备类型信息-作者：迟山", notes="根据url的id来修改设备类型信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "设备类型标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateDeviceCategory(@PathVariable @ApiParam(name = "id", value = "设备类型标示") int id, @Valid @RequestBody @ApiParam(name = "ReqUpdateDeviceCategoryVO", value ="更新模型") ReqUpdateDeviceCategoryVO reqVo) throws Exception {
		DeviceCategoryModel model = new DeviceCategoryModel();
		
		model.setId(id);
		model.setName(reqVo.name);
		model.setVersionTag(reqVo.versionTag);
		
		DeviceCategoryUpdateCommand command = new DeviceCategoryUpdateCommand(model);
		command.setRelatedSpceDataIds(reqVo.specDataIds);
		command.sendAndWait();
	}
	
	
	/**
	 * 删除设备类型信息
	 * @param id 设备类型标示
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="删除设备类型信息-作者：迟山", notes="根据url的id来删除设备类型信息")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "设备类型标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteDeviceCategory(@PathVariable @ApiParam(name = "id", value = "设备类型标示") int id) throws Exception {
		DeviceCategoryDeleteCommand command = new DeviceCategoryDeleteCommand(id);
		command.sendAndWait();
	}
	
	
	/**
	 * 新建设备类型
	 * @param reqVo 新建设备类型模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="创建设备类型信息-作者：迟山", notes="code和name是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void createDeviceCategory(@Valid @RequestBody @ApiParam(name = "ReqCreateDeviceCategoryVO",value ="新建模型") ReqCreateDeviceCategoryVO reqVo) throws Exception {
		
		DeviceCategoryModel model = new DeviceCategoryModel();
		model.setCode(reqVo.code);
		model.setName(reqVo.name);
		model.setPrimary(reqVo.isPrimary);
		
		DeviceCategoryCreateCommand command = new DeviceCategoryCreateCommand(model);
		command.setRelatedSpceDataIds(reqVo.specDataIds);
		command.sendAndWait();
	}
	
	
	/**
	 * 设备类型列表
	 * @param condition 查询条件
	 * @return 设备类型集合
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="设备类型查询--作者：迟山", notes="condition是查询条件")
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "isPrimary", value = "是否搜索主设备",  dataType = "boolean", paramType = "query"),
		 @ApiImplicitParam(name = "globalName", value = "全局搜索",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "boolean", paramType = "query"),
		 })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public DeviceCategoryCollection getDeviceCategories(@PathVariable String condition) throws Exception {
		//初始化查询参数
		ConditionUtils conditionUtil = new ConditionUtils(condition);
		
		Boolean isPrimary = conditionUtil.getValueBoolean("isPrimary", true);
		String globalName = conditionUtil.getValueString("globalName", null);
		Integer pageNo = conditionUtil.getValueInteger("pageNo", 1);
		Integer pageSize = conditionUtil.getValueInteger("pageSize", 0);
		String orderBy = conditionUtil.getValueString("orderBy", null);
		Boolean ascend = conditionUtil.getValueBoolean("ascending", true);	
		
		//给实体类model赋值
		DeviceCategorySearchQuery query = new DeviceCategorySearchQuery(pageNo,pageSize);
		query.setIsPrimary(isPrimary);
		query.setGlobalName(globalName);
		query.setOrderBy(orderBy);
		query.setAscending(ascend);
		
		//调用handler
		DeviceCategoryCollection coll = query.queryAndWait();
		//返回参数
		return coll;
	}
	
}
