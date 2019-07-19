package com.microservicios8.workstation.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class Hello {

	
	
	@GetMapping("/{name2}")
	public String hello(@PathVariable String name2) {
		System.out.println("erick");

		return "Hello " + name2;
	}
}
