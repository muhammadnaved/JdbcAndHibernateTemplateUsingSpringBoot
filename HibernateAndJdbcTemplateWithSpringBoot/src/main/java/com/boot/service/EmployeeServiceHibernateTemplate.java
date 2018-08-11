package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.boot.model.Employee;

@Service
public class EmployeeServiceHibernateTemplate implements IEmployeeService{
	
	private static String sql = "select * from emp";
	
	@Autowired
	public HibernateTemplate hiberanteTemplate;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployee() {
		return (List<Employee>)hiberanteTemplate.getSessionFactory().openSession().createNativeQuery(sql).getResultList();
		
	}

	
	
	
}
