package com.department.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentApiMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApiMongoDbApplication.class, args);
	}

}
