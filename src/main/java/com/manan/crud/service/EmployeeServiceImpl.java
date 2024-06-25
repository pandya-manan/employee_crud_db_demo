package com.manan.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manan.crud.dao.EmployeeDAO;
import com.manan.crud.entity.Employee;
import com.manan.crud.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
	{
		employeeDAO=theEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() throws EmployeeException {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(Integer id) throws EmployeeException {
		
		return employeeDAO.findById(id);
	}

	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
		
	}

	@Override
	public void update(Employee employee) throws EmployeeException {
		employeeDAO.update(employee);
		
	}

	@Override
	public void deleteById(Integer id) throws EmployeeException {
		employeeDAO.deleteById(id);
		
	}

}
