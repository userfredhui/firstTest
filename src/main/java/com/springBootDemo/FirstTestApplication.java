package com.springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.DigestUtils;


@SpringBootApplication
@EnableScheduling
public class FirstTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstTestApplication.class, args);
	}

}
