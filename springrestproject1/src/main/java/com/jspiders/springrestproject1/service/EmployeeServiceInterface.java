package com.jspiders.springrestproject1.service;

import com.jspiders.springrestproject1.dto.EmployeeDTO;

public interface EmployeeServiceInterface {
	
	EmployeeDTO insert(EmployeeDTO employee);
	
	EmployeeDTO search(int id);

}
