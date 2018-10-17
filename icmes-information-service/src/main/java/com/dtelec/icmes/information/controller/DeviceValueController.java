package com.dtelec.icmes.information.controller;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ReqCreateDeviceValueVO;
import com.dtelec.icmes.information.controller.vo.ReqNewnessCoefficientVO;
import com.dtelec.icmes.information.controller.vo.ReqUpdateDeviceValueVO;
import com.dtelec.icmes.information.service.command.DeviceValueCreateCommand;
import com.dtelec.icmes.information.service.command.DeviceValueDeleteCommand;
import com.dtelec.icmes.information.service.command.DeviceValueUpdateCommand;
import com.dtelec.icmes.information.service.model.DeviceValueCollection;
import com.dtelec.icmes.information.service.model.DeviceValueModel;
import com.dtelec.icmes.information.service.query.DeviceValueAllGrossOrgValueTotalQuery;
import com.dtelec.icmes.information.service.query.DeviceValueDetailQuery;
import com.dtelec.icmes.information.service.query.DeviceValueSearchQuery;
import com.dtelec.icmes.information.service.helper.IValueHelper;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/deviceValue")
public class DeviceValueController {

	/**
	 * 新度系数帮助
	 */
	@Autowired
	private IValueHelper valueHelper;
	
	@ApiOperation(value="获取设备净值详细信息-作者：孔轩", notes="根据url的id来获取设备净值的详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "设备净值标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public DeviceValueModel getDeviceValue(@PathVariable @ApiParam(name = "id", value = "设备净值标示") int id) throws Exception {
		if(id > 0) {
			//初始化query
			DeviceValueDetailQuery query = new DeviceValueDetailQuery(id);
			//调用handler
			DeviceValueModel model = query.queryAndWait();
			return model;
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DEVICEVALUE_QUERYTDEVICEVALUE_NOFOUND_ID);
		}
	}
	

	@ApiOperation(value="修改设备净值信息-作者：孔轩", notes="根据url的id来修改设备净值信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "设备净值标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateDeviceValue(@PathVariable @ApiParam(name = "id", value = "设备净值标示") int id, @Valid @RequestBody @ApiParam(name = "ReqUpdateDeviceValueVO", value ="更新模型")ReqUpdateDeviceValueVO reqVo) throws Exception {
		DeviceValueModel model = new DeviceValueModel();
		model.setId(id);
		model.setNetValuePeriod(reqVo.netValuePeriod);
		model.setGrossOrgValue(reqVo.grossOrgValue);
		model.setGrossNetValue(reqVo.grossNetValue);
		model.setVersionTag(reqVo.versionTag);
		model.setUpdateTime((new Date()).getTime());

		//初始化command
		DeviceValueUpdateCommand command = new DeviceValueUpdateCommand(model);
		//调用handler
		command.sendAndWait();
	}
	
	
	@ApiOperation(value="删除设备净值信息-作者：孔轩", notes="根据url的id来删除设备净值信息")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "设备净值标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteDeviceValue(@PathVariable @ApiParam(name = "id", value = "设备净值标示") int id) throws Exception {
		//初始化model数据
		DeviceValueModel model = new DeviceValueModel();
		model.setId(id);
		//初始化command
		DeviceValueDeleteCommand command = new DeviceValueDeleteCommand(model);
		//调用handler
		command.sendAndWait();
	}
	
	
	@ApiOperation(value="创建设备净值信息-作者：孔轩", notes="netValuePeriod，grossOrgValue和grossNetValue是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void createDeviceValue(@Valid @RequestBody @ApiParam(name = "ReqCreateDeviceValueVO",value ="新建模型") ReqCreateDeviceValueVO reqVo) throws Exception {
		//转换vo到model
		DeviceValueModel model = new DeviceValueModel();
		model.setNetValuePeriod(reqVo.netValuePeriod);
		model.setGrossOrgValue(reqVo.grossOrgValue);
		model.setGrossNetValue(reqVo.grossNetValue);

		//初始化command
		DeviceValueCreateCommand command = new DeviceValueCreateCommand(model);

		//调用handler
		command.sendAndWait();
	}
	
	
	@ApiOperation(value="设备净值查询--作者：孔轩", notes="condition是查询条件")
	@ApiImplicitParams({
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
	public DeviceValueCollection getDeviceValues(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils util = new ConditionUtils(condition);
		//初始化分页
		String orderBy = util.getValueString("orderBy", null);
		Boolean ascending = util.getValueBoolean("ascending", null);
		int pageNo = util.getValueInteger("pageNo", 1);
		int pageSize = util.getValueInteger("pageSize", 0);

		//给实体类赋值
		DeviceValueSearchQuery query = new DeviceValueSearchQuery(pageNo, pageSize);
		query.setOrderBy(orderBy);
		query.setAscending(ascending);

		//调用handler
		DeviceValueCollection coll = query.queryAndWait();

		return coll;
	}
	
	
	@ApiOperation(value="计算设备台账已录入的设备总原值的总和-作者：孔轩", notes="")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/allGrossOrgValueTotal", method = RequestMethod.GET)
	public double computeAllGrossOrgValueTotal() throws Exception {
		DeviceValueAllGrossOrgValueTotalQuery query = new DeviceValueAllGrossOrgValueTotalQuery();
		Double total = query.queryAndWait();

		return total;
	}
	
	
	@ApiOperation(value="计算设备的新度系数-作者：孔轩", notes="netValuePeriod，grossOrgValue和grossNetValue是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/newnessCoefficient", method = RequestMethod.POST)
	public double computeNewnessCoefficient(@Valid @RequestBody @ApiParam(name = "ReqNewnessCoefficientVO",value ="模型") ReqNewnessCoefficientVO reqVo) throws Exception {
		//计算新度系数
		Double newnessCoefficient = valueHelper.computeNewnessCoefficient(reqVo.grossOrgValue, reqVo.grossNetValue);

		return newnessCoefficient;
	}
	
}
