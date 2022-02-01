package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * This is server which manages the producers and consumers
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class CrsLtG4EurekaServerApplication {

	/**
	 * @param args
	 * It starts the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrsLtG4EurekaServerApplication.class, args);
	}

}
