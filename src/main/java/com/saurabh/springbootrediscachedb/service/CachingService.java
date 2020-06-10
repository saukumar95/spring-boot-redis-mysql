package com.saurabh.springbootrediscachedb.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CachingService {

	@CacheEvict(value = "student", allEntries = true)
	public void evictAllCacheValues() {
	}
}
