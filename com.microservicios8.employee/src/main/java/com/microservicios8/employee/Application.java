package com.microservicios8.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.microservicios8.employee.entities.Employee;
import com.microservicios8.employee.repository.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	public EmployeeRepository employeeRepository;
//	
//	public Application(EmployeeRepository employeeRepository) {
//	
//		this.employeeRepository=employeeRepository;
//		
//	}
//	
//	@Bean
//	public CommandLineRunner startup() {
//		
//		return (args) -> {
//			Employee employee = Employee.builder().firstName("Ivan").lastName("Garcia")
//					.employeeNumber("100").build();
//
//			System.out.println(employee);
//
//			employeeRepository.save(employee);
//
//			employee = Employee.builder().firstName("Fernanda").lastName("Morales")
//					.employeeNumber("101").build();
//
//			System.out.println(employee);
//
//			employeeRepository.save(employee);
//			};
//		}
}
