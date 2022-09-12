package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student object . . . ");
			
			//Create
			Student tempStudent = new Student("Nancy", "Sy", "PCG@example.com");
			
			
			//Start
			session.beginTransaction();
			
			
			//Save
			System.out.println("Saving entry . . . ");
			session.save(tempStudent);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
	}

}
