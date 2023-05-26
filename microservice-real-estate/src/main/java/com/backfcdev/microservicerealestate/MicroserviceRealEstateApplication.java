package com.backfcdev.microservicerealestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceRealEstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRealEstateApplication.class, args);
	}

}
