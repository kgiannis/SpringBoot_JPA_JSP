package com.rt.boot.appInit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.rt.boot.*")
@EntityScan("com.rt.boot.model")
public class SpringBootPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPersonApplication.class, args);
	}
}
