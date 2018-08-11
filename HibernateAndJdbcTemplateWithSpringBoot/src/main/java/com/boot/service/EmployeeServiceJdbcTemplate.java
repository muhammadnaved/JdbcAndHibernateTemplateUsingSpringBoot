package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boot.model.Employee;

/**
 * @author Naved Khan
 *
 */
@Repository
public class EmployeeServiceJdbcTemplate implements IEmployeeService {
	
	private static String sql = "select * from emp";

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getEmployee() {
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
