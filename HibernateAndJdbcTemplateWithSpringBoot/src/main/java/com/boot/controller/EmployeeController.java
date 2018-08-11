package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Employee;
import com.boot.service.IEmployeeService;

/**
 * @author Naved Khan
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	public IEmployeeService employeeServiceHibernateTemplate;

	@Autowired
	public IEmployeeService employeeServiceJdbcTemplate;

	@GetMapping("/getAllEmployeeUsingHibernateTemplate")
	public List<Employee> getAllEmployeeUsingHibernateTemplate() {
		List<Employee> employee= null;
		try {
			employee =  employeeServiceHibernateTemplate.getEmployee();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@GetMapping("/getAllEmployeeUsingJdbcTemplate")
	public List<Employee> getAllEmployeeUsingJdbcTemplate() {List<Employee> employee= null;
	try {
		employee =  employeeServiceJdbcTemplate.getEmployee();
	}catch (Exception e) {
		e.printStackTrace();
	}
	return employee;
}

}
