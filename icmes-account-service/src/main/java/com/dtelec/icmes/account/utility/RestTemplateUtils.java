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

@Component
public class RestTemplateUtils {  

	private static RestTemplate restTemplate;
	
	@Autowired(required = true)
	public void setRestTemplate(RestTemplate restTemplate) {
		RestTemplateUtils.restTemplate = restTemplate;
	}
	
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
