package com.springboot.jdbc.service;

import java.util.List;

import com.springboot.jdbc.model.Employee;

public interface EmployeeService {
	void insert(Employee employee);
	void insertBatch(List<Employee> employeeList);
	List<Employee> getAll();
	Employee findById(String empId);
}
