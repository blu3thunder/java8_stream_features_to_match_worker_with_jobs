package com.swipe.springboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.swipe.springboot.model.Worker;


@SpringBootApplication(scanBasePackages={"com.swipe.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class SpringBootRestApiExample2 {

	private static final Logger log = LoggerFactory.getLogger(SpringBootRestApiExample2.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiExample2.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		
		return args -> {
			String abc =  restTemplate.getForObject("http://test.swipejobs.com/api/workers", Worker[].class).toString();
			log.info(abc.toString());
		};
	}
}
