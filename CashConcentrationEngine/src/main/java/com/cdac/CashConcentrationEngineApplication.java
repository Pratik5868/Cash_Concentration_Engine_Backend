package com.cdac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class CashConcentrationEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashConcentrationEngineApplication.class, args);
		System.out.println("Development server ran successfully...!");
	}

}
