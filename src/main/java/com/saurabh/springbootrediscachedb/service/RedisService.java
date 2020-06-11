package com.saurabh.springbootrediscachedb.service;

import javax.validation.Valid;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.stereotype.Service;

import com.saurabh.springbootrediscachedb.domain.Student;

/**
 * @author banti
 *
 */
@Service
public interface RedisService {

	boolean save(Student student);

	@Cacheable(value = "student", key = "#id", condition = "#id > 1")
	@TimeToLive
	Student getStudentById(Integer id);

	boolean update(Student student);
}
