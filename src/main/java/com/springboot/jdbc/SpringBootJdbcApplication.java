package com.springboot.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jdbc.model.Employee;
import com.springboot.jdbc.service.EmployeeService;

/*
 * You can implement the CommandLineRunner interface,if you want access to the raw command line arguments, 
 * or you need to run some specific code once the SpringApplication has started.
 * The run(String…​ args) method will be called on all Spring beans implementing this interface. 
 */
@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner{

	@Autowired
	EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		
		 Employee emp = new Employee();
		 emp.setEmpId("E01");
		 emp.setName("Shiv");
		 emp.setDepartment("EC");
		 emp.setCity("EKM");
		 
		 Employee emp2 = new Employee();
		 emp2.setEmpId("E02");
		 emp2.setName("Renju");
		 emp2.setDepartment("EC");
		 emp2.setCity("TVM");
		 
		 Employee emp3 = new Employee();
		 emp3.setEmpId("E03");
		 emp3.setName("Lenny");
		 emp3.setDepartment("IT");
		 emp3.setCity("TVM");
		 
		 employeeService.insert(emp);
		 System.out.println(employeeService.getAll());
		 
		 List<Employee> empList = new ArrayList<Employee>();
		 empList.add(emp2);
		 empList.add(emp3);
		 employeeService.insertBatch(empList);
		 System.out.println(employeeService.getAll());
		 
		 System.out.println(employeeService.findById("E02"));
	}
}
