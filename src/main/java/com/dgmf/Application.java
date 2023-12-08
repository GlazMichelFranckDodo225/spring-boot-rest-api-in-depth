package com.dgmf;

import com.dgmf.config.AppBeansConfig;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
				// API General Information
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Glaz Dodo",
						email = "cdajavaspring.net@gmail.com",
						url = "https://www.cdajavaspring.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.cdajavaspring.net"
				)
		),
		// External Documentation
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url = "https://www.cdajavaspring.net/user_management.html"
		)
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(AppBeansConfig.class, args);
	}

}
