package com.example.demo.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Roles;
import com.example.demo.model.EmployeeDto;
import com.example.demo.repository.EmployeeRepostory;
import com.example.demo.repository.RoleRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepostory employeeRepository;

	@Autowired
	RoleRepo roleRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emp = employeeRepository.findAll();

		return emp;
	}

	@Override
	public Employee getById(Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new EntityExistsException("id not found");
		}
	}

	@Override
	public void delete(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			Employee emp = employee.get();
			employeeRepository.deleteById(emp.getId());

		} else {

			throw new EntityExistsException("id not found");
		}
	}

	@Override
	public Employee saveEmployee(Employee emp) {

		emp.setPassword(bCryptPasswordEncoder.encode(emp.getPassword()));

		Roles userRole = roleRepository.findByRole("ADMIN");
		emp.setRole(new HashSet<Roles>(Arrays.asList(userRole)));

		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee updateEmp, Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			Employee emp = employee.get();

			emp.setId(updateEmp.getId());
			emp.setUserName(updateEmp.getUserName());
			emp.setSalary(updateEmp.getSalary());
			emp.setAddress(updateEmp.getAddress());

			return employeeRepository.save(emp);
		}

		else {
			throw new EntityExistsException("id not found");
		}
	}

	@Override
	public Employee getByName(EmployeeDto emps) {
		Optional<Employee> emp = employeeRepository.findEmployeeByName(emps.getName(), emps.getAddress());
		if (emp.isPresent()) {
			return emp.get();
		} else {
			throw new EntityExistsException("not found");
		}

	}

	@Override
	public Employee getByNameemp(String name) {
		Optional<Employee> emp = employeeRepository.findEmployeeByNamepath(name);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			throw new EntityExistsException("not found");
		}
	}

	@Override
	public Employee findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
