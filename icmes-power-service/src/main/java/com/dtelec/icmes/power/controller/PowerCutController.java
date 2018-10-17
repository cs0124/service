package com.dtelec.icmes.power.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.power.controller.vo.ReqCreatePowerCutFormVO;
import com.dtelec.icmes.power.controller.vo.ResUploadTicketPhotoVO;
import com.dtelec.icmes.power.service.IPowerCutService;
import com.dtelec.icmes.power.service.model.PowerCutFormBaseModel;
import com.dtelec.icmes.power.service.model.PowerCutFormCollection;
import com.dtelec.icmes.power.service.model.PowerCutFormFullModel;
import com.dtelec.icmes.power.service.param.PowerCutPageableSearchParam;
import com.dtelec.icmes.power.utility.PowerFormAssistor;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * 停电申请控制器
 * @author dell
 *
 */
@RestController
@RequestMapping("/cutForms")
public class PowerCutController {

	@Autowired
	private IPowerCutService powerCutService;
  
	/**
	 * @param id  申请单标识
	 * @return  申请单模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="获取停电申请单详细信息-作者：何秋菊", notes="根据url的id来获取停电申请单的详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "申请单标识")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public PowerCutFormFullModel getPowerCutFormDetail(@PathVariable @ApiParam(name = "id", value = "申请单标识") String id) throws Exception {
		//根据申请单id 获取申请单详情
		PowerCutFormFullModel model = powerCutService.getPowerCutFormDetailById(id);
		return model;
	}

		
	/**
	 * 新增申请单
	 * @param reqVo  新增申请单模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="创建停电申请单的信息-作者：何秋菊", notes="")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void createPowerCutForm(@Valid @RequestBody @ApiParam(name = "ReqCreatePowerCutFormVO",value ="新建模型") ReqCreatePowerCutFormVO reqVo) throws Exception {
		//vo转为model
		PowerCutFormBaseModel model = new PowerCutFormBaseModel();
		//1默认状态为申请停电，从数据字典中获取
		model.setStatus("POWER_CUT_COMMIT");
		model.setType(reqVo.type);
		model.setReason(reqVo.reason);
		model.setScheduledCutOffTime(reqVo.scheduledCutOffTime);
		model.setScheduledSupplyTime(reqVo.scheduledSupplyTime);
		model.setMainDeviceId(reqVo.mainDeviceId);
		model.setMeasures(reqVo.measures);		
		
		//生成申请单编号
		String prefix = "PC";
				
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = sdf.format(d);
		//获取最大申请单id
		String maxId = powerCutService.getMaxcutFormId(nowTime);;
		String suffix;
		if(maxId != null && !"".equals(maxId)) {			
			suffix = maxId;
			}
		else {
				suffix = "001";
				}
		//调用通用方法生成申请单id				
		String newId = PowerFormAssistor.generatePowerFormId(prefix, suffix);
		
		model.setId(newId);		
		//调用service
		powerCutService.createPowerCutForm(model, reqVo.assDeviceIds, reqVo.ticketPhotos);
	}
	
	
	@ApiOperation(value="停电申请单查询--作者：陈少义", notes="condition是查询条件")
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "device", value = "设备标识符", dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "number", value = "停电申请单号", dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "status", value = "停电申请单状态", dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "globalName", value = "全局搜索", dataType = "string", paramType = "query"),
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
	public PowerCutFormCollection getPowerCutForms(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils conditionUtil = new ConditionUtils(condition);
		int device = conditionUtil.getValueInteger("device", 0);
		String number = conditionUtil.getValueString("number", null);
		List<String> statusList = conditionUtil.getValueStringArray("status", true);
		String globalName = conditionUtil.getValueString("globalName", null);
		int pageNo = conditionUtil.getValueInteger("pageNo", 1);
		int pageSize = conditionUtil.getValueInteger("pageSize", 0);
		String orderBy = conditionUtil.getValueString("orderBy", null);
		boolean ascending = conditionUtil.getValueBoolean("ascending", true);
		
		//初始化查询参数
		PowerCutPageableSearchParam params = new PowerCutPageableSearchParam(device, number, statusList, globalName, pageNo, pageSize);
		params.setOrderBy(orderBy);
		params.setAscending(ascending);
		
		PowerCutFormCollection powerCutFormCollection = powerCutService.searchPowerCutFormByParams(params);
		return powerCutFormCollection;
	}
	
	

	@ApiOperation(value="获取相关设备的停电申请单列表-作者：何秋菊", notes="根据url的id来获取停电申请单的相关设备的停电申请单列表")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "申请单标识")
	})
	@RequestMapping(path = "/{id}/assDeviceCutForms", method = RequestMethod.GET)
	public PowerCutFormCollection findAssDeviceCutForms(@PathVariable @ApiParam(name = "id", value = "申请单标识") String id) throws Exception {
		return powerCutService.getAssDeviceCutFormsById(id);
	}
	
	
	@ApiOperation(value="上传工作票照片-作者：", notes="")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/ticketPhoto", method = RequestMethod.POST)
	public ResUploadTicketPhotoVO uploadTicketPhoto() throws Exception {
		return null; 
	}	
	

	
}
