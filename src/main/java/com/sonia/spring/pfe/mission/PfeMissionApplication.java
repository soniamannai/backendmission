package com.sonia.spring.pfe.mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
public class PfeMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfeMissionApplication.class, args);
	}

}
