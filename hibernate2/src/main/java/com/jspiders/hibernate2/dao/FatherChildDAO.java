package com.jspiders.hibernate2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate2.dto.ChildDTO;
import com.jspiders.hibernate2.dto.FatherDTO;

public class FatherChildDAO {
	
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
		
		ChildDTO child = new ChildDTO();
		child.setName("Sagar P");
		child.setAge(23);
		
		FatherDTO father = new FatherDTO();
		father.setName("Bhagwat P");
		father.setAge(54);
		father.setChild(child);
		
		FatherDTO father1 = new FatherDTO();
		father1.setName("Bhagwat");
		father1.setAge(54);
		father1.setChild(child);
		
		manager.persist(child);
		manager.persist(father);
		
//		ChildDTO find = manager.find(ChildDTO.class, "Sagar P");
//		manager.remove(find);
		
//		FatherDTO find = manager.find(FatherDTO.class, "Bhagwat P");
//		manager.remove(find);
		
		
		transaction.commit();
		
		closeConnections();
	}

}
