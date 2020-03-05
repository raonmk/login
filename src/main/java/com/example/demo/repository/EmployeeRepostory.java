package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import java.lang.String;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepostory extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM Empl e WHERE e.name = ?1 AND e.address= ?2",nativeQuery = true)
	Optional<Employee> findEmployeeByName(String name, String address);

	@Query(value = "SELECT * FROM Empl e WHERE e.name = ?1",nativeQuery = true)
	Optional<Employee> findEmployeeByNamepath(String name);
	
}
