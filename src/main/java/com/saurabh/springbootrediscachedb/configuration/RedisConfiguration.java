package com.saurabh.springbootrediscachedb.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.saurabh.springbootrediscachedb.repository.RedisRepository;
import com.saurabh.springbootrediscachedb.repository.RedisRepositoryImpl;
import com.saurabh.springbootrediscachedb.service.RedisService;
import com.saurabh.springbootrediscachedb.service.RedisServiceImpl;
import com.saurabh.springbootrediscachedb.vo.ResponseVO;

@Configuration
@EnableCaching
@ComponentScan(basePackages = "com.saurabh.springbootrediscachedb")
public class RedisConfiguration {

	@Bean
	public RedisRepository redisRepository() {
		return new RedisRepositoryImpl();
	}

	@Bean
	public RedisService redisService() {
		return new RedisServiceImpl();
	}

}
