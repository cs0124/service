package com.dtelec.icmes.power.controller;

import java.text.SimpleDateFormat;
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
import com.dtelec.icmes.power.controller.vo.ReqCreatePowerDelayFormVO;
import com.dtelec.icmes.power.service.IPowerDelayService;
import com.dtelec.icmes.power.service.model.PowerDelayFormBaseModel;
import com.dtelec.icmes.power.service.model.PowerDelayFormFullModel;
import com.dtelec.icmes.power.utility.PowerFormAssistor;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/delayForms")
public class PowerDelayController {

	@Autowired
	private IPowerDelayService powerDelayService;
	/**
	 * 新增延迟送电申请单
	 * @param reqVo  新增送电申请单模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="创建延迟送电申请单-作者：陈少义", notes="必须提供停电申请单单号")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void createPowerSupplyForm(@Valid @RequestBody @ApiParam(name = "ReqCreatePowerDelayFormVO",value ="新建模型") ReqCreatePowerDelayFormVO reqVo) throws Exception {

		PowerDelayFormBaseModel model = new PowerDelayFormBaseModel();
		model.setPowerCutFormId(reqVo.powerCutFormId);
		model.setScheduledDelaySupplyTime(reqVo.scheduledSupplyTime);
		model.setStatus("POWER_DELAY_COMMIT");
		
		//检查停电申请单是否存在尚未批准的延迟送电申请单
		if(powerDelayService.hasUnapprovedPowerDelayForm(reqVo.powerCutFormId)) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.POWER_DELAYFORM_CREATEDELAYFORM_HASUNAPPRDELAYFORM);
		}
		
		//生成申请单编号
		String prefix = "PD";
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = sdf.format(d);

		String maxId = powerDelayService.getMaxDelayFormId(nowTime);
		String suffix;
		if(maxId != null && !"".equals(maxId)) {			
			suffix = maxId;
		}
		else {
			suffix = "001";
		}
		
		String newId = PowerFormAssistor.generatePowerFormId(prefix, suffix);
		model.setId(newId);	
		
		powerDelayService.createPowerDelayBaseForm(model);
	}
	
	
	/**
	 * 获取延迟送电申请单详细信息
	 * @param id  申请单标识
	 * @return  申请单模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="获取延迟送电申请单详细信息-作者：戴常怡", notes="根据url的id来获取延迟送电申请单的详细信息")
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
	public PowerDelayFormFullModel getPowerDelayFormDetail(@PathVariable @ApiParam(name = "id", value = "申请单标识") String id) throws Exception {
		return powerDelayService.getPowerDelayFullFormDetailById(id);
	}
	

}
