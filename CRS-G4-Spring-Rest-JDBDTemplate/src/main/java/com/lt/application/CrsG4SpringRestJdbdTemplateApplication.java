package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.lt.config.JDBCConfiguration;

@SpringBootApplication
@Import({JDBCConfiguration.class})
@ComponentScan({"com.lt.*"})
public class CrsG4SpringRestJdbdTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JDBCConfiguration.class, args);
	}

}
