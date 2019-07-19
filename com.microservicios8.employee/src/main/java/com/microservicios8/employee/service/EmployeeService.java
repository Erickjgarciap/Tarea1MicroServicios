package com.microservicios8.employee.service;

import java.util.List;

import com.microservicios8.employee.entities.Employee;

public interface EmployeeService {
	
	
	List<Employee> retrieveAll();
	
	Employee retrieveById(Long id);
	
	Employee register(Employee employee); 
	
	Employee update(Employee employee); 
	
	Employee delete(Employee employee);
	
	
}
