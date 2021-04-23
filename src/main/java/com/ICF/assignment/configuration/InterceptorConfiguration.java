package com.ICF.assignment.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private RequestInterceptor req;

	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(req);
	}
}
