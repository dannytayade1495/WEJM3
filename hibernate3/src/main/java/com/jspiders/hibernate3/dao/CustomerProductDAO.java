package com.jspiders.hibernate3.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate3.dto.CustomerDTO;
import com.jspiders.hibernate3.dto.ProductDTO;

public class CustomerProductDAO {

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
/*
		openConnections();

		transaction.begin();

		ProductDTO product1 = new ProductDTO();
		product1.setName("Face wash");
		product1.setPrice(500.00);
		product1.setQuantity(1);

		ProductDTO product2 = new ProductDTO();
		product2.setName("Perfume");
		product2.setPrice(2000.00);
		product2.setQuantity(2);

		CustomerDTO customer1 = new CustomerDTO();
		customer1.setName("Priti");
		customer1.setPhoneNumber(8976543210L);
		customer1.setAddress("Dange Chowk");

		CustomerDTO customer2 = new CustomerDTO();
		customer2.setName("Shivani");
		customer2.setPhoneNumber(9876543210L);
		customer2.setAddress("Chikhali");

		List<ProductDTO> products = Arrays.asList(product1, product2);

		customer1.setProducts(products);
		customer2.setProducts(products);

		manager.persist(product1);
		manager.persist(product2);
		manager.persist(customer1);
		manager.persist(customer2);

		transaction.commit();

		closeConnections();
		*/

	}
}
