package com.sb.app.review.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReviewMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewMicroServiceApplication.class, args);
	}

}
