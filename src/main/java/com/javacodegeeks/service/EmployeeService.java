package com.javacodegeeks.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.javacodegeeks.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private RedisTemplate<String, Employee> redisTemplate;
	private HashOperations<String, String, Employee> hashOperations;
	private final String EMPLOYEE_CACHE = "EMPLOYEECACHE";
	
	@PostConstruct
	private void initializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}
	
	public void save(Employee employee) {
		hashOperations.put(EMPLOYEE_CACHE, employee.getId(), employee);
	}
	
	public Employee findById(String id) {
		return hashOperations.get(EMPLOYEE_CACHE, id);
	}
	
	public Map<String, Employee> findAll() {
		return hashOperations.entries(EMPLOYEE_CACHE);
	}
	
	public void delete(String id) {
		hashOperations.delete(EMPLOYEE_CACHE, id);
	}
}
