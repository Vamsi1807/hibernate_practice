package com.vamsi.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vamsi.model.Student;

public class LaunchNew {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory sf=null;
		Transaction tr=null;
		Session session=null;
		boolean flag=false;
		try {
			config = new Configuration();
			sf = config.buildSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			
			
			Student stu = new Student();
			stu.setName("Siddhu");
			stu.setId(4343);
			stu.setCity("Mutukuru");
			
			
			session.persist(stu);
			
			flag=true;
			
			
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		catch(Exception a){
			a.printStackTrace();
		}
		
		finally {
			if(true) {
				System.out.println("Student object saved successfully...");
			}
			else {
				System.out.println("Error...");
			}
			session.close();
			sf.close();
		}

	}

}
