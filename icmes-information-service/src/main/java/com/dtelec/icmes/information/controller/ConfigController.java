package com.dtelec.icmes.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dtelec.icmes.common.utility.ConditionUtils;
import com.dtelec.icmes.information.controller.vo.ResConfigurationVO;
import com.dtelec.icmes.information.service.client.AccountServiceClient;
import com.dtelec.icmes.information.service.model.DictCollection;
import com.dtelec.icmes.information.service.model.MenuCollection;
import com.dtelec.icmes.information.service.query.DictListQuery;
import com.dtelec.icmes.information.service.query.MenuListQuery;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/configs")
public class ConfigController {

	@Autowired
	private AccountServiceClient accountClient;
	
	/**
	 * 获取系统配置信息
	 * @return 全系统配置信息
	 * @throws Exception 抛出异常
	 * @param condition 查询参数
	 */
	@ApiOperation(value="获取系统配置信息", notes="根据url的dict=true来获取字典配置详细信息")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 201, message = "创建成功"),
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 403, message = "被禁用"),
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "系统错误")
		})
	@ApiImplicitParams({
		@ApiImplicitParam(name= "dict",value = "标识是否获取字典详细配置信息")
	})
	@RequestMapping(path = "/{condition}", method = RequestMethod.GET)
	public ResConfigurationVO getConfigSetting(@PathVariable String condition) throws Exception {
		ConditionUtils conditionUtil = new ConditionUtils(condition);
		boolean isHasDict = conditionUtil.getValueBoolean("dict", true);
		boolean isHasFeatrue = conditionUtil.getValueBoolean("feature", true);
		// 发送菜单查询命令获取菜单集合
		MenuListQuery menuQuery = new MenuListQuery();
		MenuCollection menuColl = menuQuery.queryAndWait();
		
		DictCollection dictColl = null;
		if (isHasDict == true) {
			// 发送字典查询命令获取字典集合
			DictListQuery dictQuery = new DictListQuery();
			dictColl = dictQuery.queryAndWait();
		}
		
		ResConfigurationVO resVo = new ResConfigurationVO();
		resVo.fillVo(menuColl, dictColl);
		
		if (isHasFeatrue == true) {
			resVo.features = accountClient.getFeaturesTree();	
		}
		
		return resVo;
	}
	
}
