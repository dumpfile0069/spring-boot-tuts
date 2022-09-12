package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//Start
			session.beginTransaction();
			
			//Query Student
			List<Student> theStudent = session.createQuery("from Student").getResultList();
		
			//Display Student
			displayStudent(theStudent);
			
			//query student: modified
			theStudent = session.createQuery("from Student s where s.lastName='Xi'").getResultList();
			
			//Display Student
			System.out.println("\nDisplaying Student with Xi as last name: ");
			displayStudent(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
