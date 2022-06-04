package com.jspider.mvcproject1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspider.mvcproject1.dto.EmployeeDTO;

@Repository
public class EmployeeDAO implements EmployeeDAOInterface {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	public static void openConnections() {
		factory = Persistence.createEntityManagerFactory("wejm3");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void closeConnections() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
	}

	@Override
	public EmployeeDTO insert(String name, String email, String designation, String userName, String password) {
		
		openConnections();
		
		transaction.begin();

		EmployeeDTO employee = new EmployeeDTO();
		employee.setName(name);
		employee.setEmail(email);
		employee.setDesgination(designation);
		employee.setUserName(userName);
		employee.setPassword(password);

		manager.persist(employee);

		transaction.commit();

		closeConnections();

		return employee;
	}

}