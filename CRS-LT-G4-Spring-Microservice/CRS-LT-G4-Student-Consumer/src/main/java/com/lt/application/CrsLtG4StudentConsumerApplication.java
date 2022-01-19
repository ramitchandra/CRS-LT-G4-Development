package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan({"com.lt.*"})
@EnableAutoConfiguration
@EnableWebMvc
@EnableDiscoveryClient
@SpringBootApplication
public class CrsLtG4StudentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtG4StudentConsumerApplication.class, args);
	}

}
