package com.empproject.EmployeeProject.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.empproject.EmployeeProject.entity.Employee;
import com.empproject.EmployeeProject.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	
	EmployeeRepository employeeRepository;
	
	public Employee addemployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public Employee getemployee(Long id)
	{
		return employeeRepository.findById(id).orElse(null);
	}
	
	public List<Employee> getemployees()
	{
		return employeeRepository.findAll();
	}
	
	public String deleteemployee( Long id)
	{
		employeeRepository.deleteById(id);
		return "Deleted Successfully ";
	}
	public Employee updateemployee(Long id, Employee employee)
	{
		employee.setId(id);
		return employeeRepository.save(employee);
	}
}
