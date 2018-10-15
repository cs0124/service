package com.dtelec.icmes.information.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ReqCreateVendorVO;
import com.dtelec.icmes.information.controller.vo.ReqUpdateVendorVO;
import com.dtelec.icmes.information.controller.vo.ResVendorsVO;
import com.dtelec.icmes.information.service.command.VendorCreateCommand;
import com.dtelec.icmes.information.service.command.VendorDeleteCommand;
import com.dtelec.icmes.information.service.command.VendorUpdateCommand;
import com.dtelec.icmes.information.service.model.VendorCollection;
import com.dtelec.icmes.information.service.model.VendorModel;
import com.dtelec.icmes.information.service.query.VendorDetailQuery;
import com.dtelec.icmes.information.service.query.VendorSearchQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@ApiOperation(value="获取厂商详细信息-作者：戴常怡", notes="根据url的id来获取厂商的详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public VendorModel getVendorDetail(@PathVariable @ApiParam(name = "id", value = "厂商标示") int id) throws Exception {
		//通过厂商自增Id获取厂商信息
		VendorDetailQuery query = new VendorDetailQuery(id);
		VendorModel model = query.queryAndWait();
		
		return model;
	}
	

	@ApiOperation(value="修改厂商信息-作者：戴常怡", notes="根据url的id来修改厂商信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateVendorDetail(@PathVariable @ApiParam(name = "id", value = "厂商标示") int id, @Valid @RequestBody @ApiParam(name = "ReqUpdateVendorVO", value ="更新模型")ReqUpdateVendorVO reqVo) throws Exception {
		VendorModel model = new VendorModel();
		model.setId(id);
		model.setCode(reqVo.code);
		model.setName(reqVo.name);
		model.setAddress(reqVo.address);
		//联系人信息
		model.setContactName1(reqVo.contactName1);
		model.setContactName2(reqVo.contactName2);
		model.setContactName3(reqVo.contactName3);
		model.setContactPhone1(reqVo.contactPhone1);
		model.setContactPhone2(reqVo.contactPhone2);
		model.setContactPhone3(reqVo.contactPhone3);
		model.setVersionTag(reqVo.versionTag);
		//把任务交给UpdateCommand执行
		VendorUpdateCommand command = new VendorUpdateCommand(model);
		command.sendAndWait();
	}
	
	
	@ApiOperation(value="删除厂商信息-作者：戴常怡", notes="根据url的id来删除厂商信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteVendor(@PathVariable @ApiParam(name = "id", value = "厂商标示") int id) throws Exception {
		//初始化command
		VendorDeleteCommand command = new VendorDeleteCommand(id);
		command.sendAndWait();
	}
	
	@ApiOperation(value="创建厂商信息-作者：戴常怡", notes="code和name是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseBody
	public void createVendor(@Valid @RequestBody @ApiParam(name = "ReqCreateVendorVO",value ="厂商模型") ReqCreateVendorVO reqVo) throws Exception {
		VendorModel model = new VendorModel();
		model.setCode(reqVo.code);
		model.setName(reqVo.name);
		model.setAddress(reqVo.address);
		//联系人信息
		model.setContactName1(reqVo.contactName1);
		model.setContactName2(reqVo.contactName2);
		model.setContactName3(reqVo.contactName3);
		model.setContactPhone1(reqVo.contactPhone1);
		model.setContactPhone2(reqVo.contactPhone2);
		model.setContactPhone3(reqVo.contactPhone3);
		//把任务交给CreateCommand执行
		VendorCreateCommand command = new VendorCreateCommand(model);
		command.sendAndWait();
	}
	
	
	@ApiOperation(value="获取厂商列表-作者：戴常怡", notes="condition是查询条件")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"),
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "globalName", value = "全局搜索",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "code", value = "厂商编号",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "name", value = "厂商名称",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "bool", paramType = "query"),
		 })
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public ResVendorsVO<VendorModel> getVendors(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils conditionUtil = new ConditionUtils(condition);
		String globalName = conditionUtil.getValueString("globalName", null);
		String code = conditionUtil.getValueString("code", null);
		String name = conditionUtil.getValueString("name", null);
		//分页和排序
		Integer pageNo = conditionUtil.getValueInteger("pageNo", 1);
		Integer pageSize = conditionUtil.getValueInteger("pageSize", 0);
		String orderBy = conditionUtil.getValueString("orderBy", null);
		Boolean ascend = conditionUtil.getValueBoolean("ascending", true);
		
		
		//给实体类model赋值
		VendorSearchQuery query = new VendorSearchQuery(pageNo, pageSize);
		query.setGlobalName(globalName);
		query.setCode(code);
		query.setName(name);
		query.setOrderBy(orderBy);
		query.setAscending(ascend);
		
		//调用handler
		VendorCollection collection = query.queryAndWait();
		//返回参数
		ResVendorsVO <VendorModel> resVO = new ResVendorsVO<>(collection);
        return resVO;
	}
	
}
