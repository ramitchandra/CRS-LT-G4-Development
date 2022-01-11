package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories("com.lt.dao")
@EntityScan("com.lt.entity")
@ComponentScan({"com.lt.*"})
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class CrsG4SpringRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsG4SpringRestJpaApplication.class, args);
	}

}
