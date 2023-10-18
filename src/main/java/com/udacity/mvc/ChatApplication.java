package com.udacity.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

   /* @Bean
    public String message() {
        System.out.println("Creating Message Bean");
        return "Hello, Spring";
    }

    @Bean
    public String uppercaseMessage(MessageService msgService) {
        System.out.println("Creating uppercaseMessage Bean");
        return msgService.upperCase();
    }

    @Bean
    public String lowercaseMessage(MessageService msgService) {
        System.out.println("Creating lowercaseMessage Bean");
        return msgService.lowerCase();
    }*/
}
