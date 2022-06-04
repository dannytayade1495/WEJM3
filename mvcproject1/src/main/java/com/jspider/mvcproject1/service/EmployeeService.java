package com.jspider.mvcproject1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.mvcproject1.dao.EmployeeDAO;
import com.jspider.mvcproject1.dto.EmployeeDTO;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeDTO insert(String name, String email, String designation, String userName, String password) {
		EmployeeDTO employee = dao.insert(name, email, designation, userName, password);
		return employee;
	}

}
