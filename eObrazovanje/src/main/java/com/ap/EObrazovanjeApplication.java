package com.ap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.ap.model"})
public class EObrazovanjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EObrazovanjeApplication.class, args);
	}
}
