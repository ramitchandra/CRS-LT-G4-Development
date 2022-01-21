package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EntityScan("com.lt.entity")
@ComponentScan({"com.lt.*"})
@EnableJpaRepositories("com.lt.dao")
@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
public class CrsLtG4StudentProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtG4StudentProducerApplication.class, args);
	}

}
