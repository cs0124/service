package com.dtelec.icmes.power.service.client;


import org.springframework.cloud.openfeign.FeignClient;


/**
 * 用于访问信息服务的Sub接口
 * @author hlxu
 *
 */
@FeignClient(name = "information-service")
public interface InfoServiceClient {
	
	
}
