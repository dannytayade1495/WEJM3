package com.jspiders.springrestproject1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrestproject1.dao.EmployeeDAO;
import com.jspiders.springrestproject1.dto.EmployeeDTO;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeDTO insert(EmployeeDTO employee) {
		EmployeeDTO dto = dao.insert(employee);
		return dto;
	}

	@Override
	public EmployeeDTO search(int id) {
		EmployeeDTO employee = dao.search(id);
		return employee;
	}

}
