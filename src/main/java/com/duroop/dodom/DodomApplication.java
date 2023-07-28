package com.duroop.dodom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableJpaAuditing
@SpringBootApplication
public class DodomApplication {

	public static void main(String[] args) {
		SpringApplication.run(DodomApplication.class, args);
	}

}
