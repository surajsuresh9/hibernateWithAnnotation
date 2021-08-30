package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {
	public static void main(String[] args) {

		try {

			SessionFactory factory;
			Configuration cfg = new Configuration();

			cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			cfg.setProperty("hibernate.connection.url",
					"jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC");
			cfg.setProperty("hibernate.connection.username", "root");
			cfg.setProperty("hibernate.connection.password", "root");
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.setProperty("hibernate.hbm2ddl.auto", "update");

			cfg.addAnnotatedClass(Video1.class);

			factory = cfg.buildSessionFactory();

			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			Video1 v = new Video1("Sample Video", "E:\\Sample Videos\\file_example_MOV_480_700kB.mov");
			session.save(v);
			t.commit();
			System.out.println("saved");
			session.close();
			factory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
