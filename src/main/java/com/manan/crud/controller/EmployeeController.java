package com.manan.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manan.crud.entity.Employee;
import com.manan.crud.exception.EmployeeException;
import com.manan.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService)
	{
		employeeService=theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() throws EmployeeException
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable Integer employeeId) throws EmployeeException
	{
		return employeeService.findById(employeeId);
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee)
	{
		employeeService.save(employee);
		return "New Employee Saved!";
	}
	
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody Employee employee) throws EmployeeException
	{
		employeeService.update(employee);
		return "Employee updated with the id: "+employee.getId();
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable Integer employeeId) throws EmployeeException
	{
		employeeService.deleteById(employeeId);
		return "Employee with the id "+employeeId+" is deleted!";
		
	}

}
