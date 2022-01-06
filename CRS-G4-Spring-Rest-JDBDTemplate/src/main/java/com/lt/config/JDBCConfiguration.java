package com.lt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lt.dao.AdminDao;

@PropertySource("classpath:application.properties")
@Configuration
public class JDBCConfiguration {
	@Autowired
	Environment environment;
	@Autowired
	AdminDao adminDaoImpl;
	
	@Bean
	DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername(environment.getProperty("username"));
		dataSource.setPassword(environment.getProperty("password"));
		dataSource.setDriverClassName(environment.getProperty("driverClassName"));
		
		return dataSource;
	}
	
	@Bean
	  public JdbcTemplate jdbcTemplate() {
	    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	    jdbcTemplate.setDataSource(dataSource());
	  adminDaoImpl.setJdbcTemplate(jdbcTemplate);
	    return jdbcTemplate;
	  }
}
