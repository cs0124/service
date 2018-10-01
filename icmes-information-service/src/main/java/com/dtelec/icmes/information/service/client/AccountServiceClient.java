package com.dtelec.icmes.information.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dtelec.icmes.information.service.model.AccountBaseModel;
import com.dtelec.icmes.information.service.model.FeatureTreeModel;

@FeignClient(name = "account-service")
public interface AccountServiceClient {
	
	/**
	 * 获取功能树
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/account/features/tree", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	List<FeatureTreeModel> getFeaturesTree();
	
	/**
	 * 获取账号信息
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/account/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	AccountBaseModel getAccountInfo(@PathVariable String id);
	
}