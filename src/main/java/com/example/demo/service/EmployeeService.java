package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeDto;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getById(Long id);

	void delete(Long id);

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(Employee emp, Long id);


	Employee getByName(EmployeeDto emp);

	Employee getByNameemp(String name);

	Employee findUserByUserName(String username);
}
