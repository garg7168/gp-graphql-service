package com.citi.argentina.ip.gpservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({ "com.citi.argentina.ip.gpservice", "com.citi.payment" })
@EnableMongoRepositories(basePackages = "com.citi.argentina.ip.gpservice",mongoTemplateRef = "mongoTemplate")
public class GpServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(GpServiceApplication.class);

	public static void main(String[] args) {

		LOGGER.debug("In GpReadApplication ");
		SpringApplication.run(GpServiceApplication.class, args);
	}
}
