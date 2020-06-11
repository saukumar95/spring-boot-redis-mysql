package com.saurabh.springbootrediscachedb.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.saurabh.springbootrediscachedb.domain.Student;
import com.saurabh.springbootrediscachedb.repository.RedisRepository;

public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisRepository redisRepository;

	@Override
	public boolean save(final Student student) {
		boolean status = false;
		try {
			status = redisRepository.save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student getStudentById(Integer id) {
		Student student = null;
		try {
			student = redisRepository.getStudentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean update(Student student) {
		boolean status = false;
		try {
			status = redisRepository.update(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
