package com.springboot.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springboot.jdbc.model.Employee;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public void insert(Employee employee) {
		String sql = "INSERT INTO employee(empid, name, department, city) VALUES (?, ?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				employee.getEmpId(), employee.getName(), employee.getDepartment(), employee.getCity()
		});
	}

	@Override
	public void insertBatch(List<Employee> employeeList) {
		String sql = "INSERT INTO employee(empid, name, department, city) VALUES (?, ?, ?, ?)";

		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employeeList.get(i);
				ps.setString(1, employee.getEmpId());
				ps.setString(2, employee.getName());
				ps.setString(3, employee.getDepartment());
				ps.setString(4, employee.getCity());
			}
			public int getBatchSize() {
				return employeeList.size();
			}
		});
	}

	@Override
	public List<Employee> getAll() {
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Employee> result = new ArrayList<Employee>();

		for(Map<String, Object> row:rows){
			Employee employee = new Employee();
			employee.setEmpId((String)row.get("empid"));
			employee.setName((String)row.get("name"));
			employee.setDepartment((String)row.get("department"));
			employee.setCity((String)row.get("city"));
			result.add(employee);
		}
		return result;
	}

	@Override
	public Employee findById(String empId) {
		String sql = "SELECT * FROM employee WHERE empid = ?";
		return (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>(){
			@Override
			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Employee cust = new Employee();
				cust.setEmpId(rs.getString("empid"));
				cust.setName(rs.getString("name"));
				cust.setDepartment(rs.getString("department"));
				cust.setCity(rs.getString("city"));
				return cust;
			}
		});
	}
}
