package com.jspiders.hibernate3.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate3.dto.StudentDTO;
import com.jspiders.hibernate3.dto.TeacherDTO;

public class TeacherStudentDAO {

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
		
		StudentDTO student1 = new StudentDTO();
		student1.setName("Radhika");
		
		StudentDTO student2 = new StudentDTO();
		student2.setName("Pradeep");
		
		TeacherDTO teacher1 = new TeacherDTO();
		teacher1.setName("ABC");
		
		List<StudentDTO> students = Arrays.asList(student1, student2);
		teacher1.setStudents(students);
		
		manager.persist(student1);
		manager.persist(student2);
		manager.persist(teacher1);
		
		transaction.commit();
		System.out.println(teacher1);
		
		closeConnections();
	}

}
