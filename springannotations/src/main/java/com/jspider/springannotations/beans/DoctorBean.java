package com.jspider.springannotations.beans;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

//@Component
@Data
public class DoctorBean {
	
//	@Value("1")
	private int id;
	
//	@Value("Amol")
	private String name;
	
//	@Value("Orthopedic")
	private String specialization;
	
	@Autowired
	private PatientBean patient;

}
