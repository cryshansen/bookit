package com.artog.bookit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.artog.bookit.model") // ✅ This tells Spring Boot where to find your entities
@EnableJpaRepositories("com.artog.bookit.repository") // ✅ Ensure repositories are scanned

public class BookitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookitApplication.class, args);
	}

}
