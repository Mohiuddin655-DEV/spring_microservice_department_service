package com.example.spring_department_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringDepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDepartmentServiceApplication.class, args);
	}

}
