package com.jspider.springannotations.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspider.springannotations.beans.DoctorBean;
import com.jspider.springannotations.config.DoctorConfig;

public class DoctorMain {
	
	public static void main(String[] args) {
		
//		ApplicationContext context = new AnnotationConfigApplicationContext(DoctorConfig.class);
//		DoctorBean doctor = (DoctorBean) context.getBean("doctor");
//		System.out.println(doctor);
//		((AnnotationConfigApplicationContext)context).close();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Doctor.xml");
		DoctorBean bean = context.getBean(DoctorBean.class);
		System.out.println(bean);
		((ClassPathXmlApplicationContext)context).close();
	}

}
