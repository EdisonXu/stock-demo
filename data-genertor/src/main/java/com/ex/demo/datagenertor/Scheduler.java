package com.ex.demo.datagenertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author edison
 * On 2018/8/9 16:20
 */
@Component
public class Scheduler {


	private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

	@Autowired
	private QuoteInforMocker quoteInforMocker;

	@Value("${remote-url.base}")
	private String baseUrl;

	@Value("${remote-url.quote}")
	private String quotePath;

	@Scheduled(fixedRate = 2000l)
	public void sendData(){
		LOGGER.info("Sending quote data...");
		quoteInforMocker.send(baseUrl+quotePath);
	}
}
