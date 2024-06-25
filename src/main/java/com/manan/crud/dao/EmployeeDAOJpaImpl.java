package com.manan.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manan.crud.entity.Employee;
import com.manan.crud.exception.EmployeeException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//constructor injection for entity manager
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> findAll() throws EmployeeException {
		TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee",Employee.class);
		List<Employee> employees=theQuery.getResultList();
		if(employees.isEmpty())
		{
			throw new EmployeeException("Employees not available!");
		}
		return employees;
	}

	@Override
	public Employee findById(Integer id) throws EmployeeException {
		Employee found=entityManager.find(Employee.class, id);
		if(found==null)
		{
			throw new EmployeeException("No employee found with the id: "+id);
		}
		return found;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		entityManager.persist(employee);
		
	}

	@Override
	@Transactional
	public void update(Employee employee) throws EmployeeException {
		Employee found=entityManager.find(Employee.class, employee.getId());
		if(found==null)
		{
			throw new EmployeeException("No employee found with the id: "+employee.getId());
		}
		found.setEmail(employee.getEmail());
		found.setFirstName(employee.getFirstName());
		found.setLastName(employee.getLastName());
		entityManager.persist(found);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws EmployeeException {
		Employee found=entityManager.find(Employee.class, id);
		if(found==null)
		{
			throw new EmployeeException("No employee found with the id: "+id);
		}
		entityManager.remove(found);
		
	}

}
