package com.jspiders.springrestproject1.dao;

import com.jspiders.springrestproject1.dto.EmployeeDTO;

public interface EmployeeDAOInterface {

	EmployeeDTO insert(EmployeeDTO employee);

	EmployeeDTO search(int id);

}
