package com.jspiders.hibernate1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_details")
public class EmployeeDTO {
	
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "emp_email")
	private String email;
	
	@Column(name = "emp_sal")
	private double salary;
	
	@Column(name = "emp_contact")
	private long phoneNumber;
	

}
