package com.vamsi.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vamsi.model.Student;

public class Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//st1...create config object
		
		Configuration config = new Configuration();
		
		//st2...config xml file to config obj
		config.configure(); // This will look for hibernate.cfg.xml by default
		
		//st3..build session factory
		SessionFactory sf = config.buildSessionFactory();
		
		//st4...get session obj
		Session session = sf.openSession();
		
		//st5...begin transaction
		Transaction trans = session.beginTransaction(); // Corrected variable name to 'trans' for consistency
		
		// Create a Student object
		Student stu = new Student();
		stu.setName("Vamsi");
		stu.setId(1249);
		stu.setCity("Guntur");
		
		//st6...perform save operation
		session.persist(stu); // <--- This line saves the object to the database
		
		//st7...commit the transaction
		trans.commit(); // <--- This line commits the changes to the database
		
		//st8...close the session and session factory
		session.close();
		sf.close();
		
		System.out.println("Student object saved successfully!");
	}
}