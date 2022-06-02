package com.jspider.springannotations.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class EmployeeDetails {

	@Value("raju123@gmail.com")
	private String email;
	
	@Value("50000.00")
	private double salary;
	
	@Value("9876543210")
	private long contactNo;
}
