package com.te.assignmentmvc.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfiguration {
	
	@Bean
	public LocalEntityManagerFactoryBean factoryBean() {
		LocalEntityManagerFactoryBean bean =  new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("Munit01");
		return bean;
	}	
	
}
