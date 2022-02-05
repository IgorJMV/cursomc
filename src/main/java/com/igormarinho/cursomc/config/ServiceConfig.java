package com.igormarinho.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.igormarinho.cursomc.services.BoletoService;

@Configuration
public class ServiceConfig {
	
	@Bean
	public BoletoService boletoService() {
		return new BoletoService();
	}
	
}
