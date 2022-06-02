package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentsDTO;

public class StudentsDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManagerFactory entityManagerFactory2;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnections() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManagerFactory2 = Persistence.createEntityManagerFactory("hibernate2");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnections() {
		entityManagerFactory.close();
		entityManager.close();
		try {
			entityTransaction.rollback();
		} catch (Exception e) {
			System.out.println("The transaction is committed");
		}
	}

	public static void main(String[] args) {

		openConnections();

		entityTransaction.begin();
		
		/* CREATE AND INSERT OPERATION BEGIN */
		
		StudentsDTO dto = new StudentsDTO();
		dto.setRollNo(1);
		dto.setName("Dhananjay");
		dto.setEmailId("dhananjay_007@gmail.com");
		dto.setPhoneNo(8788491050L);
		dto.setAddress("Dubai");

		entityManager.persist(dto);
		
		/* CREATE AND INSERT OPERATION END */
		
		/* SELECT AND UPDATE OPERATION BEGIN*/
		
		StudentsDTO find = entityManager.find(StudentsDTO.class, 1);
		
		System.out.println(find);
		
		find.setName("Dhananjay B");
		
		
		entityTransaction.commit();
		
		System.out.println(find);
		
		/* SELECT AND UPDATE OPERATION END*/
		closeConnections();

	}

}
