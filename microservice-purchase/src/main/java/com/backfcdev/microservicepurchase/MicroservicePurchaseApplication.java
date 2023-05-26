package com.backfcdev.microservicepurchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePurchaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePurchaseApplication.class, args);
	}

}
