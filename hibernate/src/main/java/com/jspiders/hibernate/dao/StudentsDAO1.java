package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentsDTO;

public class StudentsDAO1 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnections() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnections() {
		entityManagerFactory.close();
		entityManager.close();
		try {
			entityTransaction.rollback();
		} catch (Exception e) {
			System.out.println("Transaction is committed. ");
		}
	}
	
	public static void main(String[] args) {
		openConnections();
		
		entityTransaction.begin();
		
		StudentsDTO dto = new StudentsDTO();
		dto.setRollNo(1);
		dto.setName("ABC");
		dto.setEmailId("abc@xyz.com");
		dto.setPhoneNo(9988776655L);
		dto.setAddress("Pune");
		
		entityManager.persist(dto);
		
		entityTransaction.commit();
		
		closeConnections();
		
	}
}
