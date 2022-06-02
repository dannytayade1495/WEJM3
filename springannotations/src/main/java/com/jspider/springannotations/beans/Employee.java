package com.jspider.springannotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Employee {
	
	@Value("101")
	private int id;
	
	@Value("Raju")
	private String name;

	@Autowired
	private EmployeeDetails details;
}
