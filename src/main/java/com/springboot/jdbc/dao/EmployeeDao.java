package com.springboot.jdbc.dao;

import java.util.List;

import com.springboot.jdbc.model.Employee;

public interface EmployeeDao {
	void insert(Employee employee);
	void insertBatch(List<Employee> customers);
	List<Employee> getAll();
	Employee findById(String empId);
}
