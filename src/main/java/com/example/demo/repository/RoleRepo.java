package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Roles;

public interface RoleRepo extends JpaRepository<Roles, Long> {
	
	
   Roles findByRole(String name);

}
