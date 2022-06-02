package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.beans.TeamBean;

public class TeamMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Team.xml");
		TeamBean bean = context.getBean(TeamBean.class);
		System.out.println(bean);
		((ClassPathXmlApplicationContext)context).close();
	}

}
