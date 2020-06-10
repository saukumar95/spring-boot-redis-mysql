package com.saurabh.springbootrediscachedb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.saurabh.springbootrediscachedb.domain.Student;
import com.saurabh.springbootrediscachedb.domain.StudentRowMapper;

public class RedisRepositoryImpl implements RedisRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${CREATE_STUDENT}")
	private String createStudent;
	@Value("${GET_STUDENT}")
	private String getStudent;

	@Override
	public boolean save(final Student student) {
		boolean status = false;
		try {
			status = jdbcTemplate.update(createStudent, student.getId(), student.getName(), student.getClz()) > 0;
		} catch (DataAccessException dex) {
			dex.printStackTrace();
		}
		return status;
	}

	@Override
	public Student getStudentById(Integer id) {
		Student student = null;
		try {
			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 20);
		} catch (DataAccessException | NullPointerException | InterruptedException nex) {
			nex.printStackTrace();
		}
		return jdbcTemplate.queryForObject(getStudent, new Object[] { id }, new StudentRowMapper());
	}

}
