package com.microservicios8.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios8.employee.entities.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
//	List<Employee> findAllByOrderByIdAsc();
	
	//List<Employee> customFindAllByOrderByIdAsc();
	
//	Employee findByEmployeeNumber(String employeeNumber);


}
