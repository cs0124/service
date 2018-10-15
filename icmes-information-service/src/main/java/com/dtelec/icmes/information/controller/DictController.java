package com.dtelec.icmes.information.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;
import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ResDictTypeVO;
import com.dtelec.icmes.information.controller.vo.ReqDictTypeAddVO;
import com.dtelec.icmes.information.controller.vo.ReqDictTypeUpdateVO;
import com.dtelec.icmes.information.service.command.DictTypeCreateCommand;
import com.dtelec.icmes.information.service.command.DictTypeDeleteCommand;
import com.dtelec.icmes.information.service.command.DictTypeUpdateCommand;
import com.dtelec.icmes.information.service.model.DictTypeCollection;
import com.dtelec.icmes.information.service.model.DictTypeModel;
import com.dtelec.icmes.information.service.query.DictDetailQuery;
import com.dtelec.icmes.information.service.query.DictTypeQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("dictTypes")
public class DictController {
	
	
	/**
	 * 字典类型查询列表
	 * @param condition
	 * @return DictTypeCollection
	 * @throws Exception
	 */
	@ApiOperation(value="字典类型查询--作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "code",value = "类型编号"),
		@ApiImplicitParam(name= "name",value = "类型名称"),
		@ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "string", paramType = "query"),
		
	})
	@RequestMapping(path="list/{condition}",method = RequestMethod.GET)
	@ResponseBody
	DictTypeCollection getDictTypeList( @PathVariable String condition) throws Exception {
		ConditionUtils conditionUtil = new ConditionUtils(condition);
		//初始化参数
		String code = conditionUtil.getValueString("code", null);
		String name = conditionUtil.getValueString("name", null);		
		//初始化分页
		Integer pageNo = conditionUtil.getValueInteger("pageNo", 1);
		Integer pageSize = conditionUtil.getValueInteger("pageSize", 0);
		String orderBy = conditionUtil.getValueString("orderBy", null);
		Boolean ascend = conditionUtil.getValueBoolean("ascending", true);
		//给实体类赋值
		DictDetailQuery query = new DictDetailQuery(code, name, pageNo, pageSize);
		query.setOrderBy(orderBy);
		query.setAscending(ascend);
		//调用handler
		DictTypeCollection modelList = query.queryAndWait();
		
		return modelList;
	}
	
	
	/**
	 * 新增字典类型
	 * @param principal
	 * @param resDictVO
	 * @throws Exception
	 */
	@ApiOperation(value="新增字典类型-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path="/", method = RequestMethod.POST)
	@ResponseBody
	void addDictType(Principal principal, @RequestBody @ApiParam(name = "dictTypeModel",value ="字典类型模型")ReqDictTypeAddVO resDictVO) 
	throws Exception{
		//初始化query
		DictTypeQuery query = new DictTypeQuery(resDictVO.code);
		//调用handler
		DictTypeModel model=query.queryAndWait();
		//判断新增字典类型在数据库中是否已存在
		if(model.getCode() != null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTTYPE_ADDERROR, "该字典类型已存在！");
		}else {
			
			DictTypeModel dictTypeModel=new DictTypeModel();	
			
			//model Set值
			dictTypeModel.setCode(resDictVO.code);
			dictTypeModel.setName(resDictVO.name);
			dictTypeModel.setCreateUserId(Integer.valueOf(principal.getName()));
			dictTypeModel.setCreateTime(System.currentTimeMillis());
			dictTypeModel.setLastUpdateTime(System.currentTimeMillis());
			UUID uuid  =  UUID.randomUUID();
			dictTypeModel.setIsBuiltIn("0");
			dictTypeModel.setVersionTag(uuid.toString());		
			dictTypeModel.setLastUpdateUserId(Integer.valueOf(principal.getName()));
			
			//初始化command
			DictTypeCreateCommand command = new DictTypeCreateCommand(dictTypeModel);
			//调用handler
			command.sendAndWait();	
		}
	}
	
	
	/**
	 * 修改字典类型
	 * @param code
	 * @param principal
	 * @param dictTypeVO
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	@ApiOperation(value="修改字典类型-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping( path="/{code}",method = RequestMethod.PUT)
	@ResponseBody
	Map<String,Object> updateDictType( @PathVariable String code,Principal principal, @RequestBody @ApiParam(name = "dictTypeModel",value ="字典类型模型") ReqDictTypeUpdateVO  dictTypeVO) throws Exception{
		DictTypeQuery query = new DictTypeQuery(code);
		DictTypeModel model=query.queryAndWait();
		
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		
		//·判断当前修改类型是否存在
		if(model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTTYPE_UPDATEERROR, "该字典类型不存在！");
			
		}else {
			model.setName(dictTypeVO.name);
			model.setCode(code);
			model.setLastUpdateTime(System.currentTimeMillis());
			model.setLastUpdateUserId(Integer.valueOf(principal.getName()));
			UUID uuid  =  UUID.randomUUID();			
			
			  //判断前端传入VersionTag和数据库中是否相同，相同则只执行更新，不相同不执行			 
			if((dictTypeVO.versionTag).equals(model.getVersionTag())) {
				model.setVersionTag(uuid.toString());
				//初始化command
				DictTypeUpdateCommand command=new DictTypeUpdateCommand(model);
				//调用handler
				command.sendAndWait();
				modelMap.put("success", true);
				modelMap.put("msg", "修改成功!");
			}else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTTYPE_VERSIONTAGERROR, "versionTag 错误！");
			}
		}
		
	  return modelMap;
	}
	
	
	
	/**
	 * 字典类型详细
	 * @param code
	 * @return ResDictTypeVO
	 * @throws Exception
	 */
	@ApiOperation(value="字典类型详细-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误"),
		
		})	
	@RequestMapping(path="/{code}",method = RequestMethod.GET)
	@ResponseBody
	ResDictTypeVO getDictType( @PathVariable String code) throws Exception{
		//初始化query
		DictTypeQuery query = new DictTypeQuery(code);
		//调用handler
		DictTypeModel model = query.queryAndWait();
		//判断该数据是否存在
		if(model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTTYPE_UPDATEERROR, "该字典类型不存在！");
		}else {
			//返回页面的VO
			ResDictTypeVO modelView = new ResDictTypeVO();
			modelView.setCode(model.getCode());
			modelView.setName(model.getName());
			modelView.setLastUpdateTime(model.getLastUpdateTime());		
			modelView.setLastUpdateUser(model.getLastUpdateUserId());
			modelView.setVersionTag(model.getVersionTag());
			
			return modelView;
		}
		
	
	
	}
	
	
	/**
	 * 字典类型删除
	 * @param code 字典编码
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(value="字典类型-删除-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path="/{code}",method = RequestMethod.DELETE)
	@ResponseBody
	public void delDictType(@PathVariable String code ) throws Exception {
		//初始化query
		DictTypeQuery query = new DictTypeQuery(code);
		//调用handler
		DictTypeModel model = query.queryAndWait();
		//判断该数据是否存在
		if(model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTTYPE_UPDATEERROR, "该字典类型不存在！");
		}else {
			//初始化command
			DictTypeDeleteCommand command = new DictTypeDeleteCommand();
			model = new DictTypeModel();
			model.setCode(code);
			command.fill(model);
			//调用handler
			command.sendAndWait();
		}
	}
	
}
