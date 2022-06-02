package com.jspiders.springcore.beans;

import lombok.Data;

@Data
public class EmployeeBean {

	private int id;

	private String name;
	
	private EmployeeDetailsBean details;

}
