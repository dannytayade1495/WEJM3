package com.jspider.mvcproject1.dao;

import java.util.List;

import com.jspider.mvcproject1.dto.EmployeeDTO;

public interface EmployeeDAOInterface {

	EmployeeDTO insert(String name, String email, String designation, String userName, String password);

	void remove(int id);

	List<EmployeeDTO> findAllEmployees();

	EmployeeDTO search(int id);

	EmployeeDTO login(String userName, String password);
}
