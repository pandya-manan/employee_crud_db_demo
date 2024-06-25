package com.manan.crud.service;

import java.util.List;

import com.manan.crud.entity.Employee;
import com.manan.crud.exception.EmployeeException;

public interface EmployeeService {
	
	List<Employee> findAll() throws EmployeeException;

	Employee findById(Integer id) throws EmployeeException;
	
	void save(Employee employee);
	
	void update(Employee employee) throws EmployeeException;
	
	void deleteById(Integer id) throws EmployeeException;
}
