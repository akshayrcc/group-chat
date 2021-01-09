package com.udacity.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.udacity.mvc.service.MessageService;


@SpringBootApplication
public class ReviewApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
	
//	@Bean
//	public String message() {
//		System.out.println("Creating Message Bean");
//		return "Hello, Spring";
//	}
//	
//	@Bean
//	public String uppercaseMessage(MessageService msgService) {
//		System.out.println("Creating uppercaseMessage Bean");
//		return msgService.upperCase();
//	}
//	
//	@Bean
//	public String lowercaseMessage(MessageService msgService) {
//		System.out.println("Creating lowercaseMessage Bean");
//		return msgService.lowerCase();
//	}
}
