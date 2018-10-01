package com.dtelec.icmes.information.controller;

import java.security.Principal;
import java.util.Date;
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
import com.dtelec.icmes.information.controller.vo.ReqDictDataAddVO;
import com.dtelec.icmes.information.controller.vo.ReqDictDataIOVO;
import com.dtelec.icmes.information.controller.vo.ReqDictDataUpdateVO;
import com.dtelec.icmes.information.controller.vo.ResDictDataVO;
import com.dtelec.icmes.information.service.command.DictDataCreateCommand;
import com.dtelec.icmes.information.service.command.DictDataDeleteCommand;
import com.dtelec.icmes.information.service.command.DictDataUpdateCommand;
import com.dtelec.icmes.information.service.model.DictDataBaseModel;
import com.dtelec.icmes.information.service.model.DictDataCollection;
import com.dtelec.icmes.information.service.query.DictDataDetailQuery;
import com.dtelec.icmes.information.service.query.DictDataQuery;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("dictDatas")
public class DictDataController {
	
	
	/**
	 * 字典数据列表
	 * @param condition
	 * @return DictDataCollection
	 * @throws Exception
	 */
	@ApiOperation(value="字典数据列表-作者：何秋菊" )
	@ApiImplicitParams({
		@ApiImplicitParam(name= "typeCode",value = "类型编号",dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageNo", value = "当前页码数", dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "pageSize", value = "一页多少条记录 0标识不分页全部显示",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "orderBy", value = "排序的字段名",  dataType = "string", paramType = "query"),
		 @ApiImplicitParam(name = "ascending", value = "是否正序",  dataType = "string", paramType = "query"),
		 })
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	
	
	@RequestMapping(path="list/{condition}",method = RequestMethod.GET)
	@ResponseBody
	DictDataCollection getDictDataList( @PathVariable String condition) throws Exception{
		ConditionUtils conditionUtil=new ConditionUtils(condition);
		//初始化参数
		String typecode = conditionUtil.getValueString("typeCode", null);
		//初始化分页
		Integer pageNo = conditionUtil.getValueInteger("pageNo", 1);
		Integer pageSize = conditionUtil.getValueInteger("pageSize", 0);
		String orderBy = conditionUtil.getValueString("orderBy", null);
		Boolean ascend = conditionUtil.getValueBoolean("ascending", true);	
		
		DictDataCollection modelList = null;	
		//初始化query
		DictDataDetailQuery query = new DictDataDetailQuery(typecode, pageNo, pageSize);
		query.setOrderBy(orderBy);
		query.setAscending(ascend);
		//调用handler
		modelList = query.queryAndWait();		
		
		return modelList;
		
	}
	
	
	/**
	 * 新增字典
	 * @param principal
	 * @param dictDataVO
	 * @return String
	 * @throws Exception
	 */
	@ApiOperation(value="新增字典数据-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")	
		
		})
	@RequestMapping(path="/", method = RequestMethod.POST)
	@ResponseBody
	boolean addDictData(Principal principal, @RequestBody @ApiParam(name = "dictDataModel",value ="字典数据模型")ReqDictDataAddVO dictDataVO) 
	throws Exception{
		DictDataQuery query = new DictDataQuery(dictDataVO.code);
		DictDataBaseModel model = query.queryAndWait();
		
		//判断新增的数据是否存在
		if(model == null || model.getCode() == null) {
			model= new DictDataBaseModel();
			//请求vo转为model
			model.setCode(dictDataVO.code);
			model.setName(dictDataVO.name);
			//初始顺序为0
			if(dictDataVO.order != null) {				
				model.setOrder(dictDataVO.order);
			}
			else {
				model.setOrder(0);
			}
			model.setTypeCode(dictDataVO.typeCode);
			model.setCreateUserId(Integer.valueOf(principal.getName()));
			model.setCreateTime(new Date().getTime());
			model.setLastUpdateTime(new Date().getTime());
			model.setDisabled(false);
			UUID uuid  =  UUID.randomUUID();
			model.setVersionTag(uuid.toString());
			model.setLastUpdateUserId(Integer.valueOf(principal.getName()));
			//初始化command
			DictDataCreateCommand command = new DictDataCreateCommand(model);
			//调用handler
			command.sendAndWait();	
			return true;
		}
		else {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_ADDERROR, "该字典数据已存在！");
		}
	
	}
	
	
	
	/**
	 * 编辑字典
	 * @param code
	 * @param principal
	 * @param dictDataVO
	 * @return String
	 * @throws Exception
	 */
	@ApiOperation(value="修改字典数据-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path="/{code}",method = RequestMethod.PUT)
	@ResponseBody
	boolean updateDictData( @PathVariable String code,Principal principal, @RequestBody @ApiParam(name = "dictDataModel",value ="字典类型模型") ReqDictDataUpdateVO dictDataVO) throws Exception{
		DictDataQuery query = new DictDataQuery(code);
		DictDataBaseModel model = query.queryAndWait();
		//判断当前修改数据是否存在
		if(model == null || model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_UPDATEERROR, "该字典数据不存在！");
		}
		else {
			model.setName(dictDataVO.name);
			if(dictDataVO.order != null) {				
				model.setOrder(dictDataVO.order);			
			}else {
				model.setOrder(0);
			}
			model.setLastUpdateTime(new Date().getTime());
			model.setLastUpdateUserId(Integer.valueOf(principal.getName()));
			String ver=model.getVersionTag();
			//v判断修改前和传进来的VersionTag是否相同
			if((dictDataVO.versionTag).equals(ver)) {
				UUID uuid  =  UUID.randomUUID();
				model.setVersionTag(uuid.toString());
				//初始化command
				DictDataUpdateCommand command = new DictDataUpdateCommand(model);
				//调用handler
				command.sendAndWait();
				return true;
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_VERSIONTAGERROR, "versionTag 错误！");
			}
		}
	}  
	
	
	
	/**
	 * 字典详细
	 * @param code
	 * @return ResDictDataVO
	 * @throws Exception
	 */
	@ApiOperation(value="字典数据详细-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})	
	@RequestMapping(path="/{code}",method = RequestMethod.GET)
	@ResponseBody
	ResDictDataVO getDictData( @PathVariable String code) throws Exception{
		DictDataQuery query = new DictDataQuery(code);
		DictDataBaseModel model = query.queryAndWait();
		//判断该数据是否存在
		if(model == null || model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_UPDATEERROR, "该字典数据不存在！");
		}
		else {
			//返回页面的VO
			ResDictDataVO modelView = new ResDictDataVO();
			modelView.setCode(model.getCode());
			modelView.setName(model.getName());
			modelView.setLastUpdateTime(model.getLastUpdateTime());
			modelView.setDisabled(model.getDisabled());			
			modelView.setLastUpdateUser(String.valueOf(model.getLastUpdateUserId()));
			modelView.setVersionTag(model.getVersionTag());
			modelView.setOrder(String.valueOf(model.getOrder())); 
			
			return modelView;
		}
	}
	
	
	
	/**
	 * 字典删除
	 * @param code
	 * @return String
	 * @throws Exception
	 */
	@ApiOperation(value="字典数据删除-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path="/{code}",method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delDictData(@PathVariable String code ) throws Exception {
		DictDataQuery query = new DictDataQuery(code);
		DictDataBaseModel model = query.queryAndWait();
		//判断该数据是否存在
		if(model == null || model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_UPDATEERROR, "该字典数据不存在！");
		}
		else {
		  //初始化command
		  DictDataDeleteCommand command = new DictDataDeleteCommand();
		  model = new DictDataBaseModel();
		  model.setCode(code);
		  command.fill(model);
		  //调用handler
		  command.sendAndWait();
		  return true;
		}
	}
	
	
	
	/**
	 * 启用字典
	 * @param code
	 * @param principal
	 * @param dictDataVO
	 * @return	String
	 * @throws Exception
	 */
	@ApiOperation(value="启用 字典数据-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	
	@RequestMapping(path="/{code}/enabled", method = RequestMethod.PUT)
	@ResponseBody
	String enabledDictData( @PathVariable String code,Principal principal,@RequestBody @ApiParam(name = "dictDataVO",value ="字典数据启用禁用模型") ReqDictDataIOVO dictDataVO) throws Exception{
		DictDataQuery query = new DictDataQuery(code);
		DictDataBaseModel model = query.queryAndWait();
		//判断当前数据是否存在
		if(model == null || model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_UPDATEERROR, "该字典数据不存在！");
		}
		else {	
			//2禁用
			model.setDisabled(true);			
			model.setLastUpdateTime(new Date().getTime());
			model.setLastUpdateUserId(Integer.valueOf(principal.getName()));
			String ver=model.getVersionTag();
			//v判断修改前和传进来的VersionTag是否相同
			if((dictDataVO.versionTag).equals(ver)) {
				UUID uuid  =  UUID.randomUUID();
				model.setVersionTag(uuid.toString());
				//初始化command
				DictDataUpdateCommand command = new DictDataUpdateCommand(model);
				//调用handler
				command.sendAndWait();
				return "{}";
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_VERSIONTAGERROR, "versionTag 错误！");
			}
		}
	}
	
	
	
	/**
	 * 禁用字典
	 * @param code
	 * @param principal
	 * @param dictDataVO
	 * @return	String
	 * @throws Exception
	 */
	@ApiOperation(value="禁用字典数据-作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
		})
	@RequestMapping(path="/{code}/disabled",method = RequestMethod.PUT)
	@ResponseBody
	String disabledDictData( @PathVariable String code,Principal principal,@RequestBody @ApiParam(name = "dictDataVO",value ="字典数据启用禁用模型") ReqDictDataIOVO dictDataVO) throws Exception{
		DictDataQuery query = new DictDataQuery(code);
		DictDataBaseModel model = query.queryAndWait();
		//判断当前数据是否存在
		if(model == null || model.getCode() == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_UPDATEERROR, "该字典数据不存在！");
		}
		else {
			
			//2启用
			model.setDisabled(false);			
			model.setLastUpdateTime(new Date().getTime());
			model.setLastUpdateUserId(Integer.valueOf(principal.getName()));
			String ver=model.getVersionTag();
			//v判断修改前和传进来的VersionTag是否相同
			if((dictDataVO.versionTag).equals(ver)) {
				UUID uuid  =  UUID.randomUUID();
				model.setVersionTag(uuid.toString());
				//初始化command
				DictDataUpdateCommand command = new DictDataUpdateCommand(model);
				//调用handler
				command.sendAndWait();
				return "{}";
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.INFO_DICTDATA_VERSIONTAGERROR, "versionTag 错误！");
			}
		}
		
	}  
	
}
