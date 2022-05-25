package com.example.Service.ServiceHealthInsurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ServiceHealthInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHealthInsuranceApplication.class, args);
	}

}
