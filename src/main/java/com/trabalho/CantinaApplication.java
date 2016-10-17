package com.trabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.trabalho.ws.controller.TokenFilter;

@SuppressWarnings("deprecation")
@SpringBootApplication
public class CantinaApplication {
	
	@Bean
	public FilterRegistrationBean getFiltroJWT(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/loged/*");
		
		return frb;
	}

	public static void main(String[] args) {
		SpringApplication.run(CantinaApplication.class, args);
	}
}
