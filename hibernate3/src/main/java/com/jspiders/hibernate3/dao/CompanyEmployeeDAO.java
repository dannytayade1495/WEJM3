package com.jspiders.hibernate3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate3.dto.CompanyDTO;
import com.jspiders.hibernate3.dto.EmployeesDTO;

public class CompanyEmployeeDAO {


	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnections() {
		factory = Persistence.createEntityManagerFactory("hibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnections() {
		factory.close();
		manager.close();
		try {
			transaction.rollback();
		} catch (Exception e) {
			System.out.println("Transaction is committed");
		}
	}
	
	public static void main(String[] args) {
		openConnections();
		
		transaction.begin();
		
		CompanyDTO company = new CompanyDTO();
		company.setName("Capgemini");
		
		EmployeesDTO employee1 = new EmployeesDTO();
		employee1.setName("Dhananjay");
		
		EmployeesDTO employee2 = new EmployeesDTO();
		employee2.setName("Sahil");
		
		EmployeesDTO employee3 = new EmployeesDTO();
		employee3.setName("Sachin");
		
		EmployeesDTO employee4 = new EmployeesDTO();
		employee4.setName("Vaibhav");
		
		EmployeesDTO employee5 = new EmployeesDTO();
		employee5.setName("Monika");
		
		employee1.setCompany(company);
		employee2.setCompany(company);
		employee3.setCompany(company);
		employee4.setCompany(company);
		employee5.setCompany(company);
		
		manager.persist(company);
		manager.persist(employee1);
		manager.persist(employee2);
		manager.persist(employee3);
		manager.persist(employee4);
		manager.persist(employee5);
		
		transaction.commit();
		
		closeConnections();
		
		
	}
}
