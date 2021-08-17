package com.springboot.payment.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.payment.dao.EmployeeRepository;
import com.springboot.payment.model.Employee;

import antlr.collections.List;

@RestController
@RequestMapping("/EmployeeService")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping("/addEmployee")
	public Response addEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return new Response(employee.getId()+" insterted",Boolean.TRUE);
		
	}
	
	@GetMapping("/getEmployees")
	public Response getAllEmployee() {
		java.util.List<Employee> employees=repository.findAll();
		return new Response("record counts : "+employees.size(),Boolean.TRUE);
	}
}
