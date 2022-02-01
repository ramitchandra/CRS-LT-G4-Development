package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * Main page of application
 *
 */
@ComponentScan({"com.lt.*"})
@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class CrsLtG4AdminConsumerApplication {

	/**
	 * @param args
	 * Used to start the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrsLtG4AdminConsumerApplication.class, args);
	}
	
	/**
	 * @return
	 * Enables us to use swagger for application
	 */
	@Bean
	public Docket apiDocket() {
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
	.paths(PathSelectors.any()).build();
	}

}
