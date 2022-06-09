package com.jspiders.springrestproject1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspiders.springrestproject1.dto.EmployeeDTO;

@Repository
public class EmployeeDAO implements EmployeeDAOInterface {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private void openConnections() {
		factory = Persistence.createEntityManagerFactory("wejm3");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private void closeConnections() {
		factory.close();
		manager.close();
		try {
			transaction.rollback();
		} catch (Exception e) {
			System.out.println("Transaction already committed.");
		}

	}

	@Override
	public EmployeeDTO insert(EmployeeDTO employee) {
		openConnections();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		closeConnections();
		return employee;
	}

	@Override
	public EmployeeDTO search(int id) {
		openConnections();
		transaction.begin();
		EmployeeDTO employee = manager.find(EmployeeDTO.class, id);
		transaction.commit();
		closeConnections();
		return employee;
	}

}
