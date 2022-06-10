package com.jspiders.springbootproject1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springbootproject1.dto.EmployeeDTO;
import com.jspiders.springbootproject1.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public EmployeeDTO insert(EmployeeDTO employee) {
		EmployeeDTO dto = repository.save(employee);
		return dto;
	}

}
