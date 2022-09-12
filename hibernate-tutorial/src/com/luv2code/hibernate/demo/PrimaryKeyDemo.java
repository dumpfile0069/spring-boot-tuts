package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		System.out.println("Creating new Student object . . . ");
		
		//Create
		Student tempStudent = new Student("Ed", "Caluag", "PCG@example.com");
		Student tempStudent1 = new Student("Joel", "Nga", "PCG@example.com");
		Student tempStudent2= new Student("Yi", "Xi", "PCG@example.com");
		
		
		//Start
		session.beginTransaction();
		
		
		//Save
		System.out.println("Saving entry . . . ");
		session.save(tempStudent);
		session.save(tempStudent1);
		session.save(tempStudent2);
		
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Done!");
		
		
		}
		finally {
		factory.close();
		}


	}

}
