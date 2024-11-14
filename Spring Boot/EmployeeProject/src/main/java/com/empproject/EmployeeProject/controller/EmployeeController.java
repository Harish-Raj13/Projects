package com.empproject.EmployeeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empproject.EmployeeProject.entity.Employee;
import com.empproject.EmployeeProject.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@PostMapping("/addemployee")
	public Employee addemployee(@RequestBody Employee employee)
	{
		return employeeService.addemployee(employee);
	}
	
	@GetMapping("/getemployee/{id}")
	public Employee getemployee(@PathVariable Long id)
	{
		return employeeService.getemployee(id);
	}
	
	@GetMapping("/getemployees")
	public List<Employee> getemployees()
	{
		return employeeService.getemployees();
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteemployee(@PathVariable Long id)
	{
		return employeeService.deleteemployee(id);
	}
	
	@PutMapping("/updateemployee/{id}")
	public Employee updateemployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		return employeeService.updateemployee(id, employee);
	}
	
}
