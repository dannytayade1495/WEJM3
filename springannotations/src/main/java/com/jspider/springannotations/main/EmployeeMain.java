package com.jspider.springannotations.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspider.springannotations.beans.Employee;
import com.jspider.springannotations.config.EmployeeConfig;

public class EmployeeMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Employee bean = (Employee) context.getBean("employee");
		System.out.println(bean);
		((AnnotationConfigApplicationContext)context).close();
	}

}
