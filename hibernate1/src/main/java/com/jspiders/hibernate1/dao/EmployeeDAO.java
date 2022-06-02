package com.jspiders.hibernate1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmployeeDAO {
	
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
		
		EmployeeDTO emp1 = new EmployeeDTO();
		emp1.setName("Rahul");
		emp1.setEmail("rahul143@gmail.com");
		emp1.setPhoneNumber(8888438701L);
		emp1.setSalary(50000);
		
		manager.persist(emp1);
		
		EmployeeDTO emp2 = new EmployeeDTO();
		emp2.setName("Anjali");
		emp2.setEmail("anjali99@gmail.com");
		emp2.setPhoneNumber(9876543210L);
		emp2.setSalary(40000);
		
		manager.persist(emp2);
		
		EmployeeDTO emp3 = new EmployeeDTO();
		emp3.setName("Sonam");
		emp3.setEmail("bewafa@gmail.com");
		emp3.setPhoneNumber(9962787368L);
		emp3.setSalary(45000);
		
		manager.persist(emp3);
		
		transaction.commit();
		
		String jpql = "select name from EmployeeDTO"; 
		Query query = manager.createQuery(jpql);
		List resultList = query.getResultList();
		
		for (Object employees : resultList) {
			System.out.println(employees);
		}
		
		String jpql1 = "update EmployeeDTO set email='sonam@gmail.com' where id=3";
		Query createQuery = manager.createQuery(jpql1);
		int executeUpdate = createQuery.executeUpdate();
		System.out.println(executeUpdate + " row(s) affected");
		
		transaction.commit();
		
		String jpql2 = "delete from EmployeeDTO where id between 2 and 3";
		Query createQuery1 = manager.createQuery(jpql2);
		int executeUpdate1 = createQuery1.executeUpdate();
		System.out.println(executeUpdate1 + " row(s) affected");
		
		transaction.commit();
		
		closeConnections();
	}

}
