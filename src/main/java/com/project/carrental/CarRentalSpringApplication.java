package com.project.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CarRentalSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalSpringApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CarRentalSpringApplication.class, ComponentConfiguration.class);
	}

	@Bean
	public MeteorServlet dispatcherServlet() {
		return new MeteorServlet();
	}

	@Bean
	public ServletRegistrationBean dispatcherServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet());
		Map<String,String> params = new HashMap<>();
		params.put("org.atmosphere.servlet","org.springframework.web.servlet.DispatcherServlet");
		params.put("contextClass","org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
		params.put("contextConfigLocation","net.org.selector.animals.config.ComponentConfiguration");
		registration.setInitParameters(params);
		return registration;
	}
}