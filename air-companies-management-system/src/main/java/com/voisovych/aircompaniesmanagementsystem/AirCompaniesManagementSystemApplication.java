package com.voisovych.aircompaniesmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AirCompaniesManagementSystemApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		return springApplicationBuilder.sources(AirCompaniesManagementSystemApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AirCompaniesManagementSystemApplication.class, args);
	}

}
