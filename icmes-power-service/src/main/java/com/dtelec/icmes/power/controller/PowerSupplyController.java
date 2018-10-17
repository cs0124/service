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

import com.dtelec.icmes.power.controller.vo.ReqCreatePowerSupplyFormVO;
import com.dtelec.icmes.power.service.IPowerSupplyService;
import com.dtelec.icmes.power.service.model.PowerSupplyFormFullModel;
import com.dtelec.icmes.power.utility.PowerFormAssistor;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 申请送点控制器
 * @author schi
 *
 */
@RestController
@RequestMapping("/supplyForms")
public class PowerSupplyController {

	@Autowired 
	IPowerSupplyService supplyService;
	
	/**
	 * 新增送电申请单
	 * @param reqVo  新增送电申请单模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="创建送电申请单-作者：迟山", notes="必须提供停电申请单单号")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void createPowerSupplyForm(@Valid @RequestBody @ApiParam(name = "ReqCreatePowerSupplyFormVO",value ="新建模型") ReqCreatePowerSupplyFormVO reqVo) throws Exception {
		PowerSupplyFormFullModel model = new PowerSupplyFormFullModel();
		
		//生成送电申请单ID
		Date nowDate = new Date();
		
		
		String prefix = "PT";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = sdf.format(nowDate);

		String maxId = supplyService.getMaxcutFormId(nowTime);
		String suffix;
		if(maxId != null && !"".equals(maxId)) {			
			suffix = maxId;
		}
		else {
			suffix = "001";
		}
		String newId = PowerFormAssistor.generatePowerFormId(prefix, suffix);
		
		model.setPowerCutFormId(reqVo.powerCutFormId);
		model.setStatus("POWER_CUT_SUPPLY_COMMIT");
		model.setId(newId);
		
		supplyService.createPowerSupplyFrom(model);
	}
	
	
	/**
	 * 获取送电申请单详细信息
	 * @param id  申请单标识
	 * @return  申请单模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="获取送电申请单详细信息-作者：迟山", notes="根据url的id来获取送电申请单的详细信息")
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
	public PowerSupplyFormFullModel getPowerSupplyFormDetail(@PathVariable @ApiParam(name = "id", value = "申请单标识") String id) throws Exception {
		PowerSupplyFormFullModel model = supplyService.getPowerSupplyFormDetail(id);
		
		return model;
	}
	
	
	public static String addZeroAsPrefix(int requireLen, String s) {

        String sReturn = "";
        for (int i = 0; i < requireLen - s.length(); i++) {
            sReturn += 0;
        }
        sReturn += s;

        return sReturn;
    }
	
}
