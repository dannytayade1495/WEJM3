package com.jspider.mvcproject1.service;

import com.jspider.mvcproject1.dto.EmployeeDTO;

public interface EmployeeServiceInterface {

	EmployeeDTO insert(String name, String email, String designation, String userName, String password);

}
