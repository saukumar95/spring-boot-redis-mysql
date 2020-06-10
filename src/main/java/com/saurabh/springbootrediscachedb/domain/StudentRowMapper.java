package com.saurabh.springbootrediscachedb.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getString("id"));
		student.setName(rs.getString("name"));
		student.setClz(rs.getString("clz"));
		return student;
	}

}
