package com.samuelapp.demoshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class DemoShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoShopApplication.class, args);
	}
}
