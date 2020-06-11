package com.saurabh.springbootrediscachedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.springbootrediscachedb.service.CachingService;

@RestController
@RequestMapping("/cache")
public class RedisCacheController {

	@Autowired
	private CachingService cachingService;

	@GetMapping("/clearAllCachesValues")
	public void clearAllCachesValues() {
		cachingService.evictAllCacheValues();
	}

//	@Scheduled(fixedRate = 10000)
//	public void evictAllcachesAtIntervals() {
//		System.out.println("Evicting the cache..");
//		cachingService.evictAllCacheValues();
//	}
}
