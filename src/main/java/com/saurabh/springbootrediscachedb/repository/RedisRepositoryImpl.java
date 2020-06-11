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
	@Value("${UPDATE_STUDENT}")
	private String updateStudent;

	@Override
	public boolean save(final Student student) {
		try {
			return jdbcTemplate.update(createStudent, student.getId(), student.getName(), student.getClz()) > 0;
		} catch (DataAccessException dex) {
			dex.printStackTrace();
			return false;
		}
	}

	@Override
	public Student getStudentById(Integer id) {
		try {
			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 5);
			return jdbcTemplate.queryForObject(getStudent, new Object[] { id }, new StudentRowMapper());
		} catch (DataAccessException | NullPointerException | InterruptedException nex) {
			nex.printStackTrace();
			return new Student();
		}
	}

	@Override
	public boolean update(Student student) {
		try {
			return jdbcTemplate.update(updateStudent, student.getName(), student.getClz(), student.getId()) > 0;
		} catch (DataAccessException dex) {
			dex.printStackTrace();
			return false;
		}
	}

}
