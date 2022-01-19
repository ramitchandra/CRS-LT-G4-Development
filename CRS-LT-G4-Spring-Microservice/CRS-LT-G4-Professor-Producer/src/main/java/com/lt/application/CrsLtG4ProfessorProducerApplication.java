package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EntityScan({"com.lt.*"})
@ComponentScan({"com.lt.*"})
@EnableJpaRepositories("com.lt.dao")
@EnableWebMvc
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class CrsLtG4ProfessorProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtG4ProfessorProducerApplication.class, args);
	}

}
