package com.VotreBanque.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class VotreBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotreBanqueApplication.class, args);
	}

}
