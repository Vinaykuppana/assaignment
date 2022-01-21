package com.te.assignment.dao;

import java.util.List;
import java.util.Scanner;
import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.assignment.dto.Student;

public class StudentMethods {
	Scanner scanner = new Scanner(System.in);

	public void getStudentId() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Munit01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String query = "select id from Student";
		Query query2 = entityManager.createNativeQuery(query);
		List resultList = query2.getResultList();
		System.out.println(resultList);

	}

	public void add() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Munit01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = new Student();

		System.out.println("enter your name");
		student.setName(scanner.next());

		System.out.println("enter your marks");
		student.setMarks(scanner.nextDouble());

		System.out.println("enter your section");
		student.setSection(scanner.next());

		entityTransaction.begin();
		entityManager.persist(student);
		System.out.println("inserted successfully");
		entityTransaction.commit();

	}

	public void getName() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Munit01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String query1 = "select name from Student";
		Query query3 = entityManager.createNativeQuery(query1);
		List resultList1 = query3.getResultList();
		System.out.println(resultList1);
	}

	public void toUpdate() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Munit01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, 4);
		System.out.println("enter new name");
		student.setName(scanner.next());
		System.out.println("enter new marks");
		student.setMarks(scanner.nextDouble());
		System.out.println("enter new section");
		student.setSection(scanner.next());

		entityTransaction.begin();
		entityManager.persist(student);
		System.out.println("inserted successfully");
		entityTransaction.commit();
	}

	public void allList() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Munit01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String query4 = "select * from Student";
		Query query5 = entityManager.createNativeQuery(query4);
		List resultList1 = query5.getResultList();
		System.out.println(resultList1);
		for (Object object : resultList1) {
			System.out.println(object);
		}
	}

	public void toDelete() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Munit01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("enter the id to delete");
		int id = scanner.nextInt();
		String query = "delete from student where id=value";
		Query query2 = entityManager.createQuery(query);
		query2.setParameter("value", id);

		entityTransaction.begin();
		entityManager.persist(query2);
		entityTransaction.commit();
	}

}
