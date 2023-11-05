package com.dgmf;

import com.dgmf.config.AppBeansConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(AppBeansConfig.class, args);
	}

}
