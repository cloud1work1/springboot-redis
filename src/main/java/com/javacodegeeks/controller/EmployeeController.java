package com.javacodegeeks.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.model.Employee;
import com.javacodegeeks.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public Map<String, Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") String id) {
		return employeeService.findById(id);
	}
	
	@PostMapping
	public String saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "Employee saved";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") String id) {
		employeeService.delete(id);
		return "Employee deleted";
	}
}
