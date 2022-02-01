package com.lt.application;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * It is a servlet initilizer
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
	
	/**
	 * Configure the applications.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CrsLtG4AdminConsumerApplication.class);
	}

}
