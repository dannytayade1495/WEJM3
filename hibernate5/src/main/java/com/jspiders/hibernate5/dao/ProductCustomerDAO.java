package com.jspiders.hibernate5.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate5.dto.CustomerDTO;
import com.jspiders.hibernate5.dto.ProductDTO;

public class ProductCustomerDAO {

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

		ProductDTO product1 = new ProductDTO();
		product1.setName("Travel Bag");
		product1.setPrice(1500);
		product1.setQuantity(5);

		ProductDTO product2 = new ProductDTO();
		product2.setName("Dress");
		product2.setPrice(2000);
		product2.setQuantity(15);

		CustomerDTO customer1 = new CustomerDTO();
		customer1.setName("Ajinkya");
		customer1.setPhoneNumber(8888888888L);
		customer1.setAddress("Pune");

		CustomerDTO customer2 = new CustomerDTO();
		customer2.setName("Tejas");
		customer2.setPhoneNumber(9999999999L);
		customer2.setAddress("Mumbai");

		List<CustomerDTO> customers = Arrays.asList(customer1, customer2);
		List<ProductDTO> products = Arrays.asList(product1, product2);

		product1.setCustomers(customers);
		product2.setCustomers(customers);

		customer1.setProducts(products);
		customer2.setProducts(products);

		manager.persist(product1);
		manager.persist(product2);

		manager.persist(customer1);
		manager.persist(customer2);

		transaction.commit();

		closeConnections();
	}
}
