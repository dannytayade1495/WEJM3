package com.jspider.springannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jspider.springannotations.beans.Employee;

@Configuration
@ComponentScan(basePackages = {"com.jspider.springannotations"})
public class EmployeeConfig {
	
	@Bean("employee")
	public Employee getEmployee() {
		return new Employee();
	}

}
