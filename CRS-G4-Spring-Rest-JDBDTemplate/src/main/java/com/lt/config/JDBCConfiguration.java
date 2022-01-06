package com.lt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@PropertySource("classpath:application.properties")
@Configuration
public class JDBCConfiguration {
	@Bean
	DataSource dataSource() {
		Properties prop = new Properties();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(prop.getProperty("URL"));
		dataSource.setUsername(prop.getProperty("USER"));
		dataSource.setPassword(prop.getProperty("PASSWORD"));
		dataSource.setDriverClassName(prop.getProperty("DRIVER"));
		
		return dataSource;
	}
	
	@Bean
	  public JdbcTemplate jdbcTemplate() {
	    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	    jdbcTemplate.setDataSource(dataSource());
	    return jdbcTemplate;
	  }
}
