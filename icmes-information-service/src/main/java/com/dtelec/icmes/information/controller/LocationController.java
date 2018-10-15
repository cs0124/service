package com.dtelec.icmes.information.controller;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ReqCreateLocationVO;
import com.dtelec.icmes.information.controller.vo.ReqUpdateLocationVO;
import com.dtelec.icmes.information.service.command.LocationCreateCommand;
import com.dtelec.icmes.information.service.command.LocationDeleteCommand;
import com.dtelec.icmes.information.service.command.LocationUpdateCommand;
import com.dtelec.icmes.information.service.model.LocationCollection;
import com.dtelec.icmes.information.service.model.LocationModel;
import com.dtelec.icmes.information.service.query.LocationDetailQuery;
import com.dtelec.icmes.information.service.query.LocationSearchQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Location Controller
 */
@RestController
@RequestMapping("/locations")
public class LocationController {
	
	@ApiOperation(value="获取位置详细信息-作者：孔轩", notes="根据url的id来获取位置的详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "位置标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public LocationModel getLocationDetail(@PathVariable @ApiParam(name = "id", value = "位置标示") int id) throws Exception {
		if(id > 0) {
			//初始化query
			LocationDetailQuery query = new LocationDetailQuery(id);
			//调用handler
			LocationModel model = query.queryAndWait();
			return model;
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_QUERYTLOCATION_NOFOUND_ID, "传入ID不能为空");
		}
	}
	

	@ApiOperation(value="修改位置信息-作者：孔轩", notes="根据url的id来修改位置信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "位置标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateLocationDetail(@PathVariable @ApiParam(name = "id", value = "位置标示") int id, @Valid @RequestBody @ApiParam(name = "ReqUpdateLocationVO", value ="更新模型")ReqUpdateLocationVO reqVo) throws Exception {
		int parentId = (reqVo == null) ? 0 :reqVo.parentId;
		if(id > 0) {
			//转换vo到model
			LocationModel model = new LocationModel();
			model.setId(id);
			model.setCode(reqVo.code);
			model.setName(reqVo.name);
			model.setParentId(reqVo.parentId);
			model.setVersionTag(reqVo.versionTag);
			model.setUpdateTime((new Date()).getTime());

			//初始化command
			LocationUpdateCommand command = new LocationUpdateCommand(model);

			//调用handler
			command.sendAndWait();
			
		}
		else if(id == 0 && parentId <= 0) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_UPDATELOCATION_ROOT_PARENTID_ERROR, "不能修改根目录的父类位置");
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_LOCATION_UPDATELOCATION_NOFOUND_ID, "传入ID不能为空");
		}
	}
	
	
	@ApiOperation(value="删除位置信息-作者：孔轩", notes="根据url的id来删除位置信息")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "位置标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteLocation(@PathVariable @ApiParam(name = "id", value = "位置标示") int id) throws Exception {
		//初始化model数据
		LocationModel model = new LocationModel();
		model.setId(id);
		//初始化command
		LocationDeleteCommand command = new LocationDeleteCommand(model);
		//调用handler
		command.sendAndWait();
	}
	
	
	@ApiOperation(value="创建位置信息-作者：孔轩", notes="code和name是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseBody
	public void createLocation(@Valid @RequestBody @ApiParam(name = "ReqCreateLocationVO",value ="位置模型") ReqCreateLocationVO reqVo) throws Exception {
		//转换vo到model
		LocationModel model = new LocationModel();
		model.setCode(reqVo.code);
		model.setName(reqVo.name);
		model.setParentId(reqVo.parentId);

		//初始化command
		LocationCreateCommand command = new LocationCreateCommand(model);

		//调用handler
		command.sendAndWait();
	}
	
	@ApiOperation(value="位置查询(无参接口)--作者：孔轩", notes="condition是查询条件")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public LocationCollection getLocationsAll() throws Exception {
		return this.getLocations("");
	}
	
	@ApiOperation(value="位置查询--作者：孔轩", notes="condition是查询条件")
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "code", value = "位置编码",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "name", value = "位置名称",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "parentId", value = "位置的上层位置标示",  dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "hierarchy", value = "递归的层级次数0标识全部子孙",  dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "bool", paramType = "query"),
		 })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public LocationCollection getLocations(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils util = new ConditionUtils(condition);
		String code = util.getValueString("code", null);
		String name = util.getValueString("name", null);	
		int parentId = util.getValueInteger("parentId", 0);

		//初始化分页
		String hierarchy = util.getValueString("hierarchy", null);
		String orderBy = util.getValueString("orderBy", null);
		Boolean ascending = util.getValueBoolean("ascending", null);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);

		//给实体类赋值
		LocationSearchQuery query = new LocationSearchQuery(pageNo, pageSize);
		query.setCode(code) ;
		query.setName(name) ;
		query.setParentId(parentId) ;
		query.setHierarchy(hierarchy) ;
		query.setOrderBy(orderBy) ;
		query.setAscending(ascending) ;
		//调用handler
		LocationCollection coll = query.queryAndWait();	

		return coll;
	}

}

