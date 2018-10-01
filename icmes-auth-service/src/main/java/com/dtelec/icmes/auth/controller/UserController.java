package com.dtelec.icmes.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtelec.icmes.auth.service.IUserService;
import com.dtelec.icmes.auth.service.model.UserModel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@ApiOperation(value="获取用户",response = Principal.class )
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 201, message = "创建成功"),
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 403, message = "被禁用"),
		@ApiResponse(code = 404, message = "未找到")
		})

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(@ApiParam(name = "principal",value ="User父类模型") Principal  principal) {
		return principal;
	}

	@ApiOperation("创建用户")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "成功"), 
		@ApiResponse(code = 201, message = "创建成功"),
		@ApiResponse(code = 401, message = "验证失败"), 
		@ApiResponse(code = 403, message = "被禁用"),
		@ApiResponse(code = 404, message = "未找到") ,
		
		})
	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody @ApiParam(name = "userModel",value ="用户模型") UserModel user) {
		userService.createUser(user);
	}
}
