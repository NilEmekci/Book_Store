package com.example.bookapi;

import com.example.bookapi.auth.AuthenticationService;
import com.example.bookapi.auth.RegisterRequest;
import com.example.bookapi.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@SpringBootApplication
@EnableJpaRepositories
@EnableSpringConfigured
@EnableMethodSecurity
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AuthenticationService service){
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@gmail.com")
					.password("1")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var user = RegisterRequest.builder()
					.firstname("User")
					.lastname("User")
					.email("user@gmail.com")
					.password("1")
					.role(Role.USER)
					.build();
			System.out.println("User token: " + service.register(user).getAccessToken());
		};


	}

}
