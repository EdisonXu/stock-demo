package com.ex.demo.datagenertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author edison
 * On 2018/8/9 17:12
 */
public class RestUtil {


	private static final Logger LOGGER = LoggerFactory.getLogger(RestUtil.class);


	public static void postJson(String url, Object data){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity entity = new HttpEntity(data, headers);
		ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, entity, data.getClass());
		LOGGER.info("ResultCode: {}", response.getStatusCode());
	}
}
