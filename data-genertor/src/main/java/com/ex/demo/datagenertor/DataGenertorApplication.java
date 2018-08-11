package com.ex.demo.datagenertor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DataGenertorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataGenertorApplication.class, args);
	}
}
