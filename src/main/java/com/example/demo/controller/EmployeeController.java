package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/register")
	public String register(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);

		return "Registration logIn";
	}

	@GetMapping("/login")
	public Employee LoginEmployee(@RequestParam("username") String name, @PathVariable("password") String password) {

		return null;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> emp = employeeService.getAllEmployees();
		return emp;
	}

	@GetMapping("/employees/{id}")
	public Employee getbyId(@PathVariable("id") Long id) {

		return employeeService.getById(id);

	}

	@DeleteMapping("/employeesdelete/{id}")
	public String deleteById(@PathVariable("id") Long id) {

		employeeService.delete(id);

		return "delete sucussfull";

	}

	@PutMapping("/employeeupdate/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {

		return employeeService.updateEmployee(employee, id);

	}

	@PostMapping("/employees")
	public Employee getEMployeeByName(@RequestBody EmployeeDto emp) {
		return employeeService.getByName(emp);
	}

	@PostMapping("/employees/path")
	public Employee getEMployeeByNames(@RequestParam String name) {
		return employeeService.getByNameemp(name);
	}

}
