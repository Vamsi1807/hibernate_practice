package com.vamsi.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vamsi.model.Student;

public class LaunchNew {

    public static void main(String[] args) {
        Configuration config = null;
        SessionFactory sf = null;
        Transaction tr = null;
        Session session = null;
        boolean flag = false;
        try {
            config = new Configuration().configure(); // Hibernate will automatically look for hibernate.cfg.xml
            sf = config.buildSessionFactory();
            session = sf.openSession();
            tr = session.beginTransaction();

            Student stu = new Student();
            stu.setName("Siddhu");
            stu.setId(4343);
            stu.setCity("Mutukuru");

            session.persist(stu);
            
            //session.update()....to update existing record using same id of object    saveOrUpdate(), merge()

            tr.commit(); // Commit the transaction if everything is successful
            flag = true;

        } catch (HibernateException e) {
            if (tr != null) {
                tr.rollback(); // Rollback the transaction if an error occurs
            }
            e.printStackTrace();
        } catch (Exception a) {
            if (tr != null) {
                tr.rollback();
            }
            a.printStackTrace();
        } finally {
            if (flag) {
                System.out.println("Student object saved successfully...");
            } else {
                System.out.println("Error occurred while saving the student.");
            }
            if (session != null) {
                session.close();
            }
            if (sf != null) {
                sf.close();
            }
        }
    }

}