package com.example.movierating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableEurekaClient
public class MovieRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingApplication.class, args);
	}

}
