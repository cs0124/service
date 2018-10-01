package com.dtelec.icmes.information.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.information.service.model.MenuCollection;
import com.dtelec.icmes.information.service.model.MenuModel;
import com.dtelec.icmes.information.service.query.MenuListQuery;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/menus")
public class MenuController {

	/**
	 * 获取菜单列表
	 * @param 
	 * @return 菜单列表
	 * @throws Exception
	 */
	@ApiOperation(value="获取系统菜单列表", notes="菜单列表是二维表结构")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 403, message = "被禁用"),
		@ApiResponse(code = 404, message = "未找到"),
		@ApiResponse(code = 500, message = "系统错误")
		})
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public List<MenuModel> getMenuList() throws Exception {		
		MenuListQuery menuQuery = new MenuListQuery();
		MenuCollection menuColl = menuQuery.queryAndWait();
		List<MenuModel> list = menuColl.getList();
		
		return list;
	}
	
}
