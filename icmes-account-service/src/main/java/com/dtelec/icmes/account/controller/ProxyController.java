package com.dtelec.icmes.account.controller;

import java.security.Principal;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.account.controller.vo.ReqProxyAddVO;
import com.dtelec.icmes.account.controller.vo.ReqProxyUpdateVO;
import com.dtelec.icmes.account.controller.vo.ResUserProxyAssignmentVO;
import com.dtelec.icmes.account.service.IProxyService;
import com.dtelec.icmes.account.service.model.UserProxyAssignmentModel;
import com.dtelec.icmes.common.error.IcmesBusinessException;
import com.dtelec.icmes.common.error.IcmesErrorTypeEnum;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/proxies")
public class ProxyController {
	
	@Autowired
	private IProxyService service;
	
	/**
	 * 新增指派代理
	 * @param id
	 * @param principal
	 * @param proxyVO
	 * @return boolean
	 * @throws Exception
	 */	
	@ApiOperation(value="新增指派代理--作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")		
		
		})
	@RequestMapping(path = "/", method = RequestMethod.POST)
	@ResponseBody
	boolean addUserProxyAssignment(Principal principal, @RequestBody @ApiParam(name = "userProxyModel",value ="指派代理模型") ReqProxyAddVO proxyVO) 
			throws Exception 
	{
		//判断结束时间是否大于开始时间
		 if (proxyVO.proxyStartDate < proxyVO.proxyEndDate) {
			//实体类初始化
			UserProxyAssignmentModel userProxyModel = new UserProxyAssignmentModel();
			userProxyModel.setAssignUserId(proxyVO.assignUserId);
			userProxyModel.setConsignUserRoleAss(proxyVO.consignUserRoleAss);
			userProxyModel.setProxyStartDate(proxyVO.proxyStartDate);
			userProxyModel.setProxyEndDate(proxyVO.proxyEndDate);
			userProxyModel.setPeriodDays(proxyVO.periodDays);
			
			//调用service
			service.addUserProxyAssignment(userProxyModel);	
			return true;
		}
		else {
		    throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ADDPROXY_TIME_ERROR, "开始时间必须小于结束时间");
		}
	}
	
	
	/**
	 * 修改指派代理
	 * @param id
	 * @param userProxyVO
	 * @return boolean
	 * @throws Exception
	 */
	@ApiOperation(value="修改指派代理--作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误"),
		
		})
	@RequestMapping(path = "/{id}",method = RequestMethod.PUT)
	@ResponseBody
	boolean updateUserProxyAssignment(@PathVariable int id, @RequestBody @ApiParam(name = "ReqProxyUpdateVO",value ="指派代理模型") ReqProxyUpdateVO userProxyVO) 
			throws Exception
	{
		UserProxyAssignmentModel model = service.getUserProxyAssignmentById(id);
		//判断当前数据是否存在
		if(model == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_UPDATEPROXY_ERROR, "该代理信息不存在，请刷新页面！");	
		}
		else {
			String currentVersionTag = StringUtils.trimToEmpty(model.getVersionTag());
			//判断传入的VersionTag和数据库中的是否一致，一致执行update,不一致不执行
			if(currentVersionTag.equalsIgnoreCase(userProxyVO.versionTag)) {
				//判断结束时间是否大于开始时间
				if(userProxyVO.proxyEndDate <= userProxyVO.proxyStartDate) {
					throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_ADDPROXY_TIME_ERROR, "开始时间必须小于结束时间！");
				}
				else {
				//实体类初始化
				model.setId(id);
				model.setUpdateTime(new Date().getTime());
				model.setVersionTag(UUID.randomUUID().toString());
				model.setAssignUserId(userProxyVO.assignUserId);
				model.setConsignUserRoleAss(userProxyVO.consignUserRoleAss);
				model.setProxyStartDate(userProxyVO.proxyStartDate);
				model.setProxyEndDate(userProxyVO.proxyEndDate);
				model.setPeriodDays(userProxyVO.periodDays);
				
				//调用service
				service.updateUserProxyAssignment(model);
				return true;
				}
			}
			else {
				throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_PROXY_VERSIONTAGERROR, "versionTag 错误");
			}
		}
	}
	
	////////////////////
	/**
	 * 指派代理详细
	 * @param id
	 * @return ResUserProxyAssignmentVO
	 * @throws Exception
	 */
	@ApiOperation(value="指派代理详细--作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误")
	
		})
	@RequestMapping(path = "/{id}",method = RequestMethod.GET)
	@ResponseBody
	ResUserProxyAssignmentVO getUserProxyAssignment( @PathVariable int id) 	throws Exception{
		//调用service
		UserProxyAssignmentModel model = service.getUserProxyAssignmentById(id);
		//判断当前数据是否存在
		if(model == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_UPDATEPROXY_ERROR, "该代理信息不存在，请刷新页面");
		}
		else {
			//实体类初始化
			ResUserProxyAssignmentVO vo = new ResUserProxyAssignmentVO();
			vo.id = model.getId();
			vo.name = model.getName();
			vo.startTime = model.getProxyStartDate();
			vo.endTime = model.getProxyEndDate();
			vo.cycle = model.getPeriodDays();
			
			return vo;
		}
	}	


	

	/**
	 * 删除指派代理
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */
	@ApiOperation(value="指派代理删除--作者：何秋菊" )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"),
		@ApiResponse(code = 401, message = "验证失败"), 		
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "内部程序错误"),
		
		
	})
	@RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	boolean delUserProxyAssignment(@PathVariable int id) 	throws Exception{
		UserProxyAssignmentModel model = service.getUserProxyAssignmentById(id);
		//判断当前数据是否存在
		if(model == null) {
			throw new IcmesBusinessException(IcmesErrorTypeEnum.ACCOUNT_UPDATEPROXY_ERROR, "该代理信息不存在，请刷新页面！");
		}
		else {			
			//调用service
			service.delUserProxyAssignmentById(id);
			return true;
		}
    }
}
