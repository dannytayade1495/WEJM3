package com.jspiders.hibernate4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate4.dto.ProjectDTO;

public class ProjectDAO {

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

		ProjectDTO project1 = new ProjectDTO();
		project1.setName("MrMrsCart");
		project1.setClientName("Karthik");
		project1.setProjectSize(24);
		project1.setTenureInYears(2.3);

		manager.persist(project1);

		transaction.commit();

		System.out.println(project1);

		/*
		 * String jpqlQuery = "delete from ProjectDTO where id=1";
		 * 
		 * Query query = manager.createQuery(jpqlQuery);
		 * 
		 * List list = query.getResultList();
		 * 
		 * System.out.println(list);
		 * 
		 * for (Object project : list) { System.out.println(project); }
		 * 
		 * 
		 * int update = query.executeUpdate();
		 * 
		 * System.out.println(update + " row(s) affected");
		 */

		transaction.begin();

		String jpqlQuery = "update ProjectDTO set name = 'MMCart' where id = 1";

		Query query = manager.createQuery(jpqlQuery);

		int update = query.executeUpdate();

		transaction.commit();

		System.out.println(update + " row(s) affected");

		jpqlQuery = "from ProjectDTO";

		query = manager.createQuery(jpqlQuery);

		List resultList = query.getResultList();

		System.out.println(resultList);

		for (Object project : resultList) {
			System.out.println(project);
		}

		closeConnections();
	}
}
