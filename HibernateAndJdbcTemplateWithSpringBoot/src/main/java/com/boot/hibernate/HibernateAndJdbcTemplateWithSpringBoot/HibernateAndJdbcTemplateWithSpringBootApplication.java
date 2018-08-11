package com.boot.hibernate.HibernateAndJdbcTemplateWithSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.boot.configuration", "com.boot.controller", "com.boot.model", "com.boot.service"})
public class HibernateAndJdbcTemplateWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAndJdbcTemplateWithSpringBootApplication.class, args);
	}
}
