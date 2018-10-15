package com.dtelec.icmes.information.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ReqCreateProcessVO;
import com.dtelec.icmes.information.controller.vo.ReqUpdateProcessVO;
import com.dtelec.icmes.information.controller.vo.ReqValidatingVO;
import com.dtelec.icmes.information.service.command.ProcessCreateCommand;
import com.dtelec.icmes.information.service.command.ProcessDeleteCommand;
import com.dtelec.icmes.information.service.command.ProcessUpdateCommand;
import com.dtelec.icmes.information.service.command.ProcessValidateCommand;
import com.dtelec.icmes.information.service.model.ProcessCollection;
import com.dtelec.icmes.information.service.model.ProcessModel;
import com.dtelec.icmes.information.service.query.ProcessDetailQuery;
import com.dtelec.icmes.information.service.query.ProcessSearchQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 工艺系统控制器
 *
 */
@RestController
@RequestMapping("/process")
public class ProcessController {

	/**
	 * 获取工艺详细信息
	 * @param id 工艺标示
	 * @return 工艺模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="获取工艺详细信息-作者：迟山", notes="根据url的id来获取工艺的详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "工艺标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ProcessModel getProcessDetail(@PathVariable @ApiParam(name = "id", value = "工艺标示") int id) throws Exception{
		ProcessDetailQuery query = new ProcessDetailQuery(id);
		ProcessModel model = query.queryAndWait();
		
		return model;
	}
	
	
	/**
	 * 验证工艺编码
	 * @param reqVo 验证模型 
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="验证工艺编码-作者：迟山")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/validation", method = RequestMethod.POST)
	public void getProcess(@Valid @RequestBody @ApiParam(name = "ReqValidatingVO",value ="验证模型") ReqValidatingVO reqVo) throws Exception{
		ProcessModel model = new ProcessModel();
		
		model.setCode(reqVo.code);
		
		ProcessValidateCommand command = new ProcessValidateCommand(model);
		command.sendAndWait();
	}

	
	/**
	 * 修改工艺信息
	 * @param id 工艺标示
	 * @param reqVo 修改模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="修改工艺信息-作者：迟山", notes="根据url的id来修改工艺信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
	})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "工艺标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void updateProcess(@PathVariable @ApiParam(name = "id", value = "工艺标示") int id, @Valid @RequestBody @ApiParam(name = "ReqUpdateProcessVO", value ="工艺更新模型")ReqUpdateProcessVO reqVo) throws Exception {
		ProcessModel model = new ProcessModel();
		
		//初始化要修改的字段
		model.setId(id);
		model.setName(reqVo.name);
		model.setVersionTag(reqVo.versionTag);
		
		//把任务交给CreateCommand执行
		ProcessUpdateCommand command = new ProcessUpdateCommand(model);
		command.sendAndWait();
	}
	
	
	/**
	 * 删除工艺信息
	 * @param id 工艺标示
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="删除工艺信息-作者：迟山", notes="根据url的id来删除工艺信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "id",value = "工艺标示")
	})
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteProcess(@PathVariable @ApiParam(name = "id", value = "工艺标示") int id) throws Exception {
		ProcessDeleteCommand command = new ProcessDeleteCommand(id);
		command.sendAndWait();
	}
	
	/**
	 * 创建工艺信息
	 * @param reqVo 新建模型
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="创建工艺信息-作者：迟山", notes="code和name是必填项")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseBody
	public void createProcess(@Valid @RequestBody @ApiParam(name = "ReqCreateProcessVO",value ="工艺模型") ReqCreateProcessVO reqVo) throws Exception {
		ProcessModel model = new ProcessModel();
		
		model.setCode(reqVo.code);
		model.setName(reqVo.name);
		
		//把任务交给CreateCommand执行
		ProcessCreateCommand command = new ProcessCreateCommand(model);
		command.sendAndWait();
	}
	

	/**
	 * 获取工艺列表
	 * @param condition 查询条件
	 * @return 工艺模型集合
	 * @throws Exception 抛出的异常
	 */
	@ApiOperation(value="获取工艺列表-作者：迟山", notes="condition是查询条件")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部系统错误")
		})
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "code", value = "工艺编号",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "name", value = "工艺名称",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "globalName", value = "全局搜索", dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "int", paramType = "query"),
		 @ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "boolean", paramType = "query"),
		 })
	@RequestMapping(path = "/list/{condition}", method = RequestMethod.GET)
	public ProcessCollection getProcesses(@PathVariable String condition) throws Exception {
		//初始化参数
		ConditionUtils conditionUtil = new ConditionUtils(condition);
		
		String code = conditionUtil.getValueString("code", null);
		String name = conditionUtil.getValueString("name", null);
		String globalName = conditionUtil.getValueString("globalName", null);
		Integer pageNo = conditionUtil.getValueInteger("pageNo", 1);
		Integer pageSize = conditionUtil.getValueInteger("pageSize", 0);
		String orderBy = conditionUtil.getValueString("orderBy", null);
		Boolean ascend = conditionUtil.getValueBoolean("ascending", true);	
		
		//给实体类model赋值
		ProcessSearchQuery query = new ProcessSearchQuery(pageNo,pageSize);
		query.setCode(code);
		query.setName(name);
		query.setGlobalName(globalName);
		query.setOrderBy(orderBy);
		query.setAscending(ascend);
		
		//调用handler
		ProcessCollection coll = query.queryAndWait();
		//返回参数
		return coll;
	}
	
}
