package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"com.lt.*"})
@EnableSwagger2
public class CrsG4SpringRestJdbdTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsG4SpringRestJdbdTemplateApplication.class, args);
	}
	
	@Bean
	public Docket apiDocket() {
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
	.paths(PathSelectors.any()).build();
	}

}
