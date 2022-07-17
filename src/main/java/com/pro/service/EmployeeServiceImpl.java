package com.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.EmployeeDao;
import com.pro.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Override
	public boolean addEmployee(Employee entity) {
		
		return empDao.addEmployee(entity);
	}

}
