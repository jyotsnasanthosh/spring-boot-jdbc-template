package com.springboot.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jdbc.dao.EmployeeDao;
import com.springboot.jdbc.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public void insert(Employee employee) {
		employeeDao.insert(employee);		
	}

	@Override
	public void insertBatch(List<Employee> employeeList) {
		employeeDao.insertBatch(employeeList);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public Employee findById(String empId) {
		return employeeDao.findById(empId);
	}

}
