package com.dtelec.icmes.account.utility;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

/**
 * RestTemplate 的工具封装类
 * @author hlxu
 *
 */
@Component
public class RestTemplateUtils {  

	private static RestTemplate restTemplate;
	
	@Autowired(required = true)
	public void setRestTemplate(RestTemplate restTemplate) {
		RestTemplateUtils.restTemplate = restTemplate;
	}
	
	/**
	 * 用于访问其他服务的工具方法
	 * 主要用于权限验证部分
	 * 
	 * @param url  用于访问的URL 地址
	 * @param auth  用于报文头传递的验证信息
	 * @param type  用于反串行化远程返回的数据结构的类型
	 * @return 进行反串行化后的返回对象
	 */
	public static <T> T getRestResponse(String url, String auth, Class<T> type) {
		HttpHeaders requestHeaders = new HttpHeaders();
	    requestHeaders.add("Content-Type", "application/json");
		auth = StringUtils.trimToNull(auth);
		if (auth != null) {
		    requestHeaders.add("Authorization", auth);	
		}
		
	    RestTemplate template = restTemplate;
		HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
	    ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, requestEntity, String.class);
	    String json = response.getBody();
	    T ins = JSON.parseObject(json, type);
	    
	    return ins;
	}	
}
