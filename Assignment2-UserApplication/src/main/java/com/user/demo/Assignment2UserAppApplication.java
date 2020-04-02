package com.user.demo;

import com.user.models.DupFlix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages={"com.user"})
public class Assignment2UserAppApplication {
    private static final Logger log = LoggerFactory.getLogger(Assignment2UserAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Assignment2UserAppApplication.class, args);
	}
      
        

}
