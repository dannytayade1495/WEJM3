package com.jspider.springannotations.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PatientBean {
	
	@Value("100")
	private int id;
	
	@Value("Aman")
	private String name;
	
	@Value("Hadapsar")
	private String address;

}
