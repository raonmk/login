package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Roles;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee employee = employeeService.findUserByUserName(username);

		List<GrantedAuthority> authorities = getUserAuthority(employee.getRole());

		return buildUserForAuthentication(employee, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Roles> employeeRole) {
		Set<GrantedAuthority> roles = new HashSet<>();
		for (Roles role : employeeRole) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new ArrayList<>(roles);
	}

	private UserDetails buildUserForAuthentication(Employee employee, List<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return new org.springframework.security.core.userdetails.User(employee.getUserName(), employee.getPassword(),
				true, true, true, false, authorities);
	}

}
