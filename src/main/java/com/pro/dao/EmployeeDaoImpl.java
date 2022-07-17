package com.pro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory factory = null;

	@Override
	public boolean addEmployee(Employee entity) {

		Session session = null;

		try {
			
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(entity);
			
			tx.commit();
			return true;

		} catch (Exception e) {

			System.out.println("failed to add employee in database!!!");
			e.printStackTrace();
			return false;

		} finally {
			session.close();
		}
	}

}
