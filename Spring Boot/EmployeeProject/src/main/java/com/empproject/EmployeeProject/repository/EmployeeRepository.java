package com.empproject.EmployeeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empproject.EmployeeProject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
		
}
