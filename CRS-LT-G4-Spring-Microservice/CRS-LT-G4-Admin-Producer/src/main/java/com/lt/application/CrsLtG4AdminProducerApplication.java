package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 * @return
 * This is the landing page of the application.
 */
@EntityScan("com.lt.entity")
@ComponentScan({"com.lt.*"})
@EnableJpaRepositories("com.lt.dao")
@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
public class CrsLtG4AdminProducerApplication {

	/**
	 * @param args
	 * @return
	 * This is used to start the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrsLtG4AdminProducerApplication.class, args);
	}

}
