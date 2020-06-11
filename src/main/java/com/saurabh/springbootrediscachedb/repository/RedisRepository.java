package com.saurabh.springbootrediscachedb.repository;

import org.springframework.stereotype.Repository;

import com.saurabh.springbootrediscachedb.domain.Student;

/**
 * @author banti
 *
 */
@Repository
public interface RedisRepository {

	boolean save(Student student);

	Student getStudentById(Integer id);

	boolean update(Student student);

}
