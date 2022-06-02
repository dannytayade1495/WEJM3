package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.beans.EmployeeBean;

public class EmployeeMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeBean bean = context.getBean(EmployeeBean.class);
		System.out.println(bean);
		((ClassPathXmlApplicationContext) context).close();

	}
}
