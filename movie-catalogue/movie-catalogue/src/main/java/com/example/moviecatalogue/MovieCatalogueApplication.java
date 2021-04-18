package com.example.moviecatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableEurekaClient
public class MovieCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogueApplication.class, args);
	}

}
