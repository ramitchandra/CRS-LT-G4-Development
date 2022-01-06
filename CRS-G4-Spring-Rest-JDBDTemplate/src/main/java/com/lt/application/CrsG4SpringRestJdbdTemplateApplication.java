package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.lt.*"})
public class CrsG4SpringRestJdbdTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsG4SpringRestJdbdTemplateApplication.class, args);
	}

}
