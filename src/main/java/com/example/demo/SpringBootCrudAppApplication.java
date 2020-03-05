package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudAppApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder password() {
		return new BCryptPasswordEncoder();

	}

}
