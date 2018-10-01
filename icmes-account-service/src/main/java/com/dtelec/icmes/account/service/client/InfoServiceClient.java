package com.dtelec.icmes.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dtelec.icmes.account.service.model.EmployeeBaseModel;
import com.dtelec.icmes.account.service.model.EmployeeModel;
import com.dtelec.icmes.account.service.model.MenuModel;

@FeignClient(name = "information-service")
public interface InfoServiceClient {
	
	/**
	 * 获取员工详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/info/employees/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	EmployeeModel getEmployeeDetail(@PathVariable String id);
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/info/menus/list", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	List<MenuModel> getMenuList();
	
	/**
	 * 编辑账号
	 * @param model
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/info/employees/persistent", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void PersistentEmployeeBase(@RequestBody EmployeeBaseModel model);
	
}
