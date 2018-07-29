package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.nt.entity.Employee;
@Repository(value="EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void insertEmployee(Employee employee) {
		
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(employee);
		tx.commit();
		
		session.close();
		factory.close();
	
	}

}
