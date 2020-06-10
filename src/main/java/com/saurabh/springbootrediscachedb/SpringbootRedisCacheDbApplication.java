package com.saurabh.springbootrediscachedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootRedisCacheDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisCacheDbApplication.class, args);
	}

}
