package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Practical of hibernate object
		//Transient
		//Persistent
		//Detached
		//Removed
		System.out.println("Example :");
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating StudentObject
		Student student=new Student();
		student.setId(1414);
		student.setName("Samarth");		
		student.setCity("Lucknow");
		student.setCerti(new Certificate("Java Hibernate Course","2 month"));
		//student : Transient
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		//student : Persistent - session,database
		
		student.setName("Sam");
		
		tx.commit();
		s.close();
		
		//student : Detached
		student.setName("Yogita");
		System.out.println(student);
		factory.close();
		
	}

}
