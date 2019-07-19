package com.microservicios8.employee.controller;

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

import com.microservicios8.employee.entities.Employee;
import com.microservicios8.employee.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;

	
	@GetMapping
	public List<Employee> getall(){
		
		return employeeservice.retrieveAll();
	}

	@GetMapping("/{employeeId}")
	public Employee getall(@PathVariable long employeeId){
		
		return employeeservice.retrieveById(employeeId);
	}
	
	@PostMapping
	public Employee postEmployee(@RequestBody Employee employee) {
		return employeeservice.register(employee);
	}
	
	@PutMapping("/{employeeid}")
	public Employee updateemployee(@PathVariable long employeeid, @RequestBody Employee ws) {
		ws.setId(employeeid);	
		return employeeservice.update(ws);
	}
	@DeleteMapping("/{employeeid}")
	public Employee deleteEmployee(@PathVariable long employeeid) {
		return employeeservice.delete(employeeservice.retrieveById(employeeid));
		
	}
}
