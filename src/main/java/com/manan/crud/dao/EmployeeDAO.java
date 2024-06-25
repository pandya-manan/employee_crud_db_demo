package com.manan.crud.dao;

import java.util.List;

import com.manan.crud.entity.Employee;
import com.manan.crud.exception.EmployeeException;

public interface EmployeeDAO {
	
	List<Employee> findAll() throws EmployeeException;
	
	Employee findById(Integer id) throws EmployeeException;
	
	void save(Employee employee);
	
	void update(Employee employee) throws EmployeeException;

	void deleteById(Integer id) throws EmployeeException;
	
}
