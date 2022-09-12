package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student object . . . ");
			
			//Create
			Student tempStudent = new Student("Bong Bong", "Marcos", "PCG@example.com");
			
			
			//Start
			session.beginTransaction();
			
			
			//Save Student
			System.out.println("Saving entry . . . ");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			//Find ID
			System.out.println("Printing Student ID: " + tempStudent.getId());
			
			//Get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with ID: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			
			System.out.println("Get Complete Student: " + myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
	}

}
