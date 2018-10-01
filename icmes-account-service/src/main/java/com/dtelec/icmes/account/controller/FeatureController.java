package com.dtelec.icmes.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.account.controller.vo.ResFeatureTreeVO;
import com.dtelec.icmes.account.service.IFeatureService;
import com.dtelec.icmes.account.service.client.InfoServiceClient;
import com.dtelec.icmes.account.service.model.FeatureCollection;
import com.dtelec.icmes.account.service.model.MenuModel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/features")
public class FeatureController {
	
	@Autowired
	private InfoServiceClient infoClient;
	
	@Autowired
	private IFeatureService featureSev;

	@ApiOperation(value = "获取全功能列表树")
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "成功"), 
			@ApiResponse(code = 401, message = "验证失败"), 
			@ApiResponse(code = 403, message = "被禁用"),
			@ApiResponse(code = 404, message = "未找到") })
	@RequestMapping(path = "/tree", method = RequestMethod.GET)
	public List<ResFeatureTreeVO> getFeatureTree() {
		List<MenuModel> menuList = infoClient.getMenuList();
		FeatureCollection featureList = featureSev.getAllFeatures();
		List<ResFeatureTreeVO> resVo = ResFeatureTreeVO.convertFeatureTree(menuList, featureList);
		
		return resVo;
	}
	
}
